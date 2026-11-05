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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                UltraPremiumGlassUI()
            }
        }
    }
}

@Composable
fun UltraPremiumGlassUI() {
    // 1. COSMIC DEEP BACKGROUND (For High Contrast)
    val cosmicBackground = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF0F172A), // Very Dark Blue (Top)
            Color(0xFF3B0764), // Deep Rich Purple (Middle)
            Color(0xFFBE185D), // Neon Pinkish (Bottom)
            Color(0xFF1E1B4B)  // Dark Space Blue
        )
    )

    // 2. ULTRA GLASSMORPHISM (Brighter borders, subtle white fill)
    val glassFill = Color.White.copy(alpha = 0.08f)
    val glassBorder = Brush.linearGradient(
        colors = listOf(Color.White.copy(alpha = 0.6f), Color.White.copy(alpha = 0.1f), Color.White.copy(alpha = 0.4f))
    )

    Box(modifier = Modifier.fillMaxSize().background(cosmicBackground)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 45.dp, start = 16.dp, end = 16.dp, bottom = 90.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // --- TOP HEADER ---
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Profile Avatar (Glowing)
                Box(
                    modifier = Modifier.size(52.dp).shadow(10.dp, CircleShape).clip(CircleShape).background(Brush.linearGradient(listOf(Color(0xFF00F2FE), Color(0xFF4FACFE)))),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Rounded.Person, contentDescription = null, tint = Color.White, modifier = Modifier.size(30.dp))
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("DJ SUNIL SONU", color = Color.White, fontSize = 19.sp, fontWeight = FontWeight.ExtraBold)
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(Icons.Rounded.Verified, contentDescription = "Verified", tint = Color(0xFF00E5FF), modifier = Modifier.size(18.dp))
                    }
                    Text("Music is Life... ♫", color = Color.White.copy(alpha = 0.8f), fontSize = 13.sp, fontWeight = FontWeight.Medium)
                }

                Row {
                    // Notification Bell Glass
                    Box(modifier = Modifier.size(46.dp).clip(CircleShape).background(glassFill).border(1.5.dp, glassBorder, CircleShape), contentAlignment = Alignment.Center) {
                        Icon(Icons.Rounded.Notifications, contentDescription = null, tint = Color.White)
                        Box(modifier = Modifier.align(Alignment.TopEnd).padding(8.dp).size(10.dp).shadow(4.dp, CircleShape).clip(CircleShape).background(Color(0xFFFF0055)))
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Box(modifier = Modifier.size(46.dp).clip(CircleShape).background(glassFill).border(1.5.dp, glassBorder, CircleShape), contentAlignment = Alignment.Center) {
                        Icon(Icons.Rounded.Tune, contentDescription = null, tint = Color.White)
                    }
                }
            }

            Spacer(modifier = Modifier.height(28.dp))

            // --- MENU TABS (Neon Active Tab) ---
            Row(
                modifier = Modifier.fillMaxWidth().height(48.dp).shadow(8.dp, RoundedCornerShape(24.dp)).clip(RoundedCornerShape(24.dp)).background(Color.White.copy(alpha=0.05f)).border(1.dp, glassBorder, RoundedCornerShape(24.dp)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(modifier = Modifier.weight(1.2f).fillMaxHeight().clip(RoundedCornerShape(24.dp)).background(Brush.horizontalGradient(listOf(Color(0xFF8A2387), Color(0xFFE94057), Color(0xFFF27121)))), contentAlignment = Alignment.Center) {
                    Text("Now Playing", color = Color.White, fontSize = 13.sp, fontWeight = FontWeight.Bold)
                }
                Text("Library", color = Color.White.copy(alpha = 0.7f), fontSize = 13.sp, fontWeight = FontWeight.Medium, modifier = Modifier.weight(1f), textAlign = androidx.compose.ui.text.style.TextAlign.Center)
                Text("DJ Mixer", color = Color.White.copy(alpha = 0.7f), fontSize = 13.sp, fontWeight = FontWeight.Medium, modifier = Modifier.weight(1f), textAlign = androidx.compose.ui.text.style.TextAlign.Center)
                Text("More", color = Color.White.copy(alpha = 0.7f), fontSize = 13.sp, fontWeight = FontWeight.Medium, modifier = Modifier.weight(0.8f), textAlign = androidx.compose.ui.text.style.TextAlign.Center)
            }

            Spacer(modifier = Modifier.height(35.dp))

            // --- 3D METALLIC VINYL PLAYER ---
            Box(
                modifier = Modifier
                    .size(260.dp)
                    .shadow(25.dp, CircleShape, spotColor = Color.Black)
                    .clip(CircleShape)
                    // Real Metallic CD Shine using SweepGradient
                    .background(Brush.sweepGradient(listOf(Color(0xFF111111), Color(0xFF555555), Color(0xFF111111), Color(0xFF555555), Color(0xFF111111))))
                    .border(3.dp, Brush.linearGradient(listOf(Color(0xFF00F2FE), Color(0xFFFA709A))), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                // CD Grooves
                Box(modifier = Modifier.size(200.dp).border(1.dp, Color.White.copy(alpha = 0.15f), CircleShape))
                Box(modifier = Modifier.size(130.dp).border(1.dp, Color.White.copy(alpha = 0.1f), CircleShape))
                
                // Center Neon Hub
                Box(modifier = Modifier.size(75.dp).shadow(10.dp, CircleShape).clip(CircleShape).background(Brush.radialGradient(listOf(Color(0xFFFA709A), Color(0xFFBF089A)))), contentAlignment = Alignment.Center) {
                    Icon(Icons.Rounded.MusicNote, contentDescription = null, tint = Color.White, modifier = Modifier.size(40.dp))
                }
            }

            Spacer(modifier = Modifier.height(35.dp))

            // --- MAIN MUSIC PLAYER CARD (Thick Glass with Drop Shadow) ---
            Box(
                modifier = Modifier.fillMaxWidth().shadow(20.dp, RoundedCornerShape(32.dp), spotColor = Color.Black.copy(alpha=0.5f)).clip(RoundedCornerShape(32.dp)).background(glassFill).border(1.5.dp, glassBorder, RoundedCornerShape(32.dp)).padding(24.dp)
            ) {
                Column {
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            // Album Art Box
                            Box(modifier = Modifier.size(56.dp).shadow(8.dp, RoundedCornerShape(14.dp)).clip(RoundedCornerShape(14.dp)).background(Brush.linearGradient(listOf(Color(0xFF00C6FF), Color(0xFF0072FF)))))
                            Spacer(modifier = Modifier.width(16.dp))
                            Column {
                                Text("Desi Bass Blast", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
                                Text("DJ SUNIL SONU • Bass Edition", color = Color.White.copy(alpha = 0.7f), fontSize = 13.sp)
                            }
                        }
                        Icon(Icons.Rounded.Favorite, contentDescription = null, tint = Color(0xFFFF2A55), modifier = Modifier.size(32.dp))
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    // Premium Progress Bar
                    Box(modifier = Modifier.fillMaxWidth().height(5.dp).clip(CircleShape).background(Color.White.copy(alpha = 0.2f))) {
                        Box(modifier = Modifier.fillMaxWidth(0.45f).height(5.dp).clip(CircleShape).background(Brush.horizontalGradient(listOf(Color(0xFF00F2FE), Color(0xFFFA709A)))))
                        Box(modifier = Modifier.padding(start = 135.dp).size(14.dp).offset(y = (-4.5).dp).shadow(4.dp, CircleShape).clip(CircleShape).background(Color.White))
                    }
                    Row(modifier = Modifier.fillMaxWidth().padding(top = 10.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text("01:32", color = Color.White.copy(alpha = 0.8f), fontSize = 12.sp, fontWeight = FontWeight.Bold)
                        Text("03:45", color = Color.White.copy(alpha = 0.8f), fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    // Controls
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Rounded.Shuffle, contentDescription = null, tint = Color.White.copy(alpha = 0.8f), modifier = Modifier.size(28.dp))
                        Icon(Icons.Rounded.SkipPrevious, contentDescription = null, tint = Color.White, modifier = Modifier.size(42.dp))
                        // Big Play/Pause Button
                        Box(
                            modifier = Modifier.size(72.dp).shadow(10.dp, CircleShape).clip(CircleShape).background(glassFill).border(1.5.dp, glassBorder, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(Icons.Rounded.Pause, contentDescription = null, tint = Color.White, modifier = Modifier.size(40.dp))
                        }
                        Icon(Icons.Rounded.SkipNext, contentDescription = null, tint = Color.White, modifier = Modifier.size(42.dp))
                        Icon(Icons.Rounded.Repeat, contentDescription = null, tint = Color.White.copy(alpha = 0.8f), modifier = Modifier.size(28.dp))
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // --- BOTTOM TOGGLES (Fixed Layout & Glass) ---
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Box(modifier = Modifier.weight(1f).height(65.dp).shadow(8.dp, RoundedCornerShape(24.dp)).clip(RoundedCornerShape(24.dp)).background(glassFill).border(1.dp, glassBorder, RoundedCornerShape(24.dp)), contentAlignment = Alignment.CenterStart) {
                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(horizontal = 14.dp)) {
                        Icon(Icons.Rounded.Headphones, contentDescription = null, tint = Color.White, modifier = Modifier.size(26.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Auto-Pause", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold, maxLines = 1, overflow = TextOverflow.Ellipsis, modifier = Modifier.weight(1f))
                        Switch(checked = true, onCheckedChange = {}, colors = SwitchDefaults.colors(checkedThumbColor = Color.White, checkedTrackColor = Color(0xFFFA709A)), modifier = Modifier.scale(0.8f))
                    }
                }
                Spacer(modifier = Modifier.width(12.dp))
                Box(modifier = Modifier.weight(1f).height(65.dp).shadow(8.dp, RoundedCornerShape(24.dp)).clip(RoundedCornerShape(24.dp)).background(glassFill).border(1.dp, glassBorder, RoundedCornerShape(24.dp)), contentAlignment = Alignment.CenterStart) {
                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(horizontal = 14.dp)) {
                        Icon(Icons.Rounded.GraphicEq, contentDescription = null, tint = Color.White, modifier = Modifier.size(26.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Gapless", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold, maxLines = 1, overflow = TextOverflow.Ellipsis, modifier = Modifier.weight(1f))
                        Switch(checked = true, onCheckedChange = {}, colors = SwitchDefaults.colors(checkedThumbColor = Color.White, checkedTrackColor = Color(0xFFFA709A)), modifier = Modifier.scale(0.8f))
                    }
                }
            }
        }

        // --- BOTTOM NAVIGATION BAR (Floating & Glowing) ---
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp, start = 16.dp, end = 16.dp)
                .fillMaxWidth()
                .height(75.dp)
                .shadow(20.dp, RoundedCornerShape(38.dp))
                .clip(RoundedCornerShape(38.dp))
                .background(Color(0xFF1E1B4B).copy(alpha = 0.6f))
                .border(1.5.dp, glassBorder, RoundedCornerShape(38.dp)),
            contentAlignment = Alignment.Center
        ) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically) {
                Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.background(Brush.radialGradient(listOf(Color(0xFFFA709A).copy(alpha=0.4f), Color.Transparent)), CircleShape).padding(10.dp)) {
                    Icon(Icons.Rounded.Home, contentDescription = null, tint = Color.White, modifier = Modifier.size(28.dp))
                    Text("Home", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(Icons.Rounded.Explore, contentDescription = null, tint = Color.White.copy(alpha = 0.5f), modifier = Modifier.size(26.dp))
                    Text("Explore", color = Color.White.copy(alpha = 0.5f), fontSize = 11.sp)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(Icons.Rounded.LibraryMusic, contentDescription = null, tint = Color.White.copy(alpha = 0.5f), modifier = Modifier.size(26.dp))
                    Text("Library", color = Color.White.copy(alpha = 0.5f), fontSize = 11.sp)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(Icons.Rounded.Settings, contentDescription = null, tint = Color.White.copy(alpha = 0.5f), modifier = Modifier.size(26.dp))
                    Text("Settings", color = Color.White.copy(alpha = 0.5f), fontSize = 11.sp)
                }
            }
        }
    }
}
