package com.koubeisi.interview.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author PC
 * @since 2024/4/19
 */
public class DeleteNodeTest {


    public static ListNode deleteNode(ListNode head, int val) {
        // write code here
        if (head == null) {
            return null;
        } else if (head.val == val) {
            return head.next;
        }

        ListNode pre = head;
        ListNode node = pre.next;

        while (node != null) {
            if (node.val == val) {
                pre.next = node.next;
                break;
            } else {
                pre = node;
                node = node.next;
            }
        }
        return head;
    }


    @ParameterizedTest
    @MethodSource("provideNodes")
    void testDeleteNode(ListNode head, int val, String expected) {
        deleteNode(head, val);
        Assertions.assertEquals(expected, ListNode.toString(head));
    }

    static Stream<Arguments> provideNodes() {

        var node1 = new ListNode(1);
        var node2 = new ListNode(2);
        var node3 = new ListNode(3);
        var node4 = new ListNode(4);
        var node5 = new ListNode(5);


        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;


        return Stream.of(
                Arguments.of(node1, 3, "[1, 2, 4, 5]"),
                Arguments.of(node1, 1, "[2, 3, 4, 5]"),
                Arguments.of(node1, 5, "[1, 2, 3, 4]"),
                Arguments.of(null, 1, "[]"),
                Arguments.of(node1, 8, "[1, 2, 3, 4, 5]")
        );
    }

}
