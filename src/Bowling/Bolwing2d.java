package Bowling;

public class Bolwing2d {
    // counter to track rolls in array
    private int roll = 0;
    // array to store rolls
    // 21 is the most rolls in a game
    private int[] rolls = new int[21];

    // rolling interface to input rolls per frame
    public void rollScores(int...rolls) {
        for (int pinsDown: rolls) {
            roll(pinsDown);
        }
    }

    public void roll(int pinsDown) {
        // remember rolls here
        // when a roll comes in, store the number of pins knocked down in that roll
        // increment roll
        rolls[roll++] = pinsDown;
    }

    public int score() {
        // score count
        int score = 0;
        // counter to keep track of where we are in the rolls array
        int cursor = 0;
        // sum up the scores from array
        // counts the total pins
        for (int frame = 0; frame < 10; frame++) {
            // strike logic
            // if roll is 10 then strike
            if (rolls[cursor] == 10) {
                // score a strike
                // rolls[cursor + 1] beacuse the first frame only had one rolls
                // rolls[cursor + 2] to add the next two rolls
                score += 10 + rolls[cursor + 1] + rolls[cursor + 2];
                // the strike only consumed one roll (per frame)
                cursor++;
            }
            // spare logic
            // test if spare happened
            // (rolls[cursor] is first roll and rolls[cursor + 1 is second roll)
            // if equals to 10 the spare happened
            else if (rolls[cursor] + rolls[cursor + 1] == 10) {
                // add 10 then the first throw of the next frame
                score += 10 + rolls[cursor+2];
                cursor += 2;
            } else {
                // in each frame there's two rolls
                score += rolls[cursor] + rolls[cursor + 1];
                cursor += 2;
            }
        }
        return score ;
    }
}
