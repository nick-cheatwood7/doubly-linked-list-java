// package miniAssignment1;

// Taken from https://www.geeksforgeeks.org/doubly-linked-list/ (originally posted by Sumit Ghosh) 
// Updated for this use case

public class DLL { 
 Node head; // head of list 
 Node tail; // tail of list

 // Node Class
 class Node { 
	 // A Node has data, next Node, and prev Node
     int data; 
     Node prev; 
     Node next; 

     // Constructor to create a new node 
     // next and prev is by default initialized as null 
     Node(int x) { data = x; } 
 } 

 // Adding a node at the front of the list 
 public void insertAtHead(int data) { 
	 
     // Create a new Node and put data in it
     Node newNode = new Node(data); 

     // make the next of the new Node the head and the prev null
     newNode.next = head; 
     newNode.prev = null; 

     // change prev of head node to the new node
     if (head != null) 
         head.prev = newNode; 

     // make the head point to the new node
     head = newNode; 
 } 

// Insert after a given Node
 public void insertAfter(Node prevNode, int data) { 

     // Check if the prev node is null
     if (prevNode == null) { 
         System.out.println("The given previous node cannot be NULL "); 
         return; 
     } 

     // Populate the new Node with data
     Node newNode = new Node(data); 

     // Make the next of the new node the next of the previous node
     newNode.next = prevNode.next; 

     // make the next of the previous node as the new node
     prevNode.next = newNode; 

     // make the previous of the new node the previous node
     newNode.prev = prevNode; 

    // If the next of the new node is valid, make the prev of the next node after the new node equal the new node	
     if (newNode.next != null) 
    	 newNode.next.prev = newNode; 
 } 

 // Add a node at the end of the list 
 void insertAtEnd(int data) { 
     // Created a new node with data 
     Node newNode = new Node(data); 

     Node last = head;

     // This is the last node, so there is no next node
     newNode.next = null; 

     // If the head is null, then the previous node should be null and the head the new node created
     if (head == null) { 
    	 newNode.prev = null; 
         head = newNode; 
         return; 
     } 

     // Change the next node for each node
     while (last.next != null) 
         last = last.next; 

     // Change the next of the last node
     last.next = newNode; 

     // Make the last node as previous of the new node
     newNode.prev = last; 
     
     tail = newNode;
 } 
 
 // remove at
//  public void removeAt(DLL list, Node curNode) {
// 	   Node sucNode = curNode.next;
// 	   Node predNode = curNode.prev;

// 	   if (sucNode != null) {
// 	      sucNode.prev = predNode;
// 	   }

// 	   if (predNode != null) {
// 	      predNode.next = sucNode;
// 	   }

// 	   if (curNode == list.head) { // Removed head
// 	      list.head = sucNode;
// 	   }

// 	   if (curNode == list.tail) { // Removed tail
// 	      list.tail = predNode;
// 	   }
// 	}
 
 public void testRemove(int data) {
	 
	 // Start at the head
	 Node curNode = head;
	 
	 // Loop through the nodes
	 while(data != curNode.data) {
		 curNode = curNode.next;
	 }
	 
     // If node to be deleted is head node 
     if (head == curNode) { 
         head = curNode.next; 
     } 

     // Change next only if node to be deleted 
     // is NOT the last node 
     if (curNode.next != null) { 
    	 curNode.next.prev = curNode.prev; 
     } 

     // Change prev only if node to be deleted 
     // is NOT the first node 
     if (curNode.prev != null) { 
    	 curNode.prev.next = curNode.next; 
     } 
	 
	 if (data != curNode.data) {
		 // Unable to locate Node – this will actually throw a Java error, so this is trivial
		 System.out.println("Error: unable to locate Node");
	 } else {
		 // Print that we located & removed the node specified
		 System.out.println("Located and removed Node: " + curNode.data);
		 System.out.println();
	 }
	 
	 return;
 }

 // This function prints contents of linked list starting from the given node 
 public void printlist(Node node) { 
     Node last = null; 
     while (node != null) { 
    	 System.out.println("Node data: " + node.data);
         // System.out.print(node.data + " "); 
         last = node; 
         node = node.next; 
     } 
 } 

 // Main Method
 public static void main(String[] args) { 
	 
     // Make a new doubly linked list
     DLL dll = new DLL(); 

     // Insert at head -> 6
     dll.insertAtHead(6); 
     
     // Insert at head -> 7, 6
     dll.insertAtHead(7);

     // Insert after position -> 7, 6, 9
     dll.insertAfter(dll.head.next, 9);

     // Insert at end -> 7, 6, 9, 1
     dll.insertAtEnd(1); 
     
     // Print the list
     System.out.println("Doubly Linked List: "); 
     dll.printlist(dll.head); 
     System.out.println();
     
     // Remove at
     // Remove middle node -> 7, 9, 1
     dll.testRemove(6);
     
     // Print the list again
     System.out.println("Doubly Linked List: "); 
     dll.printlist(dll.head); 
     System.out.println();
 } 
} 
