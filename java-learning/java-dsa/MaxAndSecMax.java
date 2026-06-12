public class MaxAndSecMax {
    public static void main(String[] args) {
        int[] arr = {10, 5};

        if (arr == null || arr.length < 2) {
            System.out.println("Second largest does not exist");
            return;
        }

        int max = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > max) {
                secMax = max;
                max = num;
            } else if (num > secMax && num != max) {
                secMax = num;
            }
        }

        System.out.println("Largest: " + max);

        if (secMax == Integer.MIN_VALUE) {
            System.out.println("No second distinct largest element");
        } else {
            System.out.println("Second Largest: " + secMax);
        }
    }
}