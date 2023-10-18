package mahmoudi.ali.firstprofessionaljetpackcomposeapplication.repository

import mahmoudi.ali.firstprofessionaljetpackcomposeapplication.data.data_sources.local.ArticleDatabase
import mahmoudi.ali.firstprofessionaljetpackcomposeapplication.data.data_sources.remote.NewsService
import mahmoudi.ali.firstprofessionaljetpackcomposeapplication.data.model.util.ArticleDtoMapper
import mahmoudi.ali.firstprofessionaljetpackcomposeapplication.domain.model.Article
import javax.inject.Inject

class NewsRepositoryImpl @Inject
constructor(
    private val newsService: NewsService,
    private val db: ArticleDatabase,
    private val mapper: ArticleDtoMapper,
) : NewsRepository {

    override suspend fun getBreakingNews() =
        mapper.toDomainList(newsService.getBreakingNews("us", 1).body()!!.articles)


    override suspend fun saveArticle(article: Article) {
        db.getArticleDao().upsert(mapper.mapFromDomainModel(article))
    }

    override fun getSavedArticles(): List<Article> =
        mapper.toDomainList(db.getArticleDao().getSavedArticles())


    override suspend fun deleteArticle(article: Article) {
        db.getArticleDao().deleteArticle(mapper.mapFromDomainModel(article))
    }

}