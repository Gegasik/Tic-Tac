import java.util.InputMismatchException;
import java.util.Scanner;
public class Scan {
    int choice;
    int rows;
    int columns;
    int shot[] = new int[2];
    Scanner sc;
    Scan(int rows, int columns){
        this.rows=rows;
        this.columns= columns;
        sc= new Scanner(System.in);
    }
    int takeNumber() {
        try {
            choice = sc.nextInt();
            return choice;
        } catch (InputMismatchException e) {
            sc.close();
            System.out.println("incorrect symbol, please try again");
            sc= new Scanner(System.in);
            choice=0;
            takeNumber();

        }
        return choice;
    }
    int[] takeShot(){
        try {
            shot[1] = sc.nextInt() - 1;
            shot[0] = sc.nextInt() - 1;
            if (shot[0]> rows || shot[1]> rows )
                throw new InputMismatchException();

            }
            catch (InputMismatchException e){
                sc.close();
                System.out.println("incorrect symbol or number of field, please try again");
                sc= new Scanner(System.in);
                takeShot();
            }
        return shot;
        }
 }
