import java.util.*;
import java.io.*;

class Main {

    static int DataValidation(String str) {
        // code goes here
        int spaceIndex = 0;
        char[] strCharArray = str.toCharArray();
        String type = "";
        String value = "";
        int isValid = -1;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                spaceIndex = i;
                while(i < str.length()) {
                    value += str.charAt(i);
                    i++;
                }
                break;
            }

            type += str.charAt(i);
        }

        System.out.println(type);
        System.out.println(value);

        if (type.equals("--count") && (Integer.parseInt(value) >= 10 && Integer.parseInt(value) =< 100)) {
            isValid = 1;
        }

        if (type.equals("--name") && (value.length() >= 3 && value.length() =< 10) {
            isValid = 1;
        }

        if (type.equals("--help") && value == " " ) {
            isValid = 1;
        }

        return isValid;
    }

    public static void main (String[] args) {
        String str = new String("--count g");
        System.out.print(DataValidation("--count g"));
    }

}