package prototype.sub;

import prototype.framework.ProductB;


// 1. ProductB 구현으로 변경합니다.
// 2. 복사 생성자를 만듭니다.
// 3. createCopy()에서 복사 생성자를 호출합니다.
public class MessageBoxB implements ProductB {
    private char decochar;

    public MessageBoxB(char decochar) {
        this.decochar = decochar;
    }
    
    // 복사 생성자
    public MessageBoxB(MessageBoxB mb) {
        this.decochar = mb.decochar;
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
    public ProductB createCopy() {
        return new MessageBoxB(this);
    }
}
