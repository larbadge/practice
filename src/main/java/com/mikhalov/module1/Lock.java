package com.mikhalov.module1;

import java.util.Arrays;

public final class Lock {

    private final int[] array;

    public Lock(final int[] array) {
        this.array = array.clone();
    }

    public int[] getArray() {
        return array.clone();
    }

    public void printArray() {
        System.out.println(Arrays.toString(array));
    }
}
