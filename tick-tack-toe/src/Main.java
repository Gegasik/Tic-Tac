// Я хуожник, Я вижу так
public class Main {

    public static void main(String[] args) {
        Menu();
    }

    static void Menu() {
        System.out.println("choose mode:");
        System.out.println("1. 1 VS bot");
        System.out.println("2. 1 VS 1");
        System.out.println("else: exit");
        Field field = new Field();
        Scan scan = new Scan(field.rows, field.columns);
        int choice = scan.takeNumber();

        switch (choice) {
            case 1:{GamePlay humanPlayer= new GamePlay(scan,field);
            humanPlayer.StartGameWithBot();}
                break;
            case 2:
                GamePlay humanPlayer = new GamePlay(scan, field);
                humanPlayer.StartHumanGame();
                break;
            default:
                return;
        }
        Menu();
    }

}