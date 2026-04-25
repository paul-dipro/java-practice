public class ReverseArrayTwoPointers {
    public static void reversedArray(int[] arr){

        int left =0;
        int right = arr.length - 1;

        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left ++;
            right --;
        }
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        reversedArray(arr);

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

    }
}