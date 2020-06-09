public class test6 {
    public static void main(String[] args) {
        int[] a = {1,0,1,0,0,1,1,0,2, 1,1,0,0,0,1};
        // 仅仅解决这个数据
        int [] a = {};
        System.out.println(method(a));
    }

    private static Integer method(int[] a) {
       // 解决了适配问题
        if (a.length < 3) {
            return null;
        }
        int start = 0;
        List<Integer[]> list = new ArrayList<>();
        for (int i = 1; i < a.length; i++) {
            if (a[i] == 1 && a[i-1] == 0 ) { // 利用他的特征变化
                // 这个是他的终点
                Integer[] en = new Integer[2];
                en[0] = start;
                en[1] = i;
                list.add(en);
            } else {
                if (a[i] == 0 && a[i-1] == 1) { // 刚进入，作为起点
                    start = i - 1;
                } else {
                    continue;
                }
            }

        }
        System.out.println(list);
        return true;

    }
}
