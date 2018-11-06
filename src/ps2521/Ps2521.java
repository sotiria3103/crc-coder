
package ps2521;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Sotiria Antaranian
 */
public class Ps2521 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        int k=10;
        double rate,rateCRC;
        double e= 0.001;
        int [] P={1,1,0,1,0,1};
        CRC crc=new CRC();
        int [][] messages,messagesCRC,altered;
        
        messages=crc.makeMessages(k);
        messagesCRC=crc.makeCRC(messages, P);
        altered=crc.alternate(messagesCRC, e);
        
        rate=crc.check(altered,messagesCRC);
        rateCRC=crc.checkCRC(altered,P);
        
        System.out.println("The rate of errors:"+rate+" %");
        System.out.println("The rate of errors detected by CRC:"+rateCRC+" %");
        System.out.println("The rate of errors not detected by CRC:"+(rate-rateCRC)+" %");
        
        //System.out.println("Give P (the first and last bit must be 1, it can't be more than 8 bits and seperate every bit space):");
        /*Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNextInt())
        list.add(scanner.nextInt());
        int[] arr  = list.toArray(new int[0]);*/
        /*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        String[] arr=reader.readLine().split(" ");
        int[] intarr=new int[arr.length];
        for(int i=0;i<arr.length;i++)
        intarr[i]=Integer.parseInt(arr[i]);*/
        int [] P1={1,0,0,1,1,0,1};
        k=15;
        e=0.1;
        messages=crc.makeMessages(k);
        messagesCRC=crc.makeCRC(messages, P1);
        altered=crc.alternate(messagesCRC, e);
        
        rate=crc.check(altered,messagesCRC);
        rateCRC=crc.checkCRC(altered,P1);
        
        System.out.println("The rate of errors:"+rate+" %");
        System.out.println("The rate of errors detected by CRC:"+rateCRC+" %");
        System.out.println("The rate of errors not detected by CRC:"+(rate-rateCRC)+" %");
        
        int []P2={1,0,1,1,1,0,0,0,1};
        k=12;
        e=0.03;
        messages=crc.makeMessages(k);
        messagesCRC=crc.makeCRC(messages, P2);
        altered=crc.alternate(messagesCRC, e);
        
        rate=crc.check(altered,messagesCRC);
        rateCRC=crc.checkCRC(altered,P2);
        
        System.out.println("The rate of errors:"+rate+" %");
        System.out.println("The rate of errors detected by CRC:"+rateCRC+" %");
        System.out.println("The rate of errors not detected by CRC:"+(rate-rateCRC)+" %");
    }
    
}
