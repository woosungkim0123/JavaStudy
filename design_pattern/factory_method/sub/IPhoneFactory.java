package factory_method.sub;

import abstract_factory.sub.IPhone;

public class IPhoneFactory extends Factory {

    @Override
    public Phone createProduct() {
        return new IPhone();
    }
}
