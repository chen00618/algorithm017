package week07;

import java.util.*;

/**
 * @program: test
 * @description: 单词接龙
 * @author: ChenWeiJun
 * @create: 2020-11-15 22:25
 **/
public class LadderLength {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();//已经遍历过的，防止重复遍历
        Deque<String> deque = new LinkedList<>();
        deque.offerLast(beginWord);
        int level = 1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                String str = deque.pollFirst();
                if (str.equals(endWord)) return level;
                char[] chars = str.toCharArray();
                for (int i=0;i<chars.length;i++) {
                    char old = chars[i];
                    for (char c='a';c<='z';c++) {
                        chars[i] = c;
                        String temp = String.valueOf(chars);
                        if (wordSet.contains(temp) && !visited.contains(temp)) {
                            deque.offerLast(temp);
                            visited.add(temp);
                        }
                    }
                    chars[i] = old;
                }
            }
            level++;
        }
        return 0;
    }
}
