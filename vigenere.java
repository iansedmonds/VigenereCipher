import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;


class vigenere {
	public static void main(String[] args) throws ArrayIndexOutOfBoundsException, FileNotFoundException{
		if(args.length < 2) {
			System.out.println("Invalid amount of arguments.");
			return;
		}
		
		File keyName = new File(args[0]);
		File plainName = new File(args[1]);
		if(keyName.exists() == false) {
			System.out.println("Key file name does not exist.");
			return;
		}
		if(plainName.exists() == false) {
			System.out.println("Message file name does not exist");
			return;
		}
	
		String keyPath = keyName.getAbsolutePath();
		String plainPath = plainName.getAbsolutePath();
		
		File keyFile = new File(keyPath);
		Scanner scan = new Scanner(keyFile);
		String key = "";
		
		while(scan.hasNextLine()) 
		{
			key = key.concat(scan.nextLine());
		}
		scan.close();
		
		
		File plainFile = new File(plainPath);
		Scanner scanner = new Scanner(plainFile);
		String plainText = "";
		
		while(scanner.hasNextLine())
		{
			plainText = plainText.concat(scanner.nextLine());
		}
		
		scanner.close();
		
		
		//entire files are set to strings
		//prints out unmodified key and plain text
		
		
		
		
		try {	
			BufferedReader br = new BufferedReader(new FileReader(keyFile));
			br.close();
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		
		//change to alphabetic characters only
		//changes to lowerecase
		int i;
		
		//changes to alphabetic characters only
		//changes letters to lowercase
		String keyText = new String();
		char[] keyArray = key.toCharArray();
		for(i = 0; i < keyArray.length; i++)
		{
			if((keyArray[i] >= 'A' && keyArray[i] <= 'Z' || keyArray[i] >= 'a' && keyArray[i] <= 'z'))
			{
				keyText =  keyText + keyArray[i];
				keyText = keyText.toLowerCase();
			}
		}
		
		System.out.println();
		System.out.println("Vigenere Key:");
		System.out.println();
		char[] myArray = keyText.toCharArray();
		for(i = 0; i < myArray.length; i++)
		{
			System.out.print(myArray[i]);
			if((i + 1) % 80 == 0)
			{
				System.out.println();
			}
		}
		
		//changes key to 512 characters
		if(keyText.length() < 512)
		{
			while(keyText.length() < 512)
			{
				keyText = keyText.concat(keyText);
			}
		}
		if(keyText.length() > 512)
		{
			keyText = keyText.substring(0, 512);
		}
		
		//keyText has everything ready for encryption
		
		String plain = new String();
		char[] plainArray = plainText.toCharArray();
		for(i = 0; i < plainArray.length; i++)
		{
			if((plainArray[i] >= 'A' && plainArray[i] <= 'Z' || plainArray[i] >= 'a' && plainArray[i] <= 'z'))
			{
				plain =  plain + plainArray[i];
				plain = plain.toLowerCase();
			}
		}		
		
		//changes plain text to 512 characters
		if(plain.length() > 512)
		{
			plain = plain.substring(0, 512);
		}
		if(plain.length() < 512)
		{
			while (plain.length() < 512)
			{
				plain = plain.concat("x");
			}
		}
		
		
		//plain has everything ready for encryption
		//change key text and plain to arrays and then
		//iterate through with a for loop and then 
		//add every letter for each individual character using ASCII
		
		// ASCII 'a' = 97
		// Vigenere 'a' = 0;
		char[] ptArr = plain.toCharArray();
		char[] kArr = keyText.toCharArray();
		
		System.out.println();
		System.out.println();
		System.out.println("Plain text:");
		System.out.println();
		for(i = 0; i < ptArr.length; i++)
		{
			System.out.print(ptArr[i]);
			if((i + 1) % 80 == 0)
			{
				System.out.println();
			}
		}
		
		int cipherVal;
		
		
		System.out.println();
		System.out.println();
		System.out.println("Cipher Text:");
		System.out.println();
		
		//cipher text must print only 80 characters per line
		for(i = 0; i < plain.length(); i++)
		{
			cipherVal = ((ptArr[i] - 'a') + (kArr[i] - 'a')) % 26 + 'a';
			char cipherLetter = (char) cipherVal;
			
			System.out.print(cipherLetter);
			if((i + 1) % 80 == 0)
			{
				System.out.println();
			}
		}	
		
		System.out.println();
		System.out.println();
			
	}

}
