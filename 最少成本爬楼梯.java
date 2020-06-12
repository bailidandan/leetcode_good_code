 public int minCostClimbingStairs(int[] cost) {
        int ct = 0;
        int a = 0;
        int b = 0;
        // 10 15 20
        for (int i = 2; i < cost.length + 1; i++) {
            int m = a + cost[i - 2];
            int n = b + cost[i - 1];
            if (m > n) {
                ct = n;
            } else {
                ct = m;
            }
            a = b;
            b = ct;
        }
        return ct;

    }
