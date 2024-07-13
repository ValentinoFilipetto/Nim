import java.util.Scanner;
import java.util.HashMap;

public class Main {
    HashMap<String, Integer> myMap = new HashMap<>();

    boolean gameContinues(HashMap<String, Integer> map) {
        return !map.containsValue(0);
    }

    ;

    String displayAsStars(Integer num) {
        String amountAsStars = "";

        for (int i = 0; i <= num; ++i) {
            amountAsStars = amountAsStars + "*";
        }

        return amountAsStars;
    }

    ;

    HashMap<String, Integer> decreasePile(HashMap<String, Integer> map, String pile) {
        if (map.containsKey(pile)) {
            int amount = map.get(pile);
            map.put(pile, amount - 1);
            return map;
        } else {
            System.out.println("You didn't select an existing pile");
        }
        ;

        return map;
    }

    ;

    public static void main(String[] args) {
        Main mainClass = new Main();

        mainClass.myMap.put("A", 3);
        mainClass.myMap.put("B", 4);
        mainClass.myMap.put("C", 5);

        Scanner names = new Scanner(System.in);
        Scanner pileChosen = new Scanner(System.in);

        System.out.println("Player 1, enter your name:");
        String namePlayer1 = names.nextLine();

        System.out.println("Player 2, enter your name:");
        String namePlayer2 = names.nextLine();

        String currentPlayer = namePlayer1;

        while (mainClass.gameContinues(mainClass.myMap)) {

            System.out.printf("A: %s\nB: %s\nC: %s\n", mainClass.displayAsStars(mainClass.myMap.get("A")), mainClass.displayAsStars(mainClass.myMap.get("B")), mainClass.displayAsStars(mainClass.myMap.get("C")));
            System.out.printf("%s, choose a pile: ", currentPlayer);
            String pile = pileChosen.nextLine();

            mainClass.myMap = mainClass.decreasePile(mainClass.myMap, pile);

            if (currentPlayer.equals(namePlayer1)) {
                currentPlayer = namePlayer2;
            } else {
                currentPlayer = namePlayer1;
            }
        }


    }
}