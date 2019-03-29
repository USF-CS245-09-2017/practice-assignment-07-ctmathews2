class Node<T>{ //Node Class
    T data;
    Node next;
    public Node(T data){
        this.data = data;
    }

    Node getNext(){
        return next;
    }

    void setNext(Node next){
        this.next = next;
    }

    T getData(){
        return this.data;
    }
}

class Assert{ //Assert class. For checking position avalibality in other methods
    public static boolean notFalse(boolean cond){
        if(cond)
            return true;
        else
            throw new IllegalArgumentException("Error");
    }
}

public class LinkedList<T> implements List<T>{ //Linked List
    Node head = null;
    int size = 0;

    public int size(){
        return this.size;
    }

    public void add(T item){ //Add item at end of list
        if(this.head == null){ //If the head is empty then set the head to the new item
            head = new Node(item);
            head.setNext(null);
            this.size++;
        }else{ //Else change last node.next to new node
            Node curr = head;
            while(curr.next!=null)
                curr = curr.next;
            Node node = new Node(item);
            node.setNext(null);
            curr.setNext(node);
            this.size++;
        }
    }

    public void add(int pos, T item){ //Change pos-1 node.next to new item. Change new node.next to pos+1 node
        Assert.notFalse(pos>=0 && pos<=size);
        if(pos == 0){
            Node n = new Node(item);
            n.setNext(head);
            head = n;
            size++;
        }else{
            Node n = new Node(item);
            Node prev = head;
            for(int i = 0; i < pos-1; i++)
                prev = prev.next;
            n.next = prev.next;
            prev.next = n;
            size++;
        }
    }

    public T remove(int pos){ //Remove node and connect pos-1 node.next to pos+1 node
        Assert.notFalse(pos>=0 && pos<=size);
        if(pos== 0){
            Node curr = head;
            head = head.next;
            this.size--;
            return (T)curr.data;
        }
        Node prev = head;
        for(int i = 0; i < pos-1; i++)
            prev = prev.next;
        Node curr = prev.next;
        prev.next = curr.next;
        this.size--;
        return (T)curr.data;

    }
    
    public T get(int pos){
        Assert.notFalse(pos>=0 && pos<=size);
        Node n = head;
        for(int i = 0; i < pos; i++){
            n = n.next;
        }
        return (T)n.data;
    }


}