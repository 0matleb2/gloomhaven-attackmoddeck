package cards;

public enum AttackModifierCardType {
	CURSE("⚡Ø⚡", "Curse"),
	MISS("Ø", "Miss"),
	MINUSTWO("-2", "Lame"),
	MINUSONE("-1", "Weak"),
	NEUTRAL("+0", "Decent"),
	PLUSONE("+1", "Keen"),
	PLUSTWO("+2", "Powerful"),
	DOUBLEDAMAGE("2x", "Critical"),
	BLESS("✞2x✞", "Bless");
	
	private String attackModifier;
	private String name;

	private AttackModifierCardType(String attackModifier, String name) {
		this.attackModifier = attackModifier;
		this.name = name;
	}
	
	public String getAttackModifier() {
		return attackModifier;
	}
	
	public String getName() {
		return name;
	}
}
