package com;

/*
push(Object value) добавляет элемент в конец
remove(int index) удаляет элемент под индексом
clear() очищает коллекцию
size() возвращает размер коллекции
peek() возвращает первый элемент в стеке (LIFO)
pop() возвращает первый элемент в стеке и удаляет его из коллекции
*/

public class MyStack {
    private int size;

    private Node first;
    private Node last;

    public MyStack() {
    }

    public Object peek() {
        return last;
    }

    public Object pop() {
        Node result = last;
        if (first != last && last.prev != null) {
            last = last.prev;
        } else {
            first = null;
            last = null;
        }
        size--;

        return result;
    }

    public void push(Object element) {
        if (size == 0) {
            first = new Node(null, element, null);
            last = first;
        } else {
            Node item = new Node(last, element, null);
            last.next = item;
            last = item;
        }
        size++;
    }

    public boolean remove(int index) {
        if (0 <= index && index < size) {
            Node item = first;
            for (int i = 1; i <= index; i++) {
                if (item.next != null) {
                    item = item.next;
                } else {
                    item = null;
                    break;
                }
            }

            Node itemPrev = item.prev;
            Node itemNext = item.next;

            itemPrev.next = itemNext;
            itemNext.prev = itemPrev;

            size--;
        } else {
            return false;
        }

        return true;
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;

//        Дальше, уборщик мусора сделает все сам.
    }

    public int size() {
        return size;
    }

    private static class Node {
        Object item;
        Node prev;
        Node next;

        Node(Node prev, Object element, Node next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
