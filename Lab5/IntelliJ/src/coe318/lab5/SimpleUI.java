package coe318.lab5;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Scanner;

public class SimpleUI implements UserInterface {
    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);
    private Boolean gameEnd = false;

    @Override
    public void setGame(BlackjackGame game) {
        this.game = game;
    }

    @Override
    public void display() {
        System.out.println("House:" + System.lineSeparator() + game.getHouseCards().toString());
        System.out.println("You:" + System.lineSeparator() + game.getYourCards().toString());
    }

    @Override
    public boolean hitMe() {
        System.out.println("Would you like a card? (y/n)");
        String in = user.nextLine().toLowerCase();
        if (in.equals("n"))
            return false;
        else if (in.equals("y"))
            return true;
        else
            return hitMe();
    }

    @Override
    public void gameOver() {
        for (Card c : game.getHouseCards().getCards())
            c.setFaceUp(true);

        display();
        int houseScore = game.getHouseScore();
        int userScore = game.getUserScore();
        boolean winner = false;

        if(houseScore >= userScore) {
            if (houseScore > 21 && userScore > 21)
                winner = false;
            else if (houseScore > 21 && userScore <= 21)
                winner = true;
            else
                winner = false;
        }
        else {
            if (houseScore >= 21 && userScore > 21)
                winner = false;
            else if(houseScore <= 21 && userScore > 21)
                winner = false;
            else
                winner =  true;
        }


        if (!winner) {
            System.out.println("The House is the winner with a score: " + Integer.toString(houseScore) + ".");
            System.out.println("Your score is: " + Integer.toString(userScore) + ".");
        }
        else {
            System.out.println("The You are the the winner with a score: " + Integer.toString(userScore) + ".");
            System.out.println("The House score is: " + Integer.toString(houseScore) + ".");
        }
        System.out.println("Would you like to play again? (y/n)");
        while(!gameEnd) {
            String in = user.nextLine().toLowerCase();
            if (in.equals("y"))
                game.main(null);
            else if (in.equals("n")) ;
                gameEnd = true;
        }

    }
}
