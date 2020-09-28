package week02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: test
 * @description:
 * @author: ChenWeiJun
 * @create: 2020-09-28 22:48
 **/
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> resMap = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (int i = 0;i<strs.length;i++) {
            char[] chars = new char[26];
            for (char c : strs[i].toCharArray()) chars[c-'a']++;
            final String key = new String(chars);
            if (resMap.get(key) == null) {
                List<String> list = new ArrayList<>();
                resMap.put(key,list);
                res.add(list);
            }
            resMap.get(key).add(strs[i]);
        }
        return res;
    }
}
