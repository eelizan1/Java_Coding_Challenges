package DataStructures.Lottery;

public class LotteryTicket {
    public static void main(String[] args) {
        // [row][column]

        int[][] loteryCard = {
                {20, 25, 7},
                {8, 7, 19},
                {7, 13, 47},
        };

        int[][] loteryCard2 = new int[3][3];

        System.out.println(loteryCard[0][0]);
        System.out.println("-----------------------");

        for(int i = 0; i < 3; i++) {;
            for(int j = 0; j < 3; j++) {
                System.out.println(loteryCard[i][j]);
            }
        }
    }
}
