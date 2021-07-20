package com;

/*
add(Object value) добавляет элемент в конец
remove(int index) удаляет элемент под индексом
clear() очищает коллекцию
size() возвращает размер коллекции
get(int index) возвращает элемент под индексом
*/

public class MyLinkedList {
    private int size;

    private Node first;

    private Node last;

    public MyLinkedList() {
    }

    public Object get(int index) {
        Node item = null;

        if (0 <= index && index < size) {
            item = first;
            for (int i = 1; i <= index; i++) {
                if (item.next != null) {
                    item = item.next;
                } else {
                    item = null;
                    break;
                }
            }
        }

        return item;
    }

    public void add(Object element) {
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
        Node next;
        Node prev;

        Node(Node prev, Object element, Node next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
