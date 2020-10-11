package week03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: test
 * @description: 全排列II
 * @author: ChenWeiJun
 * @create: 2020-10-11 16:27
 **/
public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        helper(res,0,nums,used,new ArrayList<>());
        return res;
    }
    private void helper(List<List<Integer>> res, int index, int[] nums, boolean[] used,List<Integer> list) {
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i=0;i<nums.length;i++) {
            if (used[i]) continue;
            if (i>0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            used[i] = true;
            list.add(nums[i]);
            helper(res,index+1,nums,used,list);
            used[i] = false;
            list.remove(list.size() -1);
        }
    }
}
