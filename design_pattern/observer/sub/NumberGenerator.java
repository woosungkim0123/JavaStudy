package observer.sub;

import java.util.ArrayList;
import java.util.List;

public abstract class NumberGenerator {

    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        observers.forEach(observer -> observer.update(this)); // Observer에게 통지
    }

    public abstract int getNumber(); // 수를 취득한다.

    public abstract void execute(); // 수를 생성한다.
}
