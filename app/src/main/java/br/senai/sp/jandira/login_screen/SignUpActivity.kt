package br.senai.sp.jandira.login_screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
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

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginscreenTheme {
                SignUpScreen()
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun  SignUpScreen() {
    Surface(
        modifier = Modifier.
        fillMaxSize()
    ) {
        Column(
            modifier = Modifier.
            fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.
                fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Surface(
                    modifier = Modifier
                        .width(120.dp)
                        .height(40.dp)
                    ,
                    color = Color(207, 6, 240),
                    shape = RoundedCornerShape(
                        bottomStart = 16.dp
                    )
                ) {}
            }
            //Content
            //Column title
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 25.dp, 0.dp, 25.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Sign Up",
                    color = Color(207, 6, 240),
                    fontSize = 32.sp,
                    fontWeight = FontWeight(700)
                )
                Text(text = "Create a new account.",
                    color = Color(160,156,156),
                    fontSize = 14.sp,
                )
            }
            //Column outlined texts
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 0.dp)
            ) {
                OutlinedTextField(
                    value = " ",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 0.dp, 0.dp, 31.dp),
                    shape = RoundedCornerShape(16.dp),
                    onValueChange ={},
                    label = { Text(text = stringResource(id = R.string.username))},
                    placeholder = { Text(text = "teste@email.com")},
                    leadingIcon = { Icon(painter = painterResource(id = R.drawable.baseline_person_24),
                        contentDescription = null,
                        tint = Color(207, 6, 240))}
                )
                OutlinedTextField(
                    value = " ",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 0.dp, 0.dp, 31.dp),
                    shape = RoundedCornerShape(16.dp),
                    onValueChange ={},
                    label = { Text(text = stringResource(id = R.string.phone))},
                    placeholder = { Text(text = "teste@email.com")},
                    leadingIcon = { Icon(painter = painterResource(id = R.drawable.baseline_phone_android_24),
                        contentDescription = null,
                        tint = Color(207, 6, 240))}
                )
                OutlinedTextField(
                    value = " ",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 0.dp, 0.dp, 31.dp),
                    shape = RoundedCornerShape(16.dp),
                    onValueChange ={},
                    label = { Text(text = stringResource(id = R.string.e_mail))},
                    placeholder = { Text(text = "teste@email.com")},
                    leadingIcon = { Icon(painter = painterResource(id = R.drawable.baseline_email_24),
                        contentDescription = null,
                        tint = Color(207, 6, 240))}
                )
                OutlinedTextField(
                    value = " ",
                    onValueChange ={},
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    label = { Text(text = stringResource(id = R.string.password))},
                    placeholder = { Text(text = "****************")},
                    leadingIcon = { Icon(painter = painterResource(id = R.drawable.baseline_lock_24),
                        contentDescription = null,
                        tint = Color(207, 6, 240))}
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 0.dp, 20.dp, 0.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(checked = false, onCheckedChange = {})
                Text(text = stringResource(id = R.string.over_eighteen))
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 0.dp, 16.dp, 31.dp),
                horizontalAlignment = Alignment.End
            ) {
                Button(onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(Color(207, 6, 240)),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 31.dp)
                        .height(48.dp)
                        .fillMaxWidth()
                ) {
                    Text(text = stringResource(id = R.string.create_account).uppercase(),
                        color = Color.White,
                        modifier = Modifier.padding(9.dp, 0.dp))
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(text = stringResource(id = R.string.have_account), color = Color(160,156,156))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = stringResource(id = R.string.button_signIn), color = Color(207, 6, 240))
                }
            }
            Surface(
                modifier = Modifier
                    .width(120.dp)
                    .height(40.dp)
                ,
                color = Color(207, 6, 240),
                shape = RoundedCornerShape(
                    topEnd = 16.dp
                )
            ) {}

        }



    }

}

