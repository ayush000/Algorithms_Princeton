package com.company;

public class UF {

    private int[] id;

    UF(int N)
    {
        id=new int[N];
        for (int i=0;i<N;i++)
        {
            id[i]=i;
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

    public static void main(String[] args) {
	// write your code here
        int N=StdIn.readInt();
        UF uf=new UF(N);
        while (!StdIn.isEmpty())
        {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(!uf.connected(p,q))
            {
                uf.union(p,q);
                StdOut.println(p + " " + q);
            }
        }

    }
}
