package com.jhj0517.android_template_mvvm_compose.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jhj0517.android_template_mvvm_compose.ui.Empty_activity_sampleTheme

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Empty_activity_sampleTheme {
        Greeting("Android")
    }
}