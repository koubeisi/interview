package com.koubeisi.interview.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * 删除有序链表中的重复节点
 *
 * @author KouBeisi
 * @since 2024/4/25
 */
public class DeleteDuplicationTest {

    public ListNode deleteDuplication(ListNode pHead) {
        ListNode dummy = new ListNode(0);
        dummy.next = pHead;

        ListNode pre = dummy;
        while (pHead != null) {
            while (pHead.next != null && pHead.val == pHead.next.val) {
                pHead = pHead.next;
            }
            if (pre.next != pHead) {
                pre.next = pHead.next;
            } else {
                pre = pre.next;
            }
            pHead = pHead.next;
        }
        return dummy.next;
    }


    @ParameterizedTest
    @MethodSource("provideNodes")
    void test(ListNode head, String expected) {
        head = deleteDuplication(head);
        Assertions.assertEquals(expected, ListNode.toString(head));
    }

    static Stream<Arguments> provideNodes() {

        var node1 = ListNode.create(new int[]{1, 2, 2, 4, 5});
        var node2 = ListNode.create(new int[]{1, 1, 3, 4, 5});
        var node3 = ListNode.create(new int[]{1, 2, 3, 4, 4});
        var node4 = ListNode.create(new int[]{1, 1, 1, 1, 1});


        return Stream.of(
                Arguments.of(node1, "[1, 4, 5]"),
                Arguments.of(node2, "[3, 4, 5]"),
                Arguments.of(node3, "[1, 2, 3]"),
                Arguments.of(node4, "[]"),
                Arguments.of(null, "[]")
        );
    }
}
