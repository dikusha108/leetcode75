package array_string;

import org.junit.Test;

import java.util.Arrays;

public class task238 {
    /*
    Given an integer array nums, return an array answer such that answer[i] is equal to the product of
    all the elements of nums except nums[i].
    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
    You must write an algorithm that runs in O(n) time and without using the division operation.

    Example 1:
    Input: nums = [1,2,3,4]
    Output: [24,12,8,6]

    Example 2:
    Input: nums = [-1,1,0,-3,3]
    Output: [0,0,9,0,0]

    Constraints:
        2 <= nums.length <= 105
        -30 <= nums[i] <= 30
        The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
     */

    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 2) {
            return new int[]{nums[1], nums[0]};
        }
        int n = nums.length;

        int[] result = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1; right[n - 1] = 1;

        // count the left product (prefix)
        // nums = [1,2,3,4]
        // left = [1, 1, 2, 6]
        for (int i = 1; i< n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        // count the right product (suffix)
        // nums = [1,2,3,4]
        // right = [right[1]*num[1],right[2]*num[2],right[3]*num[3],1] = [24,12,4,1]
        for(int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for(int i = 0; i < n; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }

    @Test
    public void test() {
        assert(Arrays.equals(productExceptSelf(new int[]{1, 2, 3, 4}), new int[]{24, 12, 8, 6}));
    }
}
