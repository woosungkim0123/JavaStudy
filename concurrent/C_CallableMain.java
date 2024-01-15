import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class C_CallableMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        /**
         * Callable
         * - Runnable과 비슷하지만 작업의 결과를 받을 수 있다
         */
        Callable<String> callable = () -> {
            Thread.sleep(2000L);
            return "complete";
        };

        /**
         * Future
         * - 비동기적인 작업의 현재 상태를 조회하거나 결과를 가져올 수 있게 해주는 인터페이스
         */
        Future<String> future = executorService.submit(callable);

        /**
         * 상태 조회
         */
        System.out.println("isDone: " + future.isDone()); // false

        /**
         * 결과 가져오기
         * get 이전까지는 코드가 블록킹 되지 않으나 get 이후에는 블록킹 된다
         */
        System.out.println("시작");
        String result = future.get(); // 블록킹 콜(작업이 완료될 때까지 기다림)

        // 인자로 타임아웃을 줄 수 있다. 타임아웃이 지나면 TimeoutException이 발생한다
        // String result = future.get(1, TimeUnit.SECONDS);


        System.out.println(result);

        System.out.println("isDone: " + future.isDone()); // true
        System.out.println("끝");
        executorService.shutdown();

        /**
         * 작업 취소
         * - cancel 메서드를 호출하면 현재 작업을 취소할 수 있다
         * - cancel을 호출하면 값을 가져올 때 CancellationException이 발생한다, isDone은 true를 반환한다
         */
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        Future<String> future2 = executorService2.submit(callable);

        System.out.println("isDone2: " + future2.isDone()); // false

        future2.cancel(true); // true: 현재 진행중인 작업을 인터럽트하면서 종료, false: 현재 진행중인 작업을 기다렸다가 종료

        // future2.get(); // CancellationException 발생

        System.out.println("isDone2: " + future2.isDone()); // true
        executorService2.shutdown();

        /**
         * 여러개 작업 동시에 실행하기
         * - invokeAll: 여러 작업을 동시에 실행하고 모든 작업이 끝날 때까지 기다린다.
         * - 제일 긴 작업 시간만큼 기다린다
         */
        Callable<String> callable1 = () -> {
            Thread.sleep(1000L);
            return "1second";
        };
        Callable<String> callable2 = () -> {
            Thread.sleep(4000L);
            return "4second";
        };
        Callable<String> callable3 = () -> {
            Thread.sleep(6000L);
            return "6second";
        };

        ExecutorService executorService3 = Executors.newFixedThreadPool(3);
        List<Future<String>> futures = executorService3.invokeAll(Arrays.asList(callable1, callable2, callable3));

        for (Future<String> f : futures) {
            System.out.println(f.get());
        }

        executorService3.shutdown();

        /**
         * 여러개 작업 중에 하나라도 먼저 응답이 오면 끝내기
         * - invokeAny: 여러 작업을 동시에 실행하고 제일 먼저 응답이 오는 작업이 완료되면 끝낸다
         * - 제일 짧은 작업 시간만큼 기다린다
         */
        ExecutorService executorService4 = Executors.newFixedThreadPool(3);
        String result2 = executorService4.invokeAny(Arrays.asList(callable1, callable2, callable3));

        System.out.println(result2);

        executorService4.shutdown();
    }
}
