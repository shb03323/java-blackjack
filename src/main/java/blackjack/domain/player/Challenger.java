package blackjack.domain.player;

import blackjack.dto.ChallengerMoneyDto;

public class Challenger extends Player {

    private static final int MAXIMUM_POINT_TO_PICK = 21;

    private final ChallengerName name;
    private final Money money;

    public Challenger(final String name) {
        this.name = new ChallengerName(name);
        this.money = Money.zero();
    }

    public Challenger(final ChallengerMoneyDto challengerMoneyDto) {
        this.name = challengerMoneyDto.getChallenger().name;
        this.money = challengerMoneyDto.getMoney();
    }

    @Override
    public Boolean canPick() {
        Score score = holdingCards.getDefaultSum();
        return score.getValue() <= MAXIMUM_POINT_TO_PICK;
    }

    @Override
    public Boolean isDealer() {
        return false;
    }

    @Override
    public Boolean isChallenger() {
        return true;
    }

    @Override
    public String getName() {
        return name.getName();
    }
}
