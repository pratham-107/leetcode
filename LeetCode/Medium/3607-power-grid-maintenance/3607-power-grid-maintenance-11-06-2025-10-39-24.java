class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        int[] parent = new int[c + 1];
        int[] rank = new int[c + 1];
        for (int i = 1; i <= c; i++) parent[i] = i;

        for (int[] conn : connections) {
            union(conn[0], conn[1], parent, rank);
        }

        Map<Integer, TreeSet<Integer>> gridMap = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            int root = find(i, parent);
            gridMap.computeIfAbsent(root, k -> new TreeSet<>()).add(i);
        }

        boolean[] online = new boolean[c + 1];
        Arrays.fill(online, true);

        List<Integer> result = new ArrayList<>();
        for (int[] query : queries) {
            int type = query[0];
            int x = query[1];
            int root = find(x, parent);

            if (type == 1) {
                if (online[x]) {
                    result.add(x);
                } else {
                    TreeSet<Integer> set = gridMap.get(root);
                    if (set == null || set.isEmpty()) {
                        result.add(-1);
                    } else {
                        result.add(set.first());
                    }
                }
            } else if (type == 2) {
                if (online[x]) {
                    online[x] = false;
                    TreeSet<Integer> set = gridMap.get(root);
                    if (set != null) set.remove(x);
                }
            }
        }

        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) ans[i] = result.get(i);
        return ans;
    }

    private int find(int x, int[] parent) {
        if (x != parent[x]) parent[x] = find(parent[x], parent);
        return parent[x];
    }

    private void union(int a, int b, int[] parent, int[] rank) {
        int pa = find(a, parent);
        int pb = find(b, parent);
        if (pa == pb) return;

        if (rank[pa] < rank[pb]) parent[pa] = pb;
        else if (rank[pb] < rank[pa]) parent[pb] = pa;
        else {
            parent[pb] = pa;
            rank[pa]++;
        }
    }
}
