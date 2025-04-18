package com.example.feature

import android.provider.ContactsContract.Data
import com.example.ncore.DataClass
import com.example.ncore.MyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.http.GET
import javax.inject.Inject

interface PostsRepository {
    @GET("posts")
    suspend fun getPosts(): List<DataClass>
}
class PostsRepositoryImpl @Inject constructor(
    private val postsApi: MyApi
) : PostsRepository {
    override suspend fun getPosts(): List<DataClass> {
        return postsApi.getPosts()
    }
}

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun providePostsRepository(postsApi: MyApi): PostsRepository {
        return PostsRepositoryImpl(postsApi)
    }
}