package factory_method.sub;


public class IPhoneFactory extends Factory {

    @Override
    public Phone createProduct() {
        return new IPhone();
    }
}
