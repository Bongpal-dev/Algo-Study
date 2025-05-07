package dp;

public class Rob {
    public static void main(String[] args) {
        int[] money1 = {1, 2, 3, 1};
        int[] money2 = {10, 2, 2, 100, 2, 2, 10};

        System.out.println(solution(money1));
        System.out.println(solution(money2));
    }

    private static int solution(int[] money) {
        return Math.max(
                rob(money, 0, money.length - 1),
                rob(money, 1, money.length)
        );
    }

    private static int rob(int[] money, int s, int e) {
        int prev1 = 0;
        int prev2 = 0;

        for (int i = s; i < e; i++) {
            int current = Math.max(prev1, prev2 + money[i]);

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}

// https://school.programmers.co.kr/learn/courses/30/lessons/42897