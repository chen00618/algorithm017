package week02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: test
 * @description:
 * @author: ChenWeiJun
 * @create: 2020-09-28 22:42
 **/
public class Preorder {

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);
            for (int i=node.children.size()-1;i>=0;i--)
                stack.push(node.children.get(i));
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
