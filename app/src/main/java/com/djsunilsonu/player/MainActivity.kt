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
import androidx.compose.ui.draw.scale
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
                ExactMatchGlassmorphismUI()
            }
        }
    }
}

// Helper function Glass effect ke liye
@Composable
fun GlassBox(modifier: Modifier = Modifier, shape: androidx.compose.ui.graphics.Shape, content: @Composable () -> Unit) {
    Box(
        modifier = modifier
            .clip(shape)
            .background(Color.White.copy(alpha = 0.15f))
            .border(1.dp, Color.White.copy(alpha = 0.4f), shape),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}

@Composable
fun ExactMatchGlassmorphismUI() {
    // Exact Background (Light Cyan -> Purple -> Pink -> Blue)
    val bgGradient = Brush.linearGradient(
        colors = listOf(
            Color(0xFF70A8F8), // Soft Light Blue
            Color(0xFF9868EA), // Soft Purple
            Color(0xFFE893D6), // Soft Pink
            Color(0xFF6B8DF2)  // Deep Blue
        )
    )

    Box(modifier = Modifier.fillMaxSize().background(bgGradient)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 45.dp, start = 16.dp, end = 16.dp, bottom = 90.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // --- 1. TOP HEADER ---
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Profile
                Box(
                    modifier = Modifier.size(52.dp).clip(CircleShape).background(Brush.linearGradient(listOf(Color(0xFFFA709A), Color(0xFF4A00E0)))),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Rounded.Person, contentDescription = null, tint = Color.White, modifier = Modifier.size(30.dp))
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("DJ SUNIL SONU", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(Icons.Rounded.CheckCircle, contentDescription = "Verified", tint = Color(0xFF00E5FF), modifier = Modifier.size(16.dp))
                    }
                    Text("Music is Life... ♫", color = Color.White.copy(alpha = 0.9f), fontSize = 13.sp)
                }

                Row {
                    // Bell Icon with Red 3
                    Box(contentAlignment = Alignment.TopEnd) {
                        GlassBox(modifier = Modifier.size(46.dp), shape = CircleShape) {
                            Icon(Icons.Rounded.Notifications, contentDescription = null, tint = Color.White)
                        }
                        Box(modifier = Modifier.padding(2.dp).size(16.dp).clip(CircleShape).background(Color.Red), contentAlignment = Alignment.Center) {
                            Text("3", color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    // Settings Icon
                    GlassBox(modifier = Modifier.size(46.dp), shape = CircleShape) {
                        Icon(Icons.Rounded.Tune, contentDescription = null, tint = Color.White)
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // --- 2. MENU TABS ---
            GlassBox(modifier = Modifier.fillMaxWidth().height(46.dp), shape = RoundedCornerShape(24.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Active Tab
                    Box(modifier = Modifier.weight(1.2f).fillMaxHeight().clip(RoundedCornerShape(24.dp)).background(Brush.horizontalGradient(listOf(Color(0xFF9868EA), Color(0xFF4A90E2)))), contentAlignment = Alignment.Center) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Rounded.GraphicEq, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Now Playing", color = Color.White, fontSize = 13.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                    Text("Library", color = Color.White.copy(alpha = 0.9f), fontSize = 13.sp, modifier = Modifier.weight(1f), textAlign = androidx.compose.ui.text.style.TextAlign.Center)
                    Row(modifier = Modifier.weight(1.1f), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Rounded.Tune, contentDescription = null, tint = Color.White.copy(alpha = 0.9f), modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("DJ Mixer", color = Color.White.copy(alpha = 0.9f), fontSize = 13.sp)
                    }
                    Row(modifier = Modifier.weight(0.9f), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Rounded.GridView, contentDescription = null, tint = Color.White.copy(alpha = 0.9f), modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("More", color = Color.White.copy(alpha = 0.9f), fontSize = 13.sp)
                    }
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            // --- 3. CENTER VINYL WITH SIDE BUTTONS ---
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Left Floating Button
                GlassBox(modifier = Modifier.size(55.dp), shape = CircleShape) {
                    Icon(Icons.Rounded.FastRewind, contentDescription = null, tint = Color.White, modifier = Modifier.size(28.dp))
                }
                
                // Central Glowing Vinyl
                Box(
                    modifier = Modifier
                        .size(220.dp)
                        .clip(CircleShape)
                        .background(Brush.radialGradient(listOf(Color(0xFF2B2E4A), Color(0xFF11111A))))
                        .border(3.dp, Brush.linearGradient(listOf(Color(0xFF00E5FF), Color(0xFFE285C5))), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Box(modifier = Modifier.size(170.dp).border(1.dp, Color.White.copy(alpha = 0.15f), CircleShape))
                    Box(modifier = Modifier.size(120.dp).border(1.dp, Color.White.copy(alpha = 0.1f), CircleShape))
                    Box(modifier = Modifier.size(70.dp).clip(CircleShape).background(Brush.radialGradient(listOf(Color(0xFF8B5BEA), Color(0xFF2B2E4A)))), contentAlignment = Alignment.Center) {
                        Icon(Icons.Rounded.MusicNote, contentDescription = null, tint = Color.White, modifier = Modifier.size(36.dp))
                    }
                }

                // Right Floating Button
                GlassBox(modifier = Modifier.size(55.dp), shape = CircleShape) {
                    Icon(Icons.Rounded.FastForward, contentDescription = null, tint = Color.White, modifier = Modifier.size(28.dp))
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            // --- 4. MAIN MUSIC PLAYER CARD ---
            GlassBox(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(24.dp)) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(modifier = Modifier.size(56.dp).clip(RoundedCornerShape(12.dp)).background(Brush.linearGradient(listOf(Color(0xFF00C6FF), Color(0xFF0072FF)))))
                            Spacer(modifier = Modifier.width(16.dp))
                            Column {
                                Text("DJ Sunil Sonu - Desi Bass Blast", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                                Text("DJ SUNIL SONU • Bass Edition", color = Color.White.copy(alpha = 0.8f), fontSize = 13.sp)
                            }
                        }
                        Icon(Icons.Rounded.Favorite, contentDescription = null, tint = Color(0xFFF9A8D4), modifier = Modifier.size(28.dp))
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    // Progress Bar
                    Box(modifier = Modifier.fillMaxWidth().height(4.dp).clip(CircleShape).background(Color.White.copy(alpha = 0.3f))) {
                        Box(modifier = Modifier.fillMaxWidth(0.45f).height(4.dp).clip(CircleShape).background(Brush.horizontalGradient(listOf(Color.Cyan, Color.Magenta))))
                        Box(modifier = Modifier.padding(start = 140.dp).size(12.dp).offset(y = (-4).dp).clip(CircleShape).background(Color.White))
                    }
                    Row(modifier = Modifier.fillMaxWidth().padding(top = 10.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text("01:32", color = Color.White.copy(alpha = 0.9f), fontSize = 12.sp)
                        Text("03:45", color = Color.White.copy(alpha = 0.9f), fontSize = 12.sp)
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Controls Inside Card
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Rounded.Shuffle, contentDescription = null, tint = Color.White.copy(alpha = 0.9f), modifier = Modifier.size(24.dp))
                        Icon(Icons.Rounded.SkipPrevious, contentDescription = null, tint = Color.White, modifier = Modifier.size(36.dp))
                        GlassBox(modifier = Modifier.size(60.dp), shape = CircleShape) {
                            Icon(Icons.Rounded.Pause, contentDescription = null, tint = Color.White, modifier = Modifier.size(32.dp))
                        }
                        Icon(Icons.Rounded.SkipNext, contentDescription = null, tint = Color.White, modifier = Modifier.size(36.dp))
                        Icon(Icons.Rounded.Repeat, contentDescription = null, tint = Color.White.copy(alpha = 0.9f), modifier = Modifier.size(24.dp))
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // --- 5. TOGGLES & SETTINGS (4 Glass Pills) ---
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                // Auto-Pause
                GlassBox(modifier = Modifier.weight(1f).height(65.dp), shape = RoundedCornerShape(20.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(horizontal = 12.dp)) {
                        Icon(Icons.Rounded.Headphones, contentDescription = null, tint = Color.White, modifier = Modifier.size(24.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text("Auto-Pause", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                            Text("on Disconnect", color = Color.White.copy(alpha = 0.8f), fontSize = 10.sp)
                        }
                        Switch(checked = true, onCheckedChange = {}, colors = SwitchDefaults.colors(checkedThumbColor = Color.White, checkedTrackColor = Color(0xFF8B5BEA)), modifier = Modifier.scale(0.7f))
                    }
                }
                Spacer(modifier = Modifier.width(12.dp))
                // Gapless
                GlassBox(modifier = Modifier.weight(1f).height(65.dp), shape = RoundedCornerShape(20.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(horizontal = 12.dp)) {
                        Icon(Icons.Rounded.GraphicEq, contentDescription = null, tint = Color.White, modifier = Modifier.size(24.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Gapless Playback", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
                        Switch(checked = true, onCheckedChange = {}, colors = SwitchDefaults.colors(checkedThumbColor = Color.White, checkedTrackColor = Color(0xFF8B5BEA)), modifier = Modifier.scale(0.7f))
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                // DJ Tempo
                GlassBox(modifier = Modifier.weight(1f).height(65.dp), shape = RoundedCornerShape(20.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(horizontal = 16.dp)) {
                        Icon(Icons.Rounded.Speed, contentDescription = null, tint = Color(0xFF00E5FF), modifier = Modifier.size(24.dp))
                        Spacer(modifier = Modifier.width(12.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text("DJ Tempo", color = Color.White.copy(alpha = 0.9f), fontSize = 11.sp)
                            Text("1.00x", color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        }
                        Icon(Icons.Rounded.KeyboardArrowDown, contentDescription = null, tint = Color.White)
                    }
                }
                Spacer(modifier = Modifier.width(12.dp))
                // Pitch
                GlassBox(modifier = Modifier.weight(1f).height(65.dp), shape = RoundedCornerShape(20.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(horizontal = 16.dp)) {
                        Icon(Icons.Rounded.BarChart, contentDescription = null, tint = Color.White, modifier = Modifier.size(24.dp))
                        Spacer(modifier = Modifier.width(12.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text("Pitch", color = Color.White.copy(alpha = 0.9f), fontSize = 11.sp)
                            Text("0.00", color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        }
                        Icon(Icons.Rounded.KeyboardArrowDown, contentDescription = null, tint = Color.White)
                    }
                }
            }
        }

        // --- 6. BOTTOM NAVIGATION BAR ---
        GlassBox(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp, start = 16.dp, end = 16.dp)
                .fillMaxWidth()
                .height(70.dp),
            shape = RoundedCornerShape(35.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically) {
                // Home (Glowing background)
                Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.background(Brush.radialGradient(listOf(Color(0xFF8B5BEA).copy(alpha=0.6f), Color.Transparent)), CircleShape).padding(8.dp)) {
                    Icon(Icons.Rounded.Home, contentDescription = null, tint = Color.White, modifier = Modifier.size(24.dp))
                    Text("Home", color = Color.White, fontSize = 11.sp)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(Icons.Rounded.Explore, contentDescription = null, tint = Color.White.copy(alpha = 0.8f), modifier = Modifier.size(22.dp))
                    Text("Explore", color = Color.White.copy(alpha = 0.8f), fontSize = 11.sp)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(Icons.Rounded.LibraryMusic, contentDescription = null, tint = Color.White.copy(alpha = 0.8f), modifier = Modifier.size(22.dp))
                    Text("Library", color = Color.White.copy(alpha = 0.8f), fontSize = 11.sp)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(Icons.Rounded.Settings, contentDescription = null, tint = Color.White.copy(alpha = 0.8f), modifier = Modifier.size(22.dp))
                    Text("Settings", color = Color.White.copy(alpha = 0.8f), fontSize = 11.sp)
                }
            }
        }
    }
}
