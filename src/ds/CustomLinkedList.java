package ds;

public class CustomLinkedList {

    class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;
    Node tail = null;

    public void add(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void display(){
        Node currentNode = head;

        if(currentNode == null){
            System.out.println("List is empty");
        }
        else{
            while (currentNode != null)
            {
                System.out.println(currentNode.data);
                currentNode = currentNode.next;
            }
        }
    }

    public static void main(String[] args) {
        CustomLinkedList linkList = new CustomLinkedList();
        linkList.add(10);
        linkList.add(20);
        linkList.add(30);
        linkList.add(40);
        linkList.display();
    }
}
