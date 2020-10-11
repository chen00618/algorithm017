package week03;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: test
 * @description: 全排列I
 * @author: ChenWeiJun
 * @create: 2020-10-11 16:24
 **/
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        boolean[] used = new boolean[nums.length];
        helper(res,nums,0,new ArrayList<>(),used);
        return res;
    }
    private void helper(List<List<Integer>> res,int[] nums, int index,List<Integer> list,boolean[] used) {
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i=0;i<nums.length;i++) {
            if (used[i]) continue;
            list.add(nums[i]);
            used[i] = true;
            helper(res,nums,index+1,list,used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}
