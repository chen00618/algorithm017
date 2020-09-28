package week02;

/**
 * @program: test
 * @description:
 * @author: ChenWeiJun
 * @create: 2020-09-28 22:41
 **/
public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        int length;
        if((length=s.length()) != t.length())
            return false;

        int[] count = new int[26];

        for(int i=0 ; i < length ; i++){
            count[s.charAt(i) - 'a'] = ++count[s.charAt(i) - 'a'];
            count[t.charAt(i) - 'a'] = --count[t.charAt(i) - 'a'];
        }

        for (int i = 0;i<count.length;i++) {
            if(count[i] != 0)
                return false;
        }
        return true;
    }
}
