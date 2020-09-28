package week02;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: test
 * @description:
 * @author: ChenWeiJun
 * @create: 2020-09-28 22:40
 **/
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i=0;i<nums.length;i++) {
            if (map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]),i};
            }
            map.put(target-nums[i],i);
        }
        return new int[2];
    }
}
