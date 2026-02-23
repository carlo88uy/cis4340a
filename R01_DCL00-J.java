/*
 * Rule 01. Declarations and Initialization (DCL)
 * DCL00-J. Prevent class initialization cycles
 */

// --- NON-COMPLIANT CODE ---
/*
public class Cycle {
  private final int balance;
  private static final Cycle c = new Cycle();
  private static final int deposit = (int) (Math.random() * 100);

  public Cycle() {
    balance = deposit - 10; // deposit is not yet initialized here!
  }
}
*/

// --- COMPLIANT SOLUTION ---
public class Cycle {
  private final int balance;
  // Reorder initialization: deposit must be initialized before the instance 'c'
  private static final int deposit = (int) (Math.random() * 100);
  private static final Cycle c = new Cycle();

  public Cycle() {
    balance = deposit - 10;
  }
}
