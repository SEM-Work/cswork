/**
*Created by Ethan Helfman and Abhi Bhattaru
*Get the url of a website and generates a password based on it
**/

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class passwordproject {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter website: ");
		String url = kb.next();
		String pass = createPassword(url);
		System.out.println("The password for " + url + " is " + pass + ".");
		kb.close();
	}
	
	public static String createPassword(String x){
		String url = x;
		url = url.toLowerCase();
		String site = url.substring(0, url.indexOf('.'));
		String tld = url.substring(url.indexOf('.') + 1);
		site = site.toLowerCase();
		char[] siter = site.toCharArray();
		String pass = "";
		for(char c : siter)
			pass += (char)(((int)c) + 1);
		siter = pass.toCharArray();
		pass = "";
		for(int i = 0; i < siter.length; i++) {
			if(ispowtwo(i + 1))
				siter[i] = Character.toUpperCase(siter[i]);
			pass += siter[i];
		}
		siter = site.toCharArray();
		for(int i = 0; i < siter.length; i++)
			pass += "" + alphatonum(siter[i]);
		String finalpass = alphatonum(tld.charAt(0)) + pass;
		/*start hell
		siter = finalpass.toCharArray();
		finalpass = "";
		for(int i = 0; i < siter.length; i++)
			finalpass += alphatonum(siter[i]);
		siter = finalpass.toCharArray();
		finalpass = "";
		for(int i = 0; i < siter.length; i++)
			finalpass += alphatonum(siter[i]);
		siter = finalpass.toCharArray();
		finalpass = "";
		for(int i = 0; i < siter.length; i++)
			finalpass += alphatonum(siter[i]);
			*/
		return finalpass;
	}
	
	public static boolean ispowtwo(int i) {
		if(i % 2 == 0)
			return ispowtwo(i / 2);
		else if(i == 1)
			return true;
		else
			return false;
	}
	
	public static int alphatonum(char c) {
	    int k = (int)c;
	    if(k > 96 && k < 123)
	        return k - 96;
	    return c;
	}

	
}
