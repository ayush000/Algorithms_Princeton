package com.company;

//import java.lang.*;

import java.io.*;

/**
 * Created by ayush on 12/9/15.
 */
public class ThreeSumBasic {
    public static int count(int[] a)
    {
        int N=a.length;
        int count=0;
        for(int i=0;i<N;i++)
        {
            for(int j=i+1;j<N;j++)
            {
                for (int k=j+1;k<N;k++)
                {
                    if(a[i]+a[j]+a[k]==0)
                        count++;
                }
            }
        }
//        System.out.println();
        return count;
    }
    public static void main(String[] args) throws IOException {
        int N=4000;

//        long startTime = System.nanoTime();
        BufferedReader br = new BufferedReader(new FileReader(new File("4Kints.txt")));
        String line="";
        int num=0;
        int count=0;
        int[] a=new int[N];
        int i=0;
        try {
            while (line!=null)
            {
                line = br.readLine();

                if(line!=null) {
                    num = Integer.parseInt(line.replaceAll("[^\\d.]", ""));
                    a[i]=num;
                    count++;
                }
//                System.out.println(num);
            }

        }
        finally {
            br.close();
        }
        long startTime = System.nanoTime();
        System.out.println("Number of 3sums is "+count(a));
        long endTime=System.nanoTime();

        System.out.println("Time of execution is "+(endTime-startTime)/1000000);

    }

}
