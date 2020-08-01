package francescocicala;

import java.util.HashMap;

public class Alliance extends HashMap<String, Eidos> {

  private static final long serialVersionUID = 1L;

  public void addEidos(Eidos eidos) {
    this.putIfAbsent(eidos.getName(), eidos);
  }

  public void removeEidos(Eidos eidos) {
    this.remove(eidos.getName());
  }

  public Integer cardinality() {
    return this.size();
  }




}
