package two_pointers;

import org.junit.Test;

import java.util.Arrays;

public class task283 {
    /*
    Given an integer array nums, move all 0's to the end of it while maintaining the relative order
    of the non-zero elements.

    Note that you must do this in-place without making a copy of the array.



    Example 1:

    Input: nums = [0,1,0,3,12]
    Output: [1,3,12,0,0]

    Example 2:

    Input: nums = [0]
    Output: [0]



    Constraints:

    1 <= nums.length <= 104
    -231 <= nums[i] <= 231 - 1

     */

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int j=0;
        for (int i=0; i<n; i++) {
            if (nums[i]!=0){
                result[j] = nums[i];
                j++;
            }
        }
        System.arraycopy(result, 0, nums, 0, n);
    }

    @Test
    public void test() {
        int[] a = new int[]{0,0,1,2,0,3};
        moveZeroes(a);
        assert(Arrays.equals(a, new int[]{1, 2, 3, 0, 0, 0}));
    }
}
