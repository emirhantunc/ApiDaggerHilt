package com.example.feature.posts.domain

import com.example.feature.PostsRepository
import com.example.ncore.DataClass
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    private val postsRepository: PostsRepository
) {
    suspend operator fun invoke(): List<DataClass> {
        return postsRepository.getPosts()
    }
}
