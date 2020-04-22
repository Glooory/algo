package com.glooory.algo.linkedlist;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {
    DoublyLinkedList list;
    DoublyLinkedList.Node<String> firstNode;
    DoublyLinkedList.Node<String> secondNode;
    DoublyLinkedList.Node<String> thirdNode;

    @BeforeEach
    void setup() {
        list = new DoublyLinkedList();
        firstNode = new DoublyLinkedList.Node<String>("D");
        secondNode = new DoublyLinkedList.Node<String>("F");
        thirdNode = new DoublyLinkedList.Node<String>("G");
    }

    @AfterEach
    void cleanup() {
        list = null;
        firstNode = null;
        secondNode = null;
        thirdNode = null;
    }

    @Test
    void insertFirst() {
        assertNull(list.head());
        assertEquals(firstNode, list.insertFirst(firstNode));
        assertEquals(firstNode, list.head());
        assertEquals(secondNode, list.insertFirst(secondNode));
        assertEquals(secondNode, list.head());
        assertEquals(firstNode, list.head().getNext());
    }

    @Test
    void insertLast() {
        assertNull(list.head());
        assertEquals(firstNode, list.insertLast(firstNode));
        assertEquals(firstNode, list.head());
        assertEquals(secondNode, list.insertLast(secondNode));
        assertEquals(secondNode, list.head().getNext());
        assertEquals(firstNode, list.head());
    }

    @Test
    void insertBefore() {
        assertNull(list.head());
        assertEquals(firstNode, list.insertLast(firstNode));
        assertEquals(firstNode, list.head());
        assertTrue(list.insertBefore(firstNode, secondNode));
        assertEquals(secondNode, list.head());
        assertTrue(list.insertBefore(firstNode, thirdNode));
        assertEquals(thirdNode, list.head().getNext());
    }

    @Test
    void insertAfter() {
        assertNull(list.head());
        assertEquals(firstNode, list.insertLast(firstNode));
        assertEquals(firstNode, list.head());
        assertTrue(list.insertAfter(firstNode, secondNode));
        assertEquals(firstNode, list.head());
        assertEquals(secondNode, list.head().getNext());
        assertTrue(list.insertAfter(firstNode, thirdNode));
        assertEquals(secondNode, list.head().getNext().getNext());
        assertEquals(thirdNode, list.head().getNext());
    }

    @Test
    void contains() {
        assertFalse(list.contains(firstNode));
        assertEquals(firstNode, list.insertFirst(firstNode));
        assertTrue(list.contains(firstNode));
    }

    @Test
    void removeFirst() {
        assertNull(list.head());
        assertNull(list.removeFirst());
        assertEquals(firstNode, list.insertLast(firstNode));
        assertEquals(firstNode, list.removeFirst());
        assertNull(list.head());
        assertEquals(firstNode, list.insertLast(firstNode));
        assertEquals(secondNode, list.insertLast(secondNode));
        assertEquals(thirdNode, list.insertLast(thirdNode));
        assertEquals(thirdNode, list.head().getNext().getNext());
        assertEquals(firstNode, list.removeFirst());
        assertEquals(secondNode, list.removeFirst());
        assertEquals(thirdNode, list.removeFirst());
        assertNull(list.head());
    }

    @Test
    void removeLast() {
        assertNull(list.head());
        assertNull(list.removeFirst());
        assertEquals(firstNode, list.insertLast(firstNode));
        assertEquals(firstNode, list.removeLast());
        assertNull(list.head());
        assertEquals(firstNode, list.insertLast(firstNode));
        assertEquals(secondNode, list.insertLast(secondNode));
        assertEquals(thirdNode, list.insertLast(thirdNode));
        assertEquals(thirdNode, list.head().getNext().getNext());
        assertEquals(thirdNode, list.removeLast());
        assertEquals(secondNode, list.removeLast());
        assertEquals(firstNode, list.removeLast());
        assertNull(list.head());
    }

    @Test
    void remove() {
        assertNull(list.head());
        assertNull(list.removeFirst());
        assertEquals(firstNode, list.insertLast(firstNode));
        assertTrue(list.remove(firstNode));
        assertNull(list.head());
        assertEquals(firstNode, list.insertLast(firstNode));
        assertEquals(secondNode, list.insertLast(secondNode));
        assertEquals(thirdNode, list.insertLast(thirdNode));
        assertEquals(thirdNode, list.head().getNext().getNext());
        assertTrue(list.remove(thirdNode));
        assertEquals(secondNode, list.head().getNext());
        assertNull(list.head().getNext().getNext());
        assertTrue(list.remove(secondNode));
        assertTrue(list.remove(firstNode));
        assertNull(list.head());
    }
}