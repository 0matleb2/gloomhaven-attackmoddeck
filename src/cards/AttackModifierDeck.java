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
		
		System.out.println("New Attack Modifier deck created with: ");
		System.out.println("\t" + Integer.toString(miss) + " [Miss Ø] cards");
		System.out.println("\t" + Integer.toString(lame) + " [Lame -2] cards");
		System.out.println("\t" + Integer.toString(weak) + " [Weak -1] cards");
		System.out.println("\t" + Integer.toString(decent) + " [Decent +0] cards");
		System.out.println("\t" + Integer.toString(keen) + " [Keen +1] cards");
		System.out.println("\t" + Integer.toString(powerful) + " [Powerful +2] cards");
		System.out.println("\t" + Integer.toString(critical) + " [Critical 2x] cards\n");
	}

	@Override
	public String draw() {
		IAttackModifierCard drawnCard = deck.pop();
		discardPile.push(drawnCard);
		
		String cardString = "\nDRAW: [" + drawnCard.getName() + " " + drawnCard.getModifier() +"]\n";
		System.out.println(cardString);
		
		drawnCard.handleReshuffle();
		
		return cardString;
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
