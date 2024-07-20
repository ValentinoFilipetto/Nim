import java.util.Scanner;
import java.util.HashMap;

public class Main {
    HashMap<String, Integer> myMap = new HashMap<>();

    boolean gameContinues(HashMap<String, Integer> map) {
        Integer sum = 0;

        for (String key : map.keySet()) {
            sum += map.get(key);
        }

        /* Game ends when there is only one object to be picked. */
        return sum != 1;
    }

    String displayAsStars(Integer num) {
        StringBuilder amountAsStars = new StringBuilder();

        for (int i = 0; i < num; ++i) {
            amountAsStars.append("*");
        }

        return amountAsStars.toString();
    }


    HashMap<String, Integer> decreasePile(HashMap<String, Integer> map, String pile, Integer amountChosen) {
        if (amountChosen > map.get((pile))) {
            System.out.printf("Pile %s doesn't have that many. Try again", pile);
            return map;
        }

        if (map.containsKey(pile) && map.get(pile) != 0) {
            map.compute(pile, (_, amount) -> amount - amountChosen);
            return map;
        } else {
            System.out.println("You didn't select an existing pile, or the pile you picked is empty");
        }


        return map;
    }


    public static void main(String[] args) {
        Main mainClass = new Main();

        mainClass.myMap.put("A", 3);
        mainClass.myMap.put("B", 4);
        mainClass.myMap.put("C", 5);

        Scanner names = new Scanner(System.in);
        Scanner pileChosen = new Scanner(System.in);
        Scanner amountChosen = new Scanner(System.in);

        System.out.println("Player 1, enter your name:");
        String namePlayer1 = names.nextLine();

        System.out.println("Player 2, enter your name:");
        String namePlayer2 = names.nextLine();

        String currentPlayer = namePlayer1;

        while (mainClass.gameContinues(mainClass.myMap)) {

            System.out.printf("A: %s\nB: %s\nC: %s\n",
                    mainClass.displayAsStars(mainClass.myMap.get("A")),
                    mainClass.displayAsStars(mainClass.myMap.get("B")),
                    mainClass.displayAsStars(mainClass.myMap.get("C")));
            System.out.printf("%s, choose a pile: ", currentPlayer);
            String pile = pileChosen.nextLine();

            System.out.printf("How many to remove from pile %s?: ", pile);
            int amount = amountChosen.nextInt();

            if (amount == 0) {
                System.out.println("You must remove at least one!");
            } else {
                mainClass.myMap = mainClass.decreasePile(mainClass.myMap, pile, amount);
            }


            if (currentPlayer.equals(namePlayer1)) {
                currentPlayer = namePlayer2;
            } else {
                currentPlayer = namePlayer1;
            }
        }


    }
}