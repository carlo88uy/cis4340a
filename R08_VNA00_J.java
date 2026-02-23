/*
 * Rule 08. Visibility and Atomicity (VNA)
 * VNA00-J. Ensure visibility when accessing shared primitive variables
 */

// --- NON-COMPLIANT CODE ---
/*
public class SharedFlag {
  private boolean flag = false;
  public void setFlag() { flag = true; }
  public boolean getFlag() { return flag; }
}
*/

// --- COMPLIANT SOLUTION ---
public class SharedFlag {
  // Using volatile ensures all threads see the most recent write
  private volatile boolean flag = false;
  public void setFlag() { flag = true; }
  public boolean getFlag() { return flag; }
}
