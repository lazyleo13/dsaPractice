package src.main.java.com.practice.dsa.javaConcepts;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class ExecutorServiceImpl {


    static class Task implements Callable<Integer> {

        private final int taskId;

        Task(int taskId) {
            this.taskId = taskId;
        }

        @Override
        public Integer call() throws Exception {
            int sleepTime = new Random().nextInt(3) + 1;
            System.out.println("Task " + taskId + " will sleep for " + sleepTime + " seconds.");
            Thread.sleep(sleepTime * 1000);
            return taskId * 10; // Return some result based on task ID
        }
    }

    private static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread was interrupted while sleeping.");
        }
    }

    public static void main(String[] args) {
             //// WaitingForMultipleFuturesExample
            // Create a fixed-thread-pool ExecutorService with 3 threads
            ExecutorService executor = Executors.newFixedThreadPool(3);
            // Create a list to hold Future objects
            List<Future<Integer>> futures = new ArrayList<>();
            // Submit multiple tasks to the executor and store the Future objects in the list
            for (int i = 1; i <= 5; i++) {
                futures.add(executor.submit(new Task(i)));
            }
            System.out.println("All tasks submitted.");
            // Iterate over the list of Future objects to wait for their completion and retrieve the results
            for (Future<Integer> future : futures) {
                try {
                    // Wait for the task to complete and retrieve the result
                    Integer result = future.get();
                    System.out.println("Task completed with result: " + result);
                } catch (InterruptedException e) {
                    // Handle the case where the current thread was interrupted
                    Thread.currentThread().interrupt(); // Restore interrupted status
                    System.out.println("Main thread was interrupted.");
                } catch (ExecutionException e) {
                    // Handle any exceptions thrown during task execution
                    System.out.println("Task failed with exception: " + e.getCause());
                }
            }
            // Shutdown the executor to release resources
            executor.shutdown();

        //ChainingFuturesExample

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() ->
            {
                System.out.println("Task1 Starts");
                sleep(2000);
                System.out.println("Task2 Ends");
                return 10;
        });

        CompletableFuture<Integer> future2 = future1.thenApplyAsync(result ->
        {
            System.out.println("Task 2: Start with result from Task 1: " + result);
            // Perform some computation based on the result of Task 1
            sleep(3000);
            System.out.println("Task 2: End");
            return result * 2;
        });

        // Chain a third CompletableFuture that depends on the second one
        CompletableFuture<Void> future3 = future2.thenAcceptAsync(result -> {
            System.out.println("Task 3: Start with result from Task 2: " + result);
            // Perform some action with the result of Task 2
            sleep(1000);
            System.out.println("Task 3: End");
        });
        // Chain a fourth CompletableFuture that runs after all previous tasks complete
        CompletableFuture<Void> future4 = future3.thenRun(() -> {
            System.out.println("All tasks completed successfully.");
        });

        future1.join();// Block and wait for all futures to complete
        // executor.shutdown();  // Shutdown the executor if necessary (not needed for CompletableFuture)

    }
}
