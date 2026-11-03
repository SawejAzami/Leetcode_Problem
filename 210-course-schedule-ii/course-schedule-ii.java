class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       int inDegree[] = new int[numCourses];

        // Calculate indegree
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
        }

        // Create adjacency matrix
        int graph[][] = new int[numCourses][numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]][prerequisites[i][0]] = 1;
        }

        Queue<Integer> q = new LinkedList<>();

        // Add courses having indegree 0
        for (int j = 0; j < numCourses; j++) {
            if (inDegree[j] == 0) {
                q.add(j);
            }
        }

        int res[] = new int[numCourses];
        int i = 0;

        // BFS (Kahn's Algorithm)
        while (!q.isEmpty()) {

            int row = q.remove();

            res[i++] = row;

            for (int col = 0; col < numCourses; col++) {

                if (graph[row][col] == 1) {

                    inDegree[col]--;

                    if (inDegree[col] == 0) {
                        q.add(col);
                    }
                }
            }
        }

        // Check for cycle
        if (i == numCourses) {
            return res;
        }

        return new int[0];
    }
}