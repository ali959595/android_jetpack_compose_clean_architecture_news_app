package mahmoudi.ali.firstprofessionaljetpackcomposeapplication.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import mahmoudi.ali.firstprofessionaljetpackcomposeapplication.domain.model.Article
import mahmoudi.ali.firstprofessionaljetpackcomposeapplication.repository.NewsRepository
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {

    val breakingNewsIsLoading: MutableState<Boolean> = mutableStateOf(true)
    val savedNewsIsLoading: MutableState<Boolean> = mutableStateOf(true)
    val breakingNews: MutableState<List<Article>> = mutableStateOf(listOf())
    val savedArticles: MutableState<List<Article>> = mutableStateOf(listOf())

    init {
        try {
            getBreakingNews()
            getSavedArticles()
        } catch (e: Exception) {
            print("fetching items failed!!!")
        }

    }


    private fun getBreakingNews() = viewModelScope.launch(Dispatchers.IO) {

        val response = newsRepository.getBreakingNews()

        breakingNews.value = response
        delay(3000)
        breakingNewsIsLoading.value = false

    }

    fun saveArticle(article: Article) = viewModelScope.launch(Dispatchers.IO) {
        newsRepository.saveArticle(article)
        savedArticles.value = savedArticles.value.toList().plus(article)
    }

    private fun getSavedArticles() = viewModelScope.launch(Dispatchers.IO) {
        val result = newsRepository.getSavedArticles()
        savedArticles.value = result
        savedNewsIsLoading.value = false
    }

    fun deleteArticle(article: Article) = viewModelScope.launch(Dispatchers.IO) {
        newsRepository.deleteArticle(article)
    }

}