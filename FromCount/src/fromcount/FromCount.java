package fromcount;

import java.util.Scanner;

/**
 * https://docs.google.com/document/d/19Q_YCd0VTNUCfPuoiMcbuME30AX7M9Mo/edit
 * @author NVT H211
 */
public class FromCount {
    static Scanner sc = new Scanner(System.in);
    
    public static boolean isNumeric(String string) {
        if(string == null || string.equals("")) {
            System.out.println("String cannot be parsed, it is null or empty.");
            return false;
        }
        try {
            int intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Input String cannot be parsed to Integer.");
        }
        return false;
    }
    
    public static Integer inputInteger(String mess,int min,int max){
        while(true){
            System.out.println(mess);
            String input=sc.nextLine().trim();
            if(isNumeric(input)==true){
                Integer res=Integer.parseInt(input);
                if(res<min||res>max){
                    System.out.println("Out of intervel! ");
                    continue;
                }
                return res;
            }
        }
    }
    
    public static void display(ArrayIntList a,int n,String mess){
        System.out.print(mess);
        System.out.print("[");
        for(int i=0;i<n;i++){
            if(i==n-1)
                System.out.print(a.elementData[i]);
            else 
                System.out.print(a.elementData[i]+", ");
        }
        System.out.println("]");
    }
    
    public static class ArrayIntList {
        private int[] elementData;
        private int size;
        
        public ArrayIntList(int size){
            elementData=new int[size];
            this.size=size;
        }
        
        public ArrayIntList(int[] a){
            this.elementData = a;
            this.size=a.length;
        }
        
        public ArrayIntList fromCounts(){
            int newSize=0;
            for(int i=0;i<size;i+=2){
                newSize+=this.elementData[i];
            }
            if(newSize>1000000000){
                System.out.println("Array too large!");
                System.exit(0);
            }
            ArrayIntList res=new ArrayIntList(newSize);
            int cnt=0;
            for(int i=0;i<size;i+=2){
                int amount=this.elementData[i];
                int value=this.elementData[i+1];
                for(int j=1;j<=amount;j++){
                    res.elementData[cnt]=value;
                    cnt++;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int n=inputInteger("Input the size of array:",1,Integer.MAX_VALUE);
        if(n%2==1){
            System.out.println("Size must be even!");
            return;
        }
        int[] a = new int[n+2];
        for(int i=0;i<n;i++){
            if(i%2==0)a[i]=inputInteger("",0,Integer.MAX_VALUE);
            else a[i]=inputInteger("",Integer.MIN_VALUE,Integer.MAX_VALUE);
        }
        ArrayIntList list= new ArrayIntList(a);
        ArrayIntList list2 = list.fromCounts();
        display(list2,list2.size,"new array:");
    }
    
}
