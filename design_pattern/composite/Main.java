package composite;

import composite.sub.Directory;
import composite.sub.File;

public class Main {
    public static void main(String[] args) {
        Directory rootDir = new Directory("root");
        Directory binDir = new Directory("bin");
        Directory tmpDir = new Directory("tmp");
        Directory usrDir = new Directory("usr");

        rootDir.add(binDir);
        rootDir.add(tmpDir);
        rootDir.add(usrDir);

        binDir.add(new File("vi", 10000));
        binDir.add(new File("latex", 20000));

        Directory yamadaDir = new Directory("yamada");
        usrDir.add(yamadaDir);
        yamadaDir.add(new File("diary.html", 100));

        rootDir.printList();
    }
}
