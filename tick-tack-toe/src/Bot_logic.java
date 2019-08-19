public class Bot_logic {
    Field field;
    static int Count_move_To_win=0;
    static int randomMove;
        int [][][]Number_wins_combinations= {{{0,0},{0,1},{0,2}},{{1,0},{1,1},{1,2}},{{2,0},{2,1},{2,2}},{{0,0},{1,0},{2,0}},{{0,1},{1,1},{2,1}},{{0,2},{1,2},{2,2}},{{0,0},{1,1},{2,2}},{{0,2},{1,1},{2,0}}};
    Bot_logic(Field field){
        this.field= field;
        randomMove=(int)(Math.random()*8);
Count_move_To_win=0;
    }
    void TakeBotShot() {
        if (Count_move_To_win <= 2) {
           if (field.pastCross(Number_wins_combinations[randomMove][Count_move_To_win]))
           {Count_move_To_win++;
           field.printField();
           return;
           }
        }
        if (CheckEnemyWinDangerous('X')||CheckEnemyWinDangerous('0'))
        {
            field.printField();
            return;
        }
        Random();
        field.printField();
        }
    boolean CheckEnemyWinDangerous(char symbol){
        int dangerous_area=field.CheckDangerous(Number_wins_combinations,symbol);
        if(dangerous_area!=-1)
        {
            for(int i=0;i<field.rows;i++)
            {
                if(field.pastCross(Number_wins_combinations[dangerous_area][i]))
                    return true;
            }
        }
        return false;
    }
    void Random(){
        int row=(int)(Math.random()*3);
        int column=(int)(Math.random()*3);
        int[] randomMov= {row,column};
        if(field.pastCross(randomMov))
            return;
            else Random();
    }
}
