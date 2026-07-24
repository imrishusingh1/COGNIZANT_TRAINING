public class CommandPatternDemo {
    public static void main(String[] args) {
        Light livingRoom = new Light("Living Room");
        Light bedroom = new Light("Bedroom");
        RemoteControl remote = new RemoteControl();

        remote.pressButton(new LightOnCommand(livingRoom));
        remote.pressButton(new LightOnCommand(bedroom));
        remote.pressButton(new LightOffCommand(livingRoom));

        System.out.println("\n--- Undo last 2 commands ---");
        remote.pressUndo();
        remote.pressUndo();
    }
}
