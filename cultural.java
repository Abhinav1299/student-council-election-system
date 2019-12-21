package begin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class cultural extends student{
	
	private static final long serialVersionUID = 1L;
	static Scanner sc=new Scanner(System.in);

	public int vote_for(student ob) throws IOException, ClassNotFoundException                //function that will check whether candidate has voted or not.
	{
		student s=null;
		FileInputStream is = new FileInputStream("C:\\Users\\Dell\\Desktop\\project\\g_cultural_vote.txt");	// candidates who have given their vote in general cultural elections.	
		while(is.available()>0)
		{
			ObjectInputStream ois = new ObjectInputStream(is);
			s = (student) ois.readObject();
			if(ob.ID==s.ID)
			{
				System.out.println("you have already voted.");
				return 1;
			}
		}	
		
		is.close();
		//candidate has not voted hence he will be allowed to vote
		
		try 
		{	
			FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\Dell\\Desktop\\project\\g_cultural_vote.txt"),true);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			int k=0;
			while(true)
			{
				System.out.println("1. vote");
				System.out.println("2. go back");
				int q=sc.nextInt();
				switch(q)
				{

					case 1: try 
							{
								vote();               //function that will allow the candidate to vote
								k=1;                //if vote is successfull

								oos.writeObject(ob);
							}
							catch (ClassNotFoundException e)
							{
								
								e.printStackTrace();
							} 
							catch (IOException e)
							{
						
								e.printStackTrace();
							}
							break;
					case 2: k=1;
							break;
							
					default: System.out.println("wrong choice...");		
				}
				if(k==1)
				{
					break;
				}
			}
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
			return 0;
}

	public static void vote() throws IOException, ClassNotFoundException
	{

		FileInputStream is = new FileInputStream("C:\\Users\\Dell\\Desktop\\project\\c_selected.txt");  //going in c_selected to display the data of registered candidates
		
		int count=0;
		student so=null;
		
		while(is.available()>0)
		{
			ObjectInputStream ois1 = new ObjectInputStream(is);             //reading the file to know number of registered candidates
			so= (student) ois1.readObject();
			count++;
		}
		is.close();                      //

		student s[]=new student[count];   //storing the student object data in an array
		
		FileInputStream is1 = new FileInputStream("C:\\Users\\Dell\\Desktop\\project\\c_selected.txt");	
		if(is1.available()==0)
		{
			System.out.println("no registered candidates yet.");
			return;
		}
		int i=0;
		int input;
		while(is1.available()>0)
		{
			ObjectInputStream ois = new ObjectInputStream(is1);// printing data 
			s [i]= (student) ois.readObject();
			System.out.print("Candidate Number :"+ (i+1));
			System.out.print(" 	name :  "+s[i].name);
			
			System.out.print(" 	id :  "+s[i].ID);
			
			System.out.print("	batch :  "+s[i].batch);
			
			System.out.print("	branch :  "+s[i].branch);
			
			System.out.println();	
             i++;
		}
		is1.close();
		
		int k=0;
		while(true)
		{
			System.out.println("enter the candidate ID to vote for : ");
			input=sc.nextInt();
			for(int j=0;j<s.length;j++)
			{
				if(s[j].ID==input)
				{
//					s[j].c_comittee+=1;			// c_comittee is for counting votes for selected candidates
					k=1;
					break;
				}
			}
			
			if(k==1)
			{
				break;
			}
			else
			{
				System.out.println("you entered wrong ID please retry");
			}
		}	
			try 
			{	
				BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Dell\\Desktop\\project\\stats_gen_cult.txt", true)  //Set true for append mode
                    );  
   //Add new line
				String h=Integer.toString(input);
				writer.write(h);
				writer.newLine();
				writer.close();
				System.out.println("Done");
		
				
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
			finally
			{
//				sc.close();
			}
			
			
		}
		
}



