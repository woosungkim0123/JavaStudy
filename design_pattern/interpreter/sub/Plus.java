package interpreter.sub;

public class Plus implements Expression {
    private Expression leftOperand; // + 왼쪽에 올 표현
    private Expression rightOperand; // + 오른쪽에 올 표현

    public Plus(Expression left, Expression right) {
        leftOperand = left;
        rightOperand = right;
    }

    @Override
    public int interpret() {
        // 왼쪽과 오른쪽의 결과를 더해서 반환
        return leftOperand.interpret() + rightOperand.interpret();
    }
}
