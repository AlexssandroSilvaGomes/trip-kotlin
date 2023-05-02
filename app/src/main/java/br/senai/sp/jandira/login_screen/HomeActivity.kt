package br.senai.sp.jandira.login_screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.login_screen.model.Category
import br.senai.sp.jandira.login_screen.repository.CategoryRepository
import br.senai.sp.jandira.login_screen.ui.theme.LoginscreenTheme
import br.senai.sp.jandira.login_screen.ui.theme.Shapes

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginscreenTheme {
                Home(CategoryRepository.getCategories())
            }
        }
    }
}


@Composable
fun Home(categories: List<Category>) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Text(text = "+")
            }
        }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    backgroundColor = Color.Magenta,
                    shape = RectangleShape
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.paris),
                        contentDescription = "Logo",
                        contentScale = ContentScale.Crop
                    )
                }
                Text(
                    text = stringResource(id = R.string.categories),
                    modifier = Modifier.padding(top = 14.dp, start = 16.dp)
                )
                LazyRow() {
                    items(categories) {
                        Card(
                            modifier = Modifier
                                .size(
                                    110.dp,
                                    80.dp
                                )
                                .padding(4.dp),
                            backgroundColor = Color(207, 6, 240)
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Icon(
                                    painter = it.icon!!,
                                    contentDescription = "",
                                    modifier = Modifier
                                        .height(32.dp)
                                        .width(32.dp),
                                    tint = Color.White
                                )
                                Text(
                                    text = it.name,
                                    color = Color.White
                                )
                            }
                        }
                    }

                }
            }

        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    LoginscreenTheme {
        Home(CategoryRepository.getCategories())
    }
}

