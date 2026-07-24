public class TaskLinkedList {
    private Task head;
    private int size;

    public void addTaskAtEnd(Task task) {
        if (head == null) { head = task; size++; return; }
        Task curr = head;
        while (curr.next != null) curr = curr.next;
        curr.next = task;
        size++;
    }

    public void addTaskAtBeginning(Task task) {
        task.next = head; head = task; size++;
    }

    public boolean deleteTask(int id) {
        if (head == null) return false;
        if (head.id == id) { head = head.next; size--; return true; }
        Task curr = head;
        while (curr.next != null) {
            if (curr.next.id == id) { curr.next = curr.next.next; size--; return true; }
            curr = curr.next;
        }
        return false;
    }

    public Task searchTask(int id) {
        Task curr = head;
        while (curr != null) {
            if (curr.id == id) return curr;
            curr = curr.next;
        }
        return null;
    }

    public void traverseAndDisplay() {
        System.out.println("Tasks (total=" + size + "):");
        Task curr = head;
        while (curr != null) { System.out.println("  " + curr); curr = curr.next; }
    }
}
