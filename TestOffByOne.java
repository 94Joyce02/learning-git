package project1B;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    /*
    // You must use this CharacterComparator and not instantiate
    // new ones, or the auto-grader might be upset.*/
    static CharacterComparator offByOne = new OffByOne();
    @Test
    public void testOffByOne(){
        assertEquals(offByOne.equalChars('a','b'),true);
        assertEquals(offByOne.equalChars('a','c'),false);
        assertEquals(offByOne.equalChars('n','m'),true);
    }

    // Your tests go here.
}
