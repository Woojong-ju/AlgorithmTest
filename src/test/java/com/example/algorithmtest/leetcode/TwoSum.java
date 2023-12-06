package com.example.algorithmtest.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/submissions/
// worst case!ㅋㅋ hashmap
public class TwoSum {

    @Test
    void main() {
        int[] nums = {3,2,4};
        int target = 6;
        int[] result = twoSum(nums, target);
        System.out.println(result[0] + "," + result[1]);

    }

    /**
     * 내 풀이. bruteforce지만 해석도어려움,,
     * @param nums
     * @param target
     * @return
     */
    int[] twoSum(int[] nums, int target) {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        int[] resultArray = new int[2];
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if(index < i) {
                int result = nums[index] + nums[i];
                if(result == target) {
                    resultArray[0] = index;
                    resultArray[1] = i;
                    break;
                } else if (i == nums.length - 1) {
                    index++;
                    i = index;
                }
            }
        }
        return resultArray;
    }

    /**
     * hashtable을 이용한 방법(two pass)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        // hash테이블 생성
        for (int i = 0; i < n; i++) {
            numMap.put(nums[i], i);
        }

        // map에서 남은 차에 해당하는 값이 존재하면 해당 차에 해당하는 key의 value(즉 index)를 i와 리턴
        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement) && numMap.get(complement) != i) {
                return new int[]{i, numMap.get(complement)};
            }
        }

        return new int[]{};
    }

        /**
         * hashtable을 이용한 방법
         * @param nums
         * @param target
         * @return
         */
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        //  num[i], i의 hashmap을 생성해가면서 동시에 hashmap key에 현재 target - num[i]값의 key를 확인
        // 앞선값을 key에 추가하기에 n번의 복사과정조차 사라짐.
        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }

        return new int[]{}; // No solution found
    }

}
