package leetcode13.algorithm.wk05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 118. 杨辉三角
 */
public class Exercise_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        if(numRows > 0) {
            result.add(Arrays.asList(1));
        }
        for (int x = 1; x < numRows; x++) {
            List<Integer> row = new ArrayList<>(x + 1);
            row.add(1);     // 第一个都是1
            for (int y = 1; y < x; y++) {
                List<Integer> preRow = result.get(x - 1);
                int cur = preRow.get(y - 1) + preRow.get(y);
                row.add(cur);
            }
            row.add(1);  // 最后一个都是1
            result.add(row);
        }
        return result;
    }

}
