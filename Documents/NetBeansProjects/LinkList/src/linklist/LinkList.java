/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linklist;

import java.util.*;
import java.io.*;
public class LinkList{
static LinkList list = new LinkList();
static Node head = null;
static Node head2 = null;
static int len = 0;
static class Node{
	int data;
	Node next;
	public Node(int data){
		this.data = data;
		next = null;
	}
}

public static void main(String arg[]){
	int n;
	Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	System.out.println("Creating a linked list:");
	System.out.println("Enter no. of elements to insert:");
	n = sc.nextInt();
	len = n;
	System.out.println("Enter elements:");
	while(n--!=0){
		int data = sc.nextInt();
		Node new_node = new Node(data);
		if(list.head == null){
			list.head = new_node;
			new_node.next = null;
		}
		else{
			Node last = list.head;
			while(last.next!=null){
				last = last.next;
			}
			last.next = new_node;
			}
		
	}
	Node curr = head;
	while(curr.next!=null){
		System.out.println(curr.data);
		curr = curr.next;
		
	}
	System.out.println(curr.data);
	
	int choice;
	System.out.println("Choose: 1. Insert at a. Beginning b. End c. Middle \n2. Delete \n3.Reverse \n4.Find middle element \n5. kth element from last "
                + "\n6. Remove duplicates from sorted list \n7. Remove duplicates from unsorted list \n8. Swap nodes by changing link"
                + "\n9. Odd elements followed by even \n10. Detect loop \n11. Binary search");
	choice = sc.nextInt();
	int ele;
	
	switch(choice){
		case 1:
			char op = sc.next().charAt(0);
			switch(op){
				case 'a':
				System.out.println("Enter element:");
				ele = sc.nextInt();
				Node new_node = new Node(ele);
				if(list.head==null)
				{
					new_node.next = list.head;
					list.head = new_node;
				}
				else{
					Node ptr = list.head;
					new_node.next = ptr;
					list.head = new_node;
				}
				break;
		
				case 'b':
				System.out.println("Enter element:");
				ele  = sc.nextInt();
				new_node = new Node(ele);
				Node ptr = list.head;
				while(ptr.next!=null){
					ptr = ptr.next;
				}
				ptr.next = new_node;
				new_node = null;
				
				break;
				
				case 'c':
				System.out.println("Enter element:");
				ele = sc.nextInt();
				System.out.println("Enter index (Length of linked list is "+len+"):");
				int index = sc.nextInt();
				if(index<0 || index>=len) return;
				new_node = new Node(ele);
				ptr = list.head;
				Node prev = ptr;
				int counter=-1;
				while(ptr.next!=null && counter!=index-1){
					prev = ptr;
					ptr = ptr.next;
					counter++;
				}
				new_node.next = prev.next;
				prev.next = new_node;
				
				break;
					
			}
			Node ptr = list.head;
			while(ptr!=null){
			System.out.print(ptr.data+" ");
			ptr = ptr.next;
			}
		break;
		case 2:
		System.out.println("Enter element to delete:");
		ele = sc.nextInt();
		ptr = list.head;
		Node prev = ptr;
		while(ptr!=null && ptr.data!=ele)
		{
			prev = ptr;
			ptr = ptr.next;
			
		}
		if(ptr.data==ele){
			if(ptr == list.head){
				list.head = ptr.next;
				ptr.next = null;
			}
			else{
			prev.next = ptr.next;
			ptr.next = null;
			}
			ptr = list.head;
			while(ptr!=null){
			System.out.print(ptr.data+" ");
			ptr = ptr.next;
		}
		}
		else{
			System.out.println("Element not found.");
		}
		break;
		case 3:
		Node  nxt;
		prev = null;
		curr = nxt = list.head;
		while(curr!=null){
			nxt = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nxt;
		}
			list.head = prev;
			
			
		
		ptr = list.head;
		while(ptr!=null){
			System.out.print(ptr.data+" ");
			ptr = ptr.next;
		}
		break;
	case 4:
	Node sp,fp;
	sp = list.head;
	fp = list.head;
	while(fp.next!=null && fp.next.next!=null){
		fp = fp.next.next;
		sp = sp.next;
	}
	System.out.println("Middle element is "+sp.data);
	break;
	
	case 5:

	sp = fp = list.head;
	int k;
	System.out.println("Enter value of k:");
	k = sc.nextInt();
	int counter=0;
	while(fp!=null && counter<k){
		fp = fp.next;
		counter++;
	}
	while(fp!=null){
		fp = fp.next;
		sp = sp.next;
	}
	System.out.println(sp.data);
	break;
	
        case 6:
            curr = list.head;
            prev = list.head;
            curr = curr.next;
            while(curr!=null){
                
                while((curr!=null && prev!=null) && prev.data == curr.data){
                    
                    prev.next = curr.next;
                    curr.next = null;
                    curr = prev.next;
                }
                
                if(curr!=null){
                prev = curr;
                curr = curr.next;
                }
               
            }
        sp = list.head;
        while(sp!=null){
            System.out.print(sp.data+" ");
            sp = sp.next;
        }
        break;
            
        case 7:
            Node p1 = list.head;
            Node p2 = list.head;
            prev = p2;
            p2 = p2.next;
            while(p1!=null){
                while(p2!=null){
                    if(p1!=p2 && (p1.data == p2.data)){
                        prev.next = p2.next;
                        p2.next = null;
                        p2 = prev.next;
                    }
                    else{
                    prev = p2;
                    p2 = p2.next;
                }
                }
                p1 = p1.next;
                p2 = p1;
            }
        sp = list.head;
            while(sp!=null){
                System.out.print(sp.data+" ");
                sp = sp.next;
            }
        break;
        case 8:
            System.out.println("Enter two elements:");
            int a = sc.nextInt();
            int b = sc.nextInt();
            Node node1,node2,prev1,prev2;
            node1 = node2 = prev1 = prev2 = null;
            curr = list.head;
            prev = curr;
            while(curr!=null){
               
                if(curr.data == a){
                    prev1 = prev;
                    node1 = curr;
                }
                if(curr.data == b){
                    prev2 = prev;
                    node2 = curr;
                }
                 prev = curr;
                curr = curr.next;
                
                
                
            }
            Node next1 = node1.next;
            Node next2 = node2.next;
            prev1.next = node2;
            node2.next = next1;
            prev2.next = node1;
            node1.next = next2;
            System.out.println(node1.data+ " "+node2.data);
            System.out.println("prev 1:"+prev1.data+" prev2 = "+prev2.data+" next1="+next1.data+" next2="+next2.data);
            
            sp = list.head;
            while(sp!=null){
                System.out.print(sp.data+" ");
                sp = sp.next;
            }
        break;
        case 9:
         LinkList list2 = new LinkList();
         list2.head2 = null;
            int even = 0;
            int odd = 0;
            sp = list.head;
            while(sp!=null){
             if(sp.data%2!=0){
                 Node new_node = new Node(sp.data);
                 if(list2.head2 == null){
                     list2.head2 = new_node;
                     new_node.next = null;
                 }
                 else{
                      ptr = list2.head2;
                      while(ptr.next!=null){
                          ptr = ptr.next;
                      }
                      ptr.next = new_node;
                      new_node.next = null;
                 }
//                 System.out.println(new_node.data);
                
             }
          sp = sp.next;        
	}
        sp = list.head;
            while(sp!=null){
             if(sp.data%2==0){
                 Node new_node = new Node(sp.data);
                 if(list2.head2 == null){
                     list2.head2 = new_node;
                     new_node.next = null;
                 }
                 else{
                      ptr = list2.head2;
                      while(ptr.next!=null){
                          ptr = ptr.next;
                      }
                      ptr.next = new_node;
                      new_node.next = null;
                 }
                
             }
          sp = sp.next;        
	}
        sp = list2.head2;
            while(sp!=null){
                System.out.print(sp.data+" ");
                sp = sp.next;
            }
        break;
        case 10:
            curr = list.head;
            fp = sp = curr;
            while(curr.next!=null){
                curr = curr.next;
            }
        curr.next = list.head.next;
            do{
                fp = fp.next.next;
                sp = sp.next;
                if(fp==sp) break;
            }while(fp!=sp && fp.next!=null);
        if(fp==sp){
            System.out.println("Loop is present ");
            int count=1;
            fp = fp.next;
            while(fp!=sp){
                count++;
                fp = fp.next;
            }
            System.out.println("No. of elements in loop = "+count);
        }
        break;
        case 11:
            System.out.println("Enter element to search:");
             ele = sc.nextInt();
            
            
        }
        
}

}
