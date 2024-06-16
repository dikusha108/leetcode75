package array_string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class task334_unsolved {
    /*
    Given an integer array nums, return true if there exists a triple of indices (i, j, k)
    such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.

    Example 1:
    Input: nums = [1,2,3,4,5]
    Output: true
    Explanation: Any triplet where i < j < k is valid.

    Example 2:
    Input: nums = [5,4,3,2,1]
    Output: false
    Explanation: No triplet exists.

    Example 3:
    Input: nums = [2,1,5,0,4,6]
    Output: true
    Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.

    Constraints:
    1 <= nums.length <= 5 * 105
    -231 <= nums[i] <= 231 - 1
     */

    public boolean increasingTriplet(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        for (int j = 0; j<nums.length - 1; j++) {
            for (int k=j+1; k<nums.length; k++) {
                if (nums[j] < nums[k]) {
                    temp.add(nums[k]);
                }
            }
            if (temp.size() < 2) continue;

            int isSorted = 0;
            for (int i=0; i<temp.size() - 1; i++) {
                if (temp.get(i) < temp.get(i+1)){
                    isSorted++;
                }
            }
            if (isSorted >=1) {}
        }

        return temp.size()==3;
    }

    @Test
    public void test(){
        assert(increasingTriplet(new int[] {1,2,3,4,5}));
        assert(!increasingTriplet(new int[] {5,4,3,2,1}));
        assert(increasingTriplet(new int[] {2,1,5,0,4,6}));
        assert(!increasingTriplet(new int[] {6,7,1,2}));
        assert(increasingTriplet(new int[] {20,100,10,12,5,13}));
        assert(!increasingTriplet(new int[] {0,4,2,1,0,-1,-3}));
        assert(increasingTriplet(new int[] {1,5,0,4,1,3}));
    }
}
