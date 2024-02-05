package abstract_factory.sub;


public class IPhoneFactory implements Factory {

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
        return new IPhone();
    }

    @Override
    public OS createOS() {
        return new IOS();
    }
}
