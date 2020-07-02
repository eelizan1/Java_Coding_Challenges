package InterviewCake.Arrays.CakeShop;

public class Main {
    public static void main(String[] args) {
        int[] takeOut = {1, 3, 5};
        int[] dineIn = {2, 4, 6};
        int[] served = {1, 2, 4, 6, 5, 3};

        System.out.println(isFirstComeFirstServe(takeOut, dineIn, served));
    }

    static boolean isFirstComeFirstServe(int[] takeout, int[] dineIn, int[] served) {
        int takeoutIndex = 0;
        int dineInIndex = 0;

        for (int i = 0; i < served.length; i++) {
            if (takeoutIndex < takeout.length && served[i] == takeout[takeoutIndex]) {
                takeoutIndex++;
            } else if (dineInIndex < dineIn.length && served[i] == dineIn[dineInIndex]) {
                dineInIndex++;
            } else {
                return false;
            }
        }

        // check for any extra orders at th end of takeOutOrders or dineInOrders
        if (dineInIndex != dineIn.length || takeoutIndex != takeout.length) {
            return false;
        }

        return true;
    }
}
