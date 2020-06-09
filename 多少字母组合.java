package package2;

import java.util.*;

public class test6 {
    String str;
    int ct;
    List<Integer> onels = new ArrayList<>();
    List<List<Integer>> twols = new ArrayList<>();

    public static void main(String[] args) {
        test6 t = new test6();
        String str = "12311";
        System.out.println(t.method(str));
        System.out.println(t.twols);
    }

    private int method(String str) {
        this.str = str;
        recurs(0);
        return this.ct;
    }
    public void recurs(int i) {
        if (str.length() == i) {
            List<Integer> tls = new ArrayList<>();
            tls.addAll(onels);
            twols.add(tls);

            ct++;
            return;
        }

        if (str.length() - 1 == i) { // 但是最后一个元素还没有使用
            int c = Integer.parseInt(str.substring(str.length()-1,str.length()));
            if (c >= 0 && c <= 25) {
                onels.add(c);

                List<Integer> tls = new ArrayList<>();
                tls.addAll(onels);
                twols.add(tls);

                onels.remove(onels.size() - 1);
                ct++;
            }
            return;
        }

        // 最多两个元素
        int a = Integer.parseInt(str.substring(i,i + 1));
        int b = Integer.parseInt(str.substring(i,i + 2));
        // 无措路线才往下走
        if (a >= 0 && a <= 25) {
            onels.add(a);
            recurs(i + 1);
            onels.remove(onels.size() - 1);
        }
        if (b >= 0 && b <= 25) {
            onels.add(b);
            recurs(i + 2);
            onels.remove(onels.size() - 1);
        }
    }
}
