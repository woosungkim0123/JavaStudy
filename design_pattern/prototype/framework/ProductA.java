package prototype.framework;

public interface ProductA extends Cloneable {
    void use(String s);
    ProductA createCopy();
}
