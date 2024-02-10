package proxy.sub;

public class CacheProxy implements Subject {

    private Subject target; // 실제 객체에 접근할 수 있어야 합니다.
    private String cacheValue;

    public CacheProxy(Subject target) {
        this.target = target;
    }

    @Override
    public String operation() {
        System.out.println("프록시 호출");

        if(cacheValue == null) {
            cacheValue = target.operation();
        }

        return cacheValue;
    }
}
