package visitor.sub;

import java.util.Iterator;

public class ListVisitor extends Visitor {
    private String currentdir = ""; // 현재 주목하고 있는 디렉터리 이름

    @Override
    public void visit(File file) {
        System.out.println(currentdir + "/" + file);
    }
    
    // 3. Directory를 위한 visit 메소드 구현
    @Override
    public void visit(Directory directory) {
        System.out.println(currentdir + "/" + directory);
        String savedir = currentdir;
        currentdir = currentdir + "/" + directory.getName();

        Iterator<Entry> it = directory.iterator();
        while (it.hasNext()) {
            Entry entry = it.next();
            entry.accept(this);
        }

        currentdir = savedir;
    }
}
