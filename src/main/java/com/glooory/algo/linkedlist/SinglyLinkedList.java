package com.glooory.algo.linkedlist;

public class SinglyLinkedList {
    private Node head;

    public SinglyLinkedList() {}

    public SinglyLinkedList(Node head) {
        this.head = head;
    }

    public Node head() {
        return this.head;
    }

    public Node insertFirst(Node node) {
        if (head == null) {
            head = node;
            return node;
        }

        node.next = head;
        head = node;
        return node;
    }

    public Node insertLast(Node node) {
        if (head == null) {
            head = node;
            return node;
        }

        Node prev = head;
        while (prev.next != null) {
            prev = prev.next;
        }
        prev.next = node;
        return node;
    }

    public boolean insertBefore(Node anchorNode, Node nodeToInsert) {
        if (anchorNode == null || nodeToInsert == null || head == null) {
            return false;
        }

        if (anchorNode == head) {
            nodeToInsert.next = head;
            head = nodeToInsert;
            return true;
        }

        Node prev = null;
        Node curr = head;
        while (curr.next != null) {
            if (curr.next == anchorNode) {
                prev = curr;
                break;
            }
            curr = curr.next;
        }
        if (prev == null) {
            return false;
        }

        nodeToInsert.next = anchorNode;
        prev.next = nodeToInsert;
        return true;
    }

    public boolean insertAfter(Node anchorNode, Node nodeToInsert) {
        if (anchorNode == null || nodeToInsert == null || head == null) {
            return false;
        }

        if (anchorNode == head) {
            head.next = nodeToInsert;
            return true;
        }

        boolean hasAnchorNode = false;
        Node curr = head;
        while (head.next != null) {
            if (curr.next == anchorNode) {
                hasAnchorNode = true;
                break;
            }
            curr = curr.next;
        }

        if (hasAnchorNode) {
            nodeToInsert.next = anchorNode.next;
            anchorNode.next = nodeToInsert;
            return true;
        }
        return false;
    }

    public boolean contains(Node node) {
        if (node == null || head == null) {
            return false;
        }

        Node curr = head;
        while (curr != null) {
            if (curr == node) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public Node removeFirst() {
        if (head == null) {
            return null;
        }

        Node first = head;
        head = head.next;
        return first;
    }

    public Node removeLast() {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            Node last  = head;
            head = null;
            return last;
        }

        Node curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }

        Node last = curr.next;
        curr.next = null;
        return last;
    }

    public boolean remove(Node node) {
        if (node == null || head == null) {
            return false;
        }

        Node prev = null;
        Node curr = head;
        while (curr.next != null) {
            if (curr.next == node) {
                prev = curr;
                break;
            }
            curr = curr.next;
        }

        if (prev != null) {
            prev.next = prev.next.next;
            return true;
        }
        return false;
    }

    public static class Node<T> {
        private T data;
        private Node next;

        public Node(T t) {
            this.data = t;
        }

        public T getValue() {
            return this.data;
        }

        public void setNext(Node node) {
            this.next = node;
        }

        public Node getNext() {
            return this.next;
        }
    }
}
