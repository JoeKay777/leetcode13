package leetcode13.algorithm.wk05;

import java.util.*;

/**
 * 874. 模拟行走机器人
 * -2：向左转 90 度
 * -1：向右转 90 度
 * 1 <= x <= 9：向前移动 x 个单位长度
 */
public class Exercise_874 {

    public int robotSim(int[] commands, int[][] obstacles) {
        // 定义方向
        int[][] coordinate = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int direction = 0;
        int x = 0, y = 0, res = 0;

        Set<String> x_ySet = new HashSet<>(obstacles.length);
        for (int[] obs : obstacles) {
            x_ySet.add(obs[0] + "_" + obs[1]);
        }
        for (int command : commands) {
            if (command == -1) {
                direction = (direction + 1) % 4;
            } else if (command == -2) {
                direction = (direction + 3) % 4;
            } else {
                for (int step = 1; step <= command; step++) {
                    int next_x = x + coordinate[direction][0];
                    int next_y = y + coordinate[direction][1];
                    if (!x_ySet.contains(next_x + "_" + next_y)) {
                        x = next_x;
                        y = next_y;
                        res = Math.max(res, x * x + y * y);
                    }
                }
            }
        }
        return res;
    }
}
