public class MVCPatternDemo {
    public static void main(String[] args) {
        Student model = new Student("Rishu Kumar", "CSE-2025-001", "A+");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        System.out.println("Initial state:");
        controller.updateView();

        System.out.println("\nUpdating grade to A++:");
        controller.setStudentGrade("A++");
        controller.updateView();
    }
}
