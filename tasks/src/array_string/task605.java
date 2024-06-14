package array_string;

import org.junit.Test;

public class task605 {
    /*
    You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot
    be planted in adjacent plots.

    Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an
    integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers
    rule and false otherwise.

    Example 1:
    Input: flowerbed = [1,0,0,0,1], n = 1
    Output: true

    Example 2:
    Input: flowerbed = [1,0,0,0,1], n = 2
    Output: false

    Constraints:

    1 <= flowerbed.length <= 2 * 104
    flowerbed[i] is 0 or 1.
    There are no two adjacent flowers in flowerbed.
    0 <= n <= flowerbed.length

     */

    // Runtime 0ms
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n==0) return true;
        if (flowerbed.length == 1) {
            if (n == 1)
                return flowerbed[0] == 0;
            else return false;
        }
        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            n--;
            if (n==0) return true;
        }
        if (flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0) {
            flowerbed[flowerbed.length-1] = 1;
            n--;
            if (n==0) return true;
        }
        for (int i = 1; i<flowerbed.length - 1; i++) {
            if (flowerbed[i] == 0) {
                if ((flowerbed[i - 1] == 0) && (flowerbed[i+1] == 0)) {
                    n--;
                    flowerbed[i] = 1;
                }
                if (n==0) break;
            }
        }
        return n==0;
    }

    @Test
    public void test(){
        assert(canPlaceFlowers(new int[]{1,0,0,0,1}, 1));
        assert(!canPlaceFlowers(new int[]{1,0,0,0,1}, 2));
        assert(canPlaceFlowers(new int[]{1,0,0,0,1,0,0}, 2));
        assert(canPlaceFlowers(new int[]{0}, 1));
        assert(!canPlaceFlowers(new int[]{1}, 1));
        assert(canPlaceFlowers(new int[]{1}, 0));
        assert(canPlaceFlowers(new int[]{0}, 0));
        assert(canPlaceFlowers(new int[]{0,0,1,0,0}, 1));
    }
}
