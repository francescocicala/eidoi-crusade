package francescocicala;

public class Eidos {
	private String name;
    private int attack, defense;

	public Eidos(String name, int attack, int defense) {
		this.name = name;
        this.attack = attack;
        this.defense = defense;
	}
	public String getName() {
		return name;
	}
	public Integer getAtt() {
		return attack;
	}
	public Integer getDef() {
		return defense;
	}

}
