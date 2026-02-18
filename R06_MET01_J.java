/*
 * Rule 06. Methods (MET)
 * MET01-J. Never use assertions to validate method arguments [cite: 127]
 */

// --- NON-COMPLIANT CODE ---
/*
public static int getAbsAdd(int x, int y) {
    assert x != Integer.MIN_VALUE;
    assert y != Integer.MIN_VALUE;
    int absX = Math.abs(x);
    int absY = Math.abs(y);
    assert (absX <= Integer.MAX_VALUE - absY);
    return absX + absY;
}
*/

// --- COMPLIANT SOLUTION ---
public static int getAbsAdd(int x, int y) {
    if (x == Integer.MIN_VALUE || y == Integer.MIN_VALUE) { [cite: 140]
        throw new IllegalArgumentException(); [cite: 141]
    }
    int absX = Math.abs(x); [cite: 142]
    int absY = Math.abs(y); [cite: 143]
    if (absX > Integer.MAX_VALUE - absY) { [cite: 144]
        throw new IllegalArgumentException(); [cite: 145]
    }
    return absX + absY; [cite: 147]
}
