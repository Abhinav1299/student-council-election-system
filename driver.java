
package begin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;



//                       admin
//                         |
//                       student
//            /     |           |            \
//        cultural technical   sports literature

//   files: admin.txt= admin database
//    a.txt= student database
//    c_selected= registered candidates for cultural com
//    g_cultural_vote= students who have given their vote
//    stats_gen_cult = votes saved for general cultural




public class driver {
	
	static Scanner sc=new Scanner(System.in);
	
	
	public static void main_menu() 
	{
		int u=0;
		while(true)
		{
			System.out.println();
			System.out.println("!!  _/\\_ Welcome to Student Council Elections _/\\_ !!");
			System.out.println();
			System.out.println("1. Student login");
			System.out.println("2. Admin login");
			System.out.println("3. Exit");
			System.out.println("Enter your choice =  ");
			int d=sc.nextInt();
			switch(d)
			{
				case 1: login();
						break;
						
				case 2 : admin_login();
					break;
				case 3: u=1;
						break;
				default:System.out.println("you entered wrong choice");
			}
			if(u==1)
			{
				break;
			}
		}
		
		
		
	}
	
	
	public static void admin_login()
	{
		while(true)
		{
			System.out.println();
			System.out.print("Enter your ID : ");
			int id=sc.nextInt();
			System.out.println();
			System.out.print("Enter your password : ");
			String pass=sc.next();
			try 
			{
				int i=admin_check(id,pass);
				if(i==2)
				{
					break;
				}
			} 
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	
	
	public static void login()
	{
		
		while(true)
		{
			System.out.println();
			System.out.print("Enter your ID : ");
			int id=sc.nextInt();
			System.out.println();
			System.out.print("Enter your password : ");
			String pass=sc.next();
			try 
			{
				int i=check(id,pass);
				if(i==2)
				{
					break;
				}
			} 
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	public static int admin_check(int id,String pass) throws IOException, ClassNotFoundException
	{
		admin s=null;
		int k=0;
		FileInputStream is = new FileInputStream("C:\\Users\\Dell\\Desktop\\project\\admin.txt");	
		while(is.available()>0)
		{
			ObjectInputStream ois = new ObjectInputStream(is);
			s = (admin) ois.readObject();
			if(s.admin_id==id && s.admin_password.compareTo(pass)==0)
			{
				System.out.println();
				System.out.println("logined successfully !!");
				k=1;
				System.out.println();
				break;
			}
		}	
		if(k==1)
		{
			admin_options();
			return 2;
		}
		else
		{
			System.out.println("You entered wrong ID or Password...");
			System.out.println("1. Login again");
			System.out.println("2. Go back");
			System.out.println("Enter your choice =  ");
			int input=sc.nextInt();
			switch(input)
			{
				case 1: return 1;  // login();
						
				case 2: return 2;	// main menu()
						
				default: System.out.println("wrong choice...");		
			}
		}
		return 0;
	}
	
	
	public static int check(int id,String pass) throws IOException, ClassNotFoundException
	{
		student s=null;
		int k=0;
		FileInputStream is = new FileInputStream("C:\\Users\\Dell\\Desktop\\project\\a.txt");	
		while(is.available()>0)
		{
			ObjectInputStream ois = new ObjectInputStream(is);
			s = (student) ois.readObject();
			if(s.ID==id && s.password.compareTo(pass)==0)
			{
				System.out.println();
				System.out.println("logined successfully !!");
				k=1;
				System.out.println();
				break;
			}
		}	
		if(k==1)
		{
			options(s);
			return 2;
			
		}
		else
		{
			System.out.println("You entered wrong ID or Password...");
			System.out.println("1. login again");
			System.out.println("2. go back");
			int input=sc.nextInt();
			switch(input)
			{
				case 1: return 1;  // login();
						
				case 2: return 2;	// main menu()
						
				default: System.out.println("wrong choice...");		
			}
		}
		return 0;
	}
	
	public static void general_election() throws IOException
	{
		while(true)
		{
			System.out.println();
			System.out.println();
			System.out.println("!!  _/\\_ Welcome to The General Elections  _/\\_ !!");
			System.out.println("1. Start general elections");
			System.out.println("2. Stop general elections");
			System.out.println("3. Cultural elections stats");
			System.out.println("4. Technical elections stats");
			System.out.println("5. Sports elections stats");
			System.out.println("6. Literature elections stats");
			System.out.println("7. Show result");
			System.out.println("8. Back");
			int a=0,u=0;
			System.out.println("Enter your choice =  ");
			a=sc.nextInt();
			switch(a)
			{
				case 1: BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Dell\\Desktop\\project\\control_election.txt")  //Set true for append mode
		                );  
		//Add new line
					admin.flip_flop=1;			// ff=1 when general elections are started
					String h=Integer.toString(admin.flip_flop);
					writer.write(h);
					writer.newLine();
					writer.close();
					System.out.println("Done");
					break;
					
				case 2: 
					
					BufferedWriter writer1 = new BufferedWriter(new FileWriter("C:\\Users\\Dell\\Desktop\\project\\control_election.txt")  //Set true for append mode
			                );  
			//Add new line
						admin.flip_flop=2;			// ff=2 when general elections are stopped
						String h1=Integer.toString(admin.flip_flop);
						writer1.write(h1);
						writer1.newLine();
						writer1.close();
						System.out.println("Done");
						break;
						
				case 3: 
						 try {
								admin.g_c_list();
							} catch (ClassNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		
						break;
						
						
				case 4: try {
							admin.g_t_list();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	
						break;
						
						
				case 5: try {
							admin.g_s_list();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	
						break;
						
				case 6: try {
							admin.g_l_list();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	
						break;
						
				case 7: 
					
					
						String st=null;
						File file = new File("C:\\Users\\Dell\\Desktop\\project\\control_election.txt");
						BufferedReader br1 = new BufferedReader(new FileReader(file)); 
						st = br1.readLine();
						
						int i=Integer.parseInt(st);
						if(i==2)
						{
						try {
								admin.g_c_result();
								System.out.println();
								admin.g_t_result();
								System.out.println();
								admin.g_s_result();
								System.out.println();
								admin.g_l_result();
								System.out.println();
							
							} catch (ClassNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						else
						{
							System.out.println("elections are going on.");
						}
	
							break;
						
				case 8: u=1;
						break;
						
				
		}
		
		if(u==1)
		{
			break;
		}
		
	}
		
	}
	
	
	public static void admin_options() throws IOException
	{
		while(true)
		{
			
		int u=0;
		System.out.println("1. General election");
		System.out.println("2. Presidential election");
		System.out.println("3. Vice-presidential election");
		System.out.println("4. Start registration and register a candidate in election");		
		System.out.println("5. Add a new student in database");
		System.out.println("6. View list");
		System.out.println("7. Exit");
		
		int input=sc.nextInt();
		switch(input)
		{
			case 1: 
					general_election();
					break;
			case 2: 
					break;
			case 3: 
					break;
			case 4: admin.register();
					break;
			case 5: student s=new student();
					s.input();
					break;
			case 6: student s1=new student();
					try {
						s1.output();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
							break;
			case 7: u=1;
					break;
			default: System.out.println("wrong choice...");		
		}
		if(u==1)
		{
			break;
		}
		}
	}
	
	
	public static int options(student ob) throws IOException
	{
		String st=null;
		File file = new File("C:\\Users\\Dell\\Desktop\\project\\control_election.txt");
		BufferedReader br1 = new BufferedReader(new FileReader(file)); 
		st = br1.readLine();
		if(st==null)
		{
			System.out.println("elections are not started.");
		}
		
		else
		{
			int k=Integer.parseInt(st);
			if(k==0)
			{
				System.out.println("registrations are going on.");
				return 1;
			}
			if(k==2)
			{
				System.out.println("general elections are closed.");
				return 1;
			}
			if(k==1)
			{
				int u=0;
				while(true)
				{
				System.out.println("welcome to the general elections");
				System.out.println("1. cultural");
				System.out.println("2. technical");
				System.out.println("3. sports");
				System.out.println("4. literature");
				System.out.println("5. back");
				int input=sc.nextInt();
				switch(input)
				{
					case 1: cultural c=new cultural();
							try
							{
								int d=c.vote_for(ob);
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
					case 2: 
						
							technical t=new technical();
							try
							{
								int d=t.vote_for(ob);
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
					case 3: 
						
						sports s=new sports();
						try
						{
							int d=s.vote_for(ob);
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
					case 4: 
						
						literature l=new literature();
						try
						{
							int d=l.vote_for(ob);
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
						
					case 5: u=1;
							break;
							
					default: System.out.println("wrong choice...");		
				}
				if(u==1)
				{
					break;
				}
				
				}
				return 1;
			}
		}
		return 1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		main_menu();
//		admin ad=new admin();
//		ad.admin_input();
		
//		student ob=new student();
//		ob.input();
		
		
//		student ob=new student();
//		ob.input();
	}

}