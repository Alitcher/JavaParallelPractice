import java.util.concurrent.RecursiveAction;
import java.util.ArrayList;
import java.util.List;

public class Task extends RecursiveAction
{
    private int FirstIndex, LastIndex;
    public int groceriesPerTask = Grocery.groceries.size() / 4;

    public int Average = 0;
    public Task(int firstIndex, int lastIndex)
{
    FirstIndex = firstIndex;
    LastIndex = lastIndex;
}
    @Override
    protected void compute() {
        System.out.println("Thread name: " + Thread.currentThread().getName());

        if(LastIndex-FirstIndex <= groceriesPerTask)
        {
            CalculateAverage();
        }
        else
        {
            System.out.printf("Task: pending tasks %s\n",getQueuedTaskCount());

            Task t1 = new Task(0, groceriesPerTask - 1);
            Task t2 = new Task(groceriesPerTask, (groceriesPerTask*2)-1);
            Task t3 = new Task(groceriesPerTask*2,(groceriesPerTask*3)-1);
            Task t4 = new Task(groceriesPerTask*3,LastIndex-1);

            invokeAll(t1,t2,t3,t4);

            this.Average = (t1.Average + t2.Average + t3.Average+ t4.Average) /4;
        }

    }

    private void CalculateAverage()
    {
        int totalGroceryWeight =0;
        int totalWeightEach = 0;

        for (int i = FirstIndex; i < LastIndex; i++)
        {
            totalGroceryWeight += Grocery.groceries.get(i).get(0) * Grocery.groceries.get(i).get(1);
            totalWeightEach += Grocery.groceries.get(i).get(1);
        }

        Average = totalGroceryWeight/totalWeightEach;

        System.out.println(LastIndex-FirstIndex + "groceries. And weight of all  "+ totalGroceryWeight + " each " + totalWeightEach + " = " + Average);
    }
}
