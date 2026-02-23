/*
 * Rule 10. Thread APIs (THI)
 * THI03-J. Do not use Thread.stop()
 */

// --- NON-COMPLIANT CODE ---
/*
public final class Worker implements Runnable {
  public void run() { /* work */ }
  
  public static void main(String[] args) {
    Thread t = new Thread(new Worker());
    t.start();
    // ...
    t.stop(); // Unsafe!
  }
}
*/

// --- COMPLIANT SOLUTION ---
public final class Worker implements Runnable {
  private volatile boolean done = false;
  
  public void run() {
    while (!done) { /* work */ }
  }

  public void shutDown() {
    done = true; // Safe interruption
  }
}
