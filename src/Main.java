import java.util.concurrent.ForkJoinPool;

public class Main
{
    public static void main(String[] args)
    {
        int numberofGroceries = 1600;

        Grocery groc1 = new Grocery(numberofGroceries);
        Task task = new Task(0, numberofGroceries);
        //Create a pool
        System.out.println("Hello world!");

        ForkJoinPool pool = new ForkJoinPool();

        pool.execute(task);

        do
        {
            System.out.println("****************");
            System.out.printf("main: parallelism: %d\n",pool.getParallelism());
        }
        while (!task.isDone());

        pool.shutdown();

        if(task.isCompletedNormally())
        {
            System.out.println("Main: the process has completed without errors");
            System.out.println("The final average is " + task.Average);
        }
    }

}