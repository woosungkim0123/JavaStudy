package decorator;

import decorator.sub.BaseCake;
import decorator.sub.Cake;
import decorator.sub.decorator.Sprinkles;
import decorator.sub.decorator.StrawberryCream;
import decorator.sub.decorator.chocolateChip;
import decorator.sub.decorator.chocolateCream;

public class Main {
    public static void main(String[] args) {
        // 초코 케이크
        Cake cake1 = new chocolateCream(new BaseCake());
        cake1.decorate();

        System.out.println();

        // 딸기 케이크
        Cake cake2 = new StrawberryCream(new BaseCake());
        cake2.decorate();

        System.out.println();

        // 초코 딸기 스프링클 초코칩 케이크
        Cake cake3 = new Sprinkles(new chocolateChip(new StrawberryCream(new chocolateCream(new BaseCake()))));
        cake3.decorate();
    }
}
