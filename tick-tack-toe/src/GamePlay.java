public class GamePlay {
    Scan scan;
    Field field;

    GamePlay(Scan scan, Field field) {
        this.scan = scan;
        this.field = field;
    }
    void StartHumanGame() {
            System.out.println("Start!");
            System.out.println("enter two coordinates separated by space");
            field.printField();
            int count=0;
        while (true) {
            FirstPlayer();
            field.printField();
            if(field.checkField('0')) {
                System.out.println("Player 1 win");
                return;
            }
            count++;
            if(count==field.rows*field.columns) {
                System.out.println("Draw...");
                return;
            }
            SecondPlayer();
            if(field.checkField('X')) {
                System.out.println("Player 2 win");
                return;
            }
            field.printField();
            count++;
        }
    }
    void StartGameWithBot(){
        Bot_logic bot_logic= new Bot_logic(field);
        System.out.println("Start");
        System.out.println("Bot move first");
        bot_logic.TakeBotShot();
        System.out.println("enter two coordinates separated by space");
        int count=1;
        while (true)
        {
            FirstPlayer();
            if(field.checkField('0')) {
                System.out.println("Player win");
                return;
            }
            count++;

            bot_logic.TakeBotShot();
            if(field.checkField('X')) {
                System.out.println("bot win");
                return;
            }
            count++;
            if(count==field.rows*field.columns) {
            System.out.println("Draw...");
            return;
        }
        }
        }

    void FirstPlayer() {
        System.out.println("Player, your turn");
        int shot[] = scan.takeShot();
        if (!field.pastZero(shot))
         FirstPlayer();
    }

    void SecondPlayer() {
        System.out.println("Player 2, your turn");
        int shot[] = scan.takeShot();
        if (!field.pastCross(shot)) {
            System.out.println("this move is already done, please, try again!");
            SecondPlayer();
        }
    }
}

