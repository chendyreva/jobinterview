package ru.geekbrains.mycollection;

import java.util.Arrays;

class ArrayListCustom<E> {
    // Определяем INITIAL_CAPACITY, размер элементов пользовательского ArrayList
    private static final int INITIAL_CAPACITY = 10;
    private int size = 0;
    private Object elementData[] = {};

    public ArrayListCustom() {
        elementData = new Object[INITIAL_CAPACITY];
    }

    public void add(E e) {
        if (size == elementData.length) {
            ensureCapacity(); // увеличить текущую емкость списка

        }
        elementData[size++] = e;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        // если индекс отрицательный или больше размера, мы бросаем
        // Исключение.
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size "
                    + index);
        }
        return (E) elementData[index]; // return value on index.
    }

    public Object remove(int index) {
        // если индекс отрицательный или больше размера, мы бросаем
        // Исключение.
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size "
                    + index);
        }
        Object removedElement = elementData[index];
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        size--; // уменьшаем размер ArrayListCustom после удаления элемента.
        return removedElement;
    }

    private void ensureCapacity() {
        int newIncreasedCapacity = elementData.length * 2;
        elementData = Arrays.copyOf(elementData, newIncreasedCapacity);
    }

    public void display() {
        System.out.print("\n" + "Отображение списка: ");
        for (int i = 0; i < size; i++) {
            System.out.print(elementData[i] + " ");
        }
    }
}


