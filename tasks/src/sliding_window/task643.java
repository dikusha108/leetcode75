package sliding_window;

import org.junit.Test;

public class task643 {
    /*
    You are given an integer array nums consisting of n elements, and an integer k.

    Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

    Constraints:

    n == nums.length
    1 <= k <= n <= 105
    -104 <= nums[i] <= 104

     */

    public double findMaxAverage(int[] nums, int k) {
        double res = Double.NEGATIVE_INFINITY;

        if (nums.length == 1) return nums[0];

        for (int i = 0; i < nums.length - 1; i++) {
            if (i + k > nums.length) break;

            double sum = 0.0;
            for (int j = i; j < i + k; j++) {
                sum += nums[j];
            }
            res = Math.max(res, sum / k);
        }

        return Math.round(res * 100000.0) / 100000.0;
    }

    // faster solution
    public double findMaxAverageFast(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double res = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            res = Math.max(res, sum);
        }
        return res / k;
    }

    @Test
    public void test() {
        assert(findMaxAverageFast(new int[]{1,12,-5,-6,50,3}, 4) == 12.7500);

        assert(findMaxAverage(new int[]{8860,-853,6534,4477,-4589,8646,-6155,-5577,-1656,-5779,-2619,-8604,-1358,-8009,
                4983,7063,3104,-1560,4080,2763,5616,-2375,2848,1394,-7173,-5225,-8244,-809,8025,-4072,-4391,-9579,1407,
                6700,2421,-6685,5481,-1732,-8892,-6645,3077,3287,-4149,8701,-4393,-9070,-1777,2237,-3253,-506,-4931,
                -7366,-8132,5406,-6300,-275,-1908,67,3569,1433,-7262,-437,8303,4498,-379,3054,-6285,4203,6908,4433,3077,
                2288,9733,-8067,3007,9725,9669,1362,-2561,-4225,5442,-9006,-429,160,-9234,-4444,3586,-5711,-9506,-79,-4418,
                -4348,-5891}, 93) == -594.58065);
        assert(findMaxAverage(new int[]{5}, 1) == 5.0000);
    }
}
