package week07;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @program: test
 * @description: 最小基因次数
 * @author: ChenWeiJun
 * @create: 2020-11-15 22:23
 **/
public class MinMutation {

    public int minMutation(String start, String end, String[] bank) {
        char[] charSet = {'A','C','G','T'};
        Set<String> bankSet = new HashSet<>();
        for (String str : bank) bankSet.add(str);

        Set<String> visited = new HashSet<>();
        visited.add(start);

        Deque<String> deque = new LinkedList<>();
        deque.offerLast(start);
        int count = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                String str = deque.pollFirst();
                if (str.equals(end)) return count;
                final char[] chars = str.toCharArray();
                for (int i=0;i<chars.length;i++) {
                    char old = chars[i];
                    for (int j=0;j<charSet.length;j++) {
                        chars[i] = charSet[j];
                        String temp = new String(chars);
                        if (bankSet.contains(temp) && !visited.contains(temp)) {
                            deque.offerLast(temp);
                            visited.add(temp);
                        }
                    }
                    chars[i] = old;
                }
            }
            count++;
        }
        return -1;
    }
}
