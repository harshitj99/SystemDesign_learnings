package DesignPatterns.Creational;

import java.util.*;

import java.util.concurrent.*;
import java.util.function.Supplier;

public class SingletonTest {
    public static void main(String args[]) throws InterruptedException{
      // Run a stress test for both implementations to compare behavior
      runTest("lazySingleton (non-thread-safe)", () -> lazySingleton.getInstance(), 200);
      System.out.println("----");
      runTest("ThreadSafeSingleton (synchronized)", () -> ThreadSafeSingleton.getInstance(), 200);
    }

    private static void runTest(String name, Supplier<Object> supplier, int threadcount) throws InterruptedException {
      ExecutorService executor = Executors.newFixedThreadPool(threadcount);
      CountDownLatch startGate = new CountDownLatch(1);
      CountDownLatch doneGate = new CountDownLatch(threadcount);
      List<Object> list = Collections.synchronizedList(new ArrayList<>());

      for (int i=0; i<threadcount; i++){
        executor.submit(() -> {
            try{
                startGate.await();
                Object instance = supplier.get();
                list.add(instance);
            }
            catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
            finally{
                doneGate.countDown();
            }
        });
      }

      startGate.countDown(); // release all threads at once
      doneGate.await();     // wait for all threads to finish
      executor.shutdown();

      Set<Object> set = new HashSet<>(list);
      System.out.println(name + " - Total Calls: " + list.size());
      System.out.println(name + " - Unique Instances Created: " + set.size());

      if(set.size()==1){
        System.out.println(name + " - PASS: Singleton held under concurrent access");
      }
      else{
        System.out.println(name + " - FAIL: Multiple instances were created!");
      }
    }

}
