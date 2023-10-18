package mahmoudi.ali.firstprofessionaljetpackcomposeapplication.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import mahmoudi.ali.firstprofessionaljetpackcomposeapplication.data.data_sources.local.ArticleDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ArticleDatabaseModule {


    @Singleton
    @Provides
    fun provideArticleDatabase(@ApplicationContext context: Context): ArticleDatabase {
        return ArticleDatabase(context)
    }
}