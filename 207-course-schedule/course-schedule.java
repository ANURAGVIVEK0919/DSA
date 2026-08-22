class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

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

        for (int i = 0; i < numCourses; i++) {

            if (!visited[i]) {

                if (dfs(i, graph, visited, path)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int node,
                        List<Integer>[] graph,
                        boolean[] visited,
                        boolean[] path) {

        visited[node] = true;
        path[node] = true;

        for (int neighbor : graph[node]) {

            if (!visited[neighbor]) {

                if (dfs(neighbor, graph, visited, path)) {
                    return true;
                }

            } else if (path[neighbor]) {

                return true;
            }
        }

        path[node] = false;

        return false;
    }
}