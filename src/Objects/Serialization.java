
package Objects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Serialization {
	static Cat cat;
	public static List<Cat> cats;
	
	public static void main(String[] args) {
		
		cats = new ArrayList();
		Cat vasia = new Cat("Vasia", "Cat");
		Cat murchik = new Cat("Murchik", "Cat");
		vasia.collar = new Collar(25);
		murchik.collar = new Collar(15);
		
		try(ObjectOutputStream saver = new ObjectOutputStream(
				new FileOutputStream(new File("c:\\Users\\matt\\Desktop\\cats.txt")));){
			saver.writeObject(vasia);
			saver.writeObject(murchik);
		} catch (FileNotFoundException ex) {ex.printStackTrace();
		} catch (IOException ex) {ex.printStackTrace();}
		
		try(ObjectInputStream is = new ObjectInputStream(new FileInputStream("c:\\Users\\matt\\Desktop\\cats.txt"))){
			while (true) {
				cats.add((Cat) is.readObject());
			}
		}catch(IOException e){System.out.println(e);} 
		catch (ClassNotFoundException ex) {System.out.println(ex);}

	
		for (Cat cat : cats){
			System.out.println(cat.getName());
			System.out.println(cat.collar.getSize());
			System.out.println(cat.type);
		}
		
	}
}

class Cat extends Animal implements Serializable{
	
	private static final long serialVersionUID = 6549587086947757690L;
	transient Collar collar;
	private String name;
	
	public Cat(String name, String type){
		this.name = name;
		this.type = type;

	}
	
	public String getName(){
		return this.name;
	}
	
	private void writeObject(ObjectOutputStream os){
		try{
			os.defaultWriteObject();
			// class Collar is not serializable, need to implement saving method for this field
			os.writeInt(collar.getSize());
			// during deSerialization this var will be set to Parent's defaul value if saving method is not implemented
			os.writeUTF(type);
		}catch(IOException e){e.printStackTrace();}
	}

	private void readObject(ObjectInputStream is) {
		try{
			is.defaultReadObject();
			collar = new Collar(is.readInt());
			type = is.readUTF();
		}catch(IOException e){
			e.printStackTrace();
		}catch(ClassNotFoundException c){
			c.printStackTrace();
		}
	}
}

class Collar{
	private int size;
	public Collar(int size){
		this.size = size;
	}
	public int getSize(){
		return this.size;
	}
	public void setSize(int size){
		this.size = size;
	}
}

class Animal{
	String type = "Animal";
}