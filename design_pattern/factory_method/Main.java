package factory_method;

import factory_method.sub.Phone;
import factory_method.sub.SimplePhoneFactory;
import factory_method.sub.AndroidFactory;
import factory_method.sub.IPhoneFactory;


public class Main {
    public static void main(String[] args) {
        // 심플 팩토리 패턴
        SimplePhoneFactory simplePhoneFactory = new SimplePhoneFactory();
        Phone androidPhone = simplePhoneFactory.create("ANDROID");
        androidPhone.call();

        // 팩토리 메소드 패턴
        IPhoneFactory iPhoneFactory = new IPhoneFactory();
        Phone iPhone = iPhoneFactory.create();
        iPhone.call();

        AndroidFactory androidFactory = new AndroidFactory();
        Phone android = androidFactory.create();
        android.call();
    }
}
