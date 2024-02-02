package prototype.framework;

// Cloneable 상속을 제거했습니다.
public interface ProductB {
    void use(String s);
    ProductB createCopy();
}
