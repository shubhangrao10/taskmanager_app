@Composable
fun BouncingFAB() {
    val animatedScale by animateFloatAsState(
        targetValue = if (isPressed) 0.8f else 1f,
        animationSpec = tween(durationMillis = 200)
    )

    FloatingActionButton(
        onClick = { /* FAB action */ },
        modifier = Modifier.scale(animatedScale)
    ) {
        Icon(Icons.Filled.Add, contentDescription = "Add Task")
    }
}
