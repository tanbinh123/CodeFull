package helper;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ValidationHelper {
	/**
	 * check for text field's emptiness
	 * */
	public static boolean isEmpty(JTextField txt) {
		if (txt.getText().trim().equals("")) {
			return true;
		}
		return false;
	}
	
	/**
	 * check for string's emptiness
	 * */
	public static boolean isEmpty(String str) {
		if (str.trim().equals("")) {
			return true;
		}
		return false;
	}
	
	/** 
	 * this method returns a right modiffied name
	 */
    public static String toTitleCase(String string) {
    	/* variables */
        StringBuilder sb = new StringBuilder();
        boolean nextTitleCase = true;
        
        /* program */
        string = string.trim().replaceAll("( )+", " ");
        
        for (char c : string.toLowerCase().toCharArray()) {
            if (Character.isLetterOrDigit(c) == false) {
                nextTitleCase = true;
            }
            else if (nextTitleCase == true) {
                c = Character.toTitleCase(c);
                nextTitleCase = false;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    /**
     * check for password's format. Password has as least 3 characters and just 30 characters.
     * */
    public static boolean isPassword(JPasswordField txt) {
    	if (new String(txt.getPassword()).length() < 3 || new String(txt.getPassword()).length() > 30) {
    		return false;
    	}
    	return true;
    }
    
    
    /**
     * check for name's format. Name has no digits.
     * */
    
    public static boolean isName(JTextField txt) {
    	if (txt.getText().trim().matches(".*\\d+.*")) {
    		return false;
    	}
    	return true;
    }
    
    /**
     * check for a code. That code has at least a specific number of characters.
     * */
    public static boolean isID(JTextField txt, int number) {
    	if (txt.getText().trim().length() >= number) { 
    		return true;
    	}
    	return false;
    }
    
    /**
     * check for a positive real number from text field
     * */
    public static boolean isPositive(JTextField txt) {
    	String a = txt.getText().trim();
    	double b = -1;
    	
    	try {
    		b = Double.parseDouble(a);
    	} 
    	catch (Exception ex) {
    		return false;
    	}
    	
    	if (b >= 0) {
    		return true;
    	}
    	return false;
    }
    
    /**
     * check for email's format from text field
     * */
    public static boolean isEmail(JTextField txt) {
    	if (txt.getText().trim().matches("^[a-z][a-z0-9_\\.]{2,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$")) {
    		return true;
    	}
    	return false;
    }
    
    /**
     * check for score's format from a text field
     * */
    public static boolean isScore(JTextField txt) {
    	String a = txt.getText().trim();
    	double b = -1;
    	
    	try {
    		b = Double.parseDouble(a);
    	} 
    	catch (Exception ex) {
    		return false;
    	}
    	
    	if ((b <= 10 && b >= 0) || b == -1) {
    		return true;
    	}
    	return false;
    }
    
    /**
     * check for score's format from a string
     * */
    public static boolean isScore(String a) {
    	double b = -1;
    	
    	try {
    		b = Double.parseDouble(a);
    	} 
    	catch (Exception ex) {
    		return false;
    	}
    	
    	if ((b <= 10 && b >= 0) || b == -1) {
    		return true;
    	}
    	return false;
    }
    
    /**
     * check for phone number's format from text field
     * */
    public static boolean isPhoneNumber(JTextField txt) {
    	if (txt.getText().trim().matches("^\\d{10,12}$")) {
    		return true;
    	}
    	return false;
    }
}
