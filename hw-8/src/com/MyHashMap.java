package com;

/*
put(Object key, Object value) добавляет пару ключ + значение
get(Object key) возвращает значение(Object value) по ключу
remove(Object key) удаляет пару по ключу
size() возвращает размер коллекции
clear() очищает коллекцию
*/

import java.util.Objects;

public class MyHashMap {
    private int size;

    private Node first;
    private Node last;

    private final int DEFAULT_SIZE = 10;
    private Object[] keys = new Object[DEFAULT_SIZE];

    public MyHashMap() {
    }

    public void put(Object key, Object value) {
        if (!contains(key)) {
            if (size < keys.length) {
                keys[size] = key;
                if (size == 0) {
                    first = new Node(Objects.hashCode(key), key, value, null);
                    last = first;
                } else {
                    Node item = new Node(Objects.hashCode(key), key, value, null);
                    last.next = item;
                    last = item;
                }
            } else {
                Object[] newArray = new Object[keys.length * 2];
                System.arraycopy(keys, 0, newArray, 0, keys.length);
                keys = newArray;
                keys[size] = key;

                Node item = new Node(Objects.hashCode(key), key, value, null);
                last.next = item;
                last = item;
            }

            size++;
        } else {
            Node node = first;
            while(node != null) {
                if (node.key.equals(key)) {
                    node.value = value;
                    break;
                } else {
                    node = node.next;
                }
            }
        }
    }

    public Object get(Object key) {
        if (size > 0) {
            if (contains(key)) {
                Node node = first;
                while (node != null) {
                    if (node.key.equals(key)) {
                        return node.value;
                    } else {
                        node = node.next;
                    }
                }
            }
        }

        return null;
    }

    public void remove(Object key) {
        if (contains(key) && size > 0) {
            if (first.key.equals(key)) {
                first = first.next;
                removeKey(key);
                size--;
                return;
            }

            Node node = first;
            while(node != null) {
                if (node.next != null) {
                    if (node.next.key.equals(key)) {
                        Node toBeRemoved = node.next;
                        node.next = toBeRemoved.next;
                        break;
                    } else {
                        node = node.next;
                    }
                } else {
                    break;
                }
            }

            removeKey(key);
            size--;
        }
    }

    private void removeKey(Object value) {
        int index = 0;
        for (Object o : keys) {
            if (o.equals(value)) {
                break;
            } else {
                index++;
            }
        }
        keys[index] = null;

        if (0 <= index && index < size) {
            for (int i = index; i < (size - 1); i++) {
                keys[i] = keys[i + 1];
            }
        }
    }

    public boolean contains(Object value) {
        if (size > 0) {
            for (Object key : keys) {
                if (key != null) {
                    if (key.equals(value)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public int size() {
        return size;
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
        keys = new Object[DEFAULT_SIZE];
    }

    private static class Node {
        int hash;
        Object key;
        Object value;
        Node next;

        Node(int hash, Object key, Object value, Node next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (obj == this) return true;

            if (!(obj instanceof Node)) return false;

            Node item = (Node) obj;

            return value.equals(item.value);
        }
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();

        myHashMap.put(0, "1");
        myHashMap.put(1, "2");
        myHashMap.put(2, "3");
        myHashMap.put(3, "4");
        myHashMap.put(2, "4");

        myHashMap.remove(1);

        System.out.println(myHashMap.get(0));
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(2));
        System.out.println(myHashMap.get(3));

        myHashMap.remove(3);

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println(myHashMap.get(0));
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(2));
        System.out.println(myHashMap.get(3));

        myHashMap.clear();

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println(myHashMap.get(0));
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(2));
        System.out.println(myHashMap.get(3));
    }
}
