package binarytrees;

import java.util.*;
import java.io.*;

public class Binarytrees {
	
	static Node root = null;
	static class Node{
		Node lc,rc;
		char data;
		public Node(char data){
			this.data = data;
		}
		
	}
	
	public static void main(String arg[]){
		Binarytrees tree = new Binarytrees();
		tree.root = new Node('a');
		tree.root.lc = new Node('b');
		tree.root.rc = new Node('c');
		tree.root.lc.lc = new Node('d');
		tree.root.lc.lc.lc = new Node('h');
		tree.root.lc.lc.rc = new Node('i');
		tree.root.lc.lc.rc.lc = new Node('j');
		tree.root.lc.lc.rc.rc = new Node('k');
		tree.root.lc.rc = new Node('e');
		tree.root.rc.lc = new Node('f');
		tree.root.rc.rc = new Node('g');
		tree.root.rc.rc.lc = new Node('l');
		tree.root.rc.rc.lc.lc = new Node('n');
		tree.root.rc.rc.lc.lc.lc = new Node('p');
		tree.root.rc.rc.rc = new Node('m');
		tree.root.rc.rc.rc.lc = new Node('q');
		tree.root.rc.rc.rc.rc = new Node('r');
		tree.root.rc.rc.rc.lc.lc = new Node('s');
		tree.root.rc.rc.rc.lc.lc.rc = new Node('t');
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		System.out.println("Choose: \n1. Inorder \n2. Preorder \n3. Postorder \n4. Level order \n5. Zig zag level order \n6. Reverse level order \n7. Left view \n8. Right view");
		int choice = sc.nextInt();
		Stack<Node> s = new Stack();
		switch(choice){
			case 1:
			Node curr = tree.root;
			while(curr!=null || !s.isEmpty()){
				while(curr!=null)
				{
					s.push(curr);
					curr = curr.lc;
				}
				curr = s.pop();
				System.out.print(curr.data+" ");
				
				curr = curr.rc;
			}
			break;
			
			case 2:
			curr = tree.root;
			while(curr!=null || !s.isEmpty()){
			while(curr!=null){
				System.out.print(curr.data+" ");
				if(curr.rc!=null)
					s.push(curr.rc);
				curr = curr.lc;
			}
			if(!s.isEmpty())
			curr = s.pop();
			}
			break;
			case 3:
			Stack<Node> s1 = new Stack();
			Stack<Node> s2 = new Stack();
			s1.push(tree.root);
			while(!s1.isEmpty()){
				Node t = s1.pop();
				s2.push(t);
				if(t.lc!=null)
					s1.push(t.lc);
				if(t.rc!=null)
					s1.push(t.rc);
				
			}
			while(!s2.isEmpty())
				System.out.print(s2.pop().data);
			break;
			
			case 4:
			Queue<Node> queue = new LinkedList<>(); 
                        curr = tree.root;
                        queue.add(curr);
			while(curr!=null && !queue.isEmpty()){
                            if(curr.lc!=null)
                                queue.add(curr.lc);
                            if(curr.rc!=null)
                                queue.add(curr.rc);
                            System.out.print(queue.remove().data+" ");
                            curr = queue.peek();
                        }
                        break;
                        
                        case 5:
                        Queue<Node> q= new LinkedList<>();
                        Stack<Node> st = new Stack<>();
                            
                        curr = tree.root;
                            boolean c=true;
                            q.add(curr);
                            while(!q.isEmpty()){
                             int size = q.size();
                             while(size!=0){
                                 curr = q.remove();
                                 if(c){
                                     st.push(curr);
                                 }
                                 else{
                                     System.out.print(curr.data+" ");
                                 }
                                 if(curr.lc!=null)
                                     q.add(curr.lc);
                                 if(curr.rc!=null)
                                     q.add(curr.rc);
                                 size--;
                             }
                             if(c){
                                 while(!st.isEmpty())
                                 {
                                     System.out.print(st.pop().data+" ");
                                 }
                             }
                             c=!c;
                                    
                               
                            }
                        break;
                        case 6:
                            curr = tree.root;
                            Queue<Node> q3 = new LinkedList<>();
                            Stack<Node> s3 = new Stack<>();
                            q3.add(curr);
                            while(!q3.isEmpty()){
                                curr = q3.remove();
                                s3.push(curr);
                                if(curr.rc!=null)
                                    q3.add(curr.rc);
                                if(curr.lc!=null)
                                    q3.add(curr.lc);
                                
                            }
                        while(!s3.isEmpty()){
                            System.out.print(s3.pop().data+" ");
                        }
                        break;
                        case 7:
                            queue = new LinkedList<>();
                            Node curr1 = tree.root;
                            queue.add(curr1);
                            queue.add(null);
                            curr = queue.peek();
                            while(!queue.isEmpty()){
                                if(curr!=null){
                                    System.out.print(curr.data+" ");
                                
                                while (queue.peek() != null) {
                                    if (curr.lc != null) {
                                        queue.add(curr.lc);
                                    }
                                    if (curr.rc != null) {
                                        queue.add(curr.rc);
                                    }
                                    queue.remove();
                                    curr = queue.peek();
                            }
                                queue.add(null);
                            }
                        queue.remove();
                        curr = queue.peek();
			
                            }
                        break;
                        case 8:
                        queue = new LinkedList<>();
                        curr1 = tree.root;
                        queue.add(curr1);
                        queue.add(null);
                        curr = queue.peek();
                        while (!queue.isEmpty()) {
                            if (curr != null) {
                                System.out.print(curr.data + " ");

                                while (queue.peek() != null) {
                                    if (curr.rc != null) {
                                        queue.add(curr.rc);
                                    }
                                    if (curr.lc != null) {
                                        queue.add(curr.lc);
                                    }
                                    queue.remove();
                                    curr = queue.peek();
                                }
                                queue.add(null);
                            }
                            queue.remove();
                            curr = queue.peek();

                        }
		}
	}
}