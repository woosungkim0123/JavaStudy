package decorator.sub;

public class RealComponent implements Component {

    @Override
    public String operation() {
        System.out.println("==실제 객체 실행==");

        System.out.println("비지니스 로직 실행후 data 리턴");

        System.out.println("==실제 객체 종료==");
        return "data";
    }
}
