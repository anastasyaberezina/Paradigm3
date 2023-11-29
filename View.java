import java.util.Scanner;
public class View {
    private static final Scanner scan = new Scanner(System.in);
    Table table = new Table();
    Player playerOne = new Player("G1", 'X');
    Player playerTwo = new Player("G2", 'O');
    Input input = new Input(playerOne, playerTwo, table);
    public void game() {
        System.out.print("Введите имя первого игрока: ");
        playerOne.setName(scan.nextLine());
        System.out.print("Введите имя второго игрока: ");
        playerTwo.setName(scan.nextLine());
        while (true) {
            input.makeMove(playerOne);
            if (input.checkWin(playerOne)) {
                table.printTable();
                return;
            }
            input.makeMove(playerTwo);
            if (input.checkWin(playerTwo)) {
                table.printTable();
                return;
            }
        }
    }
}
