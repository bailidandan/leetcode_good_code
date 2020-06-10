package pa4;

import java.util.*;

public class test1 {
    public static void main(String[] args) {
        test1 t = new test1();
         int[] a = {1,2,0,-1,3,-2,4,1};
        System.out.println(t.method(a));
    }
    int[] nums;
    private  int method(int[] nums) {
        int[][] a = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[i][i] = nums[i];
        }
        this.nums = nums;
        // 二级填充
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j + i < a[0].length; j++) {
                 int one = a[j + 1][j + i - 1] + nums[j] + nums[j + i];
                 int two = a[j + 1][j + i];
                 int three = a[j][j + i - 1];
                a[j][j + i] = Math.max(one,Math.max(two,three));
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + "   ,");
            }
            System.out.println();
        }
        findPath(a);

        return a[0][a[0].length - 1];
    }
    int m;
    int n;
    int[][] a;
    int[][] directions = {{1,0},{0,-1},{1,-1}}; // 下，上，有，左
    private void findPath(int[][] a) {
        this.m = a.length;
        if (m == 0) {
            return;
        }
        this.n = a[0].length;
        this.a = a;
        recurs(0,a[0].length - 1,"");
    }
    void recurs (int x,int y,String str) {
        if (x >= y) {
            return ;
        }
        for (int i = 0; i < 3; i++) {
            int newx = x + directions[i][0];
            int newy = y + directions[i][1];
            int t = a[newx][newy];
            if (i == 2) {
                t += (nums[x] + nums[y]);
            }
            if (this.inarea(newx,newy) && t == a[x][y]) {
                recurs(newx,newy,str + "," + t);
            }
        }
    }
    public boolean inarea (int x,int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
