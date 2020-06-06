public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList();
        if (s.length() < 2) {
            return ans;
        }
        int i = 0 , j = 0, n = s.length();
        for (j = 1; j < n; j++) { // 到达最后一位
            if (s.charAt(j - 1) == s.charAt(j)) {
                continue;
            }
            if (s.charAt(j - 1) != s.charAt(j)) {
                if (j-i >= 3) ans.add(Arrays.asList(new Integer[]{i, j - 1}));
                i = j;
            }
        }
        //理解此时j强行认作转向值
        if (j-i >= 3) ans.add(Arrays.asList(new Integer[]{i, j - 1}));
        
        return ans;
    }
