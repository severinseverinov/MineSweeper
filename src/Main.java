import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int rowNumber , colNumber;

        System.out.println("Lütfen oyun alanının boyutunu giriniz ! ");
        System.out.print("Satır sayısı : ");
        rowNumber = input.nextInt();
        System.out.print("Sütun sayısı : ");
        colNumber = input.nextInt();

        MineSweeper mine = new MineSweeper(rowNumber,colNumber);
        mine.run();
    }
}
