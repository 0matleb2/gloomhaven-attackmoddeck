package cards;

import contracts.IAttackModifierCard;
import contracts.IAttackModifierDeck;

public class AttackModifierCardFactory {

		
	private static AttackModifierCardFactory instance = null;
	
	private AttackModifierCardFactory() { }
	
	public static AttackModifierCardFactory getInstance() {
		if (instance == null) {
			instance = new AttackModifierCardFactory();
		}
		return instance;
	}
	
	public IAttackModifierCard create(AttackModifierCardType type, IAttackModifierDeck deck) {
		
		IAttackModifierCard newCard = null;
		
		switch (type) {
		case MISS:
			newCard = new ReshuffleAttackModifierCard(type, deck);
			break;
		case MINUSTWO:
			newCard = new StandardAttackModifierCard(type, deck);
			break;
		case MINUSONE:
			newCard = new StandardAttackModifierCard(type, deck);
			break;
		case NEUTRAL:
			newCard = new StandardAttackModifierCard(type, deck);
			break;
		case PLUSONE:
			newCard = new StandardAttackModifierCard(type, deck);
			break;
		case PLUSTWO:
			newCard = new StandardAttackModifierCard(type, deck);
			break;
		case DOUBLEDAMAGE:
			newCard = new ReshuffleAttackModifierCard(type, deck);
			break;
		}

		return newCard;
	}

}
