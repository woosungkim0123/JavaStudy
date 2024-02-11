package interpreter.sub;

public class Minus implements Expression {
    // 배치: leftOperand - rightOperand
    private Expression leftOperand;
    private Expression rightOperand;

    public Minus(Expression left, Expression right) {
        leftOperand = left;
        rightOperand = right;
    }

    @Override
    public int interpret() {
        return leftOperand.interpret() - rightOperand.interpret();
    }
}
