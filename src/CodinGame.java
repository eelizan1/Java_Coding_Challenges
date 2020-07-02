import java.util.Hashtable;
import java.util.Scanner;

public class CodinGame {
    public static void main(String[] args) {
        Hashtable<Integer, String> hashtable = new Hashtable<>();
        Scanner in = new Scanner(System.in);
        int largestProfit = 0;
        int n = in.nextInt();

        // profit = revenue - cosr
        for(int i = 0; i < n; i++) {
            int currentProfit = 0;
            String name = in.next();
            int revenue = in.nextInt();
            int cost = in.nextInt();
           currentProfit = revenue - cost;
           if (currentProfit > largestProfit) {
               largestProfit = currentProfit;
           }
           hashtable.put(currentProfit, name);
        }
        System.out.println(largestProfit);
        System.out.println(hashtable.get(largestProfit));
    }
}
