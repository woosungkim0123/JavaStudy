package prototype.sub;

import prototype.framework.ProductA;

public class UnderlinePenA implements ProductA {
    private char ulchar;

    public UnderlinePenA(char ulchar) {
        this.ulchar = ulchar;
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
    public ProductA createCopy() {
        ProductA p = null;
        try {
            p = (ProductA) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
