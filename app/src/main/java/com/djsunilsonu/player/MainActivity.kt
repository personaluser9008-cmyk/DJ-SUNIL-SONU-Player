class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // EdgeToEdge hata diya taaki purane phone me crash na ho
        setContent {
            MaterialTheme {
                MainAppScreen()
            }
        }
    }
}
