package interpreter;

import interpreter.sub.Context;
import interpreter.sub.Evaluator;

public class Main {
    public static void main(String[] args) {
        // 해석을 원하는 문장
        String expression = "5 10 42 - +";
        Context context = new Context(expression);

        // 문장에 따른 해석기를 생성
        Evaluator evaluator = new Evaluator(context);

        int translateResult = evaluator.interpret();

        System.out.print("해석 결과: " + translateResult);
    }
}
