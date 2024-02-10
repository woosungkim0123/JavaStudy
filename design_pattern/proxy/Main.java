package proxy;

import proxy.sub.CacheProxy;
import proxy.sub.Client;
import proxy.sub.RealSubject;
import proxy.sub.Subject;

public class Main {
    public static void main(String[] args) {
        // 클라이언트 -> 서버
        Subject subject = new RealSubject();
        timeCheck(() -> getData(subject));

        // 클라이언트 -> 프록시 -> 서버
        Subject proxy = new CacheProxy(subject);
        timeCheck(() -> getData(proxy));
    }

    private static void getData(Subject subject) {
        Client client = new Client(subject);
        client.execute(); // 실제 객체 호출
        client.execute(); // 프록시 사용시 캐시 호출, 미사용시 실제 객체 호출
        client.execute(); // 프록시 사용시 캐시 호출, 미사용시 실제 객체 호출
    }

    private static void timeCheck(Runnable runnable) {
        long start = System.currentTimeMillis();

        runnable.run();

        long end = System.currentTimeMillis();
        System.out.println("실행 시간 : " + (end - start) / 1000.0 + "초");
        System.out.println();
    }
}
