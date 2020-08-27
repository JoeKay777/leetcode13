package leetcode13.algorithm.wk05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 119. 杨辉三角 II
 */
public class Exercise_119 {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) {
            return Collections.emptyList();
        }
        List<Integer> row = new ArrayList<>(rowIndex + 1);
        row.add(1);
        int prev = row.get(0);
        for (int x = 1; x <= rowIndex; x++) {
            for (int y = 1; y < x; y++) {
                int cur = prev + row.get(y);
                prev = row.get(y);
                row.set(y, cur);
            }
            row.add(1);
        }
        return row;
    }

}
