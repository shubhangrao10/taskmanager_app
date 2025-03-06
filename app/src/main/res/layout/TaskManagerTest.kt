@get:Rule
val composeTestRule = createComposeRule()

@Test
fun testTaskCreation() {
    composeTestRule.setContent {
        TaskListScreen(viewModel = mockViewModel)
    }
    composeTestRule.onNodeWithText("Add Task").performClick()
    composeTestRule.onNodeWithText("Task Title").performTextInput("Test Task")
    composeTestRule.onNodeWithText("Save Task").performClick()
    composeTestRule.onNodeWithText("Test Task").assertExists()
}
