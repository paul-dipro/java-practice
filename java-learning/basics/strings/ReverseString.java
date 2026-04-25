import java.util.Arrays;

public class ReverseString {

    public void reverseString(char[] s) {

        int left = 0;
        int right = s.length - 1;

        while (left < right) {

            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {

        char[] arr = {'g','i','t','h','u', 'b'};

        ReverseString obj = new ReverseString();
        obj.reverseString(arr);

        System.out.println(Arrays.toString(arr));
    }
}