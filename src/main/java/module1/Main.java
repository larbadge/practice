package module1;

import module1.service.ArrayService;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
        ArrayService arrayService = new ArrayService();
        int[] array = arrayService.createArray(-100, 101);
        System.out.println(Arrays.toString(array));
        arrayService.sortArray(array);
        System.out.println(Arrays.toString(array));
        arrayService.cubeEachThirdElement(array);
        System.out.println(Arrays.toString(array));

        System.out.println();
        Lock lock = new Lock(array);
        lock.printArray();
        lock.getArray()[0] = 10;
        lock.printArray();
    }
}
