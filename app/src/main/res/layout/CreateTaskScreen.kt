@Composable
fun CreateTaskScreen(viewModel: TaskViewModel) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var priority by remember { mutableStateOf(Priority.LOW) }
    var dueDate by remember { mutableStateOf<Long?>(null) }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Task Title") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") },
            modifier = Modifier.fillMaxWidth()
        )
        DropdownMenu(
            expanded = true,
            onDismissRequest = { /* Handle dismiss */ }
        ) {
            listOf(Priority.LOW, Priority.MEDIUM, Priority.HIGH).forEach { priorityOption ->
                DropdownMenuItem(onClick = { priority = priorityOption }) {
                    Text(priorityOption.name)
                }
            }
        }

        DatePicker(
            value = dueDate,
            onDateSelected = { selectedDate -> dueDate = selectedDate },
        )

        Button(
            onClick = {
                val newTask = Task(title = title, description = description, priority = priority, dueDate = dueDate)
                viewModel.addTask(newTask)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save Task")
        }
    }
}
