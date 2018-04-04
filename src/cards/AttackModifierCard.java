package cards;

import contracts.IAttackModifierCard;
import contracts.IAttackModifierDeck;

public abstract class AttackModifierCard implements IAttackModifierCard {

	private AttackModifierCardType type;
	protected IAttackModifierDeck deckCallback;
	
	public AttackModifierCard(AttackModifierCardType type, IAttackModifierDeck deck) {
		this.type = type;
		this.deckCallback = deck;
	}

	@Override
	public String getModifier() {
		return type.getAttackModifier();
	}

	@Override
	public String getName() {
		return type.getName();
	}
	
	public abstract void handleReshuffle();

}
