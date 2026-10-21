
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        if (source == destination) {
            return true;
        }

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] vis = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(source);
        vis[source] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int neighbor : adj.get(curr)) {
                if (!vis[neighbor]) {
                    if (neighbor == destination) {
                        return true;
                    }

                    vis[neighbor] = true;
                    q.offer(neighbor);
                }
            }
        }

        return false;
    }
}
