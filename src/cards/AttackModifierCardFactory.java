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
		case LAME:
			newCard = new StandardAttackModifierCard(type, deck);
			break;
		case WEAK:
			newCard = new StandardAttackModifierCard(type, deck);
			break;
		case DECENT:
			newCard = new StandardAttackModifierCard(type, deck);
			break;
		case KEEN:
			newCard = new StandardAttackModifierCard(type, deck);
			break;
		case POWERFUL:
			newCard = new StandardAttackModifierCard(type, deck);
			break;
		case CRITICAL:
			newCard = new ReshuffleAttackModifierCard(type, deck);
			break;
		}

		return newCard;
	}

}
