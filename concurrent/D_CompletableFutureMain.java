import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class D_CompletableFutureMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("================= 1번 =================");

        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        completableFuture.complete("woo");
        System.out.println(completableFuture.get());


        /**
         * runAsync는 리턴이 없는 경우
         */
        System.out.println("================= 2번 =================");

        CompletableFuture<Void> completableFuture2 = CompletableFuture.runAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
        });
        System.out.println(completableFuture2.get());


        /**
         * supplyAsync는 리턴이 있는 경우
         */
        System.out.println("================= 3번 =================");

        CompletableFuture<String> completableFuture3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "complete";
        });
        System.out.println(completableFuture3.get());


        /**
         * future에서는 콜백을 사용할 수 없었지만 CompletableFuture에서는 콜백을 사용할 수 있다.
         *
         * 콜백 사용시 리턴이 있는 경우
         * - thenApply
         */
        System.out.println("================= 4번 =================");

        CompletableFuture<String> completableFuture4 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "complete";
        }).thenApply((s) -> {
            System.out.println(Thread.currentThread().getName());
            return s.toUpperCase();
        });
        System.out.println(completableFuture4.get());


        /**
         * 콜백 사용시 리턴이 없는 경우 (Consumer)
         * - thenAccept
         * - get()없이도 콜백이 실행된다.
         */
        System.out.println("================= 5번 =================");

        CompletableFuture.supplyAsync(() -> {
            System.out.println("thenAccept Using CallBack");
            return "Then Accept";
        }).thenAccept((s) -> {
            System.out.println(s.toUpperCase());
        });


        /**
         * 콜백 사용시 리턴이 없는 경우 (Runnable)
         * - thenRun
         * - get()없이도 콜백이 실행된다.
         */
        System.out.println("================= 6번 =================");

        CompletableFuture.supplyAsync(() -> {
            System.out.println("thenRun Using CallBack");
            return "Runnable";
        }).thenRun(() -> {
            System.out.println("thenRun");
        });


        /**
         * Future를 이어서 사용하기
         * - 콜백을 줄 수 없었기 때문에 비동기 작업을 연결하는 것이 어려웠다.
         */
        System.out.println("================= 7번 =================");
        
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello");
            return "hello";
        });

        // Future간에 연관관계가 있는 경우 연결 하는 법
        CompletableFuture<String> stringCompletableFuture = hello.thenCompose(D_CompletableFutureMain::getWorld);

        System.out.println(stringCompletableFuture.get());


        System.out.println("================= 8번 =================");

        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
            System.out.println("world");
            return "world";
        });

        // 연관 관계가 없이 비동기적으로 실행 (BiFunction), 두개 결과를 합쳐서 리턴
        CompletableFuture<String> hello2 = hello.thenCombine(world, (h, w) -> h + " " + w);
        System.out.println(hello2.get());


        /**
         * 내부적으로 ForkJoinPool에 commonPool을 사용하지만 원한다면 전달해줄 수 있습니다.
         */
        System.out.println("================= 9번 =================");

        CompletableFuture<Void> forkJoinPool = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello " + Thread.currentThread().getName()); // ForkJoinPool.commonPool-worker-1
            return "hello";
        }).thenRun(() -> {
            System.out.println(Thread.currentThread().getName()); // main
        });
        forkJoinPool.get();

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CompletableFuture<Void> executorPool = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello " + Thread.currentThread().getName()); // pool-1-thread-1
            return "hello";
        }, executorService).thenRunAsync(() -> {
            System.out.println(Thread.currentThread().getName()); // pool-1-thread-2
        }, executorService);

        executorPool.get();
        executorService.shutdown();


        /**
         * 두개 이상의 작업을 모두 실행하고 콜백 실행하기
         * - allOf: 모든 작업이 끝나야 콜백 실행
         */
        System.out.println("================= 10번 =================");

        CompletableFuture<List<String>> results = CompletableFuture.allOf(hello, world)
                .thenApply(v -> Arrays.asList(hello.join(), world.join())); // 작업이 끝난 후 join으로 결과값을 가져옴

        results.get().forEach(System.out::println);


        /**
         * 두개 이상의 작업 중에 가장 빨리 끝난 하나의 결과를 가지고 콜백 실행하기
         * - anyOf: 먼저 끝난 작업의 결과값을 가져옴
         */
        System.out.println("================= 11번 =================");

        CompletableFuture<Void> anyOf = CompletableFuture.anyOf(hello, world).thenAccept(System.out::println);
        anyOf.get();


        /**
         * 예외처리
         * - exceptionally: 예외가 발생했을 때 예외를 처리하고 싶을 때
         * - 예외가 발생했을 때만 실행된다.
         */
        System.out.println("================= 12번 =================");

        boolean throwError = true;

        CompletableFuture<String> helloException = CompletableFuture.supplyAsync(() -> {
            if (throwError) {
                throw new IllegalArgumentException();
            }
            System.out.println("hello");
            return "hello";
        }).exceptionally(exception -> {
            return "Error!";
        });

        System.out.println(helloException.get());


        /**
         * 예외처리
         * - handle: 예외가 발생했을 때 예외를 처리하고 싶을 때
         * - 예외가 발생했을 때와 발생하지 않았을 때 모두 실행된다.
         */
        System.out.println("================= 13번 =================");

        boolean throwError2 = false;
        CompletableFuture<String> helloHandle = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello 실행");
            if (throwError2) {
                throw new IllegalArgumentException();
            }
            return "hello";
        }).handle((result, exception) -> {
            System.out.println("handle 실행");
            if (exception != null) {
                return "Error!";
            }
            return result;
        });

        System.out.println(helloHandle.get());
    }

    private static CompletableFuture<String> getWorld(String message) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("world");
            return message + " world";
        });
    }
}
