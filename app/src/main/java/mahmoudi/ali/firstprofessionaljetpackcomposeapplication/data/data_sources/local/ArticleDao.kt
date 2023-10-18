package mahmoudi.ali.firstprofessionaljetpackcomposeapplication.data.data_sources.local

import androidx.room.*
import mahmoudi.ali.firstprofessionaljetpackcomposeapplication.data.model.ArticleDto

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: ArticleDto): Long

    @Query(value = "SELECT * FROM articles")
    fun getSavedArticles(): List<ArticleDto>

    @Delete
    suspend fun deleteArticle(article: ArticleDto)

}