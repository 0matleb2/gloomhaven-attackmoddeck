package contracts;

import cards.AttackModifierCard;

public interface IAttackModifierDeck {
	
	public IAttackModifierCard draw();
	public void shuffle();
	public String probabilities();
	
}
