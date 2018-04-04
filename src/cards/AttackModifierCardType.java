package cards;

public enum AttackModifierCardType {
	MISS("Ø", "Miss"),
	LAME("-2", "Lame"),
	WEAK("-1", "Weak"),
	DECENT("+0", "Decent"),
	KEEN("+1", "Keen"),
	POWERFUL("+2", "Powerful"),
	CRITICAL("2x", "Critical");
	
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
