package leetcode.strings.valid_palindrome;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    public void testIsPalindrome_StandardValid() {
        assertTrue(solution.isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    public void testIsPalindrome_StandardInvalid() {
        assertFalse(solution.isPalindrome("race a car"));
    }

    @Test
    public void testIsPalindrome_EmptyAndNull() {
        assertTrue(solution.isPalindrome(""));
        assertTrue(solution.isPalindrome(null));
    }

    @Test
    public void testIsPalindrome_OnlySymbols() {
        assertTrue(solution.isPalindrome("###,,,###"));
    }

    @Test
    public void testIsPalindrome_SingleCharacter() {
        assertTrue(solution.isPalindrome("a"));
    }
}