package mahmoudi.ali.firstprofessionaljetpackcomposeapplication.repository

import mahmoudi.ali.firstprofessionaljetpackcomposeapplication.database.ArticleDatabase
import mahmoudi.ali.firstprofessionaljetpackcomposeapplication.model.Article
import mahmoudi.ali.firstprofessionaljetpackcomposeapplication.network.NewsService
import javax.inject.Inject

class NewsRepository_Impl @Inject
constructor(
    private val newsService: NewsService,
    private val db: ArticleDatabase
) : NewsRepository {

    override suspend fun getBreakingNews() =
        newsService.getBreakingNews("us", 1)


    override suspend fun saveArticle(article: Article) {
        db.getArticleDao().upsert(article)
    }

    override fun getSavedArticles(): List<Article> =
        db.getArticleDao().getSavedArticles()


    override suspend fun deleteArticle(article: Article) {
        db.getArticleDao().deleteArticle(article)
    }

}