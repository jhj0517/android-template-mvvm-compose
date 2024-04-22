package com.jhj0517.android_template_mvvm_compose.views.home

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jhj0517.android_template_mvvm_compose.models.localdb.ExampleData


@Composable
fun HomeListScreen(
    modifier: Modifier = Modifier,
    list: List<ExampleData>,
    onDelete: (ExampleData) -> Unit = {},
){
    LazyColumn(modifier.fillMaxSize()) {
        items(list) {
            ListItem(it, onDelete = { onDelete(it) })
        }
    }
}

@Composable
fun ListItem(data: ExampleData, onDelete: () -> Unit, modifier: Modifier = Modifier) {
    Row(modifier.fillMaxWidth()) {
        Text(text = data.name, modifier = Modifier.weight(1f))
        DeleteButton(onClick = onDelete)
    }
}