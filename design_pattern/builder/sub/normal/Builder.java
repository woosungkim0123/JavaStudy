package builder.sub.normal;

public abstract class Builder {
    protected Data data; // 상속한 클래스에서 사용할 Data 객체

    public Builder(Data data) {
        this.data = data;
    }

    public abstract String makeTitle();
    public abstract String makeString();
    public abstract String makeItems();
}
