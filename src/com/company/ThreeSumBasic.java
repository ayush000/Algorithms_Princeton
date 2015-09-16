package com.company;

//import java.lang.*;

import java.io.*;
import java.util.Arrays;

/**
 * Created by ayush on 12/9/15.
 */
public class ThreeSumBasic {
    public static int binarySearch(int[] arr, int key, int startIndex, int endIndex) {

//        int index=-1;
        int middle;
        if(key==arr[startIndex]){
            return startIndex;
        }
        else if (key==arr[endIndex])
        {
            return endIndex;
        }
        while (startIndex <= endIndex) {
//            System.out.println("checking");
            middle = (int)(startIndex+endIndex)/2;
//            System.out.println(startIndex+ "middle: "+middle+" "+endIndex);
            if (key == arr[middle]) {
                return middle;
            } else if (key > arr[middle]) {
                startIndex=middle+1;
            } else {
                endIndex=middle-1;
            }
        }

        return -1;
    }

    public static int countBinarySearch(int[] a) {
        int count = 0;
        int N = a.length;
        int key;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                key=-(a[i]+a[j]);
//                if(binarySearch(a,key,0,N-1)!=-1)
//                {
                    count++;
//                }

            }
        }
        return count;
    }

    public static int count(int[] a) {
        int N = a.length;
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (a[i] + a[j] + a[k] == 0)
                        count++;
                }
            }
        }
//        System.out.println();
        return count;
    }

    public static void main(String[] args) throws IOException {
        int N = 4000;

//        long startTime = System.nanoTime();
        BufferedReader br = new BufferedReader(new FileReader(new File("4Kints.txt")));
        String line = "";
        int num = 0;
        int count = 0;
        int[] a = new int[N];
        int i = 0;
        try {
            while (line != null) {
                line = br.readLine();

                if (line != null) {
                    num = Integer.parseInt(line.replaceAll("[^\\d.]", ""));
                    a[i] = num;
                    count++;
                }
//                System.out.println(num);
            }

        } finally {
            br.close();
        }
        Arrays.sort(a);
        long startTime = System.nanoTime();
        int[] p={1,2,3,4,5};
//        System.out.println(binarySearch(p,6,0,4));
        System.out.println("Number of 3sums is " + count(a));
        long midTime = System.nanoTime();
        System.out.println("Time of execution is " + (midTime - startTime) / 1000000);
        System.out.println("Number of 3sums is " + countBinarySearch(a));
        long endTime = System.nanoTime();


        System.out.println("Time of execution is " + (endTime - midTime) / 1000000);

    }

}
