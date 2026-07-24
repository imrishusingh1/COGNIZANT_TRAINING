public class TaskManagerDemo {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();
        taskList.addTaskAtEnd(new Task(1, "Setup project", "DONE"));
        taskList.addTaskAtEnd(new Task(2, "Create database schema", "IN_PROGRESS"));
        taskList.addTaskAtEnd(new Task(3, "Implement REST API", "TODO"));
        taskList.addTaskAtBeginning(new Task(0, "Gather requirements", "DONE"));

        taskList.traverseAndDisplay();

        System.out.println("\nSearch task ID 2: " + taskList.searchTask(2));
        System.out.println("Delete task ID 1: " + taskList.deleteTask(1));
        System.out.println("\nAfter deletion:");
        taskList.traverseAndDisplay();
    }
}
