public class Task {
    int id;
    String title;
    String status; // TODO, IN_PROGRESS, DONE
    Task next;

    public Task(int id, String title, String status) {
        this.id = id; this.title = title; this.status = status;
    }

    @Override
    public String toString() {
        return String.format("Task{id=%d, title='%s', status=%s}", id, title, status);
    }
}
