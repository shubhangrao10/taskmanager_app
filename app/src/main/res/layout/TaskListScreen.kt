@Composable
fun TaskListScreen(viewModel: TaskViewModel) {
    val tasks by viewModel.tasks.observeAsState(emptyList())
    val navController = rememberNavController()

    Scaffold(
        topBar = { TopAppBar(title = { Text("Task Manager") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("createTask") }) {
                Icon(Icons.Filled.Add, contentDescription = "Add Task")
            }
        }
    ) {
        LazyColumn {
            items(tasks) { task ->
                TaskListItem(task, onClick = {
                    navController.navigate("taskDetail/${task.id}")
                })
            }
        }
    }
}

@Composable
fun TaskListItem(task: Task, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().clickable(onClick = onClick),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(task.title, style = MaterialTheme.typography.h6)
            task.dueDate?.let { Text("Due: ${SimpleDateFormat("MMM dd, yyyy").format(Date(it))}") }
            Text("Priority: ${task.priority}")
        }
    }
}
