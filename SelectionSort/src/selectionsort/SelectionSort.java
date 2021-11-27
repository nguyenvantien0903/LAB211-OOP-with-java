package selectionsort;

import java.util.Scanner;

/**
 * https://docs.google.com/document/d/1U8ZU_w6Oo5YHya4npUttsOvTbtfjjafu/edit
 * @author NVT
 */

public class SelectionSort {
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
        int n=inputInteger("Input size of array(positive):",1,Integer.MAX_VALUE);
        int[] a = new int[n+2];

        System.out.println("PLS input the array:");
        for(int i=1;i<=n;i++){
            a[i]=inputInteger("",Integer.MIN_VALUE,Integer.MAX_VALUE);
        }
        
        display(a,n,"Unsorted array: ");
        for(int i=1;i<n;i++){
            int index=i;
            for(int j=i+1;j<=n;j++){
                if(a[index]>a[j]){
                    index=j;
                }
            }
            if(i==index)continue;
            int temp=a[i];
            a[i]=a[index];
            a[index]=temp;
        }
        display(a,n,"Sorted array: ");
    }
    
}
