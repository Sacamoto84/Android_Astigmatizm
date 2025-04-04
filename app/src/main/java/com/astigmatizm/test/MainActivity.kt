package com.astigmatizm.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.astigmatizm.test.ui.theme.AstigmatizmTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AstigmatizmTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

//    Canvas(Modifier.fillMaxSize().background(Color.White)) {
//        drawCircle(color = Color.Yellow, radius = 10f , style = Stroke(width = 1f))
//    }

    val strokeWidth = 5f
    val deltaX = 10
    val colorBg = Color.White
    val colorLine = Color.Black

    Box(modifier = Modifier
        .fillMaxSize()
        .background(colorBg)) {

        repeat(12) {
            Canvas(Modifier
                .fillMaxSize()
                .aspectRatio(1f)
                .rotate(15f * it)) {
                drawLine(
                    colorLine,
                    start = Offset(x = size.width / 2, y = 0f),
                    end = Offset(x = size.width / 2, y = size.height),
                    strokeWidth = strokeWidth
                )
                drawLine(
                    colorLine,
                    start = Offset(x = size.width / 2 + deltaX, y = 0f),
                    end = Offset(x = size.width / 2 + deltaX, y = size.height),
                    strokeWidth = strokeWidth
                )
                drawLine(
                    colorLine,
                    start = Offset(x = size.width / 2 - deltaX, y = 0f),
                    end = Offset(x = size.width / 2 - deltaX, y = size.height),
                    strokeWidth = strokeWidth
                )

                drawLine(
                    colorLine,
                    start = Offset(x = size.width / 2 + 2 * deltaX, y = 0f),
                    end = Offset(x = size.width / 2 + 2 * deltaX, y = size.height),
                    strokeWidth = strokeWidth
                )

                drawLine(
                    colorLine,
                    start = Offset(x = size.width / 2 - 2 * deltaX, y = 0f),
                    end = Offset(x = size.width / 2 - 2 * deltaX, y = size.height),
                    strokeWidth = strokeWidth
                )

                drawCircle(color = colorBg, radius = 170f)
            }
        }
    }


}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AstigmatizmTheme {
        Greeting("Android")
    }
}