// CONTROLLER - mediates between model and view
public class StudentController {
    private final Student model;
    private final StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model; this.view = view;
    }

    public void setStudentName(String name) { model.setName(name); }
    public String getStudentName() { return model.getName(); }
    public void setStudentGrade(String grade) { model.setGrade(grade); }

    public void updateView() {
        view.displayStudentDetails(model.getName(), model.getRollNo(), model.getGrade());
    }
}
