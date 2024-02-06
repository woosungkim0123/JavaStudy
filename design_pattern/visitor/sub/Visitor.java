package visitor.sub;

/**
 * 방문하는 곳의 데이터 구조를 의존합니다.(File, Directory)
 */
public abstract class Visitor {
    public abstract void visit(File file);
    public abstract void visit(Directory directory); // 2. Directory를 위한 visit 메소드 추가
}
