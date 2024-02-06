package composite.sub;

import java.util.ArrayList;

public class Directory extends Entry {
    private String name;
    private ArrayList<Entry> directory = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return directory.stream()
                .mapToInt(Entry::getSize)
                .sum();
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        directory.forEach(entry -> entry.printList(prefix + "/" + name));
    }

    public Entry add(Entry entry) {
        directory.add(entry);
        return this;
    }
}
