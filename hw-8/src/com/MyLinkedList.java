package com;

/*
add(Object value) добавляет элемент в конец
remove(int index) удаляет элемент под индексом
clear() очищает коллекцию
size() возвращает размер коллекции
get(int index) возвращает элемент под индексом
*/

import java.util.Objects;

public class MyLinkedList<E> {
    private int size;

    private Node first;

    private Node last;

    public MyLinkedList() {
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        Node node = null;

        if (0 <= index && index < size) {
            node = first;
            for (int i = 1; i <= index; i++) {
                if (node.next != null) {
                    node = node.next;
                } else {
                    node = null;
                    break;
                }
            }
        }

        return node != null ? (E)node.item : null;
    }

    public void add(E element) {
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
            if (index == 0) {
                first = first.next;
                first.prev = null;
            } else if (index == size - 1) {
                last = last.prev;
                last.next = null;
            } else {
                for (int i = 1; i <= index; i++) {
                    if (item.next != null) {
                        item = item.next;
                    } else {
                        item = null;
                        break;
                    }
                }

                if (item != null && item.prev != null && item.next != null) {
                    Node itemPrev = item.prev;
                    Node itemNext = item.next;

                    itemPrev.next = itemNext;
                    itemNext.prev = itemPrev;
                }
            }

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

    private static class Node<E> {
        E item;
        Node next;
        Node prev;

        Node(Node prev, E element, Node next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
