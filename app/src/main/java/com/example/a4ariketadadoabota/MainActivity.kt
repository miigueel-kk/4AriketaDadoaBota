package com.example.a4ariketadadoabota

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.a4ariketadadoabota.ui.theme._4AriketaDadoaBotaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _4AriketaDadoaBotaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Ariketa(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun Ariketa (modifier: Modifier = Modifier) {
    Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        AriketaFondoa()
        AriketaTestua()
    }
}



@Composable
fun AriketaFondoa (modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.fondo_ariketa4)
    Image(
        painter = image,
        contentDescription = null,
        modifier = Modifier.fillMaxSize()
    )
}


@Composable
fun AriketaTestua(modifier: Modifier = Modifier) {
    var zenbakia by remember { mutableStateOf(1) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val dadoIrudia = when (zenbakia){
            1 -> painterResource(R.drawable.dadoa_1)
            2 -> painterResource(R.drawable.dadoa_2)
            3 -> painterResource(R.drawable.dadoa_3)
            4 -> painterResource(R.drawable.dadoa_4)
            5 -> painterResource(R.drawable.dadoa_5)
            6 -> painterResource(R.drawable.dadoa_6)
            else -> painterResource(R.drawable.dadoa_1)
        }
        Image(
            painter = dadoIrudia,
            contentDescription = "Dadoa"
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Atera den zenbakia: $zenbakia",
                fontSize = 40.sp,
                textAlign = TextAlign.Center,
                color = Color.Black
            )
        }

        Button(onClick = {
            zenbakia = (1..6).random()
        }) {
            Text(
                text = "Jaurti botoia"
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GrettingPreview(){
    _4AriketaDadoaBotaTheme() {
        Ariketa()
    }
}


