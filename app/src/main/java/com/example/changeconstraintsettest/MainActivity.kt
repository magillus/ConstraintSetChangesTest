package com.example.changeconstraintsettest

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.layoutId
import com.example.changeconstraintsettest.ui.theme.ChangeConstraintSetTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var resConstraints = ""
        resources.openRawResource(R.raw.test_constraint).use {
            resConstraints = it.bufferedReader().readText()
        }
        setContent {
            ChangeConstraintSetTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Box(Modifier.fillMaxSize()) {
                        val constraints = remember { mutableStateOf(resConstraints) }
                        Log.i("MainActivity", "Constraints: ${constraints.value}")

                        Greeting("Android", ConstraintSet(constraints.value))

                        Column(
                            Modifier
                                .align(Alignment.BottomEnd)
                                .width(150.dp)
                        ) {
                            Button({}, Modifier.fillMaxWidth()) {
                                Text("From resources")
                                constraints.value = resConstraints
                            }
                            Divider(Modifier.padding(8.dp))
                            Button({
                                constraints.value = constraintsA
                            }, Modifier.fillMaxWidth()) {
                                Text("static A const")
                            }
                            Divider(Modifier.padding(8.dp))
                            Button({
                                constraints.value = constraintsB
                            }, Modifier.fillMaxWidth()) {
                                Text("static B const")
                            }
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, constSet: ConstraintSet) {
    ConstraintLayout(
        constSet,
        modifier = Modifier
            .width(300.dp)
    ) {
        Text(
            text = "Hello $name!",
            modifier = Modifier
                .wrapContentWidth()
                .layoutId("txt_hello", "")
        )
        Text(
            text = "Test value",
            modifier = Modifier
                .wrapContentWidth()
                .layoutId("txt_test", "")
        )
        Image(
            painter = painterResource(id = android.R.drawable.ic_delete), contentDescription = "",
            modifier = Modifier
                .layoutId("img_settings", "")
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ChangeConstraintSetTestTheme {
        Greeting("Test", ConstraintSet(constraintsA))
    }
}