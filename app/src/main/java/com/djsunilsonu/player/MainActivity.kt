package com.djsunilsonu.player

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                MusicPlayerUI()
            }
        }
    }
}

@Composable
fun MusicPlayerUI() {
    val bgGradient = Brush.verticalGradient(
        colors = listOf(Color(0xFF5A72EA), Color(0xFF8B5BEA), Color(0xFFC769B7))
    )
    Box(modifier = Modifier.fillMaxSize().background(bgGradient)) {
        Column(
            modifier = Modifier.fillMaxSize().padding(top = 50.dp, start = 16.dp, end = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "DJ SUNIL SONU", color = Color.White, fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Text(text = "Music is Life...", color = Color.White.copy(alpha = 0.8f), fontSize = 14.sp)
            Spacer(modifier = Modifier.height(50.dp))
            Box(
                modifier = Modifier.size(220.dp).background(Color(0xFF1E1E2E), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Box(modifier = Modifier.size(60.dp).background(Color.Black, CircleShape))
            }
            Spacer(modifier = Modifier.height(40.dp))
            Surface(
                modifier = Modifier.fillMaxWidth().height(180.dp),
                color = Color.White.copy(alpha = 0.15f),
                shape = RoundedCornerShape(24.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize().padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text("Desi Bass Blast", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Text("DJ SUNIL SONU • Bass Edition", color = Color.White.copy(alpha = 0.7f), fontSize = 14.sp)
                }
            }
        }
    }
}
