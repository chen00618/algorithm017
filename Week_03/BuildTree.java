package week03;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: test
 * @description: 构建二叉树
 * @author: ChenWeiJun
 * @create: 2020-10-11 11:09
 **/
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder == null || preorder == null || preorder.length != inorder.length) return null;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<inorder.length;i++) map.put(inorder[i],i);
        return build(preorder,0,preorder.length - 1,inorder,0,inorder.length - 1,map);
    }
    private TreeNode build(int[] preorder, int ps, int pe, int[] inorder, int is, int ie,Map<Integer,Integer> map) {
        if (ps > pe || is > ie) return null;

        TreeNode root = new TreeNode(preorder[ps]);
        int rootIndex = map.get(root.val);
        int length = rootIndex - is;

        root.left = build(preorder,ps+1,ps+length,inorder,is,rootIndex-1,map);
        root.right = build(preorder,ps+length+1,pe,inorder,rootIndex+1,ie,map);
        return root;
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
