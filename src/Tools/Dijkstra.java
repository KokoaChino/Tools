package Tools;

import java.util.*;


public class Dijkstra {
    public int[] dijkstra(int[][] mat, int a) { // Dijkstra 单源最短路算法
        int n = mat.length;
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[a] = 0;
        Deque<Integer> q = new ArrayDeque<>();
        q.add(a);
        while (!q.isEmpty()) {
            int x = q.pollFirst();
            for (int y = 0; y < n; y++) {
                if (ans[x] + mat[x][y] < ans[y]) {
                    ans[y] = ans[x] + mat[x][y];
                    q.add(y);
                }
            }
        }
        return ans;
    }

    public int[] dijkstra(ArrayList<int[]>[] g, int a) { // 堆优化的 Dijkstra 单源最短路算法
        int n = g.length;
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[a] = 0;
        boolean[] st = new boolean[n];
        Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
        q.add(new int[]{a, 0});
        while (!q.isEmpty()) {
            int x = q.poll()[0];
            if (st[x]) continue;
            st[x] = true;
            for (int[] t : g[x]) {
                int y = t[0], d = t[1];
                ans[y] = Math.min(ans[y], ans[x] + d);
                q.add(new int[]{y, ans[y]});
            }
        }
        return ans;
    }
}