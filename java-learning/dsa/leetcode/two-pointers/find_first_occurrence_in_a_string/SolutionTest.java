package leetcode.strings.implement_strstr;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    public void testStrStr_StandardMatch() {
        assertEquals(0, solution.strStr("sadbutsad", "sad"));
    }

    @Test
    public void testStrStr_MatchInMiddle() {
        assertEquals(4, solution.strStr("leetcode", "code"));
    }

    @Test
    public void testStrStr_NoMatch() {
        assertEquals(-1, solution.strStr("leetcode", "leeto"));
    }

    @Test
    public void testStrStr_NeedleLongerThanHaystack() {
        assertEquals(-1, solution.strStr("short", "longerneedle"));
    }

    @Test
    public void testStrStr_ExactMatch() {
        assertEquals(0, solution.strStr("equal", "equal"));
    }
}