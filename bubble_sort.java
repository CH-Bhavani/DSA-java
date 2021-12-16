/* to implement bubble sort algorithm*/
public class bubblesort {
    public static void main(String[] args) {
        int[] arr = {20, 35, -15, 7, 55, 1, -22};
        for (int lastunsortedindex = arr.length-1; lastunsortedindex > 0; lastunsortedindex--) {
            for (int i = 0; i < lastunsortedindex; i++) {
                if (arr[i] > arr[i + 1])
                    swap(arr, i, i + 1);
            }
        }
        for (int ele: arr) {
            System.out.println(ele);

        }
    }
        public static  void swap(int[] array,int i,int j){
            if(i==j)
                return;
            int temp;
            temp=array[i];
            array[i]=array[j];
            array[j]=temp;
        }
    }
