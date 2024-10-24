

public class MandelbaumTheoGuerreroChristianCipher {

    public int[][] findDecryptionKey(int encryptionKey[][]) {
        return null;
    }

    public int[] encrypt(int plaintext[], int encryptionKey[][]) {
        int encryptedVector[] = new int[plaintext.length];
        for (int row = 0; row < encryptionKey.length; row++) {
            for (int column = 0; column < encryptionKey[0].length; column++) {
                encryptedVector[row] += encryptionKey[row][column] * plaintext[column];
            }
        }
        for (int i = 0; i < encryptedVector.length; i++) {
            encryptedVector[i] = encryptedVector[i] % 26;
        }
        return encryptedVector;
    }

    public int[] decrypt(int ciphertext[], int decryptionKey[][]) {
        int decryptedVector[] = new int[ciphertext.length];
        for (int row = 0; row < decryptionKey.length; row++) {
            for (int column = 0; column < decryptionKey[0].length; column++) {
                decryptedVector[row] += decryptionKey[row][column] * ciphertext[column];
            }
        }
        for (int i = 0; i < decryptedVector.length; i++) {
            decryptedVector[i] = decryptedVector[i] % 26;
        }
        return decryptedVector;
    }

    public static void main (String[] args) {
		MandelbaumTheoGuerreroChristianCipher testObj = new MandelbaumTheoGuerreroChristianCipher();

		System.out.println ("********** Project 2 output begins ********** ");
        System.out.println();
	}
}