import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.*;

public class test {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        String line = "04:59:59AM";
        
        StringBuilder s = new StringBuilder();
        s.append(line.charAt(line.length() - 2));
        s.append(line.charAt(line.length() - 1));
        
        if(s.toString().equals("AM")) {
            if(line.substring(0, line.length() - 2).equals("12:00:00")) {
                System.out.println("00:00:00");
            } else {
                if(line.substring(0, 2).equals("12")) {
                    StringBuilder temp = new StringBuilder();
                    temp.append("00");
                    temp.append(line.substring(2, line.length() - 2));
                    System.out.println(temp.toString());
                } else {
                    System.out.println(line.substring(0, line.length() - 2));
                }
            }
        } else {
            if(line.substring(0, line.length() - 2).equals("12:00:00")) {
                System.out.println("12:00:00");
            } else {
                if(line.substring(0, 2).equals("12")) {
                    System.out.println(line.substring(0, line.length() - 2));
                } else {
                    StringBuilder temp1 = new StringBuilder();
                    temp1.append(line.charAt(0));
                    temp1.append(line.charAt(1));
                    
                    int hr = Integer.parseInt(temp1.toString());
                    hr += 12;
                   
                    StringBuilder temp2 = new StringBuilder();
                    temp2.append(hr + "");
                    for(int i = 2; i < line.length() - 2; i++) {
                        temp2.append(line.charAt(i));
                    }
                    System.out.println(temp2.toString());
                }
            }
        }
    }
}