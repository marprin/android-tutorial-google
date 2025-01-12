package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCard(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ImageAndNameCard(name: String, role: String, modifier: Modifier = Modifier) {
    val img = painterResource(R.drawable.android_logo)
    Image(
        painter = img,
        contentDescription = null,
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .width(150.dp)
            .height(150.dp)
            .background(Color.Black)
    )
    Text(
        text = name,
        fontSize = 36.sp,
        modifier = Modifier
            .padding(bottom = 8.dp, top = 8.dp)
    )
    Text(
        text = role,
        fontSize = 16.sp,
    )
}

@Composable
fun ContactInfoCard(phone: String, socialMediaAccount: String, email: String, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = phone,
            modifier = Modifier
                .padding(bottom = 8.dp)
        )
        Text(
            text = socialMediaAccount,
            modifier = Modifier
                .padding(bottom = 8.dp)
        )
        Text(
            text = email,
            modifier = Modifier
                .padding(bottom = 40.dp)
        )
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Box (
        modifier = Modifier
            .background(Color(0xFF7EE26D))
    ) {
        Column (
            modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            ImageAndNameCard(
                name = "John Doe",
                role = "Software Engineer",
                modifier = modifier,
            )
        }
        Column (
            modifier,
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            ContactInfoCard(
                phone = "+11 (123) 444 55 666",
                socialMediaAccount = "@priventech",
                email = "contact@priventech.com",
                modifier = modifier,
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard(
            modifier = Modifier
                .fillMaxSize()
        )
    }
}