
package ps2521;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Sotiria Antaranian
 */
public class CRC 
{
    public int [][] makeMessages (int k)
    {
       int[][]M=new int[100000][k]; 
       for(int i=0;i<1000;i++)
       {
            for(int j=0;j<k;j++)
            {
                Random randomGenerator=new Random();
                int x=randomGenerator.nextInt(2);
                M[i][j]=x;
            }
       } 
       return M;  
    }
    
    public int[] divideXOR(int[] divisor, int[] m)
    {
        int cur=0;
        while(true)
        {
            for(int i=0;i<divisor.length;i++)
                m[cur+i]=(m[cur+i]^divisor[i]);
    
            while(m[cur]==0 && cur!=m.length-1)
                cur++;
    
            if((m.length-cur)<divisor.length)
                break;
        }
        return m;
    }
    
    public int [][] makeCRC (int [][] m,int [] P)
    {
        int n;
        n=P.length;
         int[][]newM=new int[m.length][m[0].length+n-1];
        // 2^n*M
        for(int i=0;i<m.length;i++)
            System.arraycopy(m[i], 0, newM[i], 0, m[0].length);
        for(int i=0;i<m.length;i++)
            newM[i]=divideXOR(P,newM[i]);
        for(int i=0;i<m.length;i++)
            for(int j=0;j<m[0].length;j++)
               newM[i][j]=m[i][j];  
     return newM;   
    }
    
    public int [][] alternate (int [][]a,double e)
    {
        double x;
        int [][] newA=new int [a.length][a[0].length];        
        for(int i=0; i<a.length; i++)
            System.arraycopy(a[i], 0, newA[i], 0, a[i].length);
        for(int i=0;i<a.length;i++)
        {    
            for(int j=0;j<a[0].length;j++)
            {
                Random randomGenerator=new Random();
                x=randomGenerator.nextDouble();
                if(x<e)
                {
                    if(newA[i][j]==0)
                        newA[i][j]=1;
                    else
                        newA[i][j]=0;
                }
            }
        }
        return newA;
    }
    
    public double check (int [][] a,int [][] b)
    {
        int rate=0;
        for(int i=0;i<a.length;i++)
        {
            if(!Arrays.equals(a[i],b[i]))
               rate=rate+1; 
        }
        return (double)rate*100/100000;
    }
    
    public double checkCRC (int [][] a,int [] p)
    {
        int rate=0;
        int [] array;
        for(int i=0;i<a.length;i++)
        {
            array=divideXOR(p,a[i]);
            for (int j=0;j<array.length;j++)
            {
                if (array[j]!= 0) 
                {
                    rate=rate+1;
                    break;
                }
            }
        }
        return (double)rate*100/100000;
    }
}
