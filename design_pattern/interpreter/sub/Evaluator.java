package interpreter.sub;

import java.util.Stack;

// 해석기
public class Evaluator {

    private Expression syntaxTree; // 만들 최종 해석

    public Evaluator(Context context) {
        Stack<Expression> stack = new Stack<>(); // 스택을 이용해 문법 트리를 만든다
        String expression = context.getExpression();

        // 연산자를 만나면 스택에서 2개의 피연산자를 꺼내어 연산자 객체를 만들어 다시 스택에 넣는다
        for (String strToken : expression.split(" ")) {
            if (strToken.equals("+")) {
                Expression left = stack.pop();
                Expression right = stack.pop();
                Expression plusExpression = new Plus(left, right);
                stack.push(plusExpression);
            } else if (strToken.equals("-")) {
                Expression left = stack.pop();
                Expression right = stack.pop();
                Expression minusExpression = new Minus(left, right);
                stack.push(minusExpression);
            } else {
                stack.push(new Number(strToken)); // 피연산자를 만나면 스택에 넣는다
            }
        }
        syntaxTree = stack.pop();  // 최종 결과는 스택에 남아 있는 하나의 객체
    }


    public int interpret() {
        return syntaxTree.interpret();
    }
}
