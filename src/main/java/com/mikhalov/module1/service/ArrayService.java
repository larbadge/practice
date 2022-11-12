package com.mikhalov.module1.service;

import java.util.Random;
import java.util.Scanner;

public class ArrayService {
    private final Random random = new Random();
    private final Scanner scanner = new Scanner(System.in);

    public int[] createArray(int rangeFrom, int to) {
        return random.ints(enterArrayLength(), rangeFrom, to).toArray();
    }

    public void sortArray(int[] array) {
        if (enterAnswer() == 2) {
            reversedBubbleSort(array);
        } else {
            quickSort(array);
        }
    }

    public void cubeEachThirdElement(int[] arr) {
        for (int i = 2; i < arr.length; i += 3) {
            arr[i] = (int) Math.pow(arr[i], 3);
        }
        System.out.println("Cubed each third element");
    }

    private int enterArrayLength() {
        int length = 0;
        System.out.println("Write array length more than 9:");
        if (scanner.hasNextInt()) {
            length = scanner.nextInt();
        }
        scanner.nextLine();
        return length >= 10 ? length : enterArrayLength();
    }

    private int enterAnswer() {
        int length = 0;
        System.out.println("""
                Do you wanna sort array:
                Write 1 - low to high
                Write 2 - high to low""");
        if (scanner.hasNextInt()) {
            length = scanner.nextInt();
        }
        scanner.nextLine();
        return length == 1 ? length : length == 2 ? length : enterAnswer();
    }

    private void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int from, int to) {
        if (from < to) {
            int pivotIndex = getPivotIndex(arr, from, to);
            quickSort(arr, from, pivotIndex - 1);
            quickSort(arr, pivotIndex, to);
        }
    }

    private int getPivotIndex(int[] arr, int leftIndex, int rightIndex) {
        int pivot = arr[leftIndex];

        while (leftIndex <= rightIndex) {

            while (arr[leftIndex] < pivot) {
                leftIndex++;
            }
            while (arr[rightIndex] > pivot) {
                rightIndex--;
            }
            if (leftIndex <= rightIndex) {
                swap(arr, rightIndex, leftIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    public void reversedBubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] < arr[j]) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }

    private void swap(int[] arr, int index1, int index2) {
        arr[index2] = arr[index2] + arr[index1] - (arr[index1] = arr[index2]);
    }

}
