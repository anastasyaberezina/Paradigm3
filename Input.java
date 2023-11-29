import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    private static Scanner scan;
    Table table;
    Player player1;
    Player player2;

    public Input(Player gamer1, Player player2, Table table) {
        scan = new Scanner(System.in);
        this.table = table;
        this.player1 = new Player("PlayerOne", 'X');
        this.player2 = new Player("PlayerTwo", 'O');
    }

    public void makeMove(Player player) {
        table.printTable();
        int a = 0;
        int b = 0;
        System.out.println("Ход игрока " + player.getName());
        System.out.print("Укажите номер строки: ");
        if (scan.hasNextInt()) {
            a = scan.nextInt();
        } else {
            throw new InputMismatchException("Не корректный ввод");
        }
        System.out.print("Укажите номер столбца: ");
        if (scan.hasNextInt()) {
            b = scan.nextInt();
        } else {
            throw new InputMismatchException("Не корректный ввод");
        }
        if (a > 0 && a < 4 && b > 0 && b < 4) {
            if (table.getGameTable()[a - 1][b - 1] == ' ') {
                table.getGameTable()[a - 1][b - 1] = player.getSymbol();
            } else {
                System.out.println("Поле занято");
                makeMove(player);
            }
        } else {
            makeMove(player);
        }
    }

    public boolean checkWin(Player player) {
        boolean win = false;
        if (table.getGameTable()[0][0] == player.getSymbol() &&
                table.getGameTable()[0][1] == player.getSymbol() &&
                table.getGameTable()[0][2] == player.getSymbol()) {
            win = true;
        }
        if (table.getGameTable()[1][0] == player.getSymbol() &&
                table.getGameTable()[1][1] == player.getSymbol() &&
                table.getGameTable()[1][2] == player.getSymbol()) {
            win = true;
        }
        if (table.getGameTable()[2][0] == player.getSymbol() &&
                table.getGameTable()[2][1] == player.getSymbol() &&
                table.getGameTable()[2][2] == player.getSymbol()) {
            win = true;
        }
        if (table.getGameTable()[0][0] == player.getSymbol() &&
                table.getGameTable()[1][0] == player.getSymbol() &&
                table.getGameTable()[2][0] == player.getSymbol()) {
            win = true;
        }
        if (table.getGameTable()[0][1] == player.getSymbol() &&
                table.getGameTable()[1][1] == player.getSymbol() &&
                table.getGameTable()[2][1] == player.getSymbol()) {
            win = true;
        }
        if (table.getGameTable()[0][2] == player.getSymbol() &&
                table.getGameTable()[1][2] == player.getSymbol() &&
                table.getGameTable()[2][2] == player.getSymbol()) {
            win = true;
        }
        if (table.getGameTable()[0][0] == player.getSymbol() &&
                table.getGameTable()[1][1] == player.getSymbol() &&
                table.getGameTable()[2][2] == player.getSymbol()) {
            win = true;
        }
        if (table.getGameTable()[2][0] == player.getSymbol() &&
                table.getGameTable()[1][1] == player.getSymbol() &&
                table.getGameTable()[0][2] == player.getSymbol()) {
            win = true;
        }
        if (win == true) {
            System.out.println("Победил игрок " + player.getName());
            return true;
        } else if (checkDraw(table)) {
            System.out.println("Ничья");
            return true;
        } else {
            return false;
        }
    }

    public boolean checkDraw(Table table) {
        for (int i = 0; i < table.getGameTable().length; i++) {
            for (int j = 0; j < table.getGameTable()[i].length; j++) {
                if (table.getGameTable()[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}