package abstract_factory.sub;


public interface Factory {

    public abstract Phone create();

    public abstract Phone createProduct();

    public abstract OS createOS();
}
