import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1() {
        int[][] intervals = {
                {1, 4},
                {2, 4},
                {3, 6},
                {4, 4}
        };
        int[] queries = {2, 3, 4, 5};
        int[] expected = {3, 3, 1, 4};
        int[] actual = new Solution().minInterval(intervals, queries);

        Assert.assertArrayEquals(expected, actual);
    }
    @Test
    public void test2() {
        int[][] intervals = {
                {2, 3},
                {2, 5},
                {1, 8},
                {20, 25}
        };
        int[] queries = {2, 19, 5, 22};
        int[] expected = {2, -1, 4, 6};
        int[] actual = new Solution().minInterval(intervals, queries);

        Assert.assertArrayEquals(expected, actual);
    }
}
