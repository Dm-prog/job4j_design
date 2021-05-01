package ru.job4j.gc;

import static com.carrotsearch.sizeof.RamUsageEstimator.sizeOf;

public class UserDemo {
    private static final long KB = 1000;
    private static final long MB = KB * KB;
    private static final Runtime ENVIRONMENT = Runtime.getRuntime();

    public static void info() {
        final long freeMemory = ENVIRONMENT.freeMemory();
        final long totalMemory = ENVIRONMENT.totalMemory();
        final long maxMemory = ENVIRONMENT.maxMemory();
        System.out.println("=== Environment state ===");
        System.out.printf("Free: %d%n", freeMemory / MB);
        System.out.printf("Total: %d%n", totalMemory / MB);
        System.out.printf("Max: %d%n", maxMemory / MB);
    }

    public static void main(String[] args) {
        User user = new User(16, "name");
        System.out.println(sizeOf(user));
        info();
        for (int i = 0; i < 8000; i++) {
            new User(i, "name_" + i);
        }
        //System.gc();
        info();
    }
}
