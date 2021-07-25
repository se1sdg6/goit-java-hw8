package com;

/*
put(Object key, Object value) добавляет пару ключ + значение
get(Object key) возвращает значение(Object value) по ключу
remove(Object key) удаляет пару по ключу
size() возвращает размер коллекции
clear() очищает коллекцию
*/

public class MyHashMap<K, V> {
    private int size;

    static final int DEFAULT_INITIAL_CAPACITY = 100;
    private Node<K, V>[] table;

    public MyHashMap() {
        table = (Node<K, V>[]) new Node[DEFAULT_INITIAL_CAPACITY];
    }

    public V put(K key, V value) {

        if (key == null) {
            putForNullKey(value);
        }

        int i = getIndex(key), hash = hash(key);
        if (table[i] == null) {
            table[i] = new Node<K, V>(hash, key, value, null);
            size++;
        } else {
            Node n; K k;
            if (i == 0) {
                if (table[i] == null) {
                    n = new Node<>(hash, key, value, null);
                    table[0] = new Node<>(hash(null), null, null, n);
                    size++;
                    return null;
                }
            }

            for (n = table[i]; n != null; n = n.next) {
                if (key == (k = (K) n.key) && key.equals(k)) {
                    V oldValue = (V) n.value;
                    n.value = value;
                    size++;
                    return oldValue;
                } else if (n.next == null) {
                    n.next = new Node<K, V>(hash, key, value, null);
                    size++;
                    return null;
                }
            }
        }

        return null;
    }

    protected V putForNullKey(V value) {
        if (table[0] == null) {
            table[0] = new Node(hash(null), null, value, null);
            size++;
        } else {
            Object oldValue = table[0].value;
            table[0].value = value;
            size++;
            return oldValue == null ? null : (V) oldValue;
        }
        return null;
    }

    protected int getIndex(K key) {
        if (key == null)  return 0;

        int hash = hash(key);
        return ((table.length - 1) & hash);
    }

    public V get(K key) {
        if (size > 0) {
            if (key == null) {
                return getForNullKey();
            }

            int i;
            if (table[(i = getIndex(key))] != null) {
                Node n; K k; int hash = hash(key);
                for (n = table[i]; n != null; n = n.next) {
                    if (key == (k = (K)n.key) && key.equals(k) && n.hash == hash) {
                        return (V) n.value;
                    }
                }
            }
        }

        return null;
    }

    protected V getForNullKey() {
        return table[0] == null ? null : (V)table[0].value;
    }

    public V remove(K key) {
        if (size > 0) {
            if (key == null) {
                return removeForNullKey();
            }

            Node<K, V> first, n; K k; int i = getIndex(key), hash = hash(key);
            if ((first = table[i]) != null) {
                if ((k = (K) first.key) == key || k.equals(key) && hash == first.hash) {
                    table[i] = first.next;
                    size--;
                    return first.value == null ? null : (V)first.value;
                }

                if (first.next != null) {
                    for (n = first.next; n != null; n = n.next, first = first.next) {
                        if ((k = (K) n.key) == key || k.equals(key) && hash == n.hash) {
                            first.next = n.next;
                            size--;
                            return n.value == null ? null : (V) n.value;
                        }
                    }
                }
            }
        }

        return null;
    }

    private V removeForNullKey() {
        Node<K, V> n = table[0]; V result;
        if (n != null) {
            result = n.value == null ? null : (V) n.value;

            if (n.next == null) {
                table[0] = null;
            } else {
                table[0] = new Node<K, V>(hash(null), null, null, n.next);
            }

            size--;
            return result;
        }

        return null;
    }

    public boolean containsKey(K key) {
        Node<K, V> n; int i = getIndex(key);
        if ((n = table[i]) != null) {
            for (; n != null; n = n.next) {
                if (key == n.key || key.equals(n.key)) {
                    return true;
                }
            }
        }

        return false;
    }

    static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public int size() {
        return size;
    }

    public void clear() {
        size = 0;
        table = (Node<K, V>[])new Node[DEFAULT_INITIAL_CAPACITY];
    }

    private static class Node<K, V> {
        int hash;
        K key;
        V value;
        Node next;

        Node(int hash, K key, V value, Node next) {
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
}
