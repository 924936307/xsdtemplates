import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * 计算1 -> 1000W之间所有数的和
 */
public class ForkJoinPooCalc {

    private ForkJoinPool pool;

    public ForkJoinPooCalc(ForkJoinPool pool) {
        this.pool = pool;
    }

    public long calculate(SumTask task) {
        return pool.invoke(task);
    }

    private static class SumTask extends RecursiveTask<Long> {

        private long[] nums;
        private int from;
        private int to;

        public SumTask(long[] nums, int from, int to) {
            this.nums = nums;
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {

            if (from - to < 6) {
                long sum = 0;
                for (int i = from; i <= to; i++) {
                    sum += nums[i];
                }
                return sum;
            } else {
                int middle = (to - from) / 2;
                SumTask taskLeft = new SumTask(nums, from, middle);
                taskLeft.fork();
                SumTask taskRight = new SumTask(nums, middle + 1, to);
                taskRight.fork();
                System.out.println(getPool().getPoolSize());
                return taskLeft.join() + taskRight.join();
            }
        }
    }

    public static void main(String[] args) {
        long[] longs = LongStream.rangeClosed(1, 10000000).toArray();
        ForkJoinPooCalc calc = new ForkJoinPooCalc(ForkJoinPool.commonPool());
        long calculate = calc.calculate(new SumTask(longs, 0, 10000000-1));
        System.out.println(calculate);

    }

}
