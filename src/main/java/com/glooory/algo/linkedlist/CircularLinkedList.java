package com.glooory.algo.linkedlist;

public class CircularLinkedList {
    private Node head;

    public CircularLinkedList() {}

    public CircularLinkedList(Node node) {
        this.head = node;
        node.next = node;
    }

    public Node head() {
        return this.head;
    }

    public Node insertFirst(Node node) {
        if (node == null) {
            return null;
        }

        if (head == null) {
            this.head = node;
            head.next = node;
            return node;
        }

        Node last = last();
        last.next = node;
        node.next = head;
        head = node;

        return node;
    }

    public Node insertLast(Node node) {
        if (node == null) {
            return null;
        }

        if (head == null) {
            this.head = node;
            head.next = node;
            return node;
        }

        Node last = last();
        last.next = node;
        node.next = head;

        return node;
    }

    public boolean insertBefore(Node anchorNode, Node nodeToInsert) {
        if (anchorNode == null || nodeToInsert == null || head == null) {
            return false;
        }

        Node existPrevNode = findPrev(anchorNode);
        if (existPrevNode != null) {
            existPrevNode.next = nodeToInsert;
            nodeToInsert.next = anchorNode;
            return true;
        }

        return false;
    }

    public boolean insertAfter(Node anchorNode, Node nodeToInsert) {
        if (anchorNode == null || nodeToInsert == null) {
            return false;
        }

        Node existNode = find(anchorNode);
        if (existNode != null) {
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

        return find(node) != null;
    }

    public Node removeFirst() {
        if (head == null) {
            return null;
        }

        if (head.next == head) {
            Node first = head;
            head.next = null;
            head = null;
            return first;
        }

        Node first = head;
        Node last = last();
        last.next = head.next;
        head.next = null;
        head = last.next;

        return first;
    }

    public Node removeLast() {
        if (head == null) {
            return null;
        }

        if (head.next == head) {
            Node first = head;
            head.next = null;
            head = null;
            return first;
        }

        Node last = last();
        Node secondLast = findPrev(last);
        secondLast.next = head;
        last.next = null;

        return last;
    }

    public boolean remove(Node node) {
        if (head == null) {
            return false;
        }

        if (head.next == head) {
            if (head == node) {
                head.next = null;
                head = null;
                return true;
            }
            return false;
        }

        Node prev = findPrev(node);
        if (prev != null) {
            prev.next = node.next;
            node.next = null;
            return true;
        }

        return false;
    }

    private Node last() {
        if (head == null) {
            return null;
        }

        Node curr = head;
        while (curr.next != head) {
            curr = curr.next;
        }
        return curr;
    }

    public Node find(Node node) {
        if (head == null || node == null) {
            return null;
        }

        if (head == node) {
            return head;
        }

        Node curr = head.next;
        while (curr != head) {
            if (curr == node) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }

    public Node findPrev(Node node) {
        if (head == null || node == null) {
            return null;
        }

        if (head.next == head) {
            if (head == node) {
                return head;
            }
            return null;
        }

        Node curr = head;
        while (curr.next != head) {
            if (curr.next == node) {
                return curr;
            }
            curr = curr.next;
        }
        if (curr.next == node) {
            return curr;
        }

        return null;
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
