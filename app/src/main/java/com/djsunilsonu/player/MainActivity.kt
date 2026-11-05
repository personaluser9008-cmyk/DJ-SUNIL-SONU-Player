class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Ise hatana hai
        setContent {
            MaterialTheme {
                MainAppScreen()
            }
        }
    }
}
