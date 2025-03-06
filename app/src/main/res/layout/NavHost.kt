@Composable
fun TaskNavHost(navController: NavHostController, viewModel: TaskViewModel) {
    NavHost(navController, startDestination = "taskList") {
        composable("taskList") {
            TaskListScreen(viewModel)
        }
        composable("createTask") {
            CreateTaskScreen(viewModel)
        }
        composable("taskDetail/{taskId}") { backStackEntry ->
            val taskId = backStackEntry.arguments?.getString("taskId")?.toLong() ?: return@composable
            TaskDetailScreen(taskId, viewModel)
        }
    }
}
