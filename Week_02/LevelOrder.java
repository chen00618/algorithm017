package week02;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: test
 * @description:
 * @author: ChenWeiJun
 * @create: 2020-09-28 22:46
 **/
public class LevelOrder {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<Node> deque = new LinkedList<>();
        deque.addLast(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            while (size-- >0) {
                final Node node = deque.pollFirst();
                if (node != null) {
                    list.add(node.val);
                    deque.addAll(node.children);
                }
            }
            res.add(list);
        }
        return res;
    }

    class Node {
        public int val;
        public List<Node> children;

    public Node() {}

    public Node(int _val) {
            val = _val;
        }

    public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
