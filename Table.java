
public class Table {
    private char[][] gameTable;
    public Table() {
        this.gameTable = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    }
    public char[][] getGameTable() {
        return gameTable;
    }
    public void printTable(){
        System.out.println("_");
        for (int i = 0; i < gameTable.length; i++) {
            for (int j = 0; j < gameTable[i].length; j++) {
                if (j == 0) {
                    System.out.print("| " + gameTable[i][j]);
                } else if (j == 2) {
                    System.out.print(gameTable[i][j] + " |");
                } else {
                    System.out.print(" | " + gameTable[i][j] + " | ");
                }
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
}
