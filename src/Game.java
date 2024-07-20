import java.util.HashMap;

public class Game {
    HashMap<String, Integer> myMap = new HashMap<>();

    public Game(int A, int B, int C) {
        myMap.put("A", A);
        myMap.put("B", B);
        myMap.put("C", C);
    }

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


}
