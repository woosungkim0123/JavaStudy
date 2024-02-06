package visitor.sub;

public abstract class Entry implements Element {
    public abstract String getName();

    @Override
    public String toString() {
        return getName();
    }
}
