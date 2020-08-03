package francescocicala;

import java.util.HashMap;
import java.util.Map;

public class Alliance {
  private final Map<String, Eidos> internal;

  /**
   * Construct the Alliance object, which is a collection of unique Eidos objects.
   */
  public Alliance() {
    internal = new HashMap<String, Eidos>();
  }

  /**
   * Add an Eidos to the Alliance.
   * @param eidos Eidos object to add to the Alliance.
   */
  public void addEidos(final Eidos eidos) {
    internal.putIfAbsent(eidos.getName(), eidos);
  }

  /**
   * Remove the given Eidos from the Alliance.
   * @param eidos Eidos object to remove from the Alliance.
   */
  public void removeEidos(final Eidos eidos) {
    internal.remove(eidos.getName());
  }

  /**
   * Returns the number of Eidos belonging to the Alliance.
   * @return Integer
   */
  public Integer cardinality() {
    return internal.size();
  }

  /**
   * Return true if the Alliance is empty.
   * @return boolean
   */
  public boolean isEmpty() {
    return internal.isEmpty();
  }

  /**
   * Returns true if the input Eidos belongs to the Alliance.
   * @param eidos Eidos target.
   * @return boolean
   */
  public boolean contains(final Eidos eidos) {
    return internal.containsKey(eidos.getName());
  }

  /**
   * Returns string with info about the Eidoi in the Alliance.
   * @return String
   */
  public String showAllianceString() {
    if (isEmpty()) {
      String out = "Empty alliance.";
      return out;
    }
    String out = "";
    for (Eidos eidos : internal.values()) {
      out += eidos.showInfoString() + "\n";
    }
    return out;
  }

  public Eidos[] getEidoiArr() {
    Object[] raw = internal.values().toArray();
    Eidos[] out = new Eidos[raw.length];
    for (int i = 0; i < raw.length; i++) {
      out[i] = (Eidos) raw[i];
    }
    return out;
  }
}
