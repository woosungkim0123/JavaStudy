package factory_method.sub;

public abstract class Factory {
    // type 파라미터 제거
    public final Phone create() {
        Phone p = createProduct();
        p.register();
        return p;
    }

    public abstract Phone createProduct();
}
