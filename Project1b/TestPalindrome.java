package project1B;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    /*// You must use this palindrome, and not instantiate
    // new Palindromes, or the auto-grader might be upset.
    */
    static Palindrome palindrome = new Palindrome();
    static OffByOne offByOne = new OffByOne();
    static OffByN offByN = new OffByN(5);

    @Test
    public void testWordToDeque() {
        Deque d = (Deque) palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
    //Uncomment this class once you've created your Palindrome class. */
    @Test
    public void testIsPalindrome(){
        assertFalse(palindrome.isPalindrome("cat"));
        assertTrue(palindrome.isPalindrome("m"));
        assertTrue(palindrome.isPalindrome("abcba"));
        assertFalse(palindrome.isPalindrome("abab"));
        assertTrue(palindrome.isPalindrome("mnnm"));
        assertTrue(palindrome.isPalindrome(""));
        assertFalse(palindrome.isPalindrome("ab"));
        assertTrue(palindrome.isPalindrome("aa"));
        assertTrue(palindrome.isPalindrome("a a"));
        assertTrue(palindrome.isPalindrome("mmmmmm"));

    }
    @Test
    public void TestisPalindromeByOne(){
        assertTrue(palindrome.isPalindrome("ab",offByOne));
        assertTrue(palindrome.isPalindrome("",offByOne));
        assertTrue(palindrome.isPalindrome("mhn",offByOne));
        assertTrue(palindrome.isPalindrome("flake",offByOne));
        assertFalse(palindrome.isPalindrome("123",offByOne));
        assertFalse(palindrome.isPalindrome("MM",offByOne));
    }
    @Test
    public void TestisPalindromeByN(){
        assertTrue(palindrome.isPalindrome("af",offByN));
        assertFalse(palindrome.isPalindrome("bc",offByN));
        assertTrue(palindrome.isPalindrome("abgf",offByN));
        assertTrue(palindrome.isPalindrome("m",offByN));
        assertTrue(palindrome.isPalindrome("n",offByN));
        assertTrue(palindrome.isPalindrome("hlqc",offByN));
        assertFalse(palindrome.isPalindrome("hlAc",offByN));


    }
}
