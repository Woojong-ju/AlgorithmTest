package com.example.algorithmtest.addtwo;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

//https://leetcode.com/problems/add-two-numbers
public class AddTwo {

    @Test
    void print() {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9);

        l2 = new ListNode(9, l2);
        l2 = new ListNode(9, l2);
        l2 = new ListNode(9, l2);
        l2 = new ListNode(9, l2);
        l2 = new ListNode(9, l2);
        l2 = new ListNode(9, l2);
        l2 = new ListNode(9, l2);
        l2 = new ListNode(9, l2);
        l2 = new ListNode(9, l2);
        l2 = new ListNode(9, l2);
        l2 = new ListNode(1, l2);
        addTwoNumbers(l1, l2);

    }

    ListNode addTwoNumbers (ListNode l1, ListNode l2) {
        BigInteger value = new BigInteger("0");
        BigInteger product = new BigInteger("1");

        while(true) {
            value = value.add(BigInteger.valueOf(l1.val).multiply(product));
            product = product.multiply(BigInteger.TEN);
            l1 = l1.next;
            if (l1 == null) break;
        }

        product = new BigInteger("1");
        while(true) {
            value = value.add(BigInteger.valueOf(l2.val).multiply(product));
            product = product.multiply(BigInteger.TEN);
            l2 = l2.next;
            if (l2 == null) break;
        }


        String valueString = String.valueOf(value);
        char[] valueArray = valueString.toCharArray();

        ListNode resultNode = null;
        for(int i = 0; i < valueArray.length; i++) {
            int val = Integer.valueOf(String.valueOf(valueArray[i]));
            System.out.println(valueArray[i]);
            ListNode newNode = new ListNode(val, resultNode);
            resultNode = newNode;
        }

        return resultNode;
    }



    class ListNode {
        int val;

        ListNode next;
        ListNode() {}

        ListNode (int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }
}
