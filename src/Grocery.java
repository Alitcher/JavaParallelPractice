import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class Grocery
{
    public static int GroceryCount;
    public static List<ArrayList<Integer>> groceries = new ArrayList<ArrayList<Integer>>(); //Use Arraylist inside

    public Grocery(int groceryGount)
    {
        GroceryCount=groceryGount;
        GenerateSizeofGroceries(GroceryCount);
    }

    public void GenerateSizeofGroceries(int counter)
    {
        List<Integer> w = new ArrayList<Integer>();

        for (int g = 0; g < counter; g++) {

            for(int i=0;i<2; i++)
            {
                if(w.size() == 0)
                {
                    w.add(0);
                    w.add(0);
                }
                w.set(i, ThreadLocalRandom.current().nextInt(1, 250));

            }
            groceries.add(new ArrayList(w));
        }

        System.out.println(groceries);
    }
}
