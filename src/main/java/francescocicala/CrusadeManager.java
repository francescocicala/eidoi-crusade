package francescocicala;

public class CrusadeManager {
  private final Mage mage1;
  private final Mage mage2;
  
  CrusadeManager(Mage m1, Mage m2) {
    mage1 = m1;
    mage2 = m2;
  }

  public void startCrusade() {
    Eidos mage1EidosChoice;
    String mage1ActionChoice;
    Eidos mage2EidosChoice;
    String mage2ActionChoice;
    while ((!mage1.isDead() && !mage2.isDead()) 
      && ((mage1.allianceSize() > 0) && (mage2.allianceSize() > 0))) {
      System.out.println(mage1.getName() + " turn:");
      mage1EidosChoice = selectEidos(mage1);
      mage1ActionChoice = selectAction();
      System.out.println(mage2.getName() + " turn:");
      mage2EidosChoice = selectEidos(mage2);
      mage2ActionChoice = selectAction();
      battle(mage1EidosChoice, mage1ActionChoice, mage2EidosChoice, mage2ActionChoice);    
    }
    System.out.println(crusadeEndingString());
  }
  
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

  private String selectAction() {
    System.out.println("Press 'e' to attack the enemy Eidos, 'm' to attack the enemy Mage.");
    return "e"; // <--- default for test
  }

  private Eidos selectEidos(Mage mage) {
    Alliance alliance = mage.getAlliance();
    Eidos[] eidoiArr = alliance.getEidoiArr();
    System.out.println("Press the number corresponding to the Eidos to send into battle:");
    for (Integer i = 1; i <= eidoiArr.length; i++) {
      System.out.println(i.toString() + ". " + eidoiArr[i-1].showInfoString());
    }
    return eidoiArr[0]; // <--- default for test
  }

  private void battle(Eidos eidos1, String action1, Eidos eidos2, String action2) {
    if ((action1 == "e") && (action2 == "e")) {
      attEidosAttEidos(eidos1, eidos2);
    } else if ((action1 == "e") && (action2 == "m")) {
      attEidosAttMage(eidos1, eidos2);
    } else if ((action1 == "m") && (action2 == "e")) {
      attMageAttEidos(eidos1, eidos2);
    } else {
      attMageAttMage(eidos1, eidos2);
    }
  }

  private void attMageAttMage(Eidos eidos1, Eidos eidos2) {
    mage1.loseHP(eidos2.getAtt());
    mage2.loseHP(eidos1.getAtt());
  }

  private void attMageAttEidos(Eidos eidos1, Eidos eidos2) {
    if (eidos2.getAtt() > eidos1.getDef()) {
      mage1.discard(eidos1);
    } else {
      mage2.loseHP(eidos1.getAtt());
    }
  }

  private void attEidosAttMage(Eidos eidos1, Eidos eidos2) {
    if (eidos1.getAtt() > eidos2.getDef()) {
      mage2.discard(eidos2);
    } else {
      mage1.loseHP(eidos2.getAtt());
    }
  }

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