package com.djsunilsonu.player

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
                PremiumLiquidGlassUI()
            }
        }
    }
}

@Composable
fun PremiumLiquidGlassUI() {
    // 1. Ultra-Premium Liquid Background (Neon Purple, Blue, Pink)
    val mainBackground = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF5A72EA), // Light Neon Blue
            Color(0xFF8B5BEA), // Deep Purple
            Color(0xFFE285C5), // Neon Pink
            Color(0xFF3B5998)
        )
    )

    // 2. Real Glassmorphism Effect (Fade to Transparent)
    val glassFill = Brush.linearGradient(
        colors = listOf(Color.White.copy(alpha = 0.2f), Color.White.copy(alpha = 0.05f))
    )
    val glassBorder = Brush.linearGradient(
        colors = listOf(Color.White.copy(alpha = 0.5f), Color.Transparent, Color.White.copy(alpha = 0.1f))
    )

    Box(modifier = Modifier.fillMaxSize().background(mainBackground)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 45.dp, start = 16.dp, end = 16.dp, bottom = 100.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // --- TOP HEADER ---
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Profile Pic Placeholder
                Box(
                    modifier = Modifier.size(50.dp).clip(CircleShape).background(Brush.linearGradient(listOf(Color.Magenta, Color.Cyan))),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Rounded.Person, contentDescription = null, tint = Color.White)
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("DJ SUNIL SONU", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(Icons.Rounded.Verified, contentDescription = "Verified", tint = Color(0xFF00E5FF), modifier = Modifier.size(16.dp))
                    }
                    Text("Music is Life... ♫", color = Color.White.copy(alpha = 0.8f), fontSize = 13.sp)
                }

                Row {
                    // Notification Icon with Badge
                    Box(modifier = Modifier.size(45.dp).clip(CircleShape).background(glassFill).border(1.dp, glassBorder, CircleShape), contentAlignment = Alignment.Center) {
                        Icon(Icons.Rounded.Notifications, contentDescription = null, tint = Color.White)
                        Box(modifier = Modifier.align(Alignment.TopEnd).padding(6.dp).size(10.dp).clip(CircleShape).background(Color.Red))
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Box(modifier = Modifier.size(45.dp).clip(CircleShape).background(glassFill).border(1.dp, glassBorder, CircleShape), contentAlignment = Alignment.Center) {
                        Icon(Icons.Rounded.Tune, contentDescription = null, tint = Color.White)
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // --- MENU TABS (Now Playing, Library, DJ Mixer) ---
            Row(
                modifier = Modifier.fillMaxWidth().height(45.dp).clip(RoundedCornerShape(24.dp)).background(glassFill).border(1.dp, glassBorder, RoundedCornerShape(24.dp)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(modifier = Modifier.weight(1f).fillMaxHeight().clip(RoundedCornerShape(24.dp)).background(Brush.horizontalGradient(listOf(Color(0xFF8B5BEA), Color(0xFF5A72EA)))), contentAlignment = Alignment.Center) {
                    Text("Now Playing", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                }
                Text("Library", color = Color.White.copy(alpha = 0.7f), fontSize = 12.sp, modifier = Modifier.weight(1f), textAlign = androidx.compose.ui.text.style.TextAlign.Center)
                Text("DJ Mixer", color = Color.White.copy(alpha = 0.7f), fontSize = 12.sp, modifier = Modifier.weight(1f), textAlign = androidx.compose.ui.text.style.TextAlign.Center)
                Text("More", color = Color.White.copy(alpha = 0.7f), fontSize = 12.sp, modifier = Modifier.weight(1f), textAlign = androidx.compose.ui.text.style.TextAlign.Center)
            }

            Spacer(modifier = Modifier.height(30.dp))

            // --- CENTER VINYL PLAYER (Glowing) ---
            Box(
                modifier = Modifier
                    .size(240.dp)
                    .clip(CircleShape)
                    .background(Brush.radialGradient(listOf(Color(0xFF4A4A5A), Color(0xFF11111A))))
                    .border(2.dp, Brush.linearGradient(listOf(Color(0xFF00E5FF), Color(0xFFE285C5))), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Box(modifier = Modifier.size(180.dp).border(1.dp, Color.White.copy(alpha = 0.15f), CircleShape))
                Box(modifier = Modifier.size(120.dp).border(1.dp, Color.White.copy(alpha = 0.1f), CircleShape))
                Box(modifier = Modifier.size(70.dp).clip(CircleShape).background(Brush.linearGradient(listOf(Color(0xFF8B5BEA), Color(0xFF5A72EA)))), contentAlignment = Alignment.Center) {
                    Icon(Icons.Rounded.MusicNote, contentDescription = null, tint = Color.White, modifier = Modifier.size(35.dp))
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            // --- MAIN MUSIC PLAYER CARD ---
            Box(
                modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(32.dp)).background(glassFill).border(1.dp, glassBorder, RoundedCornerShape(32.dp)).padding(20.dp)
            ) {
                Column {
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(modifier = Modifier.size(50.dp).clip(RoundedCornerShape(12.dp)).background(Brush.linearGradient(listOf(Color.Blue, Color.Cyan))))
                            Spacer(modifier = Modifier.width(12.dp))
                            Column {
                                Text("Desi Bass Blast", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                                Text("DJ SUNIL SONU • Bass Edition", color = Color.White.copy(alpha = 0.7f), fontSize = 12.sp)
                            }
                        }
                        Icon(Icons.Rounded.Favorite, contentDescription = null, tint = Color(0xFFFF6B6B), modifier = Modifier.size(28.dp))
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    // Progress Bar
                    Box(modifier = Modifier.fillMaxWidth().height(4.dp).background(Color.White.copy(alpha = 0.2f), CircleShape)) {
                        Box(modifier = Modifier.fillMaxWidth(0.45f).height(4.dp).background(Brush.horizontalGradient(listOf(Color.Cyan, Color.Magenta)), CircleShape))
                        Box(modifier = Modifier.padding(start = 135.dp).size(12.dp).offset(y = (-4).dp).clip(CircleShape).background(Color.White)) // Thumb
                    }
                    Row(modifier = Modifier.fillMaxWidth().padding(top = 8.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text("01:32", color = Color.White.copy(alpha = 0.7f), fontSize = 12.sp)
                        Text("03:45", color = Color.White.copy(alpha = 0.7f), fontSize = 12.sp)
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Controls
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Rounded.Shuffle, contentDescription = null, tint = Color.White.copy(alpha = 0.8f), modifier = Modifier.size(26.dp))
                        Icon(Icons.Rounded.SkipPrevious, contentDescription = null, tint = Color.White, modifier = Modifier.size(36.dp))
                        Box(
                            modifier = Modifier.size(65.dp).clip(CircleShape).background(glassFill).border(1.dp, glassBorder, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(Icons.Rounded.Pause, contentDescription = null, tint = Color.White, modifier = Modifier.size(36.dp))
                        }
                        Icon(Icons.Rounded.SkipNext, contentDescription = null, tint = Color.White, modifier = Modifier.size(36.dp))
                        Icon(Icons.Rounded.Repeat, contentDescription = null, tint = Color.White.copy(alpha = 0.8f), modifier = Modifier.size(26.dp))
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // --- BOTTOM TOGGLES (Auto-Pause & Gapless) ---
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Box(modifier = Modifier.weight(1f).height(60.dp).clip(RoundedCornerShape(24.dp)).background(glassFill).border(1.dp, glassBorder, RoundedCornerShape(24.dp)), contentAlignment = Alignment.Center) {
                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(horizontal = 12.dp)) {
                        Icon(Icons.Rounded.Headphones, contentDescription = null, tint = Color.White, modifier = Modifier.size(24.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Auto-Pause\non Disconnect", color = Color.White, fontSize = 11.sp, lineHeight = 14.sp, modifier = Modifier.weight(1f))
                        Switch(checked = true, onCheckedChange = {}, colors = SwitchDefaults.colors(checkedThumbColor = Color.White, checkedTrackColor = Color(0xFF8B5BEA)))
                    }
                }
                Spacer(modifier = Modifier.width(12.dp))
                Box(modifier = Modifier.weight(1f).height(60.dp).clip(RoundedCornerShape(24.dp)).background(glassFill).border(1.dp, glassBorder, RoundedCornerShape(24.dp)), contentAlignment = Alignment.Center) {
                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(horizontal = 12.dp)) {
                        Icon(Icons.Rounded.GraphicEq, contentDescription = null, tint = Color.White, modifier = Modifier.size(24.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Gapless\nPlayback", color = Color.White, fontSize = 11.sp, lineHeight = 14.sp, modifier = Modifier.weight(1f))
                        Switch(checked = true, onCheckedChange = {}, colors = SwitchDefaults.colors(checkedThumbColor = Color.White, checkedTrackColor = Color(0xFF8B5BEA)))
                    }
                }
            }
        }

        // --- BOTTOM NAVIGATION BAR ---
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
                .fillMaxWidth()
                .height(70.dp)
                .clip(RoundedCornerShape(35.dp))
                .background(glassFill)
                .border(1.dp, glassBorder, RoundedCornerShape(35.dp)),
            contentAlignment = Alignment.Center
        ) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically) {
                Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.background(Brush.verticalGradient(listOf(Color(0xFF8B5BEA).copy(alpha=0.5f), Color.Transparent)), CircleShape).padding(8.dp)) {
                    Icon(Icons.Rounded.Home, contentDescription = null, tint = Color.White)
                    Text("Home", color = Color.White, fontSize = 10.sp)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(Icons.Rounded.Explore, contentDescription = null, tint = Color.White.copy(alpha = 0.6f))
                    Text("Explore", color = Color.White.copy(alpha = 0.6f), fontSize = 10.sp)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(Icons.Rounded.LibraryMusic, contentDescription = null, tint = Color.White.copy(alpha = 0.6f))
                    Text("Library", color = Color.White.copy(alpha = 0.6f), fontSize = 10.sp)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(Icons.Rounded.Settings, contentDescription = null, tint = Color.White.copy(alpha = 0.6f))
                    Text("Settings", color = Color.White.copy(alpha = 0.6f), fontSize = 10.sp)
                }
            }
        }
    }
}
