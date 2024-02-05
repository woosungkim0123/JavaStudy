package factory_method.sub;

import abstract_factory.sub.AndroidPhone;

public class AndroidFactory extends Factory {
    @Override
    public Phone createProduct() {
        return new AndroidPhone();
    }
}
