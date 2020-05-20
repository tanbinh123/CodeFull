/**
 * This class is a parameterized class that describes Data Abstract Object
 * It contains some methods like:
 * - add one object to a list
 * - remove one object from the list
 * - update data from one object of the list
 * - find the object from the list
 * - store the list
 * - load the list
 * - get the list
 * 
 * @author: Dinh Dat Thong
 * @version: 1.0
 * */

package Thong;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

abstract public class DAO<Entity> {
	/* class's variables */

	/* instance variables */
	protected List<Entity> list = new ArrayList<Entity>(); // this list is parameterized class, its role is simply like a array

	/* instance methods */
	// 1 - this method adds one entity of type Entity to the list 
	public void add(Entity entity) {
		list.add(entity);
	}
	// end of add
	
	
	// 2 - this method removes one entity of type Entity from the list
	public void remove(Entity entity) {
		list.remove(entity);
	}
	// end of remove
	
	// 3 - this method updates data of one Entity from the list
	abstract public void update(Entity entity);
	// end of update
	
	// 4 - this method finds the Entity from the list
	abstract public Entity find(Serializable id);
	// end of find
	
	// 5 - this method returns the list
	public List<Entity> getList() {
		return list;
	}
	// end of getList
	
	// 6 - this method saves the list into a file based on the path
	public void save(String path) {
		/* variables */
		ObjectOutputStream oos;

		/* program */
		try {
			oos = new ObjectOutputStream(new FileOutputStream(path));
			oos.writeObject(list);
			oos.close();
		}
		catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	// end of save
	
	// 7 - this method loads a file of list from a path
	public void load(String path) {
		/* variables */
		ObjectInputStream ois;
		
		/* program */
		try {
			ois = new ObjectInputStream(new FileInputStream(path));
			list = (List<Entity>) ois.readObject();
			ois.close();
		}
		catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	// end of load
}
