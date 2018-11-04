//Author: Alexis Navarro
//Lab 5
//Last modification: 10/26/18

public class LinkedList {
 private Box head;
 private Box iterator;
 LinkedList(){}

 /* Add b as the last node of the linked list.*/
 void addNode(Box b){
     Box temp = b;
    if(head==null){
        head = temp;
        iterator = head;
    }else{
        temp.next = null;
        Box last = head;
    while(last.next != null){
        last = last.next;
    }//end while
    last.next=temp;
    iterator = last.next;
        }//end else
 }//END ADD NODE


 /* Insert b in position pos. If insertion is successful
 * return true, otherwise return false.
 */
 boolean insertNode(Box b, int pos){
    Box temp = b;
    Box current = head;
    int i=1;
  
    if(head == null){
        head = temp;
        iterator = head;
        return true;
    }

    if(pos==1){         //to delete the head if we are told to remove it
        temp.next=head;
        current=temp;
        iterator = temp.next;
        return true;
    }
    
    while(i < pos - 1){
        current=current.next;
        i++;
    }

    if(current!=null){
        Box last = null;
        last = current.next;
        current.next=temp;
        temp.next = last;
        iterator = temp.next;
        return true;
    }
    
    return false;
}//END INSERT NODE


 /**Print width, height, length, and volume of each of the boxes in
 * this linked list. */
 void printAllBoxes(){
    initiateIterator();
    int counter=1;

    while(iterator!=null){
      System.out.println("\nBox: "+counter);
      System.out.println("Length: "+iterator.getHeight());
      System.out.println("Width: "+ iterator.getLength());
      System.out.println("Height: "+iterator.getWidth());
        getNextBox();
        counter++;
    }//end while
 }//END PRINT ALL BOXES


 /** Remove the box in position pos. Return true if removal
 * is successful, otherwise return false.*/
 boolean removeNode(int pos){
     Box temp = head;
     Box prev = head;
     int i=1;
    if(head==null){
        return false;
    }
    if(pos==1){
        head = head.next;//Changes head
        temp.next=null;
        return true;
    }
    while(i < pos - 1){
        prev = prev.next;
        i++;
    }

    Box current = prev.next;// NODE TO BE DELETED
    prev.next = current.next;//UNLINK THE DELETED NODE
    current.next = null;
    return true;
 }//END REMOVE NODE



 /** Return the box in position pos. Return null when pos is
 * invalid.*/
 Box getBox(int pos){
     initiateIterator();
     int i=0;
    while(iterator!=null){
        if(i==pos){
            return iterator;
        }
        i++;
        getNextBox();
    }
    return null;
 }



 /**Print width, height, length, and volume of each of the boxes in
 * this linked list in reverse order.*/
 void printReverse(){

    Box prev = null;
    Box next = null;
    Box current=head;

    int counter=1;

    while(current!=null){
        next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }//end while

    while(prev!=null){
      System.out.println("\nBox: "+counter);
      System.out.println("Length: "+prev.getHeight());
      System.out.println("Width: "+ prev.getLength());
      System.out.println("Height: "+prev.getWidth());
      prev = prev.next;
        counter++;   
    }
 }//END PRINT REVERSE

 /**Initiate the iterator variable*/
 void initiateIterator(){
    iterator = head;
 }//END INITIATE ITERATOR

 /**
 * Return the box in the current iterator position.
 */
 Box getNextBox(){
    //iterator=iterator.next;
    return iterator = iterator.next;
 }//END GET NEXT BOX

}//END CLASS