package cards;

import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;

import contracts.IAttackModifierCard;
import contracts.IAttackModifierDeck;

public class AttackModifierDeck implements IAttackModifierDeck {
	
	private Stack<IAttackModifierCard> deck;
	private Stack<IAttackModifierCard> discardPile;
	
	public AttackModifierDeck() {
		this(1, 1, 5, 6, 5, 1, 1);
	}
	
	public AttackModifierDeck(int miss, int lame, int weak, int decent, 
										int keen, int powerful, int critical) {
		deck = new Stack<IAttackModifierCard>();
		discardPile = new Stack<IAttackModifierCard>();
		
		addXCards(AttackModifierCardType.MISS, miss);
		addXCards(AttackModifierCardType.LAME, lame);
		addXCards(AttackModifierCardType.WEAK, weak);
		addXCards(AttackModifierCardType.DECENT, decent);
		addXCards(AttackModifierCardType.KEEN, keen);
		addXCards(AttackModifierCardType.POWERFUL, powerful);
		addXCards(AttackModifierCardType.CRITICAL, critical);
		
		shuffle();
	}

	@Override
	public String draw() {
		IAttackModifierCard drawnCard = deck.pop();
		discardPile.push(drawnCard);
		drawnCard.handleReshuffle();
		
		return drawnCard.getName() + " " + drawnCard.getModifier();
	}

	@Override
	public void shuffle() {
		
		Iterator<IAttackModifierCard> iterator = discardPile.iterator();
		
		while (iterator.hasNext()) {
			IAttackModifierCard card = iterator.next();
			deck.add(card);
			iterator.remove();
		}
		
		Collections.shuffle(deck);
	}
	
	private void addXCards(AttackModifierCardType type, int num) {
		for (int i = 0; i < num; ++i) {
			deck.push(AttackModifierCardFactory.getInstance().create(type, this));
		}
	}

}
