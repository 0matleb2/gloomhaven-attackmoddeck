package contracts;

import cards.AttackModifierCardType;

public interface IAttackModifierCard {
	
	public String getString();
	public AttackModifierCardType getType();
	public void handleReshuffle();
	
}
