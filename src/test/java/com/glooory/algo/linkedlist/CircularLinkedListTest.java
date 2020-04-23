package com.glooory.algo.linkedlist;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircularLinkedListTest {
    CircularLinkedList list;
    CircularLinkedList.Node<String> firstNode;
    CircularLinkedList.Node<String> secondNode;
    CircularLinkedList.Node<String> thirdNode;
    CircularLinkedList.Node<String> fourthNode;

    @BeforeEach
    void setup() {
        list = new CircularLinkedList();
        firstNode = new CircularLinkedList.Node<String>("D");
        secondNode = new CircularLinkedList.Node<String>("F");
        thirdNode = new CircularLinkedList.Node<String>("G");
        fourthNode = new CircularLinkedList.Node<String>("H");
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
        assertNull(list.insertFirst(null));
        assertEquals(firstNode, list.insertFirst(firstNode));
        assertEquals(firstNode, list.head());
        assertEquals(firstNode, list.head().getNext());
        assertEquals(secondNode, list.insertFirst(secondNode));
        assertEquals(secondNode, list.head());
        assertEquals(firstNode, list.head().getNext());
        assertEquals(firstNode, secondNode.getNext());
    }

    @Test
    void insertLast() {
        assertNull(list.head());
        assertEquals(firstNode, list.insertLast(firstNode));
        assertEquals(firstNode, list.head());
        assertEquals(firstNode, list.head().getNext());
        assertEquals(secondNode, list.insertLast(secondNode));
        assertEquals(firstNode, list.head());
        assertEquals(secondNode, list.head().getNext());
        assertEquals(secondNode, firstNode.getNext());
    }

    @Test
    void insertBefore() {
        assertNull(list.head());
        assertEquals(firstNode, list.insertLast(firstNode));
        assertEquals(firstNode, list.head());
        assertEquals(firstNode, list.head().getNext());
        assertFalse(list.insertBefore(thirdNode, secondNode));
        assertTrue(list.insertBefore(firstNode, secondNode));
        assertEquals(firstNode, list.head());
        assertEquals(secondNode, list.head().getNext());
        assertEquals(firstNode, list.head().getNext().getNext());
        assertEquals(firstNode, secondNode.getNext());
        assertEquals(secondNode, firstNode.getNext());
        assertTrue(list.insertBefore(firstNode, thirdNode));
        assertEquals(firstNode, list.head());
        assertNotEquals(thirdNode, list.head());
        assertEquals(firstNode, thirdNode.getNext());
        assertEquals(thirdNode, secondNode.getNext());
        assertTrue(list.insertBefore(thirdNode, fourthNode));
        assertEquals(thirdNode, fourthNode.getNext());
        assertEquals(fourthNode, secondNode.getNext());
    }

    @Test
    void insertAfter() {
        assertNull(list.head());
        assertEquals(firstNode, list.insertLast(firstNode));
        assertEquals(firstNode, list.head());
        assertEquals(firstNode, list.head().getNext());
        assertFalse(list.insertAfter(thirdNode, secondNode));
        assertTrue(list.insertAfter(firstNode, secondNode));
        assertEquals(firstNode, list.head());
        assertEquals(secondNode, list.head().getNext());
        assertEquals(firstNode, list.head().getNext().getNext());
        assertEquals(firstNode, secondNode.getNext());
        assertEquals(secondNode, firstNode.getNext());
        assertTrue(list.insertAfter(firstNode, thirdNode));
        assertEquals(firstNode, list.head());
        assertNotEquals(thirdNode, list.head());
        assertEquals(secondNode, thirdNode.getNext());
        assertEquals(firstNode, secondNode.getNext());
        assertTrue(list.insertAfter(thirdNode, fourthNode));
        assertEquals(fourthNode, thirdNode.getNext());
        assertEquals(secondNode, fourthNode.getNext());
    }

    @Test
    void contains() {
        assertNull(list.head());
        assertFalse(list.contains(firstNode));
        assertEquals(firstNode, list.insertLast(firstNode));
        assertEquals(firstNode, list.head());
        assertEquals(firstNode, list.head().getNext());
        assertTrue(list.contains(firstNode));
    }

    @Test
    void removeFirst() {
        assertNull(list.head());
        assertEquals(firstNode, list.insertLast(firstNode));
        assertEquals(firstNode, list.head());
        assertEquals(firstNode, list.head().getNext());
        assertEquals(firstNode, list.removeFirst());
        assertNull(list.head());
        assertEquals(firstNode, list.insertLast(firstNode));
        assertEquals(secondNode, list.insertLast(secondNode));
        assertEquals(firstNode, list.removeFirst());
        assertEquals(secondNode, list.head());
        assertEquals(secondNode, list.head().getNext());
        assertEquals(secondNode, secondNode.getNext());
        assertFalse(list.contains(firstNode));
    }

    @Test
    void removeLast() {
        assertNull(list.head());
        assertEquals(firstNode, list.insertLast(firstNode));
        assertEquals(firstNode, list.head());
        assertEquals(firstNode, list.head().getNext());
        assertEquals(firstNode, list.removeLast());
        assertNull(list.head());
        assertEquals(firstNode, list.insertLast(firstNode));
        assertEquals(secondNode, list.insertLast(secondNode));
        assertEquals(secondNode, list.removeLast());
        assertEquals(firstNode, list.head());
        assertEquals(firstNode, list.head().getNext());
        assertEquals(firstNode, firstNode.getNext());
        assertFalse(list.contains(secondNode));
    }

    @Test
    void remove() {
        assertNull(list.head());
        assertEquals(firstNode, list.insertLast(firstNode));
        assertEquals(firstNode, list.head());
        assertEquals(firstNode, list.head().getNext());
        assertTrue(list.remove(firstNode));
        assertFalse(list.contains(firstNode));
        assertNull(list.head());
        assertEquals(firstNode, list.insertLast(firstNode));
        assertEquals(secondNode, list.insertLast(secondNode));
        assertEquals(thirdNode, list.insertLast(thirdNode));
        assertTrue(list.remove(secondNode));
        assertFalse(list.contains(secondNode));
        assertEquals(firstNode, thirdNode.getNext());
        assertEquals(thirdNode, firstNode.getNext());
    }

    @Test
    void find() {
        assertNull(list.head());
        assertEquals(firstNode, list.insertLast(firstNode));
        assertEquals(firstNode, list.find(firstNode));
        assertNull(list.find(thirdNode));
        assertEquals(secondNode, list.insertLast(secondNode));
        assertEquals(secondNode, list.find(secondNode));
        assertEquals(thirdNode, list.insertLast(thirdNode));
        assertEquals(thirdNode, list.find(thirdNode));
        assertEquals(secondNode, list.find(secondNode));
        assertEquals(firstNode, list.find(firstNode));
    }

    @Test
    void findPrev() {
        assertNull(list.head());
        assertEquals(firstNode, list.insertLast(firstNode));
        assertEquals(firstNode, list.findPrev(firstNode));
        assertEquals(secondNode, list.insertLast(secondNode));
        assertEquals(firstNode, list.findPrev(secondNode));
        assertEquals(thirdNode, list.insertLast(thirdNode));
        assertEquals(secondNode, list.findPrev(thirdNode));
        assertEquals(firstNode, list.findPrev(secondNode));
        assertEquals(thirdNode, list.findPrev(firstNode));
    }
}