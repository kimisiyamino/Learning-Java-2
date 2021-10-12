package com.eleonoralion;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueTest {
    public static void main(String[] args) {
        Person person1 = new Person(1);
        Person person2 = new Person(2);
        Person person3 = new Person(3);
        Person person4 = new Person(4);
        Person person5 = new Person(5);

        LinkedList<Person> linkedList = new LinkedList<>();
        List<Person> listLinkedList = new LinkedList<>();
        Queue<Person> queueLinkedList = new LinkedList<>(); // FIFO


        // linkedList.add()
        Collections.addAll(linkedList, person1, person3, person5, person4, person2);
        linkedList.remove();
        System.out.print("linkedList: ");
        System.out.println(linkedList);

        Collections.addAll(queueLinkedList, person1, person3, person5, person4, person2);
        queueLinkedList.peek();
        System.out.print("queueLinkedList: ");
        System.out.println(queueLinkedList);

        Collections.addAll(listLinkedList, person1, person3, person5, person4, person2);
        System.out.print("listLinkedList: ");
        System.out.println(listLinkedList);

        Queue<Person> arrayBlockingQueue = new ArrayBlockingQueue<>(3);

        arrayBlockingQueue.add(person1);
        arrayBlockingQueue.add(person3);
        arrayBlockingQueue.add(person2);
        arrayBlockingQueue.offer(person5);

        System.out.print("arrayBlockingQueue: ");
        System.out.println(arrayBlockingQueue);

        // add     - offer
        // remove  - poll
        // element - peek

        PriorityQueue<Person> priorityQueue = new PriorityQueue<>(5, (o1, o2) -> {
            if(o1.getId() > o2.getId()){
                return 1;
            }else if(o1.getId() < o2.getId()){
                return -1;
            }else {
                return 0;
            }
        });
        //priorityQueue.offer(person1);
        priorityQueue.offer(person4);
        System.out.println(priorityQueue);
        priorityQueue.offer(person1);
        System.out.println(priorityQueue);
        priorityQueue.offer(person2);
        System.out.println(priorityQueue);
        priorityQueue.offer(person3);
        System.out.println(priorityQueue);
        priorityQueue.offer(person5);
        System.out.println(priorityQueue);
    }
}

class Person{
    private int id;

    public Person(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }



    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                '}';
    }


}
