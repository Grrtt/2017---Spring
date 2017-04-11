/*
 The split method in the String class return an array of strings consisting 
of the substrings split by the delimiters. However, the delimiters are not 
returned. Implement the following new method that returns an array of strings 
split by the matching delimiters, including the matching delimiters.

public static String[] split(String s, String regex)

For example, split(“ab#12#453”, “[?#]”)

returns a, b, ?, gf, #, and e in an array of Strings

********* Sample run************

a
?
b
?
gf
#
e
 */
package assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.*;

/**
 *
 * @author Garrett Shepherd
 */
public class Assignment8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s = "ab#12#453";
        String[] result = Split(s, "[?#]");
        System.out.println(Arrays.toString(result));
    }
    
    private static String[] Split(String s, String regex){
        ArrayList splitString = new ArrayList();
        for(String x : s.split(regex)){
            splitString.add(x);
        }
        
        ArrayList completedList = new ArrayList();
        
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        
        int count = 0;
        m.find();
        do{
            completedList.add(splitString.toArray()[count]);
            count++;
            completedList.add(m.group());
        }while(m.find());
        completedList.add(splitString.toArray()[count]);
        
        String[] stringArray = new String[completedList.size()];
        
        count = 0;
        for(Object element : completedList){
            stringArray[count] = (String) element;
            count++;
        }
        
        return stringArray;
    }
}
