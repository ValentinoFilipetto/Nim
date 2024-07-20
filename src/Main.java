import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Game game = new Game(3, 4, 5);

        Scanner names = new Scanner(System.in);
        Scanner pileChosen = new Scanner(System.in);
        Scanner amountChosen = new Scanner(System.in);

        System.out.println("Player 1, enter your name:");
        String namePlayer1 = names.nextLine();

        System.out.println("Player 2, enter your name:");
        String namePlayer2 = names.nextLine();

        String currentPlayer = namePlayer1;

        while (game.gameContinues(game.myMap)) {

            System.out.printf("A: %s\nB: %s\nC: %s\n",
                    game.displayAsStars(game.myMap.get("A")),
                    game.displayAsStars(game.myMap.get("B")),
                    game.displayAsStars(game.myMap.get("C")));
            System.out.printf("%s, choose a pile: ", currentPlayer);
            String pile = pileChosen.nextLine();

            System.out.printf("How many to remove from pile %s?: ", pile);
            int amount = amountChosen.nextInt();

            if (amount == 0) {
                System.out.println("You must remove at least one!");
            } else {
                game.myMap = game.decreasePile(game.myMap, pile, amount);
            }

            if (currentPlayer.equals(namePlayer1)) {
                currentPlayer = namePlayer2;
            } else {
                currentPlayer = namePlayer1;
            }
        }


    }
}