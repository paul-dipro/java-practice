public class Matrix {
    public static void main(String[] args) {

        int[][] grid = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        for(int i = 0; i < grid.length; i++){
            System.out.println(grid[i][(grid.length - 1) - i]);

    }
        }
}