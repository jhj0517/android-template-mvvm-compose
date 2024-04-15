package com.jhj0517.android_template_mvvm_compose.views

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

@Composable
fun SearchBar(){
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { text = it },
        placeholder = {
            Text(text = "Input")
        }
    )
}
@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    Empty_activity_sampleTheme {
        SearchBar()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Empty_activity_sampleTheme {
        Greeting("Android")
    }
}