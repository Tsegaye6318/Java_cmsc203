import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This program checks the validity of a password for the methods of PasswordChecker
 *@author Tsegaye
 */
		public class PasswordCheckerUtility {
		public PasswordCheckerUtility() {
			
		}
		/**
	     * Checks whether a given password is valid or not
	     * @param passwordString is variable password
	     * @return boolean true for a valid password and false for an invalid
	     * @throws LengthException
	     * @throws InvalidSequenceException 
	     * @throws NoDigitException
	     * @throws NoLowerAlphaException
	     * @throws NoUpperAlphaException
	     * @throws NoSpecialSymbolException
	     */
		public static boolean isValidPassword(String passwordString) throws LengthException,
																	NoDigitException,
																	NoUpperAlphaException,
																	NoLowerAlphaException,
																	InvalidSequenceException,
																	NoSpecialSymbolException {//
			
	boolean valid;
	//boolean weak;
	if (passwordString.length() < 6)
        throw new LengthException("Password must contain at least 6 characters");
    
    else if (matched("(?s).*[A-Z].*", passwordString) == false)
        throw new NoUpperAlphaException("Must contain at least one upper case letter");
    
    else if (matched(".*[a-z].*", passwordString) == false)
        throw new NoLowerAlphaException("Password must contain at least one lower case letter");
    
    else if (matched("(.)*(\\d)(.)*", passwordString) == false)
        throw new NoDigitException("Password must contain at least one digit");
	
    else if(matched("(.*[@#$%^&+=!].*)",passwordString)==false)
    	throw new NoSpecialSymbolException("Password must contain at least one special character");//
    
    else if (specialChar(passwordString) == true)
        throw new InvalidSequenceException("Cannot contain more than 2 of the same characters in a sequence");
    
    else 
        valid = true;
	return valid;
	}

	public static boolean isWeakPassword(String passwordString) {
		
	boolean weak=false;
	
	if(passwordString.length() >= 6 && passwordString.length() <= 10)
        weak = true;
	return weak;
	}
	
	/**
     * specialChar works on whether the password have more than 2 repeated character in sequence
     * @param password1 is the value of password
     * @return boolean of value true if a character is reaped more than 2 in sequence
     */
	private static boolean specialChar(String password1) { 
	    
	    char[] arr;
	    boolean rptdInSequance = false; 
	    
	    arr = password1.toCharArray();
	   
	    for (int i = 0; i < arr.length; i++) {
	        
	        if(i > (arr.length - 3))
	            break;
	        
	        else if (arr[i] == arr[i + 1] && arr[i] == arr[i + 2])
	            rptdInSequance = true;
	        
	    }

	    return rptdInSequance; 
	    }
	/**
     * matched is used to compare the password with regular expression
     * @param regex is a string of regex 
     * @param password String variable of the password
     * @return a boolean value of true if password is in regex otherwise false
     */
	
	private static boolean matched(String regex, String password) {
	    
	    Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(password); 
	    
	  
	   return matcher.matches();
	   }
	
	/**
     * getInvalidPasswords returns ArrayList of invalid passwords  
     * @param passwords ArrayList of strings that will hold lists of passwords 
     * @return a Strings of ArrayList of invalid passwords and Their strength based on their length
     */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
	ArrayList<String> password11 = new ArrayList<>(); 
     
    for(int counter = 0; counter < passwords.size(); counter++) {

        if(passwords.get(counter).length() < 6)
           password11.add(passwords.get(counter) + "*" + "Password must contain at least 6 characters"); 
        else if(matched("(?s).*[A-Z].*", passwords.get(counter)) == false)
           password11.add(passwords.get(counter) + "*" + "Password must contain at least one uppercase letter");
        else if(matched(".*[a-z].*", passwords.get(counter)) == false)
            password11.add(passwords.get(counter) + "*" + "Password must contain at least one lowercase letter");
        else if(matched("(.)*(\\d)(.)*", passwords.get(counter)) == false)
            password11.add(passwords.get(counter) + "*" + "Password must contain at least one digit");
        else if(specialChar(passwords.get(counter)) == true)
            password11.add(passwords.get(counter) + "*" + "Password cannot contain more than 2 of the same characters in a sequence");
        }
    return password11;
    }
}
