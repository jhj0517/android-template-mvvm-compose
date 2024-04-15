package com.jhj0517.android_template_mvvm_compose.views

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Destination(
    val route: String,
    val navArguments: List<NamedNavArgument> = emptyList()
) {

    data object Home : Destination("home")

}
