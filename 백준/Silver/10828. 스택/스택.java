import java.io.*;
import java.util.*;

public class Main {
    public static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static class Stack {
        private Node head;
        private int size;

        public Stack() {
            this.head = null;
            size = 0;
        }

        public void push(Node node) {
            if(this.head == null) {
                this.head = node;
            } else {
                node.next = head;
                head = node;
            }
            size++;
        }

        public Node pop() {
            if (this.head == null) {
                return null;
            } else {
                Node tempNode = head;
                head = head.next;
                size--;
                return tempNode;
            }
        }

        public int size() {
            return this.size;
        }

        public boolean isEmpty() {
            return this.head == null;
        }

        public Node top() {
            return head;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack homeMadeStack = new Stack();
        for (int i = 0; i < N; i++) {
            String[] command = br.readLine().split(" ");


            if (command[0].equals("push")) {
                int num = Integer.parseInt(command[1]);
                homeMadeStack.push(new Node(num));
            } else if (command[0].equals("pop")) {
                Node node = homeMadeStack.pop();

                if (node==null) {
                    System.out.println(-1);
                } else {
                    System.out.println(node.value);
                }
            } else if (command[0].equals("size")) {
                int length = homeMadeStack.size();
                System.out.println(length);
            } else if (command[0].equals("empty")) {
                boolean isEmpty = homeMadeStack.isEmpty();
                if (isEmpty) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (command[0].equals("top")) {
                Node node = homeMadeStack.top();
                if (node == null) {
                    System.out.println(-1);
                } else {
                    System.out.println(node.value);
                }
            }
        }



    }
}