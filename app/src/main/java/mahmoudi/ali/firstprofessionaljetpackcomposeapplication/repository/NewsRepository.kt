package mahmoudi.ali.firstprofessionaljetpackcomposeapplication.repository

import mahmoudi.ali.firstprofessionaljetpackcomposeapplication.domain.model.Article

interface NewsRepository {

    suspend fun getBreakingNews(): List<Article>

    suspend fun deleteArticle(article: Article)
    suspend fun saveArticle(article: Article)
    fun getSavedArticles(): List<Article>
}