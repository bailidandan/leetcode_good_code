package package2;

import java.util.*;

public class test7 {
    public static void main(String[] args) {
        test7 t = new test7();
        String[] a = {"ef","fq","ao","at","lx"};
        String p = "ya";
        System.out.println(t.findAndReplacePattern(a,p));
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String en = words[i];
            if (match(en,pattern)) {
                list.add(en);
            }
        }
        return list;
    }

    private boolean match(String en, String pattern) {
        Map<String,String> map = new HashMap<>();
        for (int i = 0; i < en.length(); i++) {
            String e = en.charAt(i) + "";
            if (map.containsKey(e)) {
                String value = map.get(e);
                if(!value.equals(pattern.charAt(i) + "")) {
                    return false;
                }
            } else {
                map.put(e,pattern.charAt(i) + "");
            }
        }

        map.clear();
        for (int i = 0; i < pattern.length(); i++) {
            String e = pattern.charAt(i) + "";
            if (map.containsKey(e)) {
                String value = map.get(e);
                if(!value.equals(en.charAt(i) + "")) {
                    return false;
                }
            } else {
                map.put(e,en.charAt(i) + "");
            }
        }
        return true;
    }
}
