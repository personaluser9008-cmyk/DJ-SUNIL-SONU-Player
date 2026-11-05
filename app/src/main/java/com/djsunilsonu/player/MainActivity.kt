package com.djsunilsonu.player

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                MusicPlayerPremiumUI()
            }
        }
    }
}

@Composable
fun MusicPlayerPremiumUI() {
    // Advanced Liquid Background
    val bgGradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF2C3E8A), // Deep Blue
            Color(0xFF8B5BEA), // Purple
            Color(0xFFE285C5)  // Neon Pink
        )
    )

    // Glassmorphism transparent color & border
    val glassColor = Color.White.copy(alpha = 0.12f)
    val glassBorder = Color.White.copy(alpha = 0.3f)

    Box(modifier = Modifier.fillMaxSize().background(bgGradient)) {
        Column(
            modifier = Modifier.fillMaxSize().padding(top = 50.dp, start = 20.dp, end = 20.dp, bottom = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            
            // Top Header Bar
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Profile Avatar Placeholder
                Box(modifier = Modifier.size(50.dp).clip(CircleShape).background(Brush.linearGradient(listOf(Color.Cyan, Color.Blue))))
                
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("DJ SUNIL SONU", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(Icons.Rounded.CheckCircle, contentDescription = "Verified", tint = Color.Cyan, modifier = Modifier.size(16.dp))
                    }
                    Text("Music is Life... ♫", color = Color.White.copy(alpha = 0.7f), fontSize = 12.sp)
                }
                
                Row {
                    Box(modifier = Modifier.size(45.dp).clip(CircleShape).background(glassColor).border(1.dp, glassBorder, CircleShape), contentAlignment = Alignment.Center) {
                        Icon(Icons.Rounded.Notifications, contentDescription = "Alerts", tint = Color.White)
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Box(modifier = Modifier.size(45.dp).clip(CircleShape).background(glassColor).border(1.dp, glassBorder, CircleShape), contentAlignment = Alignment.Center) {
                        Icon(Icons.Rounded.Tune, contentDescription = "Settings", tint = Color.White)
                    }
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            // Center Vinyl Disc Player
            Box(
                modifier = Modifier
                    .size(260.dp)
                    .clip(CircleShape)
                    .background(Brush.radialGradient(listOf(Color(0xFF333344), Color(0xFF11111A))))
                    .border(3.dp, Brush.linearGradient(listOf(Color.Cyan, Color.Magenta)), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                // Inner record lines
                Box(modifier = Modifier.size(200.dp).border(1.dp, Color.White.copy(alpha = 0.1f), CircleShape))
                Box(modifier = Modifier.size(140.dp).border(1.dp, Color.White.copy(alpha = 0.1f), CircleShape))
                
                // Center Neon Note
                Box(
                    modifier = Modifier.size(80.dp).clip(CircleShape).background(Color.Black),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Rounded.MusicNote, contentDescription = "Music", tint = Color.Magenta, modifier = Modifier.size(40.dp))
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            // Main Liquid Glass Player Card
            Surface(
                modifier = Modifier.fillMaxWidth().wrapContentHeight(),
                color = glassColor,
                shape = RoundedCornerShape(32.dp),
                border = androidx.compose.foundation.BorderStroke(1.dp, glassBorder)
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text("Desi Bass Blast", color = Color.White, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                            Text("DJ SUNIL SONU • Bass Edition", color = Color.White.copy(alpha = 0.7f), fontSize = 14.sp)
                        }
                        Icon(Icons.Rounded.FavoriteBorder, contentDescription = "Like", tint = Color(0xFFFF6B6B), modifier = Modifier.size(30.dp))
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    // Progress Bar
                    Box(modifier = Modifier.fillMaxWidth().height(4.dp).background(Color.White.copy(alpha = 0.2f), CircleShape)) {
                        Box(modifier = Modifier.fillMaxWidth(0.4f).height(4.dp).background(Brush.horizontalGradient(listOf(Color.Cyan, Color.Magenta)), CircleShape))
                    }
                    
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("01:32", color = Color.White.copy(alpha = 0.6f), fontSize = 12.sp)
                        Text("03:45", color = Color.White.copy(alpha = 0.6f), fontSize = 12.sp)
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    // Playback Controls
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(Icons.Rounded.Shuffle, contentDescription = "Shuffle", tint = Color.White.copy(alpha = 0.7f), modifier = Modifier.size(28.dp))
                        Icon(Icons.Rounded.SkipPrevious, contentDescription = "Previous", tint = Color.White, modifier = Modifier.size(40.dp))
                        
                        // Play Pause Glass Button
                        Box(
                            modifier = Modifier
                                .size(70.dp)
                                .clip(CircleShape)
                                .background(glassColor)
                                .border(1.dp, Color.White.copy(alpha = 0.5f), CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(Icons.Rounded.Pause, contentDescription = "Pause", tint = Color.White, modifier = Modifier.size(40.dp))
                        }
                        
                        Icon(Icons.Rounded.SkipNext, contentDescription = "Next", tint = Color.White, modifier = Modifier.size(40.dp))
                        Icon(Icons.Rounded.Repeat, contentDescription = "Repeat", tint = Color.White.copy(alpha = 0.7f), modifier = Modifier.size(28.dp))
                    }
                }
            }
        }
    }
}
