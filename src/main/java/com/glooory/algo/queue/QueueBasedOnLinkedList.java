package com.glooory.algo.queue;

public class QueueBasedOnLinkedList {
    private Node head;

    public QueueBasedOnLinkedList() {}

    public boolean add(int element) {
        Node newNode = new Node(element);
        if (head == null) {
            head = newNode;
            return true;
        }

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        return true;
    }

    public int poll() {
        if (head == null) {
            return Integer.MIN_VALUE;
        }
        Node top = head;
        head = head.next;
        top.next = null;
        return top.value;
    }

    public void clear() {
        do {
            poll();
        } while (head != null);
    }

    public static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
