package com.example.feature.posts.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature.posts.domain.GetPostsUseCase
import com.example.ncore.DataClass
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase
) : ViewModel() {

    private val _postsData = MutableLiveData<List<DataClass>>()
    val postsData: LiveData<List<DataClass>> get() = _postsData

    init {
        fetchPosts()
    }

    fun fetchPosts() {
        viewModelScope.launch {
            try {
                _postsData.value = getPostsUseCase()
            } catch (e: Exception) {

            }
        }
    }
}