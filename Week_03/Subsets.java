package week03;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: test
 * @description: 子集
 * @author: ChenWeiJun
 * @create: 2020-10-11 11:11
 **/
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res,0,nums,new ArrayList<>());
        return res;
    }
    private void helper(List<List<Integer>> res, int index, int[] nums, List<Integer> list) {
        if (index ==  nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        helper(res,index+1,nums,list);
        list.add(nums[index]);
        helper(res,index+1,nums,list);
        list.remove(list.size() - 1);
    }
}
