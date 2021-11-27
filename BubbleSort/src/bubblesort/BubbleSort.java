package bubblesort;

import java.util.Scanner;

/**
 * https://docs.google.com/document/d/1QwNblix1Ol68pMJYObGyZGMQ2wrUz-nI/edit
 * @author NVT
 */
public class BubbleSort {
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
    
    public static void display(int a[],int n,String mess){
        System.out.print(mess);
        System.out.print("[");
        for(int i=1;i<=n;i++){
            if(i==n)
                System.out.print(a[i]);
            else 
                System.out.print(a[i]+", ");
        }
        System.out.println("]");
    }
    
    public static Integer inputInteger(String mess,int min,int max){
        while(true){
            if(!"".equals(mess))System.out.println(mess);
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
    
    public static void main(String[] args) {
        int n;
        n=inputInteger("Input size of array(positive):",1,Integer.MAX_VALUE);
        int[] a = new int[n+2];

        for(int i=1;i<=n;i++){
            a[i]=(int)Math.floor(Math.random()*n+1);
        }
        
        display(a,n,"Unsorted array: ");
        for(int i=1;i<n;i++){
            for(int j=n;j>i;j--){
                if(a[j-1]>a[j]){
                    int temp=a[j];
                    a[j]=a[j-1];
                    a[j-1]=temp;
                }
            }
        }
//        1 9 2 4 8 10
//        1 9 2 4 8 10
//        1 2 9 4 8 10
//        1 2 4 9 8 10 
//        1 2 4 8 9 10
        display(a,n,"Sorted array: ");
    }
    
}
