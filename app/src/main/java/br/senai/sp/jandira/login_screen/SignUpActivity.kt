package br.senai.sp.jandira.login_screen

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.login_screen.components.BottomShape
import br.senai.sp.jandira.login_screen.components.TopShape
import br.senai.sp.jandira.login_screen.model.User
import br.senai.sp.jandira.login_screen.repository.UserRepository
import br.senai.sp.jandira.login_screen.ui.theme.LoginscreenTheme
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

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

    var userState by remember {
        mutableStateOf("")
    }

    var phoneState by remember {
        mutableStateOf("")
    }

    var emailState by remember {
        mutableStateOf("")
    }

    var passwordState by remember {
        mutableStateOf("")
    }

    var over18State by remember {
        mutableStateOf(false)
    }

    //obter fot oda galeria de imagens

    var fotoUri by remember {
        mutableStateOf<Uri?>(null)
    }

    //criar o objeto que abrira a galeria e retornara a uri da imagem selecionada
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) {
        fotoUri = it
    }

    var painter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current).data(fotoUri).build()
    )

    var context = LocalContext.current

    Surface(
        modifier = Modifier.
        fillMaxSize()
    ) {
        //----------------------------------------------->>>>>
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.
                fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                TopShape()
            }
            //Content
            //Column title
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .weight(weight = 1f)
            ) {
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
                    Box(contentAlignment = Alignment.BottomEnd,
                        modifier = Modifier.size(100.dp)) {
                        Card(modifier = Modifier
                            .size(100.dp)
                            .align(Alignment.Center),
                            shape = CircleShape,
                            border = BorderStroke(width = 1.dp, Brush.horizontalGradient(
                                listOf(
                                    Color.Magenta,
                                    Color.White
                                )
                            ))
                        ) {
                            Image(
                                painter = painter,
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(16.dp),
                                contentScale = ContentScale.Crop
                            )
                        }
                        Icon(
                            painter = painterResource(id = R.drawable.camera),
                            contentDescription = "",
                            modifier = Modifier
                                .size(32.dp)
                                .align(Alignment.BottomEnd)
                                .clickable {
                                           launcher.launch("image/*")
                                },
                            tint = Color(207, 6, 240))
                    }
                }
                //Column outlined texts
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp, 0.dp)
                ) {
                    OutlinedTextField(
                        value = userState,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 0.dp, 0.dp, 31.dp),
                        shape = RoundedCornerShape(16.dp),
                        onValueChange ={userName -> userState = userName},
                        label = { Text(text = stringResource(id = R.string.username))},
                        placeholder = { Text(text = "teste@email.com")},
                        leadingIcon = { Icon(painter = painterResource(id = R.drawable.baseline_person_24),
                            contentDescription = null,
                            tint = Color(207, 6, 240))},
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                    )
                    OutlinedTextField(
                        value = phoneState,
                        onValueChange ={phone -> phoneState = phone},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 0.dp, 0.dp, 31.dp),
                        shape = RoundedCornerShape(16.dp),
                        label = { Text(text = stringResource(id = R.string.phone))},
                        placeholder = { Text(text = "teste@email.com")},
                        leadingIcon = { Icon(painter = painterResource(id = R.drawable.baseline_phone_android_24),
                            contentDescription = null,
                            tint = Color(207, 6, 240))},
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                    OutlinedTextField(
                        value = emailState,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 0.dp, 0.dp, 31.dp),
                        shape = RoundedCornerShape(16.dp),
                        onValueChange ={email -> emailState = email},
                        label = { Text(text = stringResource(id = R.string.e_mail))},
                        placeholder = { Text(text = "teste@email.com")},
                        leadingIcon = { Icon(painter = painterResource(id = R.drawable.baseline_email_24),
                            contentDescription = null,
                            tint = Color(207, 6, 240))},
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)

                    )
                    OutlinedTextField(
                        value = passwordState,
                        onValueChange ={password -> passwordState = password},
                        modifier = Modifier
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        label = { Text(text = stringResource(id = R.string.password))},
                        placeholder = { Text(text = "****************")},
                        leadingIcon = { Icon(painter = painterResource(id = R.drawable.baseline_lock_24),
                            contentDescription = null,
                            tint = Color(207, 6, 240))},
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        visualTransformation = PasswordVisualTransformation()
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp, 0.dp, 20.dp, 0.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(checked = over18State, onCheckedChange = {over18State = it})
                    Text(text = stringResource(id = R.string.over_eighteen))
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp, 0.dp, 16.dp, 31.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    Button(onClick = {
                                     userSave(
                                         context,
                                         userState,
                                         phoneState,
                                         emailState,
                                         passwordState,
                                         over18State
                                     )
                    },
                        colors = ButtonDefaults.buttonColors(Color(207, 6, 240)),
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier
                            .padding(0.dp, 0.dp, 0.dp, 31.dp)
                            .height(48.dp)
                            .fillMaxWidth()
                    ) {
                        Text(text = stringResource(id = R.string.create_account).uppercase(),
                            color = Color.White,
                            modifier = Modifier.padding(9.dp, 0.dp))
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = stringResource(id = R.string.have_account), color = Color(160,156,156))
                        Spacer(modifier = Modifier.width(4.dp))
                        TextButton(
                            onClick = {
                                var openSignIn = Intent(context, MainActivity::class.java)
                                context.startActivity(openSignIn)
                            }
                        ) {
                            Text(text = stringResource(id = R.string.button_signIn), color = Color(207, 6, 240))
                        }

                    }
                    //<<<<<---------------------------------------
                }
            }

            BottomShape()

        }



    }

}

fun userSave(
    context: Context,
    userName: String,
    phone: String,
    email: String,
    password: String,
    isOver18: Boolean
) {
    val userRepository = UserRepository(context)

    //Recuperando no banco um usuario que tenha o email informado
    var user = userRepository.findUserByEmail(email)

    //se o user null, gravamos o novo usuario, senao, avisamos que o usuario ja existe.
    if(user == null) {
        val newUser = User(
            userName = userName,
            phone = phone,
            email = email,
            password = password,
            isOver18 = isOver18
        )
        val id = userRepository.save(newUser)
        Toast.makeText(
            context,
            "User created #$id",
            Toast.LENGTH_LONG)
            .show()
    } else {
        Toast.makeText(
            context,
            "User already exists!",
            Toast.LENGTH_SHORT)
            .show()
    }
}

