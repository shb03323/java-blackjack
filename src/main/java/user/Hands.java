package user;

import card.Card;
import card.Deck;

import java.util.List;

public class Hands {
    public static final int ACE_SCORE_CHANGE_POINT = 11;
    public static final int ACE_EXTRA_SCORE = 10;
    public static final int BLACKJACK_SCORE = 21;
    public static final int BURST_SCORE = 21;

    private List<Card> hands;
    private int score;
    private boolean hasAce;

    {
        this.score = 0;
        this.hasAce = false;
    }

    public Hands(List<Card> hands) {
        this.hands = hands;
    }

    public Hands(Deck deck) {
        this.hands = deck.initialDraw();
    }

    public int size() {
        return hands.size();
    }

    public void draw(Deck deck) {
        hands.add(deck.draw());
    }

    public int score() {
        score = hands.stream()
                .peek(this::checkAce)
                .mapToInt(Card::score)
                .sum();
        determineAceScore();
        return this.score;
    }

    private void determineAceScore() {
        if (score <= ACE_SCORE_CHANGE_POINT && hasAce) {
            score += ACE_EXTRA_SCORE;
        }
    }

    private void checkAce(Card card) {
        if (card.isAce()) {
            hasAce = true;
        }
    }

    public boolean isBlackJack() {
        return score() == BLACKJACK_SCORE;
    }

    public boolean isBurst() {
        return score() > BURST_SCORE;
    }
}
