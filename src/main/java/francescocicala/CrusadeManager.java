package francescocicala;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class CrusadeManager {
  private final Mage mage1;
  private final Mage mage2;
  
  /**
   * Constructs CrusadeManager object, for handling the Crusade Phase.
   * @param m1 first Mage
   * @param m2 second Mage
   */
  CrusadeManager(Mage m1, Mage m2) {
    mage1 = m1;
    mage2 = m2;
  }

  /**
   * Starts the crusade phase.
   */
  public void startCrusade() {
    Eidos mage1EidosChoice;
    String mage1ActionChoice;
    Eidos mage2EidosChoice;
    String mage2ActionChoice;
    while ((!mage1.isDead() && !mage2.isDead()) 
      && ((mage1.allianceSize() > 0) && (mage2.allianceSize() > 0))) {
      showTurnInfo();
      System.out.println(mage1.getName() + "(" + mage1.getHP() + " HP)" + " turn:");
      mage1EidosChoice = selectEidos(mage1);
      mage1ActionChoice = selectAction();
      System.out.println(mage2.getName() + "(" + mage2.getHP() + " HP)" + " turn:");
      mage2EidosChoice = randomEidos(mage2);
      mage2ActionChoice = randomAction();

      System.out.println("BATTLE! " + mage1EidosChoice.getName() + " (" + mage1ActionChoice 
          + ") VS " + mage2EidosChoice.getName() + " (" + mage2ActionChoice + ")\n");
      battle(mage1EidosChoice, mage1ActionChoice, mage2EidosChoice, mage2ActionChoice);    
    }
    System.out.println(crusadeEndingString());
  }
  
  
  private void showTurnInfo() {
    Alliance alliance1 = mage1.getAlliance();
    Eidos[] eidoiArr1 = alliance1.getEidoiArr();
    System.out.println("--------------------------");
    System.out.println(mage1.getName() + "(" + mage1.getHP() + " HP)" + " Alliance:");
    for (Integer i = 1; i <= eidoiArr1.length; i++) {
      System.out.println(i.toString() + ". " + eidoiArr1[i-1].showInfoString());
    }

    Alliance alliance2 = mage2.getAlliance();
    Eidos[] eidoiArr2 = alliance2.getEidoiArr();
    System.out.println("--------------------------");
    System.out.println(mage2.getName() + "(" + mage2.getHP() + " HP)" + " Alliance:");
    for (Integer i = 1; i <= eidoiArr2.length; i++) {
      System.out.println(i.toString() + ". " + eidoiArr2[i-1].showInfoString());
    }
    System.out.println("--------------------------");
  }

  /**
   * Returns a string with the result of the match.
   * 
   * @return String
   */
  private String crusadeEndingString() {
    String out;
    if (mage1.isDead() && mage2.isDead()) {
      out = "Draw! Both Mages are dead.";
    } else if (mage1.isDead()) {
      out = mage1.getName() + " is dead! " + mage2.getName() + " win.";
    } else if (mage2.isDead()) {
      out = mage2.getName() + "  is dead! " + mage1.getName() + " win.";
    } else if ((mage1.allianceSize() == 0) && (mage2.allianceSize() == 0)) {
      out = "Draw! Both Mages' alliances have been defeated.";
    } else if (mage1.allianceSize() == 0) {
      out = mage2.getName() + " win! " + mage1.getName() + "'s alliance has been defeated.";
    } else {
      out = mage1.getName() + " win! " + mage2.getName() + "'s' alliance has been defeated.";
    }
    return out;
  }

  
  /** 
   * Collects and returns the Mage action choice.
   * @return String
   */
  private String selectAction() {
    System.out.print("Press 'e' to attack the enemy Eidos, 'm' to attack the enemy Mage: ");
    Scanner sc = new Scanner(System.in);
    String choice = sc.nextLine(); 
    //sc.close();
    return choice;
  }

  /** 
   * Returns a random Mage action choice.
   * @return String
   */
  private String randomAction() {
    System.out.println("Rival Mage choosing an action...");
    int randomNum = ThreadLocalRandom.current().nextInt(0, 2);
    if (randomNum == 0) {
      return "e";
    } else {
      return "m";
    }
  }
  
  /** 
   * @param mage
   * @return Eidos
   */
  private Eidos selectEidos(Mage mage) {
    Alliance alliance = mage.getAlliance();
    Eidos[] eidoiArr = alliance.getEidoiArr();
    System.out.print("Press the number corresponding to the Eidos to send into battle: ");
    Scanner in = new Scanner(System.in);
    int num = in.nextInt();
    //in.close();
    return eidoiArr[num - 1];
  }

  private Eidos randomEidos(Mage mage) {
    Alliance alliance = mage.getAlliance();
    Eidos[] eidoiArr = alliance.getEidoiArr();
    System.out.println("Rival Mage choosing the Eidos to send into battle...");
    int randomNum = ThreadLocalRandom.current().nextInt(0, mage.allianceSize());
    return eidoiArr[randomNum];
  }

  
  /** 
   * @param eidos1
   * @param action1
   * @param eidos2
   * @param action2
   */
  private void battle(Eidos eidos1, String action1, Eidos eidos2, String action2) {
    if ((action1.equals("e")) && (action2.equals("e"))) {
      attEidosAttEidos(eidos1, eidos2);
    } else if ((action1.equals("e")) && (action2.equals("m"))) {
      attEidosAttMage(eidos1, eidos2);
    } else if ((action1.equals("m")) && (action2.equals("e"))) {
      attMageAttEidos(eidos1, eidos2);
    } else {
      attMageAttMage(eidos1, eidos2);
    }
  }

  
  /** 
   * @param eidos1
   * @param eidos2
   */
  private void attMageAttMage(Eidos eidos1, Eidos eidos2) {
    mage1.loseHP(eidos2.getAtt());
    mage2.loseHP(eidos1.getAtt());
  }

  
  /** 
   * @param eidos1
   * @param eidos2
   */
  private void attMageAttEidos(Eidos eidos1, Eidos eidos2) {
    if (eidos2.getAtt() > eidos1.getDef()) {
      mage1.discard(eidos1);
    } else {
      mage2.loseHP(eidos1.getAtt());
    }
  }

  
  /** 
   * @param eidos1
   * @param eidos2
   */
  private void attEidosAttMage(Eidos eidos1, Eidos eidos2) {
    if (eidos1.getAtt() > eidos2.getDef()) {
      mage2.discard(eidos2);
    } else {
      mage1.loseHP(eidos2.getAtt());
    }
  }

  
  /** 
   * @param eidos1
   * @param eidos2
   */
  private void attEidosAttEidos(Eidos eidos1, Eidos eidos2) {
    if (eidos1.getAtt() > eidos2.getAtt()) {
      mage2.discard(eidos2);
    } else if (eidos1.getAtt() < eidos2.getAtt()) {
      mage1.discard(eidos1);
    } else {
      mage1.discard(eidos1);
      mage2.discard(eidos2);
    }
  }
}