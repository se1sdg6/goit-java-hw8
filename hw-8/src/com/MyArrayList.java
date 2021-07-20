package com;

/*
add(Object value) добавляет элемент в конец
remove(int index) удаляет элемент под индексом
clear() очищает коллекцию
size() возвращает размер коллекции
get(int index) возвращает элемент под индексом
*/

public class MyArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private static final Object[] EMPTY_ELEMENTDATA = {};

    private Object[] elementData;

    private int size;

    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }

    public MyArrayList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    public boolean add(Object e) {
        try {
            if (size < elementData.length) {
                elementData[size] = e;
            } else {

                //Если места мало, создаем новый масив в два раза больше
                Object[] newArray = new Object[elementData.length * 2];

                //Копируем элементы со старого в новый
                System.arraycopy(elementData, 0, newArray, 0, elementData.length);

                //Меняем ссылку на масив элеметов на новосозданный
                elementData = newArray;

                //Вставляем элемент
                elementData[size] = e;
            }

            //Инкрементируем счетчик размера
            size++;
        } catch (Exception exc) {
            return false;
        }

        return true;
    }

    public Object get(int index) {
        return 0 <= index && index < size ? elementData[index] : null;
    }


//  Если индекс меньше индекса последнего элемента, то метод смещает все элементы на один влево, и декрементирует счетчик размера.
    public boolean remove(int index) {
        try {
            if (index == (size - 1)) {
                size--;
            } else if (0 <= index && index < size) {
                for (int i = index; i < (size - 1); i++) {
                    elementData[i] = elementData[i + 1];
                }
            } else {
                return false;
            }
            size--;
        } catch (Exception exc) {
            return false;
        }

        return true;
    }

    public int size() {
        return size;
    }

    public void clear() {
        elementData = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
}
