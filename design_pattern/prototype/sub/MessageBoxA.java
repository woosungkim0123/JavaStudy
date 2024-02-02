package prototype.sub;

import prototype.framework.ProductA;

public class MessageBoxA implements ProductA {
    private char decochar;

    public MessageBoxA(char decochar) {
        this.decochar = decochar;
    }

    @Override
    public void use(String s) {
        int decolen = s.length() + 1;
        for (int i = 0; i < decolen; i++) {
            System.out.print(decochar);
        }
        System.out.println();
        System.out.println(decochar + s + decochar);
        for (int i = 0; i < decolen; i++) {
            System.out.print(decochar);
        }
        System.out.println();
    }

    @Override
    public ProductA createCopy() {
        ProductA p = null;
        try {
            /**
             * clone()은 자기 자신의 복제를 생성하는 메소드
             * - 인스턴스가 가진 필드 값도 그대로 복사됩니다.
             * - Cloneable 인터페이스를 구현해야 사용 가능합니다.
             */
            p = (ProductA) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
