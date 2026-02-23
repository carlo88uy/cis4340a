/*
 * Rule 07. Exceptional Behavior (ERR)
 * ERR01-J. Do not allow exceptions to expose sensitive information
 */

// --- NON-COMPLIANT CODE ---
/*
try {
  FileInputStream fis = new FileInputStream(fileName);
} catch (FileNotFoundException x) {
  // Directly throwing the exception reveals the file name and path
  throw new IOException("Unable to open file " + fileName, x);
}
*/

// --- COMPLIANT SOLUTION ---
try {
  FileInputStream fis = new FileInputStream(fileName);
} catch (FileNotFoundException x) {
  // Log the specific details internally for the developer
  logger.log(Level.SEVERE, "File not found", x);
  // Give the user a generic error message
  throw new IOException("Unable to open file");
}
