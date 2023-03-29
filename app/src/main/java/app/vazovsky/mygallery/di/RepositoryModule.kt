package app.vazovsky.mygallery.di

import app.vazovsky.mygallery.data.repository.GalleryRepository
import app.vazovsky.mygallery.data.repository.GalleryRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindGalleryRepository(
        genresRepository: GalleryRepositoryImpl
    ): GalleryRepository
}