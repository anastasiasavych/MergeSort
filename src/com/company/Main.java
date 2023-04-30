package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int[] arr = new int[5];

        for (int i = 0; i < 5; i++) {
            Scanner in = new Scanner(System.in);
            System.out.println("Введіть довжину коробки '" +(i+1)+ "':");
            int a = in.nextInt();
            System.out.println("Введіть ширину коробки '" +(i+1)+ "':");
            int b = in.nextInt();
            System.out.println("Введіть ширину коробки '" +(i+1)+ "':");
            int c = in.nextInt();

            int s = a*b*c;
            System.out.println("Об'єм коробки '" +(i+1)+"': "+s+ "см2");
            arr[i] = s;
        }
        System.out.println(Arrays.toString(arr));
        int[] sortArr = sort(arr);
        System.out.println(Arrays.toString(sortArr));
    }

    public static int[] sort(int[] arr) {
        if (arr.length < 2)
            return arr;
        int m = arr.length / 2;
        int[] arr1 = Arrays.copyOfRange(arr, 0, m);
        int[] arr2 = Arrays.copyOfRange(arr, m, arr.length);
        return merge(sort(arr1), sort(arr2));
    }

    public static int[] merge(int[] arr1, int arr2[]) {
        int n = arr1.length + arr2.length;
        int[] arr = new int[n];
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < n; i++) {
            if (i1 == arr1.length) {
                arr[i] = arr2[i2++];
            } else if (i2 == arr2.length) {
                arr[i] = arr1[i1++];
            } else {
                if (arr1[i1] < arr2[i2]) {
                    arr[i] = arr1[i1++];
                } else {
                    arr[i] = arr2[i2++];
                } }
        }
        return arr;
    }
}




