interface Api {
    @GET("posts") // API'deki yazıların listelendiği endpoint
    suspend fun getPosts(): List<PostResponse>
}