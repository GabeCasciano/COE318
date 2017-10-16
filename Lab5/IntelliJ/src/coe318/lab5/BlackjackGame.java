package coe318.lab5;

public class BlackjackGame {

    private CardPile deck;
    private CardPile houseCards;
    private CardPile yourCards;
    private boolean houseDone;
    private boolean playerDone;
    private UserInterface ui;
    private int houseScore;
    private int userScore;

    public BlackjackGame(UserInterface ui) {
        this.ui = ui;
        ui.setGame(this);
        deck = new CardPile();
        for (int i = 2; i < 15; i++) {
            for (int j = 0; j < 4; j++) {
                deck.add(new Card(i, j, true));
            }
        }
        houseCards = new CardPile();
        yourCards = new CardPile();
        houseDone = false;
        playerDone = false;
    }

    public void start() {
        Card c;
        c = deck.removeRandom();
        c.setFaceUp(false);
        getHouseCards().add(c);
        getHouseCards().add(deck.removeRandom());
        getYourCards().add(deck.removeRandom());
        getYourCards().add(deck.removeRandom());
        updateScore();
        ui.display();
    }

    public void play() {
        while (!houseDone || !playerDone) {
            if (!houseDone) {
                if (houseScore <= 17) {
                    getHouseCards().add(deck.removeRandom());
                    ui.display();
                } else {
                    houseDone = true;
                }
            }
            if (!playerDone) {
                if (userScore < 21 && ui.hitMe()) {
                        getYourCards().add(deck.removeRandom());
                        ui.display();
                } else {
                    playerDone = true;
                }
            }
            updateScore();
        }

    }

    public void end() {
        getHouseCards().getCards().get(0).setFaceUp(true);
        ui.gameOver();
    }
    public void updateScore(){
        houseScore = score(houseCards);
        userScore = score(yourCards);
    }
    public int getHouseScore(){
        return houseScore;
    }
    public int getUserScore(){
        return userScore;
    }
    /**
     * Determine the score of a pile of cards.
     *
     * @param p
     * @return the score
     */
    public int score(CardPile p) {
        int sum = 0;
        for(Card c : p.getCards())
            sum += ((c.getRank())>=11?10:c.getRank());
        return sum;
    }

    /**
     * @return the houseCards
     */
    public CardPile getHouseCards() {
        return houseCards;
    }

    /**
     * @return the yourCards
     */
    public CardPile getYourCards() {
        return yourCards;
    }

    public static void main(String[] args) {
        BlackjackGame game = new BlackjackGame(new SimpleUI());
        game.start();
        game.play();
        game.end();
    }
}
