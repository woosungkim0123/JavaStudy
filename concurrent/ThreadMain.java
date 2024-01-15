public class ThreadMain {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main Thread : " + Thread.currentThread().getName());

        /**
         * 메인 스레드에서 다른 스레드 만드는 방법 2가지
         * - 스레드의 순서는 보장을 못함
         */
        // 1. Thread 상속
        MyThread myThread = new MyThread();
        myThread.start();

        System.out.println("Thread 이후에 실행되었으면 하는 코드");

        // 2. Runnable 인터페이스 구현 or 람다
        Thread runnableThread = new Thread(() -> {
            System.out.println("익명 클래스 : " + Thread.currentThread().getName());
        });
        runnableThread.start();


        /**
         * sleep: 스레드를 잠시 멈추는 메서드
         * - 사용시 다른 스레드에게 우선권이 넘어감
         */
        Thread thread = new Thread(() -> {
            System.out.println("Thread sleep 스레드 : " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000L);
                System.out.println("Thread sleep 스레드 끝남");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();

        /**
         * interrupt: 스레드를 깨우는 메서드
         */
        Thread thread2 = new Thread(() -> {
            System.out.println("인터럽트 스레드 : " + Thread.currentThread().getName());
            while(true) {
                try {
                    System.out.println("인터럽트 시킬 스레드 실행중");
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    System.out.println("인터럽트 스레드 종료"); // 자는 동안 누군가가 이 스레드를 깨우면 이 스레드는 깨어나서 실행됨 (인터럽트)
                    return;
                }
            }
        });
        thread2.start();

        System.out.println("Thread2 sleep 스레드를 깨움");
        Thread.sleep(5000L);
        thread2.interrupt(); // 스레드 깨우기

        /**
         * join: 스레드가 종료될 때까지 기다리는 메서드
         * - main 스레드가 thread3가 끝나고 진행되도록 함
         */
        Thread thread3 = new Thread(() -> {
            System.out.println("조인 스레드 : " + Thread.currentThread().getName());
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread3.start();
        
        System.out.println("thread3 join 전");
        thread3.join();
        System.out.println("thread3 join 종료 - main에서 확인");
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("상속 스레드 : " + Thread.currentThread().getName());
        }
    }
}
