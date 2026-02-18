/*
 * Rule 04. Characters and Strings (STR)
 * STR03-J. Do not encode noncharacter data as a string [cite: 117]
 */

// --- NON-COMPLIANT CODE ---
/*
BigInteger x = new BigInteger("530500452766");
byte[] byteArray = x.toByteArray();
String s = new String(byteArray);
byteArray = s.getBytes();
x = new BigInteger(byteArray);
*/

// --- COMPLIANT SOLUTION ---
BigInteger x = new BigInteger("530500452766"); [cite: 122]
String s = x.toString(); // Valid character data [cite: 122]
byte[] byteArray = s.getBytes(); [cite: 122]
String ns = new String(byteArray); [cite: 123]
x = new BigInteger(ns); [cite: 124]
