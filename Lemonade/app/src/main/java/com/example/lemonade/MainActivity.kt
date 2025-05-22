package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                Lemonade()
            }
        }
    }
}

@Composable
fun Lemonade(modifier: Modifier = Modifier) {
    var currState by remember { mutableStateOf(1) }
    var totalTap by remember { mutableStateOf(-1) }
    var expTap by remember { mutableStateOf(0) }
    val currImg = when(currState) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    val currText = when(currState) {
        1 -> R.string.lemon_tree_start
        2 -> R.string.lemon_tree_squeeze
        3 -> R.string.lemon_tree_drink
        else -> R.string.lemon_tree_restart
    }

    val contentDesc = when(currState) {
        1 -> R.string.lemon_tree_text
        2 -> R.string.lemon_text
        3 -> R.string.lemon_glass_text
        else -> R.string.lemon_empty_text
    }

    Surface (
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column (
            modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(
                modifier = Modifier.background(color = Color.Green),
                onClick = {
                    when(currState) {
                        2 -> {
                            if (totalTap == -1) {
                                // we assume this is the first request for state 2
                                expTap = (1..4).random()
                                totalTap = 0
                            } else if(totalTap == expTap) {
                                currState++
                                totalTap = -1
                            } else {
                                totalTap++
                            }
                        }
                        else -> {
                            // can directly update the curr state
                            if (currState < 4) {
                                currState++
                            } else {
                                currState = 1
                            }
                        }
                    }
                }
            ) {
                Image(
                    painter = painterResource(currImg),
                    contentDescription = stringResource(contentDesc),
                )
            }

            Text(
                text = stringResource(currText),
                fontSize = 18.sp,
                modifier = Modifier.padding(18.dp)
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun LemonadePreview() {
    LemonadeTheme {
        Lemonade(modifier = Modifier.fillMaxSize())
    }
}
