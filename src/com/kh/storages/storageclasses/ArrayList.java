package com.kh.storages.storageclasses;

import java.util.Arrays;

public class ArrayList {

    private Object[] arrayList;
    private int lastIndex = 0;
    private final double extensionPercent;

    public ArrayList() {
        this.arrayList = new Object[10];
        this.extensionPercent = 0.75;
    }

    public void put(Object object) {
        this.arrayList[this.lastIndex] = object;
        this.lastIndex++;
        System.out.println("Element added");
        if ((double) this.lastIndex / this.arrayList.length
                >= this.extensionPercent) {
            resize(this.arrayList.length * 2);
            System.out.println("The ArrayList has been resized");
        }
    }

    public Object get(int index) {
        if (index >= 0 && index < arrayList.length) {
            return this.arrayList[index];
        } else {
            System.err.println("Index out of range");
        }
        return null;
    }

    public void remove(int index) {
        if (index >= 0 && index < arrayList.length) {
            Object[] newArrayList = new Object[this.arrayList.length];
            System.arraycopy(this.arrayList, 0, newArrayList, 0, index);
            System.arraycopy(this.arrayList, index + 1, newArrayList, index, this.arrayList.length - index - 1);
            this.arrayList = newArrayList;
        } else {
            System.err.println("Index out of range");
        }
    }

    public void resize(int size) {
        Object[] newArrayList = new Object[size];
        System.arraycopy(this.arrayList, 0, newArrayList, 0, this.arrayList.length);
        this.arrayList = newArrayList;
    }

    public String toString() {
        return Arrays.toString(this.arrayList);
    }
}
