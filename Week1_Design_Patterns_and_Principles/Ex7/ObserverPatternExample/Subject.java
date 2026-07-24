import java.util.List;
import java.util.ArrayList;

public abstract class Subject {
    private final List<Observer> observers = new ArrayList<>();

    public void registerObserver(Observer o) { observers.add(o); }
    public void deregisterObserver(Observer o) { observers.remove(o); }
    protected void notifyObservers(String eventType, Object data) {
        observers.forEach(o -> o.update(eventType, data));
    }
}
