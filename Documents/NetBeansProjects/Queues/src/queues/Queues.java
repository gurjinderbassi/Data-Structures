/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queues;

import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Gurjinder
 */
public class Queues {

    /**
     * @param args the command line arguments
     */
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // TODO code application logic here
//        System.out.println("Reversing a part of queue:");
//        reverse();
//        System.out.println("Reversing a queue:");
//        reverseQueue();
        System.out.println("Number of page faults:");
        page_replacement();

    }

    static void reverseQueue() {
        int size, front, rear;
        front = rear = -1;
        System.out.println("Enter size of queue:");
        size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter no. of elements to insert:");
        int num = sc.nextInt();
        if (num > size) {
            System.out.println("Overflow");
        }
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }
        Stack<Integer> s = new Stack();
        for (int i = 0; i < arr.length; i++) {
            s.push(arr[i]);
        }
        int i = 0;
        while (!s.isEmpty()) {
            arr[i++] = s.pop();
        }
        for (int k : arr) {
            System.out.print(k + " ");
        }

    }

    static void reverse() {
        int size, front, rear;
        front = rear = -1;
        System.out.println("Enter size of queue:");
        size = sc.nextInt();
        Stack<Integer> s = new Stack();
        System.out.println("Enter number of elements to enqueue:");
        int num = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter elements:");
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
            front = 0;
            rear++;
        }
        System.out.println("No. of elements to reverse:");
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            s.push(arr[i]);
            front++;
        }
        while (!s.isEmpty()) {
            arr[++rear] = s.pop();

        }
        for (int i = 0; i < (num - k); i++) {
            s.push(arr[front++]);
        }
        while (!s.isEmpty()) {
            arr[++rear] = s.pop();
        }
        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void page_replacement() {

        int size, pf = 0;
        System.out.println("Enter memory size:");
        size = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter reference string:");
        String ref = sc.nextLine();
        String[] ref1 = ref.split(",");
        int[] exp = new int[ref1.length];
        for (int i = 0; i < exp.length; i++) {
            exp[i] = Integer.parseInt(ref1[i]);
        }
        int[] arr = new int[size];
        int front = -1;
        int rear = -1;

        for (int i = 0; i < exp.length; i++) {
            if (front == -1 && rear == -1) //queue is empty
            {
                front = (front + 1) % size;
                arr[front] = exp[i];
                pf++;
                rear = (rear + 1) % size;
            } else {
                int j = front;
                boolean found = false;
                while (j != rear) {
                    if (arr[j] == exp[i]) {
                        found = true;
                    }
                    j = (j + 1) % size;
                }
                if (found == false) {
                    pf++;
                    rear = (rear + 1) % size;
                    if (rear == front) {
                        arr[rear] = exp[i];
                        front = (front + 1) % size;
                    } else {
                        arr[rear] = exp[i];
                    }
                }
            }
        }
        System.out.println("Number of page faults = " + pf);
    }

}
