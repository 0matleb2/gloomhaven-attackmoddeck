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

	public String getString() {
		return type.getAttackModifier() + " " + type.getName();
	}
	
	public AttackModifierCardType getType() {
		return type;
	}
	
	public abstract void handleReshuffle();

}
