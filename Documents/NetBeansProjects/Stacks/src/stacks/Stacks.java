/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stacks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Gurjinder
 */
public class Stacks {

    /**
     * @param args the command line arguments
     */
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        // TODO code application logic here
        Queue<Integer> q = new LinkedList<>();
        int[] stack = new int[10];
        int n,size;
        
        size = 5;
        int choice = 0,top = -1;
        for(int k=0;k<size;k++){
            stack[k] = 0;
        }
        System.out.println("Infix to postfix:");
        infix_to_postfix();
        System.out.println("Postfix evaluation");
        postfix_evaluation();
        //nge();
       
        do{
        System.out.println("Choose:\n1. Push \n2. Pop \n3. Infix to Postfix \n4. Postfix evaluation \n5.Next greater element "
                + "\n6. Get minimum"+"\n7.Exit ");
        choice = sc.nextInt();
        switch(choice){
            case 1:
                if(top == size-1){
                    System.out.println("Overflow");
                
                }
                else{
                    System.out.println("Enter element to push");
                    n = sc.nextInt(); 
                    stack[top+1] = n;
                    top++;
                    for(int k:stack){
                        System.out.print(k+" ");
                    }
                }
            break;
            case 2:
                if(top==-1){
                    System.out.println("Stack underflow");
                }
                else{
                    stack[top] = 0;
                    top--;
                    for(int k:stack){
                    System.out.print(k+" ");
                    }
                }
        break;
            case 3:
               infix_to_postfix();
        break;
            case 4:
                postfix_evaluation();
         break;
            case 5:
                nge();
        break;
            case 6:
                getMin();
                break;
        }
        }while(choice!=7);
        
    }
        /*INFIX TO POSTFIX CONVERSION*/
        static void infix_to_postfix(){
        String str;
        System.out.println("Enter infix expression:");
        str = sc.nextLine();
        char[] exp = str.toCharArray();
        String res = "";
        Stack<Character> s = new Stack<>();
        for(int i=0;i<exp.length;i++){
            char temp = exp[i];
            switch(temp){
                case '(':
                    s.push(temp);
                break;
                    
                case ')':
                    while(s.peek()!='('){
                
                        char x = s.pop();
                        System.out.print(x);
                        res+=x;
                    
                    }
                    s.pop();
                break;
                    
                case '/':
                    if(s.isEmpty()){
                        s.push(temp);
                    }
                    else{
                        if(s.peek()==temp){
                            while((!s.isEmpty()) && s.peek()==temp ){
                                char x = s.pop();
                                System.out.print(x);
                                res=res+x;
                         
                            }
                        s.push(temp);
                        }
                        else{
                            s.push(temp);
                        }
                    }
                break;
                case '*':
                    if(s.isEmpty()){
                        s.push(temp);
                    }
                    else{
                        if(s.peek()==temp || s.peek()=='/'){
                            while((!s.isEmpty()) && (s.peek()==temp || s.peek()=='/')  ){
                                char x = s.pop();
                                System.out.print(x);
                                res=res+x;
                           }
                        s.push(temp);
                        }
                        else
                        {
                            s.push(temp);
                            
                        }
                    }
                break;
                case '+':
                    if(s.isEmpty()){
                        s.push(temp);
                    }
                    else{
                        if(s.peek()==temp || s.peek()=='*' || s.peek()=='/'||s.peek()=='-'){
                            while((!s.isEmpty())&&(s.peek()==temp || s.peek()=='*' || s.peek()=='/'||s.peek()=='-') ){
                            char x = s.pop();
                            System.out.print(x);
                            res=res+x;
                            }
                            s.push(temp);
                        }
                        else{
                            s.push(temp);
                        }
                    }
                break;
                case '-':
                    if(s.isEmpty()){
                        System.out.print(temp);
                    }
                    else{
                        if(s.peek()==temp || s.peek()=='*' || s.peek()=='/' || s.peek()=='+'){
                            while((!s.isEmpty())&&(s.peek()==temp || s.peek()=='*' || s.peek()=='/' || s.peek()=='+') ){
                            char x = s.pop();
                            System.out.print(x);
                            res=res+x;
                            }
                            s.push(temp);
                        }
                        else{
                            s.push(temp);
                        }
                    }
                break;
                default:
                    System.out.print(temp);
                    res=res+temp;
            }
            
        }
        while(!s.isEmpty()){
         char temp2=s.pop();
         System.out.print(temp2);
         res+=temp2;
        }
  
    }
    static void postfix_evaluation(){
      String str;
      System.out.println("Enter postfix expression:");
      str = sc.nextLine();
      char[] exp = str.toCharArray();
      Stack<Character> s = new Stack<>();
      for(int i=0;i<exp.length;i++){
          char temp = exp[i];
          if(temp=='/' || temp=='*' || temp=='+' || temp=='-'){
              char x = s.pop();
              char y = s.pop();
              int a = Integer.parseInt(String.valueOf(x));
              int b = Integer.parseInt(String.valueOf(y));
//              System.out.println(a+" "+b);
              if(temp=='/'){
                  int res = b/a;
//                  System.out.println(res);
                  char res2 = (char)(res + '0');
                  s.push(res2);
//                  System.out.println(s);
              }
              else if(temp=='*'){
                  int res = b*a;
                  char res2 = (char)(res + '0');
                  s.push(res2);
//                  System.out.println(s);
              }
              else if(temp=='+'){
                  int res = b+a;
//                  System.out.println(res);
                  char res2 = (char)(res + '0');
//                  System.out.println(res2);
                  s.push(res2);
//                  System.out.println(s);
              }
              else if(temp=='-'){
                  int res = b-a;
                  char res2 = (char)(res + '0');
                  s.push(res2);
//                  System.out.println(s);
              }
          }
          else{
              s.push(temp);
             
          }
      }
      System.out.println("Result = "+s.peek());
        }
    static void nge(){
        Stack<Integer> s = new Stack<>();
        System.out.println("Enter size of stack:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
         
        }
        for(int i=0;i<n;i++){
            if(s.isEmpty()){
                s.push(arr[i]);
            }
            else{
                if(arr[i]>s.peek()){
                    while((!s.isEmpty())&&arr[i]>s.peek()){
                        System.out.println("Next greater of "+s.peek()+" = "+arr[i]);
                        s.pop();
                        
                    }
                    s.push(arr[i]);
                }
                else{
                    s.push(arr[i]);
                }
                
            }
        }
        while(!s.isEmpty()){
            int temp = s.pop();
            System.out.println("Next greater of "+temp+" = -1");
        }
        
    }
    static void getMin(){
        int min = 0;
        int size;
        Stack<Integer> s = new Stack();
        System.out.println("Enter size of stack:");
        size = sc.nextInt();
        System.out.println("Enter elements:");
        int[] arr = new int[size];
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
            
            
        }
        for(int i =0;i<arr.length;i++){
            if(s.isEmpty()){
                s.push(arr[i]);
                min = arr[i];
            }
            else{
                if(arr[i]>=min){
                    s.push(arr[i]);
                }
                else{
                 
                    int ele = (2*arr[i])-min;
                    s.push(ele);
                    min = arr[i];
                }
            }
            
        }
        System.out.println("Minimum = "+min);
        
        int option;
        do{
        System.out.println("Do you want to pop:\n1.Yes \n2. No");
        option = sc.nextInt();
        switch(option){
            case 1:
               int y = s.peek();
               System.out.println("y = "+y);
               s.pop();
               System.out.println(s);
               if(y<min){
                min = (2*min)-y; 
                System.out.println("Minimum = "+min);
               } 
               else{
                   System.out.println("Minimum = "+min);
               }
                break;           
            
        }
        }while(option!=2);
        
        
    }
    
}
