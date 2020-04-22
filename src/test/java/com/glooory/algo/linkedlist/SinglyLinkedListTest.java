package com.glooory.algo.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    @Test
    void insertFirst() {
        SinglyLinkedList list = new SinglyLinkedList();
        assertNull(list.head());
        list.insertFirst(new SinglyLinkedList.Node<String>("D"));
        assertNotNull(list.head());
        assertNull(list.head().getNext());
        assertEquals("D", list.head().getValue());
    }

    @Test
    void insertLast() {
        SinglyLinkedList list = new SinglyLinkedList();
        assertNull(list.head());
        list.insertLast(new SinglyLinkedList.Node<String>("D"));
        assertNotNull(list.head());
        assertNull(list.head().getNext());
        assertEquals("D", list.head().getValue());
    }

    @Test
    void insertBefore() {
        SinglyLinkedList list = new SinglyLinkedList();
        assertNull(list.head());
        SinglyLinkedList.Node<String> firstNode = new SinglyLinkedList.Node<String>("D");
        list.insertFirst(firstNode);
        assertNotNull(list.head());
        SinglyLinkedList.Node<String> secondNode = new SinglyLinkedList.Node<String>("F");
        assertTrue(list.insertBefore(firstNode, secondNode));
        assertEquals("F", list.head().getValue());
        SinglyLinkedList.Node<String> thirdNode = new SinglyLinkedList.Node<String>("G");
        assertTrue(list.insertBefore(secondNode, thirdNode));
        assertEquals(thirdNode, list.head());
        assertEquals(secondNode, list.head().getNext());
        assertEquals(firstNode, list.head().getNext().getNext());
    }

    @Test
    void insertAfter() {
        SinglyLinkedList list = new SinglyLinkedList();
        assertNull(list.head());
        SinglyLinkedList.Node<String> firstNode = new SinglyLinkedList.Node<String>("D");
        list.insertFirst(firstNode);
        assertNotNull(list.head());
        SinglyLinkedList.Node<String> secondNode = new SinglyLinkedList.Node<String>("F");
        assertTrue(list.insertAfter(firstNode, secondNode));
        SinglyLinkedList.Node<String> thirdNode = new SinglyLinkedList.Node<String>("G");
        assertTrue(list.insertAfter(secondNode, thirdNode));
        assertEquals(firstNode, list.head());
        assertEquals(secondNode, list.head().getNext());
        assertEquals(thirdNode, list.head().getNext().getNext());
    }

    @Test
    void contains() {
        SinglyLinkedList list = new SinglyLinkedList();
        assertNull(list.head());
        SinglyLinkedList.Node<String> firstNode = new SinglyLinkedList.Node<String>("D");
        list.insertFirst(firstNode);
        assertNotNull(list.head());
        SinglyLinkedList.Node<String> secondNode = new SinglyLinkedList.Node<String>("F");
        assertTrue(list.insertAfter(firstNode, secondNode));
        SinglyLinkedList.Node<String> thirdNode = new SinglyLinkedList.Node<String>("G");
        assertFalse(list.contains(thirdNode));
        assertTrue(list.insertAfter(secondNode, thirdNode));
        assertTrue(list.contains(firstNode));
        assertTrue(list.contains(secondNode));
        assertTrue(list.contains(thirdNode));
        assertFalse(list.contains(null));
    }

    @Test
    void removeFirst() {
        SinglyLinkedList list = new SinglyLinkedList();
        assertNull(list.head());
        SinglyLinkedList.Node<String> firstNode = new SinglyLinkedList.Node<String>("D");
        list.insertFirst(firstNode);
        assertNotNull(list.head());
        assertEquals(firstNode, list.removeFirst());
        assertNull(list.head());
        list.insertFirst(firstNode);
        SinglyLinkedList.Node<String> secondNode = new SinglyLinkedList.Node<String>("F");
        assertTrue(list.insertAfter(firstNode, secondNode));
        SinglyLinkedList.Node<String> thirdNode = new SinglyLinkedList.Node<String>("G");
        assertTrue(list.insertAfter(secondNode, thirdNode));
        assertEquals(firstNode, list.removeFirst());
        assertEquals(secondNode, list.head());
        assertEquals(thirdNode, list.head().getNext());
        assertFalse(list.contains(firstNode));
    }

    @Test
    void removeLast() {
        SinglyLinkedList list = new SinglyLinkedList();
        assertNull(list.head());
        SinglyLinkedList.Node<String> firstNode = new SinglyLinkedList.Node<String>("D");
        list.insertFirst(firstNode);
        assertNotNull(list.head());
        assertEquals(firstNode, list.removeLast());
        assertNull(list.head());
        list.insertFirst(firstNode);
        SinglyLinkedList.Node<String> secondNode = new SinglyLinkedList.Node<String>("F");
        assertTrue(list.insertAfter(firstNode, secondNode));
        SinglyLinkedList.Node<String> thirdNode = new SinglyLinkedList.Node<String>("G");
        assertTrue(list.insertAfter(secondNode, thirdNode));
        assertEquals(thirdNode, list.removeLast());
        assertEquals(firstNode, list.head());
        assertEquals(secondNode, list.head().getNext());
        assertFalse(list.contains(thirdNode));
    }

    @Test
    void remove() {
        SinglyLinkedList list = new SinglyLinkedList();
        assertNull(list.head());
        SinglyLinkedList.Node<String> firstNode = new SinglyLinkedList.Node<String>("D");
        list.insertFirst(firstNode);
        assertNotNull(list.head());
        assertEquals(firstNode, list.removeLast());
        assertNull(list.head());
        list.insertFirst(firstNode);
        SinglyLinkedList.Node<String> secondNode = new SinglyLinkedList.Node<String>("F");
        assertTrue(list.insertAfter(firstNode, secondNode));
        SinglyLinkedList.Node<String> thirdNode = new SinglyLinkedList.Node<String>("G");
        assertFalse(list.remove(thirdNode));
        assertTrue(list.insertAfter(secondNode, thirdNode));
        assertTrue(list.contains(thirdNode));
        assertTrue(list.remove(thirdNode));
        assertFalse(list.contains(thirdNode));
        assertNull(list.head().getNext().getNext());
        assertTrue(list.insertAfter(secondNode, thirdNode));
        assertTrue(list.remove(secondNode));
        assertEquals(thirdNode, list.head().getNext());
    }
}