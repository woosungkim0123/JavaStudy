package adapter;

import adapter.sub.*;

public class Main {
    public static void main(String[] args) {
        // 들어온 값
        String a = "30";
        String b = "20";

        // 어댑터 패턴을 사용하지 않은 경우 (기존 코드 수정 없이 사용)
        IntegerAdder integerAdder = new IntegerAdder();
        int a1 = Integer.parseInt(a);
        int b2 = Integer.parseInt(b);
        int intResult = integerAdder.add(a1, b2);
        String result1 = String.valueOf(intResult);
        System.out.println("어댑터 패턴을 사용하지 않은 경우: " + result1);

        // 상속을 사용한 어댑터 패턴
        StringAdderA adderAdapterA = new AdderAdapterA();
        String result2 = adderAdapterA.add(a, b);
        System.out.println("상속을 사용한 어댑터 패턴: " + result2);

        // 위임을 사용한 어댑터
        StringAdderB adderAdapterB = new AdderAdapterB();
        String result3 = adderAdapterB.add(a, b);
        System.out.println("위임을 사용한 어댑터 패턴: " + result3);
    }
}
