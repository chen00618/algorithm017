package week02;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: test
 * @description:
 * @author: ChenWeiJun
 * @create: 2020-09-28 22:44
 **/
public class PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(res,root);
        return res;
    }
    private void helper(List<Integer> res, TreeNode root) {
        if (root == null) return;
        res.add(root.val);
        helper(res,root.left);
        helper(res,root.right);
    }

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
