/*
 * Rule 02. Expressions (EXP)
 * XP00-J. Do not ignore values returned by methods [cite: 91]
 */

// --- NON-COMPLIANT CODE ---
/*
public void deleteFile() {
    File someFile = new File("someFileName.txt");
    // Do something with someFile
    someFile.delete();
}
*/

// --- COMPLIANT SOLUTION ---
public void deleteFile() {
    File someFile = new File("someFileName.txt"); [cite: 99]
    // Do something with someFile
    if (!someFile.delete()) { [cite: 101]
        // Handle failure to delete the file [cite: 102]
    }
}
