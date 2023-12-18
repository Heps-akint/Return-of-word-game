
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hephzibahakintunde
 */
public class wordGame {
    
    public static void main(String[] args){
        gameStart();
    }

    static void gameStart() {

        boolean outcome = false;

        ArrayList<String> words = new ArrayList<>();
        words.add("mango");
        System.out.println("Word Game started with " + words.get(0));

        while (outcome == false) {

            Scanner userword = new Scanner(System.in);
            System.out.println("Enter a word (caseSensitive) to play the game, such as \norane->energy->your...: ");
            while (!userword.hasNext("[A-Za-z]+")) {
                System.out.println("Entered word is invalid, please try again.");
                userword.next();
            }

            String inputword = userword.next();
            String[] wordz = inputword.split(" ");
            String lastElement = words.get(words.size() - 1);
            char lastCharacter = lastElement.charAt(lastElement.length() - 1);

            if (inputword.isEmpty()) {
                System.out.println("Nothing was entered, Game restarted.");
                userword.close();
                return;
            }

            for (String word : wordz) {
                word = word.toLowerCase();
                char firstcharacter = word.charAt(0);
                boolean compare = firstcharacter == lastCharacter;
                int index = words.indexOf(word);
                if (index == -1 && compare == true) {
                    words.add(word);
                    System.out.println(words);
                } else {
                    outcome = true;
                }
            }

        }

        if (outcome == true) {
            System.out.println("Game over");
        }
    }

    static void gameRestart() {
        System.out.println("Game Restarted");
        gameStart();
    }

}
