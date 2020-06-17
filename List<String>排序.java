
 Collections.sort(d, new Comparator < String > () { // 实现已经排好顺序了
            public int compare(String s1, String s2) {
                return s2.length() != s1.length() ? 
                s2.length() - s1.length() : s1.compareTo(s2);
            }
        });
