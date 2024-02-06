package chain_of_responsibility;

import chain_of_responsibility.sub.SolveType;
import chain_of_responsibility.sub.Support;
import chain_of_responsibility.sub.Trouble;
import chain_of_responsibility.sub.support.*;

public class Main {
    public static void main(String[] args) {
        Support alice = new DesignSupport("Alice");
        Support bob = new ItSupport("Bob");
        Support charlie = new NormalSupport("Charlie");
        Support diana = new SalesSupport("Diana");
        Support elmo = new NoSupport("Elmo");

        // 연쇄 구성
        // no -> normal -> desgin -> it -> sales
        elmo.setNext(charlie).setNext(alice).setNext(bob).setNext(diana);

        // 트러블1 발생
        elmo.support(new Trouble(SolveType.SALES));

        System.out.println();

        // 트러블2 발생
        elmo.support(new Trouble(SolveType.NORMAL));
    }
}
