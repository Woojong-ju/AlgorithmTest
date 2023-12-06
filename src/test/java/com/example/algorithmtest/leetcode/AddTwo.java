package com.example.algorithmtest.leetcode;

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
    public ListNode addTwoNumbersSol(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum / 10;
            ListNode newNode = new ListNode(digit);
            tail.next = newNode;
            tail = tail.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        ListNode result = dummyHead.next;
        dummyHead.next = null;
        return result;
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
