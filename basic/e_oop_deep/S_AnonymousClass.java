package e_oop_deep;

import java.awt.*;
import java.awt.event.*;

public class S_AnonymousClass {
    public static void main(String[] args) {
        /*
        익명 클래스(anonymous class)

        개념
        이름이 없는 일회용 클래스. 정의와 생성을 동시에

        문법
        new 조상클래스이름(){}
        new 구현인터페이스이름(){}

        컴파일 결과
        e_oop_deep.S_AnonymousClass.class
        e_oop_deep.S_AnonymousClass$1.class
        e_oop_deep.S_AnonymousClass$2.class
        e_oop_deep.S_AnonymousClass$3.class
        */

        // AWT(JAVA 윈도우 프로그래밍) 같은데서 일회성으로 사용할 클래스들을 익명클래스로 많이 사용
        Button b = new Button("Start");
        b.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("ActionEvent occurred!!!");
                }
            }
        );
    }
    //  셋다 모두 익명클래스
    Object iv = new Object(){ void method(){} };
    static Object cv = new Object(){ void method(){} };
    void myMethod() {
        Object lv = new Object(){ void method(){} };
    }
}


