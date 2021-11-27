package flip;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://docs.google.com/document/d/1tqKjOe_0Btw2X6q2ZBt4duiuTtd6aeHF/edit
 * @author NVT
 */
public class Flip {
    public static void flipLines(Scanner fileScan){
        List<String> dic = new ArrayList<String>();
        while (fileScan.hasNext()) {
            dic.add(fileScan.nextLine());
        }
        fileScan.close();
        for(int i=0;i<dic.size();i+=2){
            if(i+1<dic.size())System.out.println(dic.get(i+1));
            System.out.println(dic.get(i));
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        File file = new File("words.txt");
        if(!file.exists()){
            System.out.println("File not exist!");
            return;
        }
        flipLines(new Scanner(file));
    }
    
}
