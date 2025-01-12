package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DetailPage(
                        title = stringResource(R.string.jetpack_compose_title_text),
                        firstContent = stringResource(R.string.jetpack_compose_first_content_title),
                        secondContent = stringResource(R.string.jetpack_compose_second_content_text),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ContentDetail(title: String, firstContent: String, secondContent: String, modifier: Modifier = Modifier) {
    Column (
        modifier = modifier,
    ) {
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier,
        )
        Text(
            text = firstContent,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(top = 16.dp),
        )
        Text(
            text = secondContent,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(top = 16.dp),
        )
    }
}

@Composable
fun DetailPage(title: String, firstContent: String, secondContent: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Box(modifier) {
        Column(modifier) {
            Image(
                painter = image,
                modifier = Modifier,
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
            )
            ContentDetail(
                title = title,
                firstContent = firstContent,
                secondContent = secondContent,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(18.dp),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeArticlePreview() {
    ComposeArticleTheme {
        DetailPage(
            title = stringResource(R.string.jetpack_compose_title_text),
            firstContent = stringResource(R.string.jetpack_compose_first_content_title),
            secondContent = stringResource(R.string.jetpack_compose_second_content_text),
        )
    }
}