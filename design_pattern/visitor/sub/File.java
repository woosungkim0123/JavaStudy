package visitor.sub;

public class File extends Entry {
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String getName() {
        return name;
    }

}
