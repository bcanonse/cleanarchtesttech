package gt.bcanon.cleanarchtesttech.home.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import gt.bcanon.cleanarchtesttech.home.domain.model.Character
import gt.bcanon.cleanarchtesttech.home.presentation.viewmodel.CharactersViewModel

@Composable
fun CharactersScreen(
    viewModel: CharactersViewModel = hiltViewModel()
) {
    val state = viewModel.state

    if (state.isLoading) {
        Box(modifier = Modifier.fillMaxSize())
        {
            CircularProgressIndicator()
        }
    }

    if (state.characters.isNotEmpty()) {
        LazyColumn {
            items(state.characters) {
                Item(character = it)
            }
        }
    }
}


@Composable
fun Item(
    character: Character
) {
    Box(
        modifier = Modifier
            .padding(24.dp)
            .clip(RoundedCornerShape(24))
            .border(2.dp, Color.Green, shape = RoundedCornerShape(0, 24, 0, 24))
            .fillMaxWidth()
            .height(250.dp), contentAlignment = Alignment.BottomCenter
    ) {
        AsyncImage(
            model = character.image,
            contentDescription = "character image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(
                    Brush.verticalGradient(
                        listOf(
                            Color.Black.copy(alpha = 0f),
                            Color.Black.copy(alpha = 0.6f),
                            Color.Black.copy(alpha = 1f)
                        )
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(text = character.name, color = Color.White, fontSize = 18.sp)
        }

    }
}