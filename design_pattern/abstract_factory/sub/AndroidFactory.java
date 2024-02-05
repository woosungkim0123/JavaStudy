package abstract_factory.sub;


public class AndroidFactory implements Factory {
    @Override
    public Phone create() {
        Phone phone = createProduct();
        phone.register();
        OS os = createOS();
        os.install();
        os.setting();

        return phone;
    }

    @Override
    public Phone createProduct() {
        return new AndroidPhone();
    }

    @Override
    public OS createOS() {
        return new GoogleOS();
    }
}
