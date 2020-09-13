package leetcode13.algorithm.wk07;

/**
 * 547. 朋友圈
 */
public class HW_547 {

    /**
     * 类似岛屿数量
     *
     * @param M
     * @return
     */
    public int findCircleNum(int[][] M) {

        int count = 0;
        int[] visited = new int[M.length];
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                findAllFriend(i, M, visited);
                count++;
            }
        }
        return count;
    }

    private void findAllFriend(int i, int[][] M, int[] visited) {
        for(int j = 0; j < M.length; j++) {
            if(M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                findAllFriend(j, M, visited);
            }
        }
    }


}
