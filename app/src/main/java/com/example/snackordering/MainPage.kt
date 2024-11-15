package com.example.snackordering

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.snackordering.ui.theme.SnackOrderingTheme

import android.content.Intent as Intent1
import androidx.compose.ui.graphics.Brush



class MainPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SnackOrderingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    FinalView(this)
                    val context = LocalContext.current
                    //PopularFoodColumn(context)
                }
            }
        }
    }
}

@Composable
fun TopPart() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xffeceef1))
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = "Menu Icon",
            modifier = Modifier
                .clip(CircleShape)
                .size(40.dp)
                .background(Color.LightGray)
                .padding(8.dp),
            tint = Color.Black,
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Your Location",
                style = MaterialTheme.typography.subtitle1,
                color = Color.Black
            )
            Row {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "Location",
                    tint = Color.Red,
                )
                Text(text = "PSG iTech", color = Color.Black, fontWeight = FontWeight.Bold)
            }
        }
        Icon(
            imageVector = Icons.Default.Notifications,
            contentDescription = "Notification Icon",
            modifier = Modifier
                .size(40.dp)
                .background(Color.LightGray)
                .clip(CircleShape)
                .padding(8.dp),
            tint = Color.Black,
        )
    }
}
@Composable
fun CardPart() {
    Card(
        modifier = Modifier
            .size(width = 300.dp, height = 180.dp)
            .clip(RoundedCornerShape(20.dp)),
        elevation = 10.dp
    ) {
        Row(modifier = Modifier.padding(16.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text(
                    text = "Exclusive Offer!",
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Get up to 85% off",
                    style = MaterialTheme.typography.h5,
                    color = Color(0xFF008577)
                )
                Button(
                    onClick = { /* Handle voucher */ },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF008577))
                ) {
                    Text(text = "Claim Now", color = Color.White)
                }
            }
            Image(
                painter = painterResource(id = R.drawable.food_tip_im),
                contentDescription = "Food Image",
                modifier = Modifier.size(100.dp)
            )
        }
    }
}

@Composable
fun PopularFood(
    @DrawableRes drawable: Int,
    @StringRes text1: Int,
    context: Context
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .width(300.dp)
            .height(250.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = 5.dp
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = drawable),
                contentDescription = "Food Image",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(id = text1),
                style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold),
                color = Color.White
            )
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Rs.150",
                    style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold),
                    color = Color(0xFF00796B)
                )
                IconButton(onClick = {
                    val intent = Intent1(context, TargetActivity::class.java)
                    context.startActivity(intent)
                }) {
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "Add to Cart",
                        tint = Color(0xFF00796B)
                    )
                }
            }
        }
    }
}



private val FoodList = listOf(
    R.drawable.sandwich to R.string.sandwich,
    R.drawable.burger to R.string.burgers,
    R.drawable.pack to R.string.pack,
    R.drawable.pasta to R.string.pasta,
    R.drawable.salad to R.string.salad,
    R.drawable.popcorn to R.string.popcorn,
    R.drawable.donut to R.string.donut,
    R.drawable.icecream to R.string.icecream,
    R.drawable.pizza to R.string.pizza,
    R.drawable.sushi to R.string.sushi
).map { DrawableStringPair(it.first, it.second) }

private data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text1: Int
)


@Composable
fun App(context: Context) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFFFFF3E0), Color(0xFFFBE9E7))
                )
            )
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(elevation = 5.dp) { TopPart() }
        Spacer(modifier = Modifier.height(16.dp))
        CardPart()
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Popular Food",
            style = MaterialTheme.typography.h5,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Start)
        )
        PopularFoodColumn(context)
    }
}



@Composable
fun PopularFoodColumn(context: Context) {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),

        content = {
            items(FoodList) { item ->
                PopularFood(context = context,drawable = item.drawable, text1 = item.text1)
                abstract class Context
            }
        },
        verticalArrangement = Arrangement.spacedBy(16.dp))
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun FinalView(mainPage: MainPage) {
    SnackOrderingTheme {
        Scaffold() {
            val context = LocalContext.current
            App(context)
        }
    }
}