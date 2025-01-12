package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Surface (
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    QuadrantApp()
                }
            }
        }
    }
}

@Composable
fun QuadrantApp(modifier: Modifier = Modifier) {
    Column (
        Modifier.fillMaxWidth()
    ) {
        Row (Modifier.weight(1f)) {
            QuadrantCard(
                title = stringResource(R.string.text_composable_text),
                content = stringResource(R.string.text_composeable_description_text),
                bgColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f),
            )
            QuadrantCard(
                title = stringResource(R.string.image_composable_text),
                content = stringResource(R.string.image_composeable_description_text),
                bgColor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f),
            )
        }
        Row (Modifier.weight(1f)) {
            QuadrantCard(
                title = stringResource(R.string.row_composable_text),
                content = stringResource(R.string.row_composeable_description_text),
                bgColor = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f),
            )
            QuadrantCard(
                title = stringResource(R.string.column_composable_text),
                content = stringResource(R.string.column_composeable_description_text),
                bgColor = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f),
            )
        }
    }
}

@Composable
fun QuadrantCard(title: String, content: String, bgColor: Color, modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .background(color = bgColor)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
        Text(
            text = content,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun QuadrantPreview() {
    ComposeQuadrantTheme {
        QuadrantApp()
    }
}