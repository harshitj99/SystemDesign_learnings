package DesignPatterns.Behavioral;

import java.util.concurrent.*;

public class ThreadRace {
    public static void main(String[] args) throws InterruptedException {
        int threadCount = 200;
        ExecutorService ex = Executors.newFixedThreadPool(threadCount);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done = new CountDownLatch(threadCount);
        ConcurrentSkipListSet<Integer> ids = new ConcurrentSkipListSet<>();

        for (int i = 0; i < threadCount; i++) {
            ex.submit(() -> {
                try {
                    start.await();
                    ids.add(System.identityHashCode(ThreadSafeSingleton.getInstance()));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    done.countDown();
                }
            });
        }

        start.countDown();
        done.await();
        ex.shutdown();

        System.out.println("Total calls: " + threadCount);
        System.out.println("Unique instances: " + ids.size());
        System.out.println("Instance ids: " + ids);
        if (ids.size() == 1) {
            System.out.println("PASS: singleton held");
        } else {
            System.out.println("FAIL: multiple instances created");
        }
    }
}
