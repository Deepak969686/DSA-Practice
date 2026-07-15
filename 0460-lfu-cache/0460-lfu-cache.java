import java.util.*;

class Node {
    int key, value, freq;
    Node prev, next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.freq = 1;
    }
}

class DoublyLinkedList {

    Node head, tail;
    int size;

    DoublyLinkedList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    void insertAtFront(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;

        size++;
    }

    void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    Node removeLast() {
        if (size == 0)
            return null;

        Node node = tail.prev;
        remove(node);
        return node;
    }
}

class LFUCache {

    int capacity;
    int minFreq;

    HashMap<Integer, Node> keyMap;
    HashMap<Integer, DoublyLinkedList> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;

        keyMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {

        if (!keyMap.containsKey(key))
            return -1;

        Node node = keyMap.get(key);

        update(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (capacity == 0)
            return;

        if (keyMap.containsKey(key)) {

            Node node = keyMap.get(key);
            node.value = value;

            update(node);
            return;
        }

        if (keyMap.size() == capacity) {

            DoublyLinkedList list = freqMap.get(minFreq);

            Node remove = list.removeLast();

            keyMap.remove(remove.key);
        }

        Node node = new Node(key, value);

        minFreq = 1;

        freqMap.putIfAbsent(1, new DoublyLinkedList());

        freqMap.get(1).insertAtFront(node);

        keyMap.put(key, node);
    }

    private void update(Node node) {

        int oldFreq = node.freq;

        DoublyLinkedList oldList = freqMap.get(oldFreq);

        oldList.remove(node);

        if (oldFreq == minFreq && oldList.size == 0)
            minFreq++;

        node.freq++;

        freqMap.putIfAbsent(node.freq, new DoublyLinkedList());

        freqMap.get(node.freq).insertAtFront(node);
    }
}
/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */