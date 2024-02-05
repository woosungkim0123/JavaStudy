package abstract_factory;


import abstract_factory.sub.AndroidFactory;
import abstract_factory.sub.Factory;
import abstract_factory.sub.IPhoneFactory;
import abstract_factory.sub.Phone;


public class Main {
    public static void main(String[] args) {
        Factory factory1 = new IPhoneFactory();
        Phone phone1 = factory1.create();
        phone1.call();

        System.out.println();

        Factory factory2 = new AndroidFactory();
        Phone phone2 = factory2.create();
        phone2.call();
    }
}
