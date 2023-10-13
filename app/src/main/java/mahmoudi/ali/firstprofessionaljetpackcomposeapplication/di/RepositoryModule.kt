package mahmoudi.ali.firstprofessionaljetpackcomposeapplication.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mahmoudi.ali.firstprofessionaljetpackcomposeapplication.database.ArticleDatabase
import mahmoudi.ali.firstprofessionaljetpackcomposeapplication.network.NewsService
import mahmoudi.ali.firstprofessionaljetpackcomposeapplication.repository.NewsRepository
import mahmoudi.ali.firstprofessionaljetpackcomposeapplication.repository.NewsRepository_Impl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideNewsRepository(newsService: NewsService, db: ArticleDatabase): NewsRepository {
        return NewsRepository_Impl(newsService, db)
    }

}