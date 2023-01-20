import java.util.*;
class Node{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data= data;
    }
}
class DoubleLinkedList{
    /*public LinkedList(int x ){
        head=new Node(x);
    }*/
    Node head;
    Node tail;
    void addToLast(int data)
    {
        Node newNode =new Node(data);
        if(head==null)
        {
            head =newNode;
            tail=newNode;
        }
        else
            {
               tail.next=newNode;
               newNode.prev=tail;
               tail=newNode;
            }

    }
   public void addToFirst(int data)
    {
        Node newNode=new Node(data);
        if(head==null)
        {
            head=newNode;
            tail=newNode;
        }
        else
            {
                newNode.next=head;
                head.prev=newNode;
                head=newNode;

            }
        }
        void addAtPosition(int data, int pos)
        {
            Node newNode= new Node(data);
            int currPos=1;
            Node currNode=head;
            while(currPos<pos-1)
            {
                currNode=currNode.next;
                currPos++;
            }
            if(pos==1)
            {
                Node child=head;
                newNode.next=child;
                child.prev=head;
                head=newNode;
                tail=head;
            }
            else
            {
                Node child=currNode.next;
                currNode.next=newNode;
                newNode.next=child;
                child.prev=newNode;
                newNode.prev=currNode;
            }
        }
        //for delete particular data from double linked list 
        public void delete(int data)
        {
            if(head.data==data)
            {
                head=head.next;
                return;
            }
            Node currNode=head;
            while(currNode.next.data!=data)
            {
                currNode=currNode.next;
            }
            currNode.next=currNode.next.next;
            if(currNode.next.data != data)
            {
                currNode.next.prev=currNode;
            }
            else
            {
                tail=currNode;
            }
        }
        public void DeleteAtPosition(int pos)
        {
            int currPos=1;
            Node currNode=head;
            while(currPos<pos-1)
            {
                currNode=currNode.next;
                currPos++;
            }
            currNode.next=currNode.next.next;
            if(currNode.next !=null)
            currNode.next.prev=currNode;
            else
            tail=currNode;
        }
        public void reverse()
        {
            Node prev=null;
            Node curr=head;
            while(curr != null)
            {
                Node next=curr.next;
                curr.next=prev;
                if(next !=null)
                    curr.prev=next;
                prev=curr;
                curr=next;
            }
            head=prev;
        }
        Node reverseRec(Node head)
        {
            if(head.next==null)
            return head;
            else{
                Node curr=head;
                Node nextNode=curr.next;
                Node newHead=reverseRec(head.next);
                nextNode.next=curr;
                curr.prev=nextNode;
                //because here creat loop to storing each other node so  
                curr.next=null;
                return newHead;
            }
        }
    void printList()
    {
        Node currNode=head;
        while(currNode != null)
        {
            System.out.print(currNode.data+" ");
            currNode=currNode.next;
        }
        System.out.println();
    }
    void printReverseList()
    {
        Node currNode=tail;
        while(currNode != null)
        {
            System.out.print(currNode.data+" ");
            currNode=currNode.prev;
        }
        System.out.println();
    }

}
public class MyClass2 {
    public static void main(String args[]) {
    DoubleLinkedList l=new DoubleLinkedList();
l.addToLast(3);
l.addToLast(2);
l.addToLast(7);
l.addToLast(9);
l.addToFirst(9);
l.addAtPosition(2,5);
l.printList();
l.delete(7);
l.printList();
l.printReverseList();
l.DeleteAtPosition(4);
l.printList();
l.reverse();
l.printList();
l.head=l.reverseRec(l.head);
l.printList();
    }
}