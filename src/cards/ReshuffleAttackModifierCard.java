package cards;

import contracts.IAttackModifierDeck;

public class ReshuffleAttackModifierCard extends AttackModifierCard {

	public ReshuffleAttackModifierCard(AttackModifierCardType type, IAttackModifierDeck deck) {
		super(type, deck);
	}

	@Override
	public void handleReshuffle() {
		deckCallback.shuffle();
		System.out.println("Deck reshuffled");
	}

}
