package com;

public class MyColletionsTest {

    public static void main(String[] args) {
        MyColletionsTest myColletionsTest = new MyColletionsTest();

        myColletionsTest.testMyArrayList();
        myColletionsTest.testMyStack();
        myColletionsTest.testMyLinkedList();
        myColletionsTest.testMyHashMap();
        myColletionsTest.testMyQueue();
    }

    void testMyArrayList() {
        System.out.println("*** Testing MyArrayList ***");

        MyArrayList<String> myArrayList = new MyArrayList<>();

        try {
            myArrayList.add("Sun");
            myArrayList.add("Microsystems");
            myArrayList.add("The Best");
            myArrayList.add("Hello");
            myArrayList.add("Oracle");

            System.out.println(myArrayList.size());
            myArrayList.remove(3);
            System.out.println(myArrayList.size());

            System.out.println();

            System.out.println(myArrayList.get(0));
            System.out.println(myArrayList.get(1));
            System.out.println(myArrayList.get(2));
            System.out.println(myArrayList.get(3));

            myArrayList.remove(3);

            System.out.println();

            System.out.println(myArrayList.get(0));
            System.out.println(myArrayList.get(1));
            System.out.println(myArrayList.get(2));
//            System.out.println(myArrayList.get(3)); //IndexOutOfBoundsException

            System.out.println();

            System.out.println(myArrayList.size());
            myArrayList.clear();
            System.out.println(myArrayList.size());

            System.out.println();

//            System.out.println(myArrayList.get(0)); //IndexOutOfBoundsException
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\n" + "IndexOutOfBoundsException" + "\n");
        }

        System.out.println("*** Testing MyArrayList ends ***" + "\n\n");
    }

    void testMyStack() {
        System.out.println("*** Testing MyStack ***");

        MyStack<String> myStack = new MyStack<>();

        try {
            myStack.push("Oracle");
            myStack.push("The Best");
            myStack.push("Microsystems");
            myStack.push("Hello");
            myStack.push("Sun");

            System.out.println(myStack.size());
            myStack.remove(3);
            System.out.println(myStack.size());

            System.out.println();

            System.out.println(myStack.pop());
            System.out.println(myStack.pop());
            System.out.println(myStack.peek());
            System.out.println(myStack.pop());
            System.out.println(myStack.pop());
//            System.out.println(myStack.pop()); //IndexOutOfBoundsException

            myStack.push("Hello");
            myStack.push("Sun");

            System.out.println(myStack.size());
            myStack.clear();
            System.out.println(myStack.size());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\n" + "IndexOutOfBoundsException" + "\n");
        }

        System.out.println("*** Testing MyStack ends ***" + "\n\n");
    }

    void testMyLinkedList() {
        System.out.println("*** Testing MyLinkedList ***");

        MyLinkedList<String> myLinkedList = new MyLinkedList<>();

        try {
            myLinkedList.add("Sun");
            myLinkedList.add("Microsystems");
            myLinkedList.add("The Best");
            myLinkedList.add("Hello");
            myLinkedList.add("Oracle");

            System.out.println(myLinkedList.size());
            myLinkedList.remove(3);
            System.out.println(myLinkedList.size());

            System.out.println();

            System.out.println(myLinkedList.get(0));
            System.out.println(myLinkedList.get(1));
            System.out.println(myLinkedList.get(2));
            System.out.println(myLinkedList.get(3));

            myLinkedList.remove(3);

            System.out.println();

            System.out.println(myLinkedList.get(0));
            System.out.println(myLinkedList.get(1));
            System.out.println(myLinkedList.get(2));
//            System.out.println(myLinkedList.get(3)); //IndexOutOfBoundsException

            System.out.println();

            System.out.println(myLinkedList.size());
            myLinkedList.clear();
            System.out.println(myLinkedList.size());

//            System.out.println(myLinkedList.get(0)); //IndexOutOfBoundsException
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\n" + "IndexOutOfBoundsException" + "\n");
        }


        System.out.println("*** Testing MyLinkedList ends ***" + "\n\n");
    }

    void testMyHashMap() {
        System.out.println("*** Testing MyHashMap ***");

        MyHashMap<String, String> myHashMap = new MyHashMap<>();

        myHashMap.put("1", "one");
        myHashMap.put("2", "two");
        myHashMap.put("3", "three");
        myHashMap.put("2", "four");

        myHashMap.remove("1");

        System.out.println(myHashMap.get("1")); //null
        System.out.println(myHashMap.get("2")); //four
        System.out.println(myHashMap.get("3")); //three
        System.out.println(myHashMap.get("4")); //null

        myHashMap.remove("3");

        System.out.println();

        System.out.println(myHashMap.get("1")); //null
        System.out.println(myHashMap.get("2")); //four
        System.out.println(myHashMap.get("3")); //null
        System.out.println(myHashMap.get("4")); //null
        System.out.println(myHashMap.get("9")); //null

        System.out.println();

        System.out.println(myHashMap.size());   //2
        myHashMap.clear();
        System.out.println(myHashMap.size());   //0

        System.out.println();

        myHashMap.put("9", "nine");

        System.out.println(myHashMap.get("9")); //nine
        System.out.println(myHashMap.get("1")); //null
        System.out.println(myHashMap.get("2")); //null
        System.out.println(myHashMap.get("3")); //null
        System.out.println(myHashMap.get("4")); //null

        myHashMap.remove("9");
        System.out.println(myHashMap.size());   //0

        System.out.println("*** Testing MyHashMap ends ***" + "\n\n");
    }

    void testMyQueue() {
        System.out.println("*** Testing MyQueue ***");

        MyQueue<String> myQueue = new MyQueue<>();

        try {
            myQueue.add("Sun");
            myQueue.add("Microsystems");
            myQueue.add("The Best");
            myQueue.add("Hello");
            myQueue.add("Oracle");

            System.out.println(myQueue.size());
            myQueue.remove(3);
            System.out.println(myQueue.size());

            System.out.println();

            System.out.println(myQueue.poll());
            System.out.println(myQueue.poll());
            System.out.println(myQueue.peek());
            System.out.println(myQueue.poll());
            System.out.println(myQueue.poll());
//            System.out.println(myQueue.poll()); //IndexOutOfBoundsException

            myQueue.add("Hello");
            myQueue.add("Sun");

            System.out.println("\n" + myQueue.size());
            myQueue.clear();
            System.out.println(myQueue.size());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\n" + "IndexOutOfBoundsException" + "\n");
        }

        System.out.println("*** Testing MyQueue ends ***" + "\n\n");
    }
}
