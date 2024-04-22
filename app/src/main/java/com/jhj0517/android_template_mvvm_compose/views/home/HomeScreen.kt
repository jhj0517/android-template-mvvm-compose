package com.jhj0517.android_template_mvvm_compose.views.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jhj0517.android_template_mvvm_compose.models.localdb.ExampleData
import com.jhj0517.android_template_mvvm_compose.ui.Theme
import com.jhj0517.android_template_mvvm_compose.viewmodels.DataViewModel
import com.jhj0517.android_template_mvvm_compose.views.common.NormalAppBar


@Composable
fun HomeScreen(
    viewModel: DataViewModel = hiltViewModel(),
){
    var input by rememberSaveable { mutableStateOf("") }
    val list  = viewModel.exampleDataList.observeAsState().value ?: listOf()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding(),
        topBar = {
            NormalAppBar(title = "HomeScreen")
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(top = 20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            SearchBar(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                input=input,
                onChange = { input= it },
                onSend = { viewModel.insertLocalData(ExampleData(name = input)) }
            )

            HomeListScreen(
                list = list,
                onDelete = { viewModel.deleteLocalData(it) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    Theme {
        HomeScreen()
    }
}

@Composable
fun DeleteButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    IconButton(onClick = onClick, modifier = modifier) {
        Icon(
            imageVector = Icons.Filled.Delete,
            contentDescription = "Delete",
        )
    }
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    input: String,
    onChange: (String) -> Unit,
    onSend: () -> Unit
) {
    TextField(
        modifier = modifier,
        value = input,
        onValueChange = onChange,
        placeholder = {
            Text(text = "Input")
        },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Send),
        keyboardActions = KeyboardActions(onSend = { onSend() } )
    )
}