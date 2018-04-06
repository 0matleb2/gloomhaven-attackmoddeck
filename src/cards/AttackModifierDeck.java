package cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import contracts.IAttackModifierCard;
import contracts.IAttackModifierDeck;

public class AttackModifierDeck implements IAttackModifierDeck {
	
	private Stack<IAttackModifierCard> deck;
	private Stack<IAttackModifierCard> discardPile;
	private ArrayList<Integer> numCardsInDeckbyType;
	
	public AttackModifierDeck() {
		this(1, 1, 5, 6, 5, 1, 1);
	}
	
	public AttackModifierDeck(int miss, int lame, int weak, int decent, 
										int keen, int powerful, int critical) {
		deck = new Stack<IAttackModifierCard>();
		discardPile = new Stack<IAttackModifierCard>();
		numCardsInDeckbyType = new ArrayList<Integer>();
		numCardsInDeckbyType.addAll(Arrays.asList(miss, lame, weak, decent, keen, powerful, critical));
		
		addXCards(AttackModifierCardType.MISS, miss);
		addXCards(AttackModifierCardType.MINUSTWO, lame);
		addXCards(AttackModifierCardType.MINUSONE, weak);
		addXCards(AttackModifierCardType.NEUTRAL, decent);
		addXCards(AttackModifierCardType.PLUSONE, keen);
		addXCards(AttackModifierCardType.PLUSTWO, powerful);
		addXCards(AttackModifierCardType.DOUBLEDAMAGE, critical);
		
		shuffle();
		
		System.out.println("New Attack Modifier deck created with the following cards: ");
		System.out.println("\t" + Integer.toString(miss) + " [Ø Miss]");
		System.out.println("\t" + Integer.toString(lame) + " [-2 Lame]");
		System.out.println("\t" + Integer.toString(weak) + " [-1 Weak]");
		System.out.println("\t" + Integer.toString(decent) + " [+0 Decent]");
		System.out.println("\t" + Integer.toString(keen) + " [+1 Keen]");
		System.out.println("\t" + Integer.toString(powerful) + " [+2 Powerful]");
		System.out.println("\t" + Integer.toString(critical) + " [2x Critical]\n");
	}

	@Override
	public IAttackModifierCard draw() {
		IAttackModifierCard drawnCard = deck.pop();
		discardPile.push(drawnCard);
		
		String cardString = "\nDRAW: [" + drawnCard.getString() + "]\n";
		System.out.println(cardString);
		
		drawnCard.handleReshuffle();
		
		return drawnCard;
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
	
	public String probabilities() {
		
		int numCardsInDeck = 0;
		for (Integer numOfType : numCardsInDeckbyType) {
			numCardsInDeck += numOfType;
		}
		
		double missChance = (double)numCardsInDeckbyType.get(0)/numCardsInDeck;
		
		System.out.println("Chance of drawing a miss: " + Double.toString(missChance));
		
		return "";
	}
	
	private void addXCards(AttackModifierCardType type, int num) {
		for (int i = 0; i < num; ++i) {
			deck.push(AttackModifierCardFactory.getInstance().create(type, this));
		}
	}

}
