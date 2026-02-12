package HackerRankLeetCodeQuestions;

import java.util.HashMap;

public class LeetCode46LRUcacheUsingDLLAndHashMap {

    int capacity;

    public LeetCode46LRUcacheUsingDLLAndHashMap(int capacity){

        this.capacity = capacity;
    }

    static class Node{

        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    Node head = null;
    Node tail = null;

    HashMap<Integer, Node> map = new HashMap<>();

    private void addAtHead(Node node){

        if(head == null){//at starting both head and tail will be null
            head = node;
            tail = node;
        }else{

            node.next = head;
            head.prev = node;
            head = node;

        }
    }

    private void remove(Node node){

        if(node.prev != null){
            node.prev.next = node.next;
        }else{//at head
            node = node.next;
        }
        
        if(node.next!=null){
            node.next.prev = node.prev;
        }else{//at tail
            tail = node.prev;
            node.prev = null; 

        }
        
    }

    private void put(int key, int value){

        if(map.containsKey(key)){

            Node node = map.get(key);

            remove(node);
            node.value = value;
            addAtHead(node);

            return;
        }


        Node node = new Node(key, value);

        if(map.size() >= capacity){

            map.remove(tail.key);
            remove(tail);

            map.put(key, node);
            addAtHead(node);
        }else{

            map.put(key, node);
            addAtHead(node);
        }
    }
    
    private int get(int key){
        
        if(!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);
        remove(node);
        addAtHead(node);

        return node.value;
    }

    public static void main(String[] args){

        LeetCode46LRUcacheUsingDLLAndHashMap lRUCache = new LeetCode46LRUcacheUsingDLLAndHashMap(2);


        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}

        int value = lRUCache.get(1);    // returns 1
        System.out.println("returned: "+value);
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2
                    // cache is {1=1, 3=3}

        value = lRUCache.get(2);    // returns -1 (not found)
        System.out.println("returned: "+value);
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1
                    // cache is {4=4, 3=3}

        value = lRUCache.get(1);    // returns -1 (not found)
        System.out.println("returned: "+value);
        value = lRUCache.get(3);    // returns 3
        System.out.println("returned: "+value);
        value = lRUCache.get(4);    // returns 4
        System.out.println("returned: "+value);
       
    }

    
}
