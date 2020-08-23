package leetcode13.algorithm.wk04;

import java.util.*;

/**
 * 874. 模拟行走机器人
 * -2：向左转 90 度
 * -1：向右转 90 度
 * 1 <= x <= 9：向前移动 x 个单位长度
 */
public class Problem_874 {

    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};  // 方向定义
        int dir = 0;    // 行走方向，对应direction下表
        int x = 0, y = 0;
        int maxDistance = 0;
        Set<String> obSet = new HashSet<>(obstacles.length); // 障碍物集合
        for (int i = 0; i < obstacles.length; i++) {
            obSet.add(obstacles[i][0] + "_" + obstacles[i][1]);
        }
        for (int command : commands) {
            if (command == -1) {
                dir = (dir + 1) % 4;
            } else if (command == -2) {
                dir = (dir + 3) % 4;
            } else {
                for (int step = 0; step < command; step++) {
                    int next_x = x + direction[dir][0];
                    int next_y = y + direction[dir][1];
                    if (obSet.contains(next_x + "_" + next_y)) { // 碰到障碍物，停止
                        break;
                    }
                    x = next_x;
                    y = next_y;
                    maxDistance = Math.max(maxDistance, x * x + y * y);
                }
            }
        }
        return maxDistance;
    }
}
