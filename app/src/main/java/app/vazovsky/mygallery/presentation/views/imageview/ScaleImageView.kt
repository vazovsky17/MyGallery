package app.vazovsky.mygallery.presentation.views.imageview

import android.content.Context
import android.graphics.Matrix
import android.graphics.PointF
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener
import android.widget.ImageView
import com.google.android.material.imageview.ShapeableImageView
import kotlin.math.abs
import kotlin.math.min

class ScaleImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : ShapeableImageView(context, attrs) {

    @get:JvmName("getAdapterContext") var matrix: Matrix? = null
    var mode = ImageState.NONE

    var lastPoint = PointF()
    var startPoint = PointF()

    var minScale = 1F
    var maxScale = 3F

    var matrixArray: FloatArray = floatArrayOf()
    var viewWidth = 0
    var viewHeight = 0
    var saveScale = 1f
    private var origWidth = 0f
    private var origHeight = 0f
    var oldMeasuredWidth = 0
    var oldMeasuredHeight = 0
    var mScaleDetector: ScaleGestureDetector? = null

    init {
        super.setClickable(true)
        mScaleDetector = ScaleGestureDetector(context, ScaleListener())
        matrix = Matrix()
        matrixArray = FloatArray(9)
        imageMatrix = matrix
        scaleType = ImageView.ScaleType.MATRIX
        setOnTouchListener { _, event ->
            mScaleDetector!!.onTouchEvent(event)
            val currentPoint = PointF(event.x, event.y)
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    lastPoint.set(currentPoint)
                    startPoint.set(lastPoint)
                    mode = ImageState.DRAG
                }
                MotionEvent.ACTION_MOVE -> if (mode == ImageState.DRAG) {
                    val deltaX = currentPoint.x - lastPoint.x
                    val deltaY = currentPoint.y - lastPoint.y
                    val fixTransX = getFixDragTrans(
                        deltaX, viewWidth.toFloat(), origWidth * saveScale
                    )
                    val fixTransY = getFixDragTrans(
                        deltaY, viewHeight.toFloat(), origHeight * saveScale
                    )
                    matrix!!.postTranslate(fixTransX, fixTransY)
                    fixTrans()
                    lastPoint[currentPoint.x] = currentPoint.y
                }
                MotionEvent.ACTION_UP -> {
                    mode = ImageState.NONE
                    val xDiff = abs(currentPoint.x - startPoint.x).toInt()
                    val yDiff = abs(currentPoint.y - startPoint.y).toInt()
                    if (xDiff < ImageState.CLICK.ordinal && yDiff < ImageState.CLICK.ordinal) performClick()
                }
                MotionEvent.ACTION_POINTER_UP -> mode = ImageState.NONE
            }
            imageMatrix = matrix
            invalidate()
            true
        }
    }

    private inner class ScaleListener : SimpleOnScaleGestureListener() {
        override fun onScaleBegin(detector: ScaleGestureDetector): Boolean {
            mode = ImageState.ZOOM
            return true
        }

        override fun onScale(detector: ScaleGestureDetector): Boolean {
            var mScaleFactor = detector.scaleFactor
            val origScale = saveScale
            saveScale *= mScaleFactor
            if (saveScale > maxScale) {
                saveScale = maxScale
                mScaleFactor = maxScale / origScale
            } else if (saveScale < minScale) {
                saveScale = minScale
                mScaleFactor = minScale / origScale
            }
            if (origWidth * saveScale <= viewWidth || origHeight * saveScale <= viewHeight) matrix!!.postScale(
                mScaleFactor, mScaleFactor, (viewWidth / 2).toFloat(), (viewHeight / 2).toFloat()
            ) else matrix!!.postScale(
                mScaleFactor, mScaleFactor, detector.focusX, detector.focusY
            )
            fixTrans()
            return true
        }
    }

    fun fixTrans() {
        matrix!!.getValues(matrixArray)
        val transX = matrixArray[Matrix.MTRANS_X]
        val transY = matrixArray[Matrix.MTRANS_Y]
        val fixTransX = getFixTrans(transX, viewWidth.toFloat(), origWidth * saveScale)
        val fixTransY = getFixTrans(
            transY, viewHeight.toFloat(), origHeight * saveScale
        )
        if (fixTransX != 0f || fixTransY != 0f) matrix!!.postTranslate(fixTransX, fixTransY)
    }

    private fun getFixTrans(trans: Float, viewSize: Float, contentSize: Float): Float {
        val minTrans: Float
        val maxTrans: Float
        if (contentSize <= viewSize) {
            minTrans = 0f
            maxTrans = viewSize - contentSize
        } else {
            minTrans = viewSize - contentSize
            maxTrans = 0f
        }
        if (trans < minTrans) return -trans + minTrans
        return if (trans > maxTrans) -trans + maxTrans else 0F
    }

    private fun getFixDragTrans(delta: Float, viewSize: Float, contentSize: Float): Float {
        return if (contentSize <= viewSize) 0F else delta
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        viewWidth = MeasureSpec.getSize(widthMeasureSpec)
        viewHeight = MeasureSpec.getSize(heightMeasureSpec)

        if (oldMeasuredHeight == viewWidth && oldMeasuredHeight == viewHeight || viewWidth == 0 || viewHeight == 0) return
        oldMeasuredHeight = viewHeight
        oldMeasuredWidth = viewWidth
        if (saveScale == 1f) {
            // Fit to screen.
            val scale: Float
            val drawable = drawable
            if (drawable == null || drawable.intrinsicWidth == 0 || drawable.intrinsicHeight == 0) return
            val bmWidth = drawable.intrinsicWidth
            val bmHeight = drawable.intrinsicHeight

            val scaleX = viewWidth.toFloat() / bmWidth.toFloat()
            val scaleY = viewHeight.toFloat() / bmHeight.toFloat()
            scale = min(scaleX, scaleY)
            matrix!!.setScale(scale, scale)

            var redundantYSpace = viewHeight.toFloat() - scale * bmHeight.toFloat()
            var redundantXSpace = viewWidth.toFloat() - scale * bmWidth.toFloat()
            redundantYSpace /= 2f
            redundantXSpace /= 2f
            matrix!!.postTranslate(redundantXSpace, redundantYSpace)
            origWidth = viewWidth - 2 * redundantXSpace
            origHeight = viewHeight - 2 * redundantYSpace
            imageMatrix = matrix
        }
        fixTrans()
    }
}

enum class ImageState {
    NONE,
    DRAG,
    ZOOM,
    CLICK,
}