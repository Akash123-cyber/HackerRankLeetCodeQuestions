package HackerRankLeetCodeQuestions;

import java.util.ArrayDeque;
import java.util.Queue;


public class LeetCode225ImplementStackUsingQueues {

    static void push(Queue<Integer> queue, int d){

        queue.offer(d);
    }

    static int pop(Queue<Integer> queue){
        //we just need to reverse our list to n - 1 elements in this way
        //our last element will automatically become the first element in the queue

        int  n = queue.size();
        for(int i = 0; i < n - 1; i++){
            queue.offer(queue.poll());
        }

        return queue.poll();
    }

    static int top(Queue<Integer> queue) {
        int n = queue.size();

        for(int i = 0; i < n -1; i++){
            queue.offer(queue.poll());
        }
        
        int element = queue.poll();
        queue.offer(element);

        return element;
    }

    // static void printStack(queue<Integer> queue)

    public static void main(String[] args){
        //implement stack using simple queue;


        Queue<Integer> queue = new ArrayDeque<>();

        push(queue, 10);
        push(queue, 20);
        push(queue, 30);
        push(queue, 40);
        push(queue, 50);
        
        System.out.println(pop(queue));// 50
        System.out.println(pop(queue));// 40
        
        push(queue, 60);//
        
        System.out.println(pop(queue));// 60
        
    }
    
}

    