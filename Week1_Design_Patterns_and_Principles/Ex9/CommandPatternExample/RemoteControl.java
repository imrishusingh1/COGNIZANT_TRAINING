import java.util.Stack;

public class RemoteControl {
    private final Stack<Command> history = new Stack<>();

    public void pressButton(Command command) {
        command.execute();
        history.push(command);
    }

    public void pressUndo() {
        if (!history.isEmpty()) {
            Command last = history.pop();
            System.out.print("Undoing last command -> ");
            last.undo();
        } else {
            System.out.println("Nothing to undo.");
        }
    }
}
