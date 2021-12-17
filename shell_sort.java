/* to implement shell sort*/


public class shellsort {
    public static void main(String[] args) {
        int[] arr = { 20, 35, -15, 7, 55, 1, -22 };
        for(int gap= arr.length/2;gap>0;gap/=2){
            for(int i=gap;i<arr.length;i++) {
                int newele = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > newele) {
                    arr[j] = arr[j - gap];
                    j-=gap;
                }
                arr[j] = newele;
            }
        }
        for(int ele:arr){
            System.out.println(ele);
        }
    }
}
