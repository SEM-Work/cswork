import java.util.Scanner;

public class passwordproject {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter website: ");
		String url = kb.next();
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
		pass += alphatonum(site.charAt(site.length() - 2)) + "" + alphatonum(site.charAt(site.length() - 1));
		String finalpass = alphatonum(tld.charAt(0)) + pass;
		System.out.println(finalpass);
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
	    return -1;
	}

}
