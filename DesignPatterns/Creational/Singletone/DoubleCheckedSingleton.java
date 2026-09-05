package DesignPatterns.Creational.Singletone;


/*
You've spotted the real cost: synchronized doesn't distinguish between "the instance doesn't exist yet"
 and "the instance already exists." Every single call, forever, has to acquire and release that lock — even 
 the 10,000th call, long after the object was created on the very first call. If getInstance() gets called 
 frequently (e.g. in a hot loop, or from many threads constantly), that locking overhead adds up for no reason, 
 since after the first call there's nothing left to protect.

The better approach: Double-Checked Locking

The fix is to only synchronize the first-time creation, not every call: */

public class DoubleCheckedSingleton {
    private static volatile DoubleCheckedSingleton instance;

    private DoubleCheckedSingleton(){};
    public static DoubleCheckedSingleton getInstance(){
        if(instance==null){       //1st check (no lock)
            synchronized(DoubleCheckedSingleton.class){
                if(instance==null){         //2nd check (lock)
                    instance = new DoubleCheckedSingleton();
                }
            }
        }
        return instance;
    }
}

/*
Why two checks? The first check (outside the lock) lets almost every call skip locking entirely once the instance 
exists — this recovers the performance you were worried about. The second check (inside the lock) is what actually 
prevents the race: if two threads both pass the first check simultaneously and both try to enter the synchronized
 block, only one gets in at a time, creates the instance, and the second one — now inside the lock — 
 sees instance != null and does nothing.

Why volatile matters: Without it, one thread's writes to instance might not be immediately visible to other threads 
(due to CPU caching / compiler reordering), so a thread could see a half-constructed object. volatile guarantees 
the write is fully visible to all threads before any other thread can read it as non-null.

This gets you: lazy creation, thread safety, and near-zero locking overhead after the first call — genuinely the best 
of the SimpleSingleton and ThreadSafeSingleton worlds. It's a bit fiddly to get exactly right 
(missing volatile is a classic subtle bug), which is exactly why the Bill Pugh Holder approach is usually preferred
 in Java — it achieves the same result by leaning on the JVM's class-loading guarantees instead of hand-written
  locking, with zero risk of getting the double-check wrong. */