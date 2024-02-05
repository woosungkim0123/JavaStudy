package factory_method.sub;

import abstract_factory.sub.AndroidPhone;
import abstract_factory.sub.IPhone;

public class SimplePhoneFactory {

    public final Phone create(String type) {
        Phone p = createProduct(type);
        p.register();
        return p;
    }

    private Phone createProduct(String type){
        return switch (type) {
            case "IPHONE" -> new IPhone();
            case "ANDROID" -> new AndroidPhone();
            default -> null;
        };
    }
}
