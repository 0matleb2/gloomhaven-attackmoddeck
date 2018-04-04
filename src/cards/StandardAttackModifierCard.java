package cards;

import contracts.IAttackModifierDeck;

public class StandardAttackModifierCard extends AttackModifierCard {

	public StandardAttackModifierCard(AttackModifierCardType type, IAttackModifierDeck deck) {
		super(type, deck);
	}

	@Override
	public void handleReshuffle() { 
		// No reshuffle for standard cards
	}

}
