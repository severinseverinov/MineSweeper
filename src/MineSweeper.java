import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    int rowNumber, colNumber,size;
    String[][] map;
    static String [][] board;
    boolean gameCheck=true;

    Random random = new Random();
    Scanner input = new Scanner(System.in);

    MineSweeper(int rowNumber, int colNumber){

        this.rowNumber= rowNumber;
        this.colNumber=colNumber;
        this.map= new String [rowNumber][colNumber];
        this.board= new String [rowNumber][colNumber];
        this.size= (rowNumber*colNumber);
    }

    public void run() {

        int userRowNumber, userColNumber;
        int counter=0;

        prep();
        //System.out.println("Mayınların Konumu");
        //print(map);
        System.out.println("--------------");
        System.out.println(" Oyun Tahtası aşağıdaki gibidir. İyi Şanslar!");
        print(board);

        while (gameCheck) {
            System.out.print("Satırı giriniz : ");
            userRowNumber=input.nextInt();
            userRowNumber--;
            System.out.print("Sütunu giriniz : ");
            userColNumber=input.nextInt();
            userColNumber--;

            if(userRowNumber<0 || userRowNumber>= rowNumber){ //Kullanıcının girdiği sayıların kontrolü
                System.out.println(" Geçersiz bir sayı girdiniz !");
                continue;
            }
            if(userColNumber<0 || userColNumber>= colNumber){
                System.out.println(" Geçersiz bir sayı girdiniz !");
                continue;
            }

            if(map[userRowNumber][userColNumber] != "*"){
                mineCheck(userRowNumber, userColNumber);
                counter++;
                if(counter == (size - (size/4))){
                    System.out.println("Tebrikler KAZANDINIZ !!!");
                    break;
                }
            }else{
                gameCheck=false;
                System.out.println("  ");
                System.out.println("BOOOOM ");
                System.out.println("Üzgünüm Kaybettiniz ! ");
            }
        }
    }

    public void prep(){ // Mayınların haritaya rastgele yerleştirilmesi
        int prepRow, prepCol, counter=0;
        while(counter != (size/4)){
            prepRow=random.nextInt(rowNumber);
            prepCol=random.nextInt(colNumber);
            if(map[prepRow][prepCol] != "*"){
                map[prepRow][prepCol] = "*";
                counter++;
            }
        }
    }

    public static void print(String[][] dizi){ // haritayı ve mayınlı haritayı bastıran kısım

        for (int i=0; i<dizi.length;i++){
            for(int j=0; j< dizi[0].length;j++){
                if(dizi[i][j]== null)
                    dizi[i][j]="-";
                System.out.print(dizi[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void mineCheck(int r, int c){ // Girilen koordinatın yanındaki hücrelerdeki mayın sayısı
        int n=0;
        if(map[r][c]== "-"){

            if (r - 1 >= 0) {
                if (map[r - 1][c].equals("*")) {
                    n++;
                }
            }
            if (r - 1 >= 0 && c - 1 >= 0) {
                if (map[r - 1][c - 1].equals("*")) {
                    n++;
                }
            }
            if (c - 1 >= 0) {
                if (map[r][c - 1].equals("*")) {
                    n++;
                }
            }
            if (c + 1 < colNumber) {
                if (map[r][c + 1].equals("*")) {
                    n++;
                }
            }
            if (c + 1 < colNumber && r + 1 < rowNumber) {
                if (map[r + 1][c + 1].equals("*")) {
                    n++;
                }
            }
            if (r + 1 < rowNumber) {
                if (map[r + 1][c].equals("*")) {
                    n++;
                }
            }
            if (r - 1 >= 0 && c + 1 < colNumber) {
                if (map[r - 1][c + 1].equals("*")) {
                    n++;
                }
            }
            if (r + 1 < rowNumber && c - 1 >= 0) {
                if (map[r + 1][c - 1].equals("*")) {
                    n++;
                }
            }
            board[r][c]=String.valueOf(n);
        }
        print(board);
    }
}
