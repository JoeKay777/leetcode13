package leetcode13.algorithm.wk04;

import java.util.*;

/**
 * 860. 柠檬水找零
 */
public class Problem_860 {


    /**
     *
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {    // 5元购买，不需找零
                five++;
                continue;
            }
            if (bill == 10) { // 10元购买
                five--;
                ten++;
            } else if (ten > 0) {   // 20元购买，存在10元找零
                ten--;
                five--;
            } else {  // 20元购买，无10元找零
                five -= 3;
            }
            if (five < 0) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        new Problem_860().lemonadeChange(new int[]{5, 5, 10, 5, 20, 20, 20, 10, 5, 10});
    }
}
