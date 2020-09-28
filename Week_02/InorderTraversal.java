package week02;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: test
 * @description:
 * @author: ChenWeiJun
 * @create: 2020-09-28 22:43
 **/
public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(res,root);
        return res;
    }
    private void helper(List<Integer> res, TreeNode root) {
        if (root == null) return;

        helper(res,root.left);
        res.add(root.val);
        helper(res,root.right);
    }

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
