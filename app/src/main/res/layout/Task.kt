@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val description: String? = null,
    val priority: Priority,
    val dueDate: Long? = null,
    val isCompleted: Boolean = false
)

enum class Priority {
    LOW, MEDIUM, HIGH
}
