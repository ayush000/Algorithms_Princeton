package com.company;

import java.io.*;
import java.lang.Math;


public class UF {

    //Naive method to Union Find
    private int[] id;
    private int[] sz;

    public UF(int N)
    {
        id=new int[N];
        sz=new int[N];
        for (int i=0;i<N;i++)
        {
            id[i]=i;
            sz[i]=1;
        }
    }

    void union(int p,int q)
    {
        int pid=id[p];
        int qid=id[q];
        for (int i=0;i<id.length;i++)
        {
            if(id[i]==pid)
            {
                id[i]=qid;
            }
        }
    }

    boolean connected(int p,int q)
    {
        return id[p]==id[q];
    }


    // Tree method to Union Find
    private int root(int i)
    {
        while (i!=id[i])
        {
            i=id[i];
            id[i]=id[id[i]];
        }
        return i;
    }

    public boolean connectedT(int p,int q)
    {
        return root(p)==root(q);
    }

    public void unionT(int p,int q)
    {
        id[root(p)]=root(q);
    }

    //Balanced Tree method for Union Find
    public void unionTB(int p,int q)
    {
        int i=root(p);
        int j=root(q);
        if(i==j)
        {
            return;
        }
        if(sz[i]<sz[j])
        {
            id[i]=j;
            sz[j]+=sz[i];
        }
        else
        {
            id[j]=i;
            sz[i]+=sz[j];
        }
    }

    public static void main(String[] args) throws IOException {

        long startTime = System.nanoTime();

        BufferedReader br = new BufferedReader(new FileReader(new File("largeUF.txt")));
        int N=0;
        UF uf=null;
        try {
            String line = br.readLine();
            N=Integer.parseInt(line);
//            System.out.println(line);
            uf = new UF(N);
            int p,q;

            while (line != null) {
                line = br.readLine();
                if(line!=null)
                {
                    String[] arr=line.split(" ");
                    p=Integer.parseInt(arr[0]);
                    q=Integer.parseInt(arr[1]);
//                    System.out.println(p+" "+q);
                    uf.unionTB(p,q);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }
        int p1=(int)Math.ceil(Math.random()*N);
        int q1=(int)Math.ceil(Math.random()*N);
        System.out.println(p1+" is connected to "+q1+":"+uf.connectedT(p1,q1));
        long endTime = System.nanoTime();
        long duration=(endTime-startTime);
        System.out.println("duration = " + duration / 1000);

    }
//    public static void main()
//    {
        // write your code here
//        int N=StdIn.readInt();
//        UF uf=new UF(N);
//        while (!StdIn.isEmpty())
//        {
//            int p = StdIn.readInt();
//            int q = StdIn.readInt();
//            if(!uf.connected(p,q))
//            {
//                uf.union(p,q);
//                StdOut.println(p + " " + q);
//            }
//        }
//        System.out.println(System.getProperty("user.dir"));
//    }
}
