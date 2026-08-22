class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<Integer>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        // Graph banana
        for (int[] p : prerequisites) {
            graph[p[1]].add(p[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];

        List<Integer> result = new ArrayList<>();

        // DFS
        for (int i = 0; i < numCourses; i++) {

            if (!visited[i]) {

                if (dfs(i, graph, visited, path, result)) {
                    return new int[0];
                }
            }
        }

        // DFS mein reverse order mila tha
        Collections.reverse(result);

        // List → int[]
        int[] ans = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }

    private boolean dfs(int node,
                        List<Integer>[] graph,
                        boolean[] visited,
                        boolean[] path,
                        List<Integer> result) {

        visited[node] = true;
        path[node] = true;

        for (int neighbor : graph[node]) {

            if (!visited[neighbor]) {

                if (dfs(neighbor, graph, visited, path, result)) {
                    return true;
                }

            } else if (path[neighbor]) {

                // Cycle found
                return true;
            }
        }

        // Node completely processed
        path[node] = false;

        result.add(node);

        return false;
    }
}