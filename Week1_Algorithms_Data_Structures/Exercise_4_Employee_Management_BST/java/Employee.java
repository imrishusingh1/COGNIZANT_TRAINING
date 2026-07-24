public class Employee {
    int id;
    String name;
    String department;
    double salary;
    Employee left, right;

    public Employee(int id, String name, String department, double salary) {
        this.id = id; this.name = name;
        this.department = department; this.salary = salary;
        this.left = this.right = null;
    }

    @Override
    public String toString() {
        return String.format("Employee{id=%d, name='%s', dept='%s', salary=%.2f}",
                id, name, department, salary);
    }
}
