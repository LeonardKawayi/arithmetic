package com.daojia.zzk.arithmetic._1array;

/**
 * @author zhangzk
 * 数组，自动扩容
 */
public class GenericArray<T> {
    // 用以存储数据
    private T[] data;

    private int size;

    public GenericArray(int capacity) {
        data =(T[]) new Object[capacity];
        this.size = 0;
    }

    public GenericArray() {
        this(10);
    }

    // 数组容量
    public int getCapacity () {
        return data.length;
    }

    // 获取当前元素个数
    public int count() {
        return size;
    }

    // 判断是否为空
    public boolean isEmpty () {
        return size == 0;
    }

    // 修改index位置的元素
    public void set (int index, T value) {
        checkIndex(index);
        data[index] = value;
    }

    // 获取index位置的元素
    public T get (int index) {
        checkIndex(index);
        return data[index];
    }

    // 查看元素是否包含
    public boolean contains (T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    // 获取对应元素的下标, 未找到，返回 -1
    public int find (T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }

        return -1;
    }

    // 在 index 位置，插入元素e, 时间复杂度 O(m+n)
    public void add (int index, T e) {
        checkIndex(index);

        // 当前数组放满，扩容
        if (size == data.length) {
            resize(size*2);
        }

        // index位置插入新元素，后面的依此往后移动一位
        for (int i = size; i > index; i--) {
            data[i] = data[i-1];
        }

        // index位置存放e
        data[index] = e;
        // size+1
        size++;
    }

    // 数组头放入一个元素
    public void addFirst (T e) {
        add(0, e);
    }

    // 数组尾部放入一个元素
    public void addLast (T e) {
        add(size, e);
    }

    // 删除 index 位置的元素，并返回
    public T remove (int index) {
        checkRemoveIndex(index);

        T result = data[index];

        // index后面的顺序往前一位
        for (int i = index; i < size -1; i++) {
            data[i] = data[i + 1];
        }

        size--;
        data[size] = null;

        // 缩容
        if (size == data.length >> 2 && data.length >> 1 != 0) {
            resize(data.length >> 1);
        }

        return result;
    }

    // 删除第一个元素
    public T removeFirst () {
        return  remove(0);
    }

    // 删除最后一个元素
    public T removeLast () {
        return remove(size-1);
    }

    // 删除指定元素
    public void removeElement (T e) {
        int i = find(e);
        if (i > 0) {
            remove(i);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array size = %d, capacity = %d \n", size, data.length));
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }

    // 扩容
    public void resize (int capacity) {
        T[] newData =(T[]) new Object[capacity];

        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }

        data = newData;
    }

    private void checkRemoveIndex (int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove index error");
        }
    }

    private void checkIndex (int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index error");
        }
    }

}
