package com.koubeisi.interview.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author KouBeisi
 * @since 2024/4/21
 */
public class FindLTthToTailTest {



    public static ListNode findKthToTail (ListNode pHead, int k) {
        // write code here
        ListNode head = pHead;
        ListNode tail = pHead;
        while (k > 0) {
            if (tail == null) {
                return null;
            }
            tail = tail.next;
            k--;
        }

        while (tail != null) {
            head = head.next;
            tail = tail.next;
        }
        return head;
    }


    @ParameterizedTest
    @MethodSource("provideNodes")
    void test(ListNode head, int k, int expected) {
        head = findKthToTail(head, k);
        if (head == null){
            Assertions.assertEquals(expected, 0);
        } else {
            Assertions.assertEquals(expected, head.val);
        }
    }

    static Stream<Arguments> provideNodes() {

        var node1 = ListNode.create(new int[]{1, 2});
        var node2 = ListNode.create(new int[]{1, 2, 3, 4, 5});
        var node3 = ListNode.create(new int[]{1, 2, 3, 4, 5});
        var node4 = ListNode.create(new int[]{1, 2, 3, 4, 5});


        return Stream.of(
                Arguments.of(node1, 3, 0),
                Arguments.of(node2, 1, 5),
                Arguments.of(node3, 5, 1),
                Arguments.of(null, 0, 0),
                Arguments.of(node4, 5, 1)
        );
    }

}
