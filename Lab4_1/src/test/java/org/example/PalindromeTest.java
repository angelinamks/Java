package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PalindromeTest {
    private final Palindrome palindrome = new Palindrome();

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome("radar"));
        assertTrue(palindrome.isPalindrome("Racecar"));
        assertTrue(palindrome.isPalindrome("A man a plan a canal Panama"));
        assertFalse(palindrome.isPalindrome("hello"));
        assertFalse(palindrome.isPalindrome("OpenAI"));
    }

    @Test
    public void testIsPalindromeWithSpaces() {
        assertTrue(palindrome.isPalindrome("A man    a plan    a canal Panama"));
        assertTrue(palindrome.isPalindrome("   radar   "));
    }

    @Test
    public void testIsPalindromeEmptyString() {
        assertTrue(palindrome.isPalindrome(""));
    }
}

