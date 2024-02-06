package visitor;

import visitor.sub.Directory;
import visitor.sub.File;
import visitor.sub.ListVisitor;

public class Main {
    public static void main(String[] args) {
        Directory root = new Directory("woo");
        Directory bin = new Directory("bin");
        Directory tmp = new Directory("tmp");
        Directory usr = new Directory("usr");
        root.add(bin);
        root.add(tmp);
        root.add(usr);

        bin.add(new File("vi"));
        bin.add(new File("latex"));

        tmp.add(new File("temp1"));
        tmp.add(new File("temp2"));
        tmp.add(new File("temp3"));

        root.accept(new ListVisitor());
    }
}
