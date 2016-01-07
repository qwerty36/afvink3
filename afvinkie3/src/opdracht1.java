/**
 * Created by rich_ on 1/2/2016.
 */
import java.util.*;

public class opdracht1 {
    public static void main(String[] args) {
        Stack meh = new Stack();
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter Code you Scrub! \n");
        String a = reader.next();
        int l = a.length();
        int j = 0;
        int rondehaak = 0;
        int hoekshit = 0;
        int acculadeshit = 0;
        for (int i = 0; i < l; i++) {
            j++;
            if (a.substring(i, j).equals("(")) {
                rondehaak++;
            }
            if (a.substring(i, j).equals(")")) {
                rondehaak--;
            }
            if (a.substring(i, j).equals("[")) {
                hoekshit++;
            }
            if (a.substring(i, j).equals("]")) {
                hoekshit--;
            }
            if (a.substring(i, j).equals("{")) {
                acculadeshit++;
            }
            if (a.substring(i, j).equals("}")) {
                acculadeshit--;
            }

        }
        if (rondehaak < 0){
            meh.push(" Te veel ')' ");
        }
        if (rondehaak > 0){
            meh.push(" Te veel '(' ");
        }
        if (hoekshit < 0){
            meh.push(" Te veel ']' ");
        }
        if (hoekshit > 0){
            meh.push(" Te veel '[' ");
        }
        if (acculadeshit < 0){
            meh.push(" Te veel '}' ");
        }
        if (acculadeshit > 0){
            meh.push(" Te veel '{' ");
        }
        System.out.println(meh);

    }
}
