package ceasars.cipher;

public class CaesarsCipher {
	
	private static final char LETTER_A = 'a';
	private static final char LETTER_Z = 'z';
	private static final char ALPHABET_SIZE = 26;
	
	public String cipher(String message, int offset) {
		offset %= ALPHABET_SIZE;
		char[] characterArray = message.toCharArray();
		offsetBy(characterArray, offset);
		return new String(characterArray);
	}

	private void offsetBy(char[] characterArray, int offset) {
		for (int i=0; i< characterArray.length; ++i) {
			if(characterArray[i] != ' ') {
				characterArray[i] = offsetChar(characterArray[i], offset, LETTER_A, LETTER_Z);
			}
		}
	}

	private char offsetChar(char c, int offset, char letterA, char letterZ) {
		c += offset;
		if(c < letterA) {
			return (char) (c + ALPHABET_SIZE);
		}
		if(c > letterZ) {
			return (char) (c - ALPHABET_SIZE);
		}
		return c;
	}

}
