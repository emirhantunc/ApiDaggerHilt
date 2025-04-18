import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.hilt.navigation.compose.hiltViewModel
import com.example.feature.posts.presentation.PostsViewModel
import org.w3c.dom.Text

@Composable
fun PostsScreen(viewModel: PostsViewModel = hiltViewModel()) {
    val posts by viewModel.postsData.observeAsState(emptyList())
    Column(modifier=Modifier.background(Color.White)) {
        LazyColumn {
            items(posts) { post ->
                Text(text = "ID: ${post.id}, Title: ${post.title}, User ID: ${post.userId}")
            }
        }
    }
}
