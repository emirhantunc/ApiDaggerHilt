interface PostsApi {

    @GET("posts")
    suspend fun getPosts(): List<DataClass>
}