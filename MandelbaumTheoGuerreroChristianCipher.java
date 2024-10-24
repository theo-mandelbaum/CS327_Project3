

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

    public static void main (String[] args) {
		MandelbaumTheoGuerreroChristianCipher testObj = new MandelbaumTheoGuerreroChristianCipher();

		System.out.println ("********** Project 2 output begins ********** ");
        System.out.println();
	}
}