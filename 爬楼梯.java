package package3;

import java.util.*;

public class test6 {
    int ct;
    public int climbStairs(int n) {
        if (n == 1){
            return 1;
        }
        // 动态规划
        int a = 1;
        int b = 1;
        for (int i = 2;i < n;i++) {
            ct = a + b;
            b = a;
            a = ct;
        }
        return ct;
    }

}
