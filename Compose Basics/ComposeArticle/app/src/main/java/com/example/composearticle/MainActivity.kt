package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
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
                }
                CombinedUI(
                    para1 = stringResource(R.string.para1_text),
                    para2 = stringResource(R.string.para2_text),
                    para3 = stringResource(R.string.para3_text)
                )
            }
        }
    }
}

@Composable
fun HeaderImage(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Image(
        painter = image,
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
        modifier = modifier
    )
}

@Composable
fun HeaderTexts(para1: String, para2: String, para3: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = para1,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)
        )
        Text(
            text = para2,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = para3,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(16.dp)
        )
    }
}

@Composable
fun CombinedUI(para1: String, para2: String, para3: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        HeaderImage()
        HeaderTexts(
            para1 = para1,
            para2 = para2,
            para3 = para3
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun ComposeArticlePreview() {
    ComposeArticleTheme {
        CombinedUI(
            para1 = stringResource(R.string.para1_text),
            para2 = stringResource(R.string.para2_text),
            para3 = stringResource(R.string.para3_text)
        )
    }
}
