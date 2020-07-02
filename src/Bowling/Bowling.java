package Bowling;

/**
 * Rules:
 * 10 frames with two rolls each frame
 * Score for any given frame is the sum of the pins knocked down during the two rolls (ex. 2 + 3 = 5)
 * Two special situations:
 *      1. All 10 pins w/ 2 balls: Spare - taking the 10 knocked down and adding it to the very next throw
 *          Ex. 5 + 5 = 10 (first frame) + 3 (next throw) = 13 for the first frame - overriding the 10
 *      2. All 10 pins with first throw in a frame: Strike - 10 + next two throws = first frame's score
 *
 *      10th frame:
 *          - Spare - throw one ball to determine 10th' frame's score
 *          - Strike - throw two more balls to determine 10th's frame's score
 */

/*
* Spare logic
*---------------
* Objective: Need to remember that a spare happened in the last frame (will need memory)
* Do this by remembering all of the rolls and how many pins were knocked down
* THEN calculate the score in the end once we have all the information from the frames
*
* Frame Boundery Logic
* ------------------
* Spares should be consecutive within a frame
* Rolling a 0, 5, 5, is not a spare because it splits across two frames
* Need 5 and a 5 in the same frame
* So instead of iterating over the rolls, iterate in frames - always 10 frames per game
*/

public class Bowling {
    // counter to track rolls in array
    private int roll = 0;
    // array to store rolls
    // 21 is the most rolls in a game
    private int[] rolls = new int[21];

    // rolling interface to input rolls per frame
    public void rollScores(int[] rolls) {
        for (int pinsDown: rolls) {
            roll(pinsDown);
        }
    }

    public void roll(int pinsDown) {
        // remember rolls here
        // when a roll comes in, store the number of pins knocked down in that roll
        // increment roll
        rolls[roll++] = pinsDown;
        String n = "sdf";
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
