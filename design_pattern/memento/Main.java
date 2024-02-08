package memento;

import memento.sub.Caretaker;
import memento.texteditor.TextEditor;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Caretaker caretaker = new Caretaker();

        add(editor, caretaker, "Hello");
        add(editor, caretaker, " World");

        // 메모장에 뒤에서 3글자 삭제
        delete(editor, caretaker, 3);

        undo(editor, caretaker);
        undo(editor, caretaker);
    }

    private static void add(TextEditor editor, Caretaker caretaker, String newText) {
        System.out.println("==메모장에 " + newText + " 입력==");
        caretaker.save(editor.save());
        editor.addText(newText);
        System.out.println("메모장: " + editor.getText());
        System.out.println();
    }

    private static void delete(TextEditor editor, Caretaker caretaker, int length) {
        System.out.println("==메모장에 " + length + "글자 삭제==");
        caretaker.save(editor.save());
        editor.deleteText(3);
        System.out.println("메모장: " + editor.getText());
        System.out.println();
    }

    private static void undo(TextEditor editor, Caretaker caretaker) {
        System.out.println("==메모장에 undo 실행==");
        editor.restore(caretaker.undo());
        System.out.println("메모장: " + editor.getText());
        System.out.println();
    }
}
