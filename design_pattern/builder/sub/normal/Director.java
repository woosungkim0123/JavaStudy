package builder.sub.normal;

public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public String build() {
        StringBuilder sb = new StringBuilder();
        sb.append(builder.makeTitle());
        sb.append(builder.makeString());
        sb.append(builder.makeItems());

        return sb.toString();
    }
}
