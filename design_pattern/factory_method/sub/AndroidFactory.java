package factory_method.sub;

public class AndroidFactory extends Factory {
    @Override
    public Phone createProduct() {
        return new AndroidPhone();
    }
}
