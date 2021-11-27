package fromcounts;

/**
 * https://docs.google.com/document/d/19Q_YCd0VTNUCfPuoiMcbuME30AX7M9Mo/edit
 * @author NVT H211
 */
public class FromCounts {
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
                if(this.elementData[i]<0){
                    System.out.println("Invalid number");
                    System.exit(0);
                }
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
        int[] a = new int[]{2, 2, 2, -5, 4, 3, 2, 4, 1, 1, 1, 0, 2, 17};
        ArrayIntList list= new ArrayIntList(a);
        ArrayIntList list2 = list.fromCounts();
        display(list2,list2.size,"new array:");
    }
    
}
