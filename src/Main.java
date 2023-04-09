import java.util.Arrays;
import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int[][] input = {{6,7,5},{1,8,2},{4,3,0}};
        solve(input);
    }

    private static void solve(int[][] input){
        int[][] result = {{1,2,3},{4,5,6},{7,8,0}};
        if (input.length != 3 && input[0].length != 3)
            throw new RuntimeException("Inccorect input");
        int[] check = new int[8];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                System.out.print(input[i][j] + "  ");
            }
            System.out.println();
        }
        for (int i = 0;i < input.length;i++){
            for (int j = 0;j < input[0].length;j++)
                if (input[i][j] != 0 && check[input[i][j] - 1]==0){
                    check[input[i][j] - 1] = 1;
                } else {
                    if(input[i][j] != 0)
                        throw new RuntimeException("Inccorect input");
                }
        }
        int xOfZero = 2;
        int yOfZero = 2;
        Random random = new Random();
        while (!Arrays.deepEquals(input, result)){
            int save;
            int direction = random.nextInt(4);
            if (direction == 0 && xOfZero - 1 != -1){
                save = input[yOfZero][xOfZero - 1];
                input[yOfZero][xOfZero] = save;
                input[yOfZero][xOfZero - 1] = 0;
                xOfZero -=1;
                System.out.println((xOfZero + 1) + "," + (yOfZero + 1) + " -> " + (xOfZero + 2) + "," + (yOfZero + 1));
                continue;
            }
            if (direction == 1 && xOfZero + 1 != 3){
                save = input[yOfZero][xOfZero + 1];
                input[yOfZero][xOfZero] = save;
                input[yOfZero][xOfZero + 1] = 0;
                xOfZero +=1;
                System.out.println((xOfZero + 1) + "," + (yOfZero + 1) + " -> " + (xOfZero) + "," + (yOfZero + 1));
                continue;
            }
            if (direction == 2 && yOfZero - 1 != -1){
                save = input[yOfZero- 1][xOfZero];
                input[yOfZero][xOfZero] = save;
                input[yOfZero - 1][xOfZero] = 0;
                yOfZero -=1;
                System.out.println((xOfZero + 1) + "," + (yOfZero + 1) + " -> " + (xOfZero + 1) + "," + (yOfZero + 2));
                continue;
            }
            if (direction == 3 && yOfZero + 1 != 3){
                save = input[yOfZero + 1][xOfZero];
                input[yOfZero][xOfZero] = save;
                input[yOfZero + 1][xOfZero] = 0;
                yOfZero +=1;
                System.out.println((xOfZero + 1) + "," + (yOfZero + 1) + " -> " + (xOfZero + 1) + "," + yOfZero);
            }
        }
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                System.out.print(input[i][j] + "  ");
            }
            System.out.println();
        }
    }
}