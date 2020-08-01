package francescocicala;

public class Eidos {
  private String name;
  private int attack;
  private int defense;

  /**
   * Construct an Eidos object.
   * @param name eidos' name
   * @param attack eidos' attack value
   * @param defense eidos' defense value
   */
  public Eidos(String name, int attack, int defense) {
    this.name = name;
    this.attack = attack;
    this.defense = defense;
  }

  
  /** 
   * Returns the name of the eidos.
   * @return String
   */
  public String getName() {
    return name;
  }
  
  
  /** 
   * Returns the attack value.
   * @return Integer
   */
  public Integer getAtt() {
    return attack;
  }

  
  /** 
   * Returns the defense value.
   * @return Integer
   */
  public Integer getDef() {
    return defense;
  }

}
