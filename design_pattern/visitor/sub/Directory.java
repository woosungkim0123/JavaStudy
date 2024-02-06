package visitor.sub;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// 1. Directory 구현
public class Directory extends Entry {
    private String name;
    private List<Entry> directory = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public Entry add(Entry entry) {
        directory.add(entry);
        return this;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String getName() {
        return name;
    }

    public Iterator<Entry> iterator() {
        return directory.iterator();
    }
}
