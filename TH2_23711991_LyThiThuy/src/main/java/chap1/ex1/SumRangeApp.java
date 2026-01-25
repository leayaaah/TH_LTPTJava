package chap1.ex1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//Callable + ExecuteService
public class SumRangeApp {
	public static void main(String[] args) throws InterruptedException {
		long range = 1_000_000L;
		long total = 0L;
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<Long> future = executor.submit(new SumRange(0, range));
        try {
            total = future.get();
			System.out.println("Total: " + total);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
		executor.shutdown();
    }
}
