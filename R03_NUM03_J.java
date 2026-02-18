/*
 * Rule 03. Numeric Types and Operations (NUM)
 * NUM03-J. Use integer types that can fully represent the possible range of unsigned data [cite: 107]
 */

// --- NON-COMPLIANT CODE ---
/*
public static int getInteger(DataInputStream is) throws IOException {
    return is.readInt();
}
*/

// --- COMPLIANT SOLUTION ---
public static long getInteger(DataInputStream is) throws IOException { [cite: 111]
    return is.readInt() & 0xFFFFFFFFL; // Mask with 32 one-bits [cite: 113]
}
