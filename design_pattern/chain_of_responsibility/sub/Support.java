package chain_of_responsibility.sub;

public abstract class Support {
    private String name; // 트러블 해결자 이름
    private Support next; // 떠넘길 곳

    public Support(String name) {
        this.name = name;
    }

    public Support setNext(Support next) { // 떠넘기는 곳 설정
        this.next = next;
        return next;
    }

    public final void support(Trouble trouble) { // 트러블 해결의 수순
        if (resolve(trouble)) {
            done(trouble);
        } else if (next != null) {
            System.out.println(this + " cannot resolve " + trouble + ".");
            next.support(trouble);
        } else {
            fail(trouble);
        }
    }

    protected abstract boolean resolve(Trouble trouble); // 해결용 메소드

    protected void done(Trouble trouble) { // 해결
        System.out.println(trouble + " is resolved by " + this + ".");
    }

    protected void fail(Trouble trouble) { // 미해결
        System.out.println(trouble + " cannot be resolved.");
    }

    @Override
    public String toString() {
        return "[" + name + "]";
    }
}
