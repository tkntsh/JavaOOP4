/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * Ntshangase
 * Ntokozo
 * 4123601
 * CSC211 2022 Practical 4
 * PriorityQueue.java
 * @author Ntokozo
 */

public class PriorityQueue 
{
    /* attributes */
    private int currentSize; // Number of elements in heap
    private PriorityQueueNode [ ] PQ; // The priority queue array
    private static final int DEFAULT_CAPACITY = 2>>14; 
    private Comparator<? super PriorityQueueNode> cmp; // object to compare to instances of PriorityQueueNode

    /* default constructor */
    public PriorityQueue( )
    { 
        currentSize = 0;
        cmp = null;
        PQ = new PriorityQueueNode [DEFAULT_CAPACITY + 1];
    }
    
    
    /* getter methods for attributes */
    public int getSize( )
    { 
        return currentSize; 
    }
    
   /* methods from Practical 4 (Phase 3) */
    public boolean add( PriorityQueueNode x ) // [ 4 marks ]
    { 
        // insert code here
        int size=0;
        
        //checking if priority queue is full
        if(size>currentSize)
        {
            return false;
        }
        
        //assigning new variable to add to priority queue
        PQ[++size] = x;
        int current = size;
        
        //percolate up method
        while(PQ[current].getRating()<x.getRating())
        {
            swapReferences(PQ, current, x.getRating());
            current = x.getRating();
            return true;
        }
        return false;
    }

    public PriorityQueueNode remove( ) // [ 2 marks ]
    { 
        //the following code removes the max element of the priority queue
        PriorityQueueNode minItem = element();
        
        //removing max element of priority queue
        PQ[14] = PQ[currentSize--];
        percolateDown(14);
        
        //returning new max element of priority queue
        return minItem;
    }
    
    private void percolateDown( int hole ) // [ 6 marks ]
    { 
        //the following code takes the postion of next node
        int child = 0;
        PriorityQueueNode tmp = PQ[hole];
        
        for(; hole*2 <= currentSize; hole=child)
        {
            child = hole*2;
            //if statements compare elements so the array can get sorted
            if(child!=currentSize && compare(PQ[child+1], PQ[child])>0)
            {
                child++;
            }
            if(compare(PQ[child], tmp)<0)
            {
                PQ[hole] = PQ[child];
            }
            else
            {
                break;
            }
        }
        //assigning variable tmp created to the array position available
        PQ[hole] = tmp;
    }
    
    public void display() // [ 6 marks ]
    {
        //code below displays the priority queue in tree format
        for(int i = 0; i<=currentSize; i++)
        {
            //checks if this is the first level and prints items in priortiy queue
            if(currentSize<=2)
            {
                System.out.println(PQ[i]);
                
                //checks if there is a second level and prints items in priortiy queue
                if(currentSize>1&&currentSize<3)
                {
                    System.out.println(PQ[i+1] + " " + PQ[i+2]);
                    
                    //checks if there is a thrid level and prints items in priortiy queue
                    if(currentSize>3&&currentSize<5)
                    {
                        System.out.println(PQ[i+3] + " " +PQ[i+4] + " " + PQ[i+5] + " " +PQ[i+6]);
                        
                        //checks if there is a fourth level and prints items in priortiy queue
                        if(currentSize>5&&currentSize<9)
                        {
                            System.out.println(PQ[i+7]+ " " + PQ[i+8] + " " +PQ[i+9] + " " + PQ[i+10] + " " +PQ[i+11] + " " + PQ[i+12] + " " +PQ[i+13] + " " + PQ[i+14]);
                        }   
                    }
                }
            }
        }
    }
    
    /* auxiliary methods: you may use the below methods to help you write your code, if necessary */
    private int compare( PriorityQueueNode lhs, PriorityQueueNode rhs )
    { 
        if(cmp == null)
        {
            return ((Comparable)lhs).compareTo(rhs);
        }
        else
        {
            return cmp.compare(lhs, rhs);
        }
    }
    
    public void swapReferences(PriorityQueueNode [] a, int p, int q)
    {
        PriorityQueueNode tmp = a[p];
        a[p] = a[q];
        a[q] = tmp;
    }
    
    private void doubleArray( )
    { 
        PriorityQueueNode [ ] newArray;
        newArray =  new PriorityQueueNode[ PQ.length * 2 ];
        for( int i = 0; i < PQ.length; i++ )
            newArray[ i ] = PQ[ i ];
        PQ = newArray;
    }
    
    public PriorityQueueNode element( )
    { 
        if(isEmpty())
        {
            throw new NoSuchElementException();
        }
        return PQ[1];
    }
    
    public void clear( )
    { 
        currentSize = 0;
    }
    
    public boolean isEmpty()
    {
        return currentSize==0;
    }
}
