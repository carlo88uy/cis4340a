/*
 * Rule 14. Serialization (SER)
 * SER01-J. Do not trust external data during deserialization
 */

// --- NON-COMPLIANT CODE ---
/*
public class UserProfile implements Serializable {
  public int privilegeLevel = 0; // Can be manipulated in the byte stream
}
*/

// --- COMPLIANT SOLUTION ---
public class UserProfile implements Serializable {
  private int privilegeLevel = 0;

  // Implement readObject to perform validation during deserialization
  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    if (privilegeLevel < 0) {
      throw new InvalidObjectException("Invalid privilege level");
    }
  }
}
