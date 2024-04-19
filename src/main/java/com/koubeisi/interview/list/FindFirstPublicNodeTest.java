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
public class FindFirstPublicNodeTest {


    public static ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;

        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        while (p1 != p2) {
            p1 = p1.next == null ? pHead2 : p1.next;
            p2 = p2.next == null ? pHead1 : p2.next;

            if (p1.next == null && p2.next == null && p1 != p2) {
                p1 = null;
                break;
            }
        }

        return p1;
    }


    @ParameterizedTest
    @MethodSource("provideNodes")
    void testAddOne(ListNode pHead1, ListNode pHead2, Integer expected) {
        long startTime = System.nanoTime(); // 记录开始时间
        ListNode.println(pHead1);
        ListNode.println(pHead2);

        var result = findFirstCommonNode(pHead1, pHead2);

        long duration = System.nanoTime() - startTime; // 计算运行时间

        // 输出结果和运行时间
        System.out.println("Test finished in " + duration / 1_000_000.0 + " milliseconds.");


        if (result != null) {
            Assertions.assertEquals(expected, result.val);
        } else {
            Assertions.assertNull(expected);
        }
    }


    static Stream<Arguments> provideNodes() {

        var node1 = new ListNode(1);
        var node2 = new ListNode(2);
        var node3 = new ListNode(3);
        var node4 = new ListNode(4);
        var node5 = new ListNode(5);
        var node6 = new ListNode(6);
        var node7 = new ListNode(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node6;
        node6.next = node7;

        node4.next = node5;
        node5.next = node6;


        var node11 = new ListNode(11);
        var node12 = new ListNode(12);
        var node13 = new ListNode(13);
        var node14 = new ListNode(14);
        var node15 = new ListNode(15);
        var node16 = new ListNode(16);

        node11.next = node12;
        node12.next = node13;
        node14.next = node15;
        node15.next = node16;


        var node21 = new ListNode(21);
        var node22 = new ListNode(22);
        var node23 = new ListNode(23);
        var node24 = new ListNode(24);
        var node25 = new ListNode(25);
        node21.next = node22;
        node22.next = node23;
        node24.next = node25;
        node25.next = node23;
        return Stream.of(
                Arguments.of(node1, node4, 6),
                Arguments.of(node2, node4, 6),
                Arguments.of(node11, node14, null),
                Arguments.of(node21, node24, 23),
                Arguments.of(null, null, null),
                Arguments.of(null, node21, null)
        );

    }
}
