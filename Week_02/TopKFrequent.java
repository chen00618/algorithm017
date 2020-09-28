package week02;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @program: test
 * @description:
 * @author: ChenWeiJun
 * @create: 2020-09-28 22:47
 **/
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> countMap = new HashMap<>();
        for (int i=0;i<nums.length;i++)
            countMap.put(nums[i],countMap.getOrDefault(nums[i],0)+1);

        PriorityQueue<HeapNode> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.value - o2.value);
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (priorityQueue.size() == k) {
                if (entry.getValue() > priorityQueue.peek().value) {
                    priorityQueue.poll();
                    priorityQueue.add(new HeapNode(entry.getKey(),entry.getValue()));
                }
            }else {
                priorityQueue.add(new HeapNode(entry.getKey(),entry.getValue()));
            }
        }
        return priorityQueue.stream().mapToInt(i->i.key).toArray();
    }
    class HeapNode {
        int key;
        int value;
        public HeapNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
