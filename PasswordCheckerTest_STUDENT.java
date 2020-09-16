
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *@author Tsegaye
 */
public class PasswordCheckerTest_STUDENT {

	@Before
	public void setUp() throws Exception {
		String[] x = {"334455BB", "Im2cool4U#", "george2ZZ", "4sal#", "bertha22#", "4wardMarch#",
				"august30", "abcdef", "Applesxx#", "aa11b", "pilotProject", "myPassword", 
				"myPassword2"};
		ArrayList<String>passwords = new ArrayList<String>();
		passwords.addAll(Arrays.asList(x)); 
		
	}

	@After
	public void tearDown() throws Exception {
	
	}

	/**
	 * Test if the password is less than 8 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		//fail("Not implemented by student yet");
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("qweABC12#"));
			PasswordCheckerUtility.isValidPassword("qb12#");
			assertTrue("Did not throw lengthException",false);
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a lengthExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides lengthException",false);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		//fail("Not implemented by student yet");
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("$234567aA#"));
			PasswordCheckerUtility.isValidPassword("$234567a#");
			assertTrue("Did not throw NoUpperAlphaException",false);
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Successfully threw a NoUpperAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoUpperAlphaException",false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		//fail("Not implemented by student yet");
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("$$234567Aa#"));
			PasswordCheckerUtility.isValidPassword("$$234567A#");
			assertTrue("Did not throw NoLowerAlphaException",false);
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoLowerAlphaException",false);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		//fail("Not implemented by student yet");
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("QQs34aaAA#"));
			boolean weakPwd = PasswordCheckerUtility.isWeakPassword("QQs34aaA#");
			assertTrue(weakPwd);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some incorrect exception",false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		//fail("Not implemented by student yet");
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("1234aaAA#"));
			PasswordCheckerUtility.isValidPassword("1234aAAA#");
			assertTrue("Did not throw an InvalidSequenceException",false);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Successfully threw an InvalidSequenceExcepetion",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides an InvalidSequenceException",false);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		//fail("Not implemented by student yet");
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("4567567Aa#"));
			PasswordCheckerUtility.isValidPassword("4567567A#");
			assertTrue("Did not throw NoDigitException",false);
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Successfully threw a NoDigitExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoDigitException",false);
		}
		
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		fail("Not implemented by student yet");
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		
		ArrayList<String> results = null;
		results = PasswordCheckerUtility.getInvalidPasswords(results);
		Scanner scan = new Scanner(results.get(0)); //
		assertEquals(scan.next(), "1223455B");
		String nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("qwerty"));
		
		scan = new Scanner(results.get(1)); //
		assertEquals(scan.next(), "qwertY77");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("@#$%^&&^%$#"));
		
		scan = new Scanner(results.get(3)); //
		assertEquals(scan.next(), "qwert#ww");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("ASFCVCX"));
		
		scan = new Scanner(results.get(5)); //
		assertEquals(scan.next(), "abcdef");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("uppercase") || nextResults.contains("digit"));
		
		scan = new Scanner(results.get(6)); //a
		assertEquals(scan.next(), "Applesxx#");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("digit"));
	}
	
}