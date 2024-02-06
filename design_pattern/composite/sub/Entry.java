package composite.sub;

public abstract class Entry {
    public abstract String getName();
    public abstract int getSize();

    // 목록을 표시한다.
    public void printList() {
        printList("");
    }

    protected abstract void printList(String prefix);

    @Override
    public String toString() {
        return getName() + " (" + getSize() + ")";
    }
}
