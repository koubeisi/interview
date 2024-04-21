package com.koubeisi.interview.list;

import java.util.ArrayList;

/**
 * @author PC
 * @since 2024/4/19
 */
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    public static void println(ListNode node) {
        System.out.println(toString(node));
    }

    public static String toString(ListNode node){
        if (node == null) return "[]";
        var list = new ArrayList<Integer>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        return list.toString();
    }


    public static ListNode create(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        var head = new ListNode(arr[0]);
        var node = head;
        for (int i = 1; i < arr.length; i++) {
            node.next = new ListNode(arr[i]);
            node = node.next;
        }
        return head;
    }
}
