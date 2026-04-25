public class CountEven {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 6, 9, 8, 3, 7};
        int evenCount = 0;

        for(int num : arr) {
            if (num % 2 == 0) {
                ++evenCount;
            }
        }

        System.out.println(evenCount);
    }
}
