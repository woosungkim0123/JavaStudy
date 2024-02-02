package prototype.sub;

import prototype.framework.ProductA;
import prototype.framework.ProductB;

// 1. ProductB 구현으로 변경합니다.
// 2. 복사 생성자를 만듭니다.
// 3. createCopy()에서 복사 생성자를 호출합니다.
public class UnderlinePenB implements ProductB {
    private char ulchar;

    public UnderlinePenB(char ulchar) {
        this.ulchar = ulchar;
    }

    // 복사 생성자
    public UnderlinePenB(UnderlinePenB up) {
        this.ulchar = up.ulchar;
    }

    @Override
    public void use(String s) {
        int ulen = s.length();
        System.out.println(s);
        for (int i = 0; i < ulen; i++) {
            System.out.print(ulchar);
        }
        System.out.println();
    }

    @Override
    public ProductB createCopy() {
        return new UnderlinePenB(this);
    }
}
