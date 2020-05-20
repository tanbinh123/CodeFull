/**
 * This class includes information of an account
 * 
 * @author: Dinh Dat Thong
 * @version: 1.0
 * */

package Thong;

import java.io.Serializable;

public class Account implements Serializable {
	
	/* instance's variables */
	protected String username;
	protected String password;
	
	/* constructors */
	public Account(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	/* getters / setters */
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	/* instance's methods */
	// 1 - this methods test if the pass-through string equals password or not
	public boolean doesPasswordEqual(String password) {
		return this.password.equals(password);
	}
	// end of doesPasswordEqual
}