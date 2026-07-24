public class EmployeeBST {
    private Employee root;

    public void insert(Employee emp) {
        root = insertRec(root, emp);
    }

    private Employee insertRec(Employee node, Employee emp) {
        if (node == null) return emp;
        if (emp.id < node.id) node.left = insertRec(node.left, emp);
        else if (emp.id > node.id) node.right = insertRec(node.right, emp);
        return node;
    }

    public Employee search(int id) {
        return searchRec(root, id);
    }

    private Employee searchRec(Employee node, int id) {
        if (node == null || node.id == id) return node;
        return id < node.id ? searchRec(node.left, id) : searchRec(node.right, id);
    }

    public void inOrderTraversal() {
        System.out.println("--- In-order (sorted by ID) ---");
        inOrder(root);
    }

    private void inOrder(Employee node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println("  " + node);
            inOrder(node.right);
        }
    }
}
