package memento.sub;

import memento.texteditor.Memento;

import java.util.Stack;

// 관리자 클래스
public class Caretaker {
    private Stack<Memento> history = new Stack<>();

    public void save(Memento memento) {
        history.push(memento);
    }

    public Memento undo() {
        if (!history.isEmpty()) {
            return history.pop();
        }
        return null;
    }
}
