package br.senai.sp.jandira.login_screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.login_screen.ui.theme.LoginscreenTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginscreenTheme {
                    Home()
                }
            }
        }
    }


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Home() {
    Surface(modifier =  Modifier
        .fillMaxSize()
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
        ) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(360.dp)
            ) {
                Image(painter = painterResource(id = R.drawable.paris),
                    contentDescription = "",
                    alignment = Alignment.BottomCenter
                )
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 13.dp, end = 19.dp),
                horizontalAlignment = Alignment.End) {
                    Card(modifier = Modifier.size(61.dp),
                    shape = CircleShape,
                    border = BorderStroke(2.dp, color = Color.White)
                    ) {
                        Image(painter = painterResource(id = R.drawable.susanna_profile), contentDescription = "")
                    }
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(text = stringResource(id = R.string.user_name),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                        color = Color(255, 255, 255)
                    )
                }
            }

        }

    }
}
