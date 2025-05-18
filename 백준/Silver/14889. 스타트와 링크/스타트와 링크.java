import java.io.*;
import java.util.*;

public class Main {
    private static int[][] abilityMap;
    private static int N;
    private static int M;
    private static int[] array;
    private static boolean[] visited;
    private static Deque<List<Integer>> deque;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = N / 2;
        abilityMap = new int[N][N];
        deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            abilityMap[i] = row;
        }

        array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = i; // 0부터 N-1까지
        }

        visited = new boolean[N];
        dfs(0, 0);

        int minDiff = Integer.MAX_VALUE;

        for (List<Integer> teamA : deque) {
            List<Integer> teamB = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if (!teamA.contains(i)) {
                    teamB.add(i);
                }
            }

            int sumA = calculateAbility(teamA);
            int sumB = calculateAbility(teamB);

            minDiff = Math.min(minDiff, Math.abs(sumA - sumB));
        }

        System.out.println(minDiff);
    }


    static void dfs(int start, int depth) {
        if (depth == M) {
            List<Integer> team = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if (visited[i]) team.add(i);
            }
            deque.add(team);
            return;
        }

        for (int i = start; i < N; i++) {
            visited[i] = true;
            dfs(i + 1, depth + 1);
            visited[i] = false;
        }
    }

    static int calculateAbility(List<Integer> team) {
        int sum = 0;
        for (int i = 0; i < team.size(); i++) {
            for (int j = 0; j < team.size(); j++) {
                if (i != j) {
                    sum += abilityMap[team.get(i)][team.get(j)];
                }
            }
        }
        return sum;
    }


}
