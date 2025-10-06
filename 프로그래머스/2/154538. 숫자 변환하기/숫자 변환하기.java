import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int x, int y, int n) {
        if (x == y) return 0;

        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[y + 1];

        q.add(new int[]{x, 0});
        visited[x] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int num = cur[0];
            int count = cur[1];

            int[] nexts = {num + n, num * 2, num * 3};
            for (int next : nexts) {
                if (next == y) return count + 1;
                if (next < y && !visited[next]) {
                    visited[next] = true;
                    q.add(new int[]{next, count + 1});
                }
            }
        }

        return -1;
    }
}