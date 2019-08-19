public class Field {
    public final int rows;
    public final int columns;
    public char FIELD[][];

    Field() {
        this.rows = this.columns = 3;
        FIELD = new char[rows][columns];
        fillingField(this.rows, this.columns);
    }

    Field(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        FIELD = new char[rows][columns];
        fillingField(this.rows, this.columns);
    }

    public void printField() {
        for (int i = 0; i <= rows; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.print((i + 1) + " ");

            for (int j = 0; j <  rows; j++) {
                if (FIELD[i][j] == 0)
                    System.out.print("?" + " ");
                else System.out.print(FIELD[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void fillingField(int rows, int columns) {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                FIELD[i][j] = '?';
    }

public int CheckDangerous(int [][][] area, char symbol){
        for(int i=0;i<area.length;i++)
            for(int j=0;j<area[i].length;j++)
            {
                if(((FIELD[area[i][0][0]][area[i][0][1]]==FIELD[area[i][1][0]][area[i][1][1]])&&FIELD[area[i][0][0]][area[i][0][1]]==symbol) || ((FIELD[area[i][1][0]][area[i][1][1]]==FIELD[area[i][2][0]][area[i][2][1]])&&FIELD[area[i][2][0]][area[i][2][1]]==symbol) ||((FIELD[area[i][0][0]][area[i][0][1]]==FIELD[area[i][2][0]][area[i][2][1]])&&symbol==FIELD[area[i][2][0]][area[i][2][1]]))
                {
                    return i;
                }
            }
        return -1;
}
    public boolean pastZero(int[] shot) {
        if (FIELD[shot[0]][shot[1]] == '?') {
            FIELD[shot[0]][shot[1]] = '0';
            return true;
        } else {
            System.out.println("this move is already done, please, try again!");
            return false;
        }
    }

    public boolean pastCross(int[] shot) {
        if (FIELD[shot[0]][shot[1]] == '?') {
            FIELD[shot[0]][shot[1]] = 'X';
            return true;
        } else
            return false;
    }


    public boolean checkField(char symbol) {
        if(Diagonally(FIELD, rows-1, symbol))
            return true;
        for (int i = 0; i < rows; i++)
            if (Horizontally(FIELD[i], rows-1, symbol) || Vertically(FIELD, i,rows-1, symbol))
                return true;
            return false;
    }

    boolean Horizontally(char mas[], int length_of_rows, char symbol) {
        for (int i = 0; i <= length_of_rows; i++) {
            if (mas[i] == symbol)
                continue;
            else return false;
        }
        return true;
    }

    boolean Vertically(char mas[][], int number_of_rows,int length_of_rows, char symbol) {
        for (int i = 0; i <= length_of_rows; i++) {
            if (mas[i][number_of_rows] == symbol)
                continue;
            else return false;
        }
        return true;
    }
    boolean Diagonally(char mas[][],int Length, char symbol)
    {for(int i=0;i<=Length;i++)
        if(mas[i][i]==symbol)
            continue;
        else {
            for (int j = 0; j <= Length; j++)
            {if(mas[j][Length-j]!=symbol)
                return false;
            }
        }
        return true;
    }
}
