package blackjack.domain.player;

import blackjack.domain.card.Card;

public abstract class Player {

    protected final HoldingCards holdingCards;

    protected Player() {
        this.holdingCards = new HoldingCards();
    }

    public void pickStartCards(Card card1, Card card2) {
        holdingCards.initialCard(card1, card2);
    }

    public HoldingCards getHoldingCards() {
        return holdingCards;
    }

    public void pick(Card card) {
        holdingCards.add(card);
    }

    public int getTotalPoint() {
        return holdingCards.getSum();
    }

    public abstract Boolean canPick();

    public abstract Boolean isDealer();

    public abstract Boolean isChallenger();

    public abstract String getName();
}
