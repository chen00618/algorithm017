import java.util.HashMap;
import java.util.Map;

/**
 * @program: test
 * @description: 第一周作业
 * @author: ChenWeiJun
 * @create: 2020-09-27 20:34
 **/
public class Week01 {

    public int removeDuplicates(int[] nums) {
        /**
         * @Description: 删除排序数组中的重复项
         * @Param: [nums]
         * @return: int
         * @Author: ChenWeiJun
         * @Date: 2020/9/27
        */ 
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int pos = 1;
        for (int i=1;i<nums.length;i++) {
            if (nums[i] != nums[i-1])
                nums[pos++] = nums[i];
        }
        return pos;
    }

    public void rotate(int[] nums, int k) {
        /**
         * @Description: 旋转数组
         * @Param: [nums, k]
         * @return: void
         * @Author: ChenWeiJun
         * @Date: 2020/9/27
        */ 
        k %= nums.length;
        reverArrays(nums,0,nums.length - 1);
        reverArrays(nums,0,k - 1);
        reverArrays(nums,k,nums.length - 1);
    }
    private void reverArrays(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /**
         * @Description: 合并两个有序链表
         * @Param: [l1, l2]
         * @return: Week01.ListNode
         * @Author: ChenWeiJun
         * @Date: 2020/9/27
        */
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /**
         * @Description: 合并两个有序数组
         * @Param: [nums1, m, nums2, n]
         * @return: void
         * @Author: ChenWeiJun
         * @Date: 2020/9/27
        */
        int p = nums1.length - 1,p1 = m-1,p2 = n-1;
        while (p1 >=0 && p2 >= 0) {
            nums1[p--] = (nums1[p1] > nums2[p2]) ? nums1[p1--] : nums2[p2--];
        }
        while (p2 >= 0){
            nums1[p--] = nums2[p2--];
        }
    }

    public int[] twoSum(int[] nums, int target) {
        /**
         * @Description: 两数之和
         * @Param: [nums, target]
         * @return: int[]
         * @Author: ChenWeiJun
         * @Date: 2020/9/27
        */
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            if (map.get(nums[i]) != null) {
                return new int[]{i,map.get(nums[i])};
            }
            map.put(target - nums[i],i);
        }
        return new int[]{-1,-1};
    }

    public int[] plusOne(int[] digits) {
        /**
         * @Description: 加一
         * @Param: [digits]
         * @return: int[]
         * @Author: ChenWeiJun
         * @Date: 2020/9/27
        */ 
        int i = digits.length - 1;
        int sign = 10;
        while (i >=0 && sign == 10) {
            sign = digits[i] + 1;
            digits[i] = (digits[i] + 1) % 10;
            i--;
        }
        if (sign == 10) {
            int[] newArray = new int[digits.length + 1];
            newArray[0] = 1;
            digits = newArray;
        }
        return digits;
    }

    public int trap(int[] height) {
        /**
         * @Description: 接雨水
         * @Param: [height]
         * @return: int
         * @Author: ChenWeiJun
         * @Date: 2020/9/27
        */ 
        if (height == null || height.length <= 2) return 0;
        int[] rightMax = new int[height.length];

        rightMax[height.length - 1] = height[height.length - 1];//初始化最右边的值
        for (int i=height.length - 2;i>=0;i--) {
            rightMax[i] = Math.max(height[i],rightMax[i+1]);
        }

        int leftMax = 0;
        int res = 0;
        for (int i=0;i<height.length;i++) {
            leftMax = Math.max(leftMax,height[i]);
            int minH = Math.min(leftMax,rightMax[i]);
            res += minH <= height[i] ? 0 : minH - height[i];
        }
        return res;
    }


    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
