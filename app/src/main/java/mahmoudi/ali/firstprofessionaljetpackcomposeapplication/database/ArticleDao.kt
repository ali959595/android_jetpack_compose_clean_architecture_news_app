package mahmoudi.ali.firstprofessionaljetpackcomposeapplication.database

import androidx.room.*
import mahmoudi.ali.firstprofessionaljetpackcomposeapplication.model.Article

@Dao
interface ArticleDao {

       @Insert(onConflict = OnConflictStrategy.REPLACE)
      suspend fun upsert(article: Article) : Long

      @Query(value = "SELECT * FROM articles")
      fun getSavedArticles() : List<Article>

      @Delete
      suspend fun deleteArticle(article: Article)

}