package shortestpath;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInGameMap {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] maps1 = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1},
        };
        int[][] maps2 = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1},
        };
        System.out.println(solution.solution(maps1));
        System.out.println(solution.solution(maps2));
    }
}

class Solution {
    public int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];

        visited[0][0] = true;

        return find(maps.length, maps[0].length, maps, visited);
    }

    private int find(int n, int m, int[][] maps, boolean[][] visited) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0, 1});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            if (x == n - 1 && y == m - 1) {
                return distance;
            }

            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                if (newX >= 0 && newX < n && newY >= 0 && newY < m && maps[newX][newY] == 1 && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX, newY, distance + 1});
                }
            }
        }

        return -1;
    }
}