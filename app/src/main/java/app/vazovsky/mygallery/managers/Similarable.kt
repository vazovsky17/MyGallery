package app.vazovsky.mygallery.managers

interface Similarable<T> {
    fun areItemsTheSame(other: T): Boolean
    fun areContentsTheSame(other: T): Boolean
}