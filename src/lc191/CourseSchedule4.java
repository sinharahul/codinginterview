package lc191;

import java.util.*;

public class CourseSchedule4 {
    public static void main(String[] args) {
        int[][] preq = {{1, 0}};
        int[][] queries = {{0, 1}, {1, 0}};
        CourseSchedule4 c = new CourseSchedule4();
        System.out.println(c.checkIfPrerequisite(2, preq, queries));
    }

    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List<Boolean> list = new ArrayList<>();
        if (edge(prerequisites, queries, list)) return list;
        Map<Integer, List<Integer>> map = convert(prerequisites);
        list = check(map, n,queries);
        return list;
    }

    private List<Boolean> check(Map<Integer, List<Integer>> map, int n, int[][] queries) {
        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            boolean reachable = dfs(map, n,queries[i][0], queries[i][1]);
            list.add(reachable);
        }
        return list;
    }

    //a is pre b . reach a starting from b
    private boolean dfs(Map<Integer, List<Integer>> map, int n, int a, int b) {
        if (a == b) return true;
        Stack<Integer> stack = new Stack<>();
        stack.push(b);
        boolean[] visited=new boolean[n];
        while (!stack.empty()) {
            int elem = stack.pop();
            if (elem == a) {
                return true;
            }
            visited[elem]=true;
            List<Integer> adj = map.get(elem);
            if(adj!=null) {
                for (Integer i : adj) {
                    if(!visited[i]) {
                        stack.add(i);
                    }
                }
            }
        }
        return false;
    }

    private Map<Integer, List<Integer>> convert(int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int elem = prerequisites[i][1];
            List<Integer> list = map.get(elem);
            if (list == null) {
                list = new ArrayList<>();
                map.put(elem, list);
            }
            list.add(prerequisites[i][0]);
        }
        return map;
    }

    private boolean edge(int[][] prerequisites, int[][] queries, List<Boolean> list) {
        if (prerequisites.length == 0) {
            for (int i = 0; i < queries.length; i++) {
                list.add(false);
            }
        }
        return false;
    }
}
