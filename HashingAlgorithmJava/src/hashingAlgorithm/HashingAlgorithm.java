package hashingAlgorithm;

import java.math.BigInteger;

public class HashingAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(hash("hello"));
		
	}
	
	/*
	 * hashes a string
	 */
	public static String hash(String subject) {
		
		//initialising variables
		String result = "";
		//used to hold the running total
		BigInteger total = new BigInteger("1");
		//stores the index of the exponent char
		int j;
		//the base which will have the exponent used on it
		BigInteger base;
		//the exponent which will be used on the base
		int exponent;
		//the result of the base ** exponent
		BigInteger beResult = new BigInteger("1");
				
		//iterating through each char in the subject
		for (int i = 0; i < subject.length(); i++) {
					
			//setting the index of the char which will calculate our exponent
			//if the index is the first, it uses the last char
			if (i == 0) {
						
				j = subject.length() - 1;
					
			//if the index is any other, it uses the previous char
			} else {
				j = i - 1;
			}
					
			//setting the values of the base and exponent
			exponent = (int)subject.charAt(j);
			base = new BigInteger(String.valueOf((int)subject.charAt(i)));
				
			//raising the base to the exponent
			//this is done is a BigInteger because the results can get very large
			for (int b = 0; b < exponent; b++) {
				beResult = beResult.multiply(base);
			}
					
			//multiplying the result by the total, this generates a very large number
			total = total.multiply(beResult);
		}
				
		result = String.valueOf(total);
		
		
		//-------------------------------------depending on algorithm, keys may be truncated or formatted differently
		
		int length = 64;
		
		//-------------------------------------

		//truncation
		//ensuring that the result is no more than 64 chars
		if (result.length() > length) {
					
			result = result.substring(0, length-1);
					
		//adding to the string if less that 64 chars
		} else {
					
			//calculating how many characters are missing
			int gap = 64 - result.length();
					
			//take the *gap* amount of chars from the beginning of the string
			String append = result.substring(0, (gap-1));
			result = result.concat(append);
		}

		return result;
	}
	
}
