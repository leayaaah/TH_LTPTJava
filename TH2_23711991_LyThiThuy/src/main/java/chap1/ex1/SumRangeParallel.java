package chap1.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SumRangeParallel {

	public static void main(String[] args) {
		long range = 1_000_000L;
		long step = range/4;
		long total = 0L;
		List<SumRange> sumTasks = new ArrayList<>();
		ExecutorService executor = Executors.newFixedThreadPool(4);
		for (int i = 0; i < 4; i++){
			long start = i * step;
			long end = start + step;
			sumTasks.add(new SumRange(start,end));
		}
		try {
			Future<Long> f1 = executor.submit(sumTasks.get(0));
			Future<Long> f2 = executor.submit(sumTasks.get(1));
			Future<Long> f3 = executor.submit(sumTasks.get(2));
			Future<Long> f4 = executor.submit(sumTasks.get(3));
			total = f1.get() + f2.get() + f3.get() + f4.get();
			System.out.println("Total: " + total);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			executor.shutdown();
		}

	}
}

