package begin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class student extends admin implements Serializable 
{
	
	static Scanner sc=new Scanner(System.in);
	private static final long serialVersionUID = 1L;
	
	String name;
	int ID;
	String DOB;
	String password;
	int batch;
	String branch;
	long phone;
	String e_mail;
	
	public student()
	{
		name=null;
		ID=0;
		DOB=null;
		password=null;
		batch=0;
		branch=null;
		phone=0;
		e_mail=null;
	}

	
	public void input()
	{
		
		System.out.print("enter name :  ");
		this.name=sc.next();
		System.out.print("enter id :  ");
		this.ID=sc.nextInt();
		System.out.print("enter dob : ");
		this.DOB=sc.next();
		System.out.print("enter batch :  ");
		this.batch=sc.nextInt();
		System.out.print("enter branch :  ");
		this.branch=sc.next();
		System.out.print("enter phone : ");
		this.phone=sc.nextLong();
		System.out.print("enter email :  ");
		this.e_mail=sc.next();
		System.out.print("enter password :  ");
		this.password=sc.next();
		
		try 
		{	
			FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\Dell\\Desktop\\project\\a.txt"),true);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			// write object to file
			oos.writeObject(this);
			System.out.println("Done");
			oos.close();
			fos.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
//			sc.close();
		}
		
		
	}
	
	
	public void output() throws IOException, ClassNotFoundException
	{

		student s=null;
		
		
		FileInputStream is = new FileInputStream("C:\\Users\\Dell\\Desktop\\project\\a.txt");	
		while(is.available()>0)
		{
			ObjectInputStream ois = new ObjectInputStream(is);
			s = (student) ois.readObject();

			System.out.print(" 	name :  "+s.name);
			
			System.out.print(" 	id :  "+s.ID);
			
			System.out.print("	dob : "+s.DOB);
			
			System.out.print("	batch :  "+s.batch);
			
			System.out.print("	branch :  "+s.branch);
			
			System.out.print("	phone : "+s.phone);
			
			System.out.print("	email :  "+s.e_mail);
			System.out.println();	

		}
		System.out.println();
		System.out.println();
		is.close();
	}
	
	
}
