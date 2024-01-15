import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class B_ExecutorMain {
    public static void main(String[] args) {
        /**
         * ExecutorService는 Executor 인터페이스를 구현한 클래스로, 스레드를 생성하고 관리하는 기능을 제공한다
         */
        ExecutorService executorService = Executors.newSingleThreadExecutor(); // 스레드를 하나만 생성하는 ExecutorService 생성
        executorService.execute(() -> System.out.println("Thread " + Thread.currentThread().getName()));

        /**
         * ExecutorService는 작업을 실행하고 다음 작업이 들어올 때까지 대기한다. 따라서 명시적으로 종료를 해줘야 한다
         */
        executorService.shutdown(); // graceful shutdown (현재 진행중인 작업을 끝까지 마치고 종료)
        // executorService.shutdownNow(); // 강제 종료 (현재 진행중인 작업을 취소하고 종료)


        /**
         * 내부에 스레드 풀이 있기 때문에 스레드를 두개 가지고 있는 ExecutorService를 만들 수 있다.
         * 스레드 풀은 스레드를 미리 생성해두고 작업이 들어오면 스레드를 할당해주고 작업이 끝나면 스레드를 회수하는 방식으로 동작한다
         * 스레드 풀을 사용하면 스레드를 생성하고 종료하는 비용이 줄어들기 때문에 효율적이다
         */
        ExecutorService executorService2 = Executors.newFixedThreadPool(2);

        // 두개의 스레드가 번갈아가면서 작업을 처리한다
        executorService2.submit(printMessageAndThreadName("woosung"));
        executorService2.submit(printMessageAndThreadName("woosung2"));
        executorService2.submit(printMessageAndThreadName("woosung3"));
        executorService2.submit(printMessageAndThreadName("woosung4"));
        executorService2.submit(printMessageAndThreadName("woosung5"));
        executorService2.submit(printMessageAndThreadName("woosung6"));

        executorService2.shutdown();


        /**
         * ScheduledExecutorService: ExecutorService를 상속 받은 인터페이스로 특정 시간 이후에 또는 주기적으로 작업을 실행할 수 있다
         */
        ScheduledExecutorService scheduledExecutorService1 = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService1.schedule(printMessageAndThreadName("schedule1"), 5, TimeUnit.SECONDS); // 3초 후에 작업 실행
        scheduledExecutorService1.shutdown();

        ScheduledExecutorService scheduledExecutorService2 = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService2.scheduleAtFixedRate(printMessageAndThreadName("schedule2"), 1, 2, TimeUnit.SECONDS); // 1초 후에 작업 실행하고 2초마다 작업 실행

        // scheduleExecutorService가 반복적으로 수행되나 shudown 때문에 실행되지 않는다. 주석처리하면 정상적으로 작동한다
        scheduledExecutorService2.shutdown();


        /**
         * Fork/Join 프레임워크
         * ExecutorService의 구현체로 손쉽게 멀티 프로세서를 활용할 수 있게끔 도와준다. (스레드 아님)
         */
    }

    public static Runnable printMessageAndThreadName(String message) {
        return () -> System.out.println(message + " " + Thread.currentThread().getName());
    }
}
