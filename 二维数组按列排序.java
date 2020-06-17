  /**
     * 按列排序
     * @param ob 待排序的数组
     * @param order 列排序的优先级， 如：new int{1, 2} 先根据第一列比较，若相同则再比较第二列
     */
    private static void sortByColumn(int[][] ob, final int[] order) {
        Arrays.sort(ob, new Comparator<Object>() {
            public int compare(Object o1, Object o2) {
                int[] one = (int[]) o1;
                int[] two = (int[]) o2;
                for (int i = 0; i < order.length; i++) {
                    int k = order[i];
                    if (one[k] > two[k]) {
                        return 1;
                    } else if (one[k] < two[k]) {
                        return -1;
                    } else {
                        continue;
                    }
                }
                return 0;
            }
        });
    }
