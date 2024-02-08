package memento.texteditor;

public class TextEditor {
    private StringBuilder text = new StringBuilder();

    // 텍스트 추가
    public void addText(String newText) {
        text.append(newText);
    }

    // 텍스트 삭제 (마지막 입력된 텍스트를 삭제)
    public void deleteText(int length) {
        int textLength = text.length();
        if (length > 0 && textLength > 0) {
            text.delete(textLength - length, textLength);
        }
    }

    // 현재 텍스트 상태를 반환
    public String getText() {
        return text.toString();
    }

    // 현재 텍스트 상태를 메멘토 객체로 저장 (create memento 메소드 역할)
    public Memento save() {
        return new Memento(text.toString());
    }

    // 메멘토 객체로부터 텍스트 상태를 복원 (set memento 메소드 역할)
    public void restore(Memento memento) {
        text = new StringBuilder(memento.getText());
    }
}
