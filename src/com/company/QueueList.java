package com.company;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class QueueList {

    private ListElement head;
    private ListElement tail;
    private int elements;
    private int size;

    QueueList(int value){
        elements=0;
        size=value;
    }

    void add(int element)
    {
        if(elements+1!=size){
            ListElement a = new ListElement();//новый узел
            a.element=element;
            if(head == null)//Если очередь пустая
            {
                elements++;
                head = a;
                head.next=tail;
                tail = a;
            }
            else {
                elements++;
                tail.next=a;
                tail=tail.next;
            }
        }
    }
    public int pull(){
        elements--;
        ListElement tmp=head;
        head=head.next;
        return tmp.element;
    }

}
