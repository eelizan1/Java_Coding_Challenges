package TMobile;

import static TMobile.Main.removeDups;
import static org.junit.Assert.*;

public class MainTest {
    @org.junit.Test
    public void dummyTest() {
        int num = removeDups(new int[]{2, 3, 3, 3, 6, 9, 9});
        assertEquals(4, num);
    }

}