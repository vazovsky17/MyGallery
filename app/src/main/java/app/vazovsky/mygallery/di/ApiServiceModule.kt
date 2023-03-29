package app.vazovsky.mygallery.di

import android.content.Context
import app.vazovsky.mygallery.data.remote.MockMyGalleryApiService
import app.vazovsky.mygallery.data.remote.MyGalleryApiService
import app.vazovsky.mygallery.data.remote.SemimockMyGalleryApiService
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.unsplash.com/"
private const val ACCESS_KEY = "sxqtfUPYg_bHiW16STwuOdOVYuyoB23pICQ5KghF_ek"

@Module
@InstallIn(SingletonComponent::class)
object ApiServiceModule {

    @Singleton
    @Provides
    fun provideClient(@ApplicationContext context: Context): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor { chain ->
            chain.proceed(chain.request().newBuilder().addHeader("Authorization", "Client-ID $ACCESS_KEY").build())
        }.addInterceptor(ChuckerInterceptor(context)).build()
    }


    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson, client: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).client(client)
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(
        retrofit: Retrofit,
    ): MyGalleryApiService {
        return SemimockMyGalleryApiService(
            apiService = retrofit.create(MyGalleryApiService::class.java),
            mockApiService = MockMyGalleryApiService(),
        )
    }
}