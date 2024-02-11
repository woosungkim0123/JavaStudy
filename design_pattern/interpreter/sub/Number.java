package interpreter.sub;

import static java.lang.Integer.parseInt;

public class Number implements Expression {

    private int number;

    public Number(String number) {
        this.number = parseInt(number);
    }

    @Override
    public int interpret() {
        return number;
    }
}
