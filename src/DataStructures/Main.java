package DataStructures;

public class Main {
    public static void main(String[] args) {

        // 2D array
        int [][] numberGrid = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {0},
        };

        //System.out.println(numberGrid[1][2]);
        for(int i = 0; i < numberGrid.length; i++) { // loop through rows
            for(int j = 0; j < numberGrid[i].length; j++) { // loop through columns
                System.out.print(numberGrid[i][j]);
            }
            //System.out.println();
        }

//        for(int i = 1; i < 3; i++) {
//            for(int j = 1; j< 4; j++) {
//                System.out.println(i + ", " + j);
//            }
//        }
    }

    // 2d Array


}
