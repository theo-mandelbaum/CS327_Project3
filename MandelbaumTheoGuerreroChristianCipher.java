

public class MandelbaumTheoGuerreroChristianCipher {

    public int[][] findDecryptionKey(int encryptionKey[][]) {
        int determanent = (encryptionKey[0][0] * encryptionKey[1][1]) -  (encryptionKey[0][1] *  encryptionKey[1][0]);
        int[][] inverseMod = new int[2][2];
	    while(determanent>26){
		    determanent = determanent -26;
	    }
        int xdet = xgcd(determanent,26);
        for(int i = 0; i <= encryptionKey.length-1; i ++){
            for(int j = 0; j <= encryptionKey[0].length-1; j++){
                if (j == i){
                    inverseMod[i][j] = encryptionKey[encryptionKey[i].length-1 -i][encryptionKey[j].length-1 -j];
                    inverseMod[i][j] = (inverseMod[i][j] * xdet)%26;
                }else{
                    inverseMod[i][j] = encryptionKey[i][j] * -1;
                    inverseMod[i][j] = (inverseMod[i][j] * xdet) %26;
                }
                while(inverseMod[i][j] < 0){
                    inverseMod[i][j] = inverseMod[i][j] +26;
                }
            }
        }
        return inverseMod;
    }
    public int xgcd (int inE, int inZ) {

		int d_old = inZ;
		int d_new = inE;
		int t_old = 0;
		int t_new = 1;
		int s_old = 1;
		int s_new = 0;
		int q = Math.floorDiv(inZ, inE);
		while (d_new > 0) {
			int temp_d = d_new;
			d_new = d_old - d_new*q;
			d_old = temp_d;
			int temp_t = t_new;
			t_new = t_old - t_new*q;
			t_old = temp_t;
			int temp_s = s_new;
			s_new = s_old - s_new*q;
			s_old = temp_s;
			if (d_new != 0) {
				q = Math.floorDiv(d_old, d_new);
			}
		}

		if (d_old != 1) {
			return -1;
		}

		if (t_old < 0) {
			t_old += inZ;
		}

		//System.out.println(t_old);
		return t_old;
	}


    public int[] encrypt(int plaintext[], int encryptionKey[][]) {
        int encryptedVector[] = new int[plaintext.length];

        for (int i = 0; i < plaintext.length; i += encryptionKey.length) {
            for (int row = 0; row < encryptionKey.length; row++) {
                encryptedVector[i + row] = 0;
                for (int column = 0; column < encryptionKey[0].length; column++) {
                    encryptedVector[i + row] += encryptionKey[row][column] * plaintext[i + column];
                }
                encryptedVector[i + row] = encryptedVector[i + row] % 26;
            }
        }

        return encryptedVector;
    }

    public int[] decrypt(int ciphertext[], int decryptionKey[][]) {
        int decryptedVector[] = new int[ciphertext.length];

        for (int i = 0; i < ciphertext.length; i += decryptionKey.length) {
            for (int row = 0; row < decryptionKey.length; row++) {
                decryptedVector[i + row] = 0;
                for (int column = 0; column < decryptionKey[0].length; column++) {
                    decryptedVector[i + row] += decryptionKey[row][column] * ciphertext[i + column];
                }
                decryptedVector[i + row] = decryptedVector[i + row] % 26;
            }
        }

        return decryptedVector;
    }

    public void encryptionTest () {
        int encryptionKey[][] = new int[2][2];
        encryptionKey[0][0] = 16;
        encryptionKey[0][1] = 7;
        encryptionKey[1][0] = 9;
        encryptionKey[1][1] = 14;

        int decryptionKey[][] = findDecryptionKey(encryptionKey);

        System.out.println("Decryption Key =");
        for (int i = 0; i < decryptionKey.length; i++) {
            System.out.print("[");
            for (int j = 0; j < decryptionKey[0].length; j++) {
                System.out.print(decryptionKey[i][j]);
                if (j != decryptionKey[0].length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println("]");
        }

        System.out.println();


        String plainText = "JMUCSISCOOL";
        if (plainText.length() % 2 == 1) {
            plainText += 'Z';
        }
        int plainTextArray[] = new int[plainText.length()];
        for (int i = 0; i < plainText.length(); i++) {
            plainTextArray[i] = plainText.charAt(i) - 'A';
        }

        int cipherText[] = encrypt(plainTextArray, encryptionKey);

        String cipherTextString = "";
        for (int i = 0; i < cipherText.length; i++) {
            cipherTextString += (char) (cipherText[i] + 'A');
        }

        System.out.println("Encrypted result: " + cipherTextString);
        System.out.println();

        String newCipherText = "MQGVGQSMJI";

        int newCipherArray[] = new int[newCipherText.length()];
        for (int i = 0; i < newCipherText.length(); i++) {
            newCipherArray[i] = newCipherText.charAt(i) - 'A';
        }

        int decrptedMessage[] = decrypt(newCipherArray, decryptionKey);

        String clearTextString = "";
        for (int i = 0; i < decrptedMessage.length; i++) {
            clearTextString += (char) (decrptedMessage[i] + 'A');
        }

        System.out.println("Decrption result: " + clearTextString);
        System.out.println();
    }

    public static void main (String[] args) {
		MandelbaumTheoGuerreroChristianCipher testObj = new MandelbaumTheoGuerreroChristianCipher();
        int[][] nums = new int[2][2];
        nums[0][0] = 8;
        nums[0][1] = 5;
        nums[1][0] = 3;
        nums[1][1] = 7; 

		System.out.println ("********** Project 3 output begins ********** ");
        System.out.println();

        testObj.encryptionTest();
        /*nums = testObj.findDecryptionKey(nums);
        System.out.println(nums[0][0]);
        System.out.println(nums[0][1]);
        System.out.println(nums[1][0]);
        System.out.println(nums[1][1]);
        
        int[] text = {3,20};
        testObj.encrypt(text, nums);*/


	}
}

