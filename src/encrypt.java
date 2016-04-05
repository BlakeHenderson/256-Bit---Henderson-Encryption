import java.util.*;
import java.math.*;
import java.nio.charset.StandardCharsets;

public class encrypt {
	
	static String binaryString = "";
	static int numChars;
	
	public static void main(String[] args){
		convert();
		String bitCode = generateCode();
		encrypt(binaryString, bitCode);
		decrypt();
	}
	
	public static String generateCode(){
		System.out.println("Generating 256 Bit...");
		
	    String random = "";
		Random randomGenerator = new Random();
		
		for (int i= 1; i <= 128; ++i){
			int randomInt = randomGenerator.nextInt(9);
		    random += randomInt;
		} 
		
		System.out.println("Key: " + random + "\n");
		
		return random;
	}
	
	public static void encrypt(String message, String code){
		System.out.println("Beginning Encryption...");
		BigInteger codeParse = new BigInteger(code);
		BigInteger messageParse = new BigInteger(message);
		
		BigInteger codePower = new BigInteger((codeParse.multiply(messageParse)).toString());
		codePower.pow(numChars);
		
		System.out.println(codePower);
		
		System.out.println("End Encryption.");
	}
	
	public static void convert(){
		Scanner userInput = new Scanner(System.in);
		System.out.println("Please Enter your String: ");
		String userString = userInput.nextLine();
		byte[] convert = null;
		convert = userString.getBytes(StandardCharsets.UTF_8);
		
		for (byte b : convert) {
            binaryString += "0" + Integer.toBinaryString(b);
            numChars += 8;
        }
		
		System.out.println("Char Key: " + numChars);
		System.out.println("Binary Value: " + binaryString);
	}
	
	public static void decrypt(){
		Scanner userInput = new Scanner(System.in);
		System.out.println("Please Enter the Char Count: ");
		int charCount = userInput.nextInt();
		
		BigInteger encryptionKey = new BigInteger("0");
		System.out.println("Please Enter the Encryption Key: ");
		encryptionKey = userInput.nextBigInteger();
		
		BigInteger encryptedMessage = new BigInteger("0");
		System.out.println("Please Enter the Ecrypted Message: ");
		encryptedMessage = userInput.nextBigInteger();
		
		BigInteger decrypt = new BigInteger((encryptedMessage.divide(encryptionKey)).toString());
		decrypt.pow(1/charCount);
		
		System.out.print("0" + decrypt.toString());
		
		
		
	}
	
}
