package main;

import java.util.Scanner;

import cards.AttackModifierDeck;
import contracts.IAttackModifierDeck;

public class Driver {

	public static void main(String[] args) {

		println("Gloomhaven Attack Modifier Deck");
		println("===============================");
		println();
		
		boolean appRunning = true;
		
		while (appRunning) {
			
			IAttackModifierDeck deck = new AttackModifierDeck();
			
			boolean sessionRunning = true;
			
			while (sessionRunning) {
				println("Enter <'> to draw. Press <R> to reset. Press <Q> to quit");
				
				Scanner scanner = new Scanner(System.in);
				String input = scanner.next();
				
				switch (input) {
				case "'":
				case "\"":
					deck.draw();
					break;
				case "r":
				case "R":
					sessionRunning = false;
					break;
				case "q":
				case "Q":
					sessionRunning = false;
					appRunning = false;
					break;
				}
			}
		}
		

	}
	
	private static void println() {
		println("");
	}
	
	private static void println(String str) {
		System.out.println(str);
	}

}
