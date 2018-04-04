package main;

import cards.AttackModifierDeck;
import contracts.IAttackModifierDeck;

public class Driver {

	public static void main(String[] args) {
		
		IAttackModifierDeck deck = new AttackModifierDeck();
		
		System.out.println(deck.draw());
		System.out.println(deck.draw());
		System.out.println(deck.draw());
		System.out.println(deck.draw());
		System.out.println(deck.draw());
		System.out.println(deck.draw());

	}

}
