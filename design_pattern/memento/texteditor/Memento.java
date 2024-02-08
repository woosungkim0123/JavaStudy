package memento.texteditor;

// 메멘토(Memento) 클래스
public class Memento {
    private final String text;

    // wide interface
    Memento(String text) {
        this.text = text;
    }

    // 복원하고자 하는 텍스트를 반환
    String getText() { // wide interface
        return text;
    }
}
