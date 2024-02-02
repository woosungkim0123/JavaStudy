package template_method;

import template_method.sub.AbstractDisplay;
import template_method.sub.CharDisplay;
import template_method.sub.StringDisplay;

public class Main {
    public static void main(String[] args) {
        AbstractDisplay ad1 = new CharDisplay('A');
        ad1.display();

        AbstractDisplay ad2 = new StringDisplay("Hello");
        ad2.display();
    }
}
