//Author: Alexis Navarro
//Lab 5
//Last modification: 10/26/18

//PURPOSE OF THE PROGRAM:
//The purpose of this program is to be able to work with Linked Lists by using three different files with different functionalities that have an effect in each file.
//The Runner file will mostly depend on the Linked List file by trying to avoid using the variable "next" from the Box file, however some parts will require the methods in the Box file.
//The Linked List file contains the methods used to allow the Runner to function properly which can be to add a Node, delete a Node, print the Linked list and many more that work to improve the code.
//The Box file will contain the information of the Nodes in the Linked List and some functionalities to answer certain requirments.

import java.util.Scanner;
import java.io.*;
class Runner{


//METHOD THAT READS AND CREATES A LINKED LIST WITHOUT USING THE BOX FILE
    public static LinkedList createLinkedList(String file){
        Scanner s = null;
        LinkedList obj = new LinkedList();//create a new object 
        try{
            s = new Scanner(new File(file));
            String line = s.nextLine();
            String[] aSplit = line.split(" ");

            Box head = new Box(Double.parseDouble(aSplit[0]),Double.parseDouble(aSplit[1]),Double.parseDouble(aSplit[2]));// used to be able to read the text into a string and store each dimension
            Box temp = head;
            obj.addNode(temp);//needed to start the list off with the head

            while(s.hasNextLine()){
                line = s.nextLine();
                aSplit = line.split(" ");
                temp= new Box(Double.parseDouble(aSplit[0]),Double.parseDouble(aSplit[1]),Double.parseDouble(aSplit[2]));
                obj.addNode(temp);//used to store the rest of the list that is obtained in the while loop
            }//end while

            return obj;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }//END CREATELINKEDLIST


//METHOD THAT FINDS THE SMALLEST BOX IN THE LINKED LIST
    public static void smallestBox(LinkedList tempLL){
        Box smallest = tempLL.getBox(0);//gets head
        Box current = tempLL.getBox(1);//gets the box after the head

        int pos=1;
        int i=1;

        while(current!=null){
            if(current.getVolume()<smallest.getVolume()){
                smallest = current;
                pos = i;
            }
            current = tempLL.getNextBox();
            i++;
        }//end while

        System.out.println("Smallest Box Position: "+pos);
        System.out.println("Smallest Box Dimensions: "+ smallest.getHeight()+" "+smallest.getLength()+" "+smallest.getWidth());
        System.out.println("Smallest Box Volume: "+ smallest.getVolume());
    }//END SMALLEST BOX


//FINDS THE LARGEST BOX IN THE LINKED LIST
    public static void largestBox(LinkedList tempLL){
        Box largest = tempLL.getBox(0);//gets head
        Box current = tempLL.getBox(1);//gets the box after the head

        int pos=1;
        int i=1;

        while(current!=null){
            if(current.getVolume()>largest.getVolume()){
                largest = current;
                pos = i;
            }
            current = tempLL.getNextBox();
            i++;
        }//end while
        System.out.println("Largest Box Position: "+pos);
        System.out.println("Largest Box Dimensions: "+ largest.getHeight()+" "+largest.getLength()+" "+largest.getWidth());
        System.out.println("Largest Box Volume: "+ largest.getVolume());
    }//END LARGEST BOX

    
//METHOD THAT FINDS THE AMOUNT OF CUBIC BOXES IN THE LINKED LIST
    public static void amountOfCubic(LinkedList tempLL){
        int i=0;
        Box list = tempLL.getBox(0);
        while(list!=null){
            if(list.getCubic()==true){
                i++;
            }
            list = tempLL.getNextBox();
        }
        System.out.println("\nAmount of Cubic Boxes: "+i);
    }//END AMOUNT OF CUBICS

    
    public static void main(String[] args)throws FileNotFoundException{

        Box input = new Box(1,2,3);// Box object to test out the methods
        LinkedList h = createLinkedList("input.txt");
        h.printAllBoxes();
        LinkedList z= createLinkedList("input.txt");
        

        System.out.println("\nReverse The Boxes Order");
         z.printReverse();

        System.out.println("\nIs Insertion Possible?");
        System.out.print(h.insertNode(input, 4));
        h.printAllBoxes();
        
        

        System.out.println("\nIs Deletion Possible?");
        System.out.println(h.removeNode(4));
        h.printAllBoxes();

       System.out.println("\nSmallest Box In The List");
       smallestBox(h);
       System.out.println("\nLargest Box In The List"); 
       largestBox(h);
       amountOfCubic(h);   

    }//END MAIN
}//END RUNNER