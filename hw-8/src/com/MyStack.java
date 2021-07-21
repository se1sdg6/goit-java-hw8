package com;

/*
push(Object value) добавляет элемент в конец
remove(int index) удаляет элемент под индексом
clear() очищает коллекцию
size() возвращает размер коллекции
peek() возвращает первый элемент в стеке (LIFO)
pop() возвращает первый элемент в стеке и удаляет его из коллекции
*/

import java.util.Objects;

public class MyStack<E> {
    private int size;

    private final int DEFAULT_SIZE = 10;
    private Object[] elementData;

    public MyStack() {
        elementData = new Object[DEFAULT_SIZE];
    }

    public MyStack(int length) {
        elementData = new Object[length];
    }

    public E peek() {
        Objects.checkIndex(0, size);
        E result = size > 0 ? (E) elementData[size - 1] : null;
        return result;
    }

    public E pop() {
        Objects.checkIndex(0, size);
        E result = size > 0 ? (E) elementData[size - 1] : null;
        size--;
        return result;
    }

    public boolean push(E e) {
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

    public boolean remove(int index) {
        Objects.checkIndex(index, size);

        try {
            if (index == (size - 1)) {
                size--;
            } else if (0 <= index && index < size) {
                for (int i = index; i < (size - 1); i++) {
                    elementData[i] = elementData[i + 1];
                }
                size--;
            } else {
                return false;
            }
        } catch (Exception exc) {
            return false;
        }

        return true;
    }

    public void clear() {
        elementData = new Object[DEFAULT_SIZE];
        size = 0;

//        Дальше, уборщик мусора сделает все сам.
    }

    public int size() {
        return size;
    }
}
