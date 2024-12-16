package com.chivnet.jitpacksample

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chivnet.jitpacksample.ui.theme.JitpackSampleTheme
import com.chivnet.mylibrary_jetpack_compose.ElectricalCalc

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JitpackSampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {

    var volt = 415.0
    var current = 100.0
    var powerfactor = 0.9
    ElectricalCalc()
    var elec= ElectricalCalc()
    var kwresult=elec.kw(volt,current,powerfactor)
    var kvaresult=elec.kva(volt,current)
    var kvarresult=elec.kvar(volt,current,powerfactor)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp, start = 20.dp, end = 20.dp, bottom = 50.dp)
            .background(Color.LightGray),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Box (
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(0.9f)
                .padding(24.dp)
                .background(Color.White),
            contentAlignment = Alignment.Center
        )
        {
            Text(
                text = "kw = $kwresult",
                modifier = Modifier
                    .padding(24.dp)
                    .background(Color.White)
            )
        }
        Box (
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(0.9f)
                .padding(24.dp)
                .background(Color.White),
            contentAlignment = Alignment.Center
        )
        {
            Text(
                text = "kva = $kvaresult",
                modifier = Modifier
                    .padding(24.dp)
                    .background(Color.White)
            )
        }

        Box (
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(0.9f)
                .padding(24.dp)
                .background(Color.White),
            contentAlignment = Alignment.Center
        )
        {
            Text(
                text = "kvar = $kvarresult",
                modifier = Modifier
                    .padding(24.dp)
                    .background(Color.White)
            )
        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JitpackSampleTheme {
        //Greeting("Android")
    }
}