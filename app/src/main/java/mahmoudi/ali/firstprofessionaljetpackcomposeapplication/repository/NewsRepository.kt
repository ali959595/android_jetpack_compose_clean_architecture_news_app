package mahmoudi.ali.firstprofessionaljetpackcomposeapplication.repository

import mahmoudi.ali.firstprofessionaljetpackcomposeapplication.model.Article
import mahmoudi.ali.firstprofessionaljetpackcomposeapplication.model.NewsResponse
import retrofit2.Response

interface NewsRepository  {

    suspend fun getBreakingNews() : Response<NewsResponse>

    suspend fun deleteArticle(article: Article)
    suspend fun saveArticle(article: Article)
    fun getSavedArticles() : List<Article>
}