package com.example.mytweetsy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mytweetsy.screens.CategoryScreen
import com.example.mytweetsy.screens.detailScreen
import com.example.mytweetsy.ui.theme.MyTweetsyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
//    @Inject
//    lateinit var tweetsyAPI: TweetsyAPI
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTweetsyTheme {
                // A surface container using the 'background' color from the theme

                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "Tweetsy")
                            }, backgroundColor = Color.Black, contentColor = Color.White)
                    }
                ) {
                    Box(modifier = Modifier.padding(it)) {
                        App()
                    }
                }
            }
        }
    }

}

@Composable
fun App() {
    val navController = rememberNavController()
    val navHostController = NavHost(navController = navController, startDestination = "category") {
        composable(route = "category") {
            CategoryScreen {
                navController.navigate("detail")
            }
        }
        composable(route = "detail") {
            detailScreen()
        }
    }
}

// Test code
//GlobalScope.launch(Dispatchers.IO) {
//    var response = tweetsyAPI.getCategories()
//    Log.d("CheezyCode",response.body().toString())
//    var list = response.body()
//    var categoryList = ArrayList<String>()
//    list?.forEach {
//        it.text
//        categoryList.add(it.category)
//        Log.d("CheezyCode",it.category)
//    }
//}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyTweetsyTheme {
        Greeting("Android")
    }
}