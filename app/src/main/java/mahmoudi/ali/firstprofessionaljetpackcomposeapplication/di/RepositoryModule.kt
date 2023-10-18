package mahmoudi.ali.firstprofessionaljetpackcomposeapplication.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mahmoudi.ali.firstprofessionaljetpackcomposeapplication.data.data_sources.local.ArticleDatabase
import mahmoudi.ali.firstprofessionaljetpackcomposeapplication.data.data_sources.remote.NewsService
import mahmoudi.ali.firstprofessionaljetpackcomposeapplication.data.model.util.ArticleDtoMapper
import mahmoudi.ali.firstprofessionaljetpackcomposeapplication.repository.NewsRepository
import mahmoudi.ali.firstprofessionaljetpackcomposeapplication.repository.NewsRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideNewsRepository(
        newsService: NewsService,
        db: ArticleDatabase,
        mapper: ArticleDtoMapper
    ): NewsRepository {
        return NewsRepositoryImpl(newsService, db, mapper)
    }

}