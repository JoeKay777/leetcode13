package leetcode13.algorithm.wk09;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 205. 同构字符串
 */
public class HW_205 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (map.containsKey(key)) {
                if (map.get(key) != t.charAt(i)) {
                    return false;
                }
            } else if (map.containsValue(t.charAt(i))) {
                return false;

            }
            map.put(key, t.charAt(i));
        }
        return true;
    }

    public static void main(String[] args) {
        new HW_205().isIsomorphic("egg", "add");
    }
}
