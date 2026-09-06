package Templates.Creational;

/*
 * Singleton Pattern Assignment
 *
 * Problem:
 * An application needs exactly one shared configuration object.
 *
 * Student task:
 * 1. Prevent direct object creation from outside the class.
 * 2. Store the single instance in a static field.
 * 3. Return the same object every time getInstance() is called.
 * 4. Try both a simple lazy version and a thread-safe version.
 */

class AppConfiguration {
    private static AppConfiguration instance;

    private AppConfiguration() {
        // TODO: Keep this private so callers cannot use new AppConfiguration().
        // TODO: Add any setup message or fields you want for testing.
    }

    static AppConfiguration getInstance() {
        // TODO: If instance has not been created yet, create it.
        // TODO: Return the same instance every time.
        return null;
    }

    void printConfigSource() {
        // TODO: Print a message proving this object can be used.
    }
}

class ThreadSafeAppConfiguration {
    private static volatile ThreadSafeAppConfiguration instance;

    private ThreadSafeAppConfiguration() {
        // TODO: Keep constructor private.
    }

    static ThreadSafeAppConfiguration getInstance() {
        /*
         * TODO:
         * Implement a thread-safe singleton.
         *
         * Hint:
         * - Use a first null check before locking.
         * - Synchronize only during first-time creation.
         * - Check for null again inside the synchronized block.
         */
        return null;
    }
}

public class SingletonTemplate {
    public static void main(String[] args) {
        // TODO: Call AppConfiguration.getInstance() twice.
        // TODO: Print whether both references point to the same object using ==.
        // TODO: Repeat for ThreadSafeAppConfiguration.
    }
}
