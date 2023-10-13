package mahmoudi.ali.firstprofessionaljetpackcomposeapplication.network

import mahmoudi.ali.firstprofessionaljetpackcomposeapplication.config.Constants
import mahmoudi.ali.firstprofessionaljetpackcomposeapplication.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        country: String,
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = Constants.NEWS_API_KEY
    ) : Response<NewsResponse>
}