package Tools;

import java.util.ArrayDeque;
import java.util.ArrayList;


class TopologicalSort {

    public static ArrayList<Integer> get(int n, int[][] edges) { // 返回该有向无环图的拓扑排序
        int[] deg = new int[n];
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<Integer>());
        for (int[] arr: edges) {
            g.get(arr[0]).add(arr[1]);
            deg[arr[1]]++;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) {
                q.offer(i);
                ans.add(i);
            }
        }
        while (!q.isEmpty()) {
            for (int x: g.get(q.pop())) {
                if (--deg[x] == 0) {
                    q.offer(x);
                    ans.add(x);
                }
            }
        }
        return ans.size() == n ? ans : new ArrayList<>();
    }
}