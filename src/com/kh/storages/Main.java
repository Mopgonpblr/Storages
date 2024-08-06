package com.kh.storages;

import com.kh.storages.storageclasses.*;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        testArrayList();
        testHashSet();
    }

    static void testArrayList(){
        ArrayList arrayList = new ArrayList();
        arrayList.put(1);
        arrayList.put(2);
        arrayList.put(3);
        arrayList.put(4);
        arrayList.put(5);
        arrayList.put(6);
        arrayList.put(7);
        arrayList.put(8);
        arrayList.put(9);
        arrayList.put(10);

        System.out.println(arrayList);

        System.out.println(arrayList.get(5));

        arrayList.remove(4);

        System.out.println(arrayList);
    }

    static void testHashSet(){
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.put(1);
        hashSet.put(2);
        hashSet.put(3);
        hashSet.put(1);
        hashSet.put(3);
        hashSet.put(2);
        Iterator<Integer> it = hashSet.iterator();

        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        hashSet.delete(2);

        it = hashSet.iterator();
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        hashSet.put(4);
        hashSet.delete(1);

        it = hashSet.iterator();
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }
}