package com.example.algorithmtest.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class LongestString {

    @Test
    public void test(){
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));

    }

    public int lengthOfLongestSubstring(String s) {
        String[] strArr = s.split("");
        String subStr = "";
        if("".equals(s)) {
            return 0;
        }
        int length = 0;
        for(int i = 0; i < strArr.length; i++) {
            if(subStr.contains(strArr[i])) {
                subStr = subStr.substring(subStr.indexOf(strArr[i]) + 1) + strArr[i];
            } else {
                subStr += strArr[i];
            }
            if(subStr.length() > length) {
                length = subStr.length();
            }
        }
        return length;
    }
}
