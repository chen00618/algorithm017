package week03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: test
 * @description: 电话号码的数字组合
 * @author: ChenWeiJun
 * @create: 2020-10-11 10:38
 **/
public class LetterCombinations {

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        Map<Character,String> digitsMap = new HashMap<>();
        digitsMap.put('2',"abc");
        digitsMap.put('3',"def");
        digitsMap.put('4',"ghi");
        digitsMap.put('5',"jkl");
        digitsMap.put('6',"mno");
        digitsMap.put('7',"pqrs");
        digitsMap.put('8',"tuv");
        digitsMap.put('9',"wxyz");
        helper(res,digits,0,"",digitsMap);
        return res;
    }
    private void helper(List<String> res, String digits, int index, String str,Map<Character,String> digitsMap) {
        if (index == digits.length()) {
            res.add(str);
            return;
        }

        final char[] chars = digitsMap.get(digits.charAt(index)).toCharArray();
        for (char c : chars) {
            helper(res,digits,index+1,str+c,digitsMap);
        }
    }
}
