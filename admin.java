package begin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

public class admin implements Serializable     //admin class (superclass)
{
	private static final long serialVersionUID = 1L;     //required for implementation of serializable.
	static Scanner sc=new Scanner(System.in);              

	private String admin_name;
	private String designation;               //admin details
	String admin_password;
	int admin_id;
	
	static int flip_flop=0;          //variable that tells what is going on (elections or results or registration)
	
	admin()                           //admin constructor
	{
		admin_name=null;
		designation=null;
		admin_password=null;
		admin_id=0;
	}
	
	public  void admin_input()          //function to enter admin details in a file admin.txt
	{
		System.out.print("enter name :  ");
		this.admin_name=sc.next();
		System.out.print("enter id :  ");
		this.admin_id=sc.nextInt();
		System.out.print("enter designation : ");
		this.designation=sc.next();
		
		System.out.print("enter password :  ");
		this.admin_password=sc.next();
		
		
		try 
		{	
			FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\Dell\\Desktop\\project\\admin.txt"),true);  
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

	public static void register() throws IOException                   //function that can be accessed by admin to register a candidate
	{
		BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Dell\\Desktop\\project\\control_election.txt")  //Set true for append mode
                );  
//Add new line
			admin.flip_flop=0;   	// ff=0 when registrations starts
			String h=Integer.toString(admin.flip_flop);
			writer.write(h);
			writer.newLine();
			writer.close();
			System.out.println("Done");
		int num;
		int roll;
		
		while(true)
		{
			
			int u=0;
		System.out.println("1. cultural");
		System.out.println("2. technical");
		System.out.println("3. sports");
		System.out.println("4. literature");
		System.out.println("5. back");
		
		int input=sc.nextInt();
		switch(input)
		{
			case 1: 
					System.out.println("enter the number of candidates to register =  ");
					num=sc.nextInt();
				       
					for(int i=0;i<num;i++)             //feeding id's of each candidate
					{
						try
						{
						roll=sc.nextInt();
						student s=null;
						int k=0;
						FileInputStream is = new FileInputStream("C:\\Users\\Dell\\Desktop\\project\\a.txt"); //reading data from student database (a.txt)
						while(is.available()>0)
						{
							ObjectInputStream ois = new ObjectInputStream(is);
							s = (student) ois.readObject();
							if(s.ID==roll )         //if id is correct and matched by student database then add in c_selected.txt
							{
								try
								{
									FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\Dell\\Desktop\\project\\c_selected.txt"),true);	// people standing in general election of cultural comittee.
									ObjectOutputStream oos = new ObjectOutputStream(fos);
									// s.c_comittee+=1;
									// write object to file
									oos.writeObject(s);
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
//									sc.close();
								}
							}
						}
						}//try
						catch(Exception e)
						{
							System.out.println(e);
						}
					}
					break;
					
			case 2: //int num;
					System.out.println("enter the number of candidates to register =  ");       //technical committee
					num=sc.nextInt();
					
					for(int i=0;i<num;i++)
					{
						try
						{
						roll=sc.nextInt();
						student s=null;
						int k=0;
						FileInputStream is = new FileInputStream("C:\\Users\\Dell\\Desktop\\project\\a.txt");	
						while(is.available()>0)
						{
							ObjectInputStream ois = new ObjectInputStream(is);
							s = (student) ois.readObject();
							if(s.ID==roll )
							{
								try 
								{	
									FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\Dell\\Desktop\\project\\t_selected.txt"),true);
									ObjectOutputStream oos = new ObjectOutputStream(fos);
									oos.writeObject(s);
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
		//							sc.close();
								}
							}
						}
						}//try
						catch(Exception e)
						{
							System.out.println(e);
						}
					}
					break;
			case 3:                                                                              //sports committee
				System.out.println("enter the number of candidates to register =  ");
				num=sc.nextInt();
				
				for(int i=0;i<num;i++)
				{
					try
					{
					roll=sc.nextInt();
					student s=null;
					int k=0;
					FileInputStream is = new FileInputStream("C:\\Users\\Dell\\Desktop\\project\\a.txt");	
					while(is.available()>0)
					{
						ObjectInputStream ois = new ObjectInputStream(is);
						s = (student) ois.readObject();
						if(s.ID==roll )
						{
							try 
							{	
								FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\Dell\\Desktop\\project\\s_selected.txt"),true);
								ObjectOutputStream oos = new ObjectOutputStream(fos);
//								s.s_comittee+=1;
								// write object to file
								oos.writeObject(s);
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
	//							sc.close();
							}
						}
					}
					}//try
					catch(Exception e)
					{
						System.out.println(e);
					}
				}
				break;
			case 4:                                                                         //literature
				System.out.println("enter the number of candidates to register =  ");
				num=sc.nextInt();
				
				for(int i=0;i<num;i++)
				{
					try
					{
					roll=sc.nextInt();
					student s=null;
					int k=0;
					FileInputStream is = new FileInputStream("C:\\Users\\Dell\\Desktop\\project\\a.txt");	
					while(is.available()>0)
					{
						ObjectInputStream ois = new ObjectInputStream(is);
						s = (student) ois.readObject();
						if(s.ID==roll )
						{
							try 
							{	
								FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\Dell\\Desktop\\project\\l_selected.txt"),true);
								ObjectOutputStream oos = new ObjectOutputStream(fos);
//								s.l_comittee+=1;
								// write object to file
								oos.writeObject(s);
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
	//							sc.close();
							}
						}
					}
					}//try
					catch(Exception e)
					{
						System.out.println(e);
					}
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
	}
	
	
	
	
	
	public static void g_c_list() throws IOException, ClassNotFoundException           //function to  declare the winners of general cultural elections
	{
		File file = new File("C:\\Users\\Dell\\Desktop\\project\\stats_gen_cult.txt"); 
		  int count=0;
		  BufferedReader br = new BufferedReader(new FileReader(file)); 
		  String st; 
		  while ((st = br.readLine()) != null) 
		  {
		    count++; 
		  } 
		  if(count==0)
		  {
			  return;
		  }
//		  System.out.println("count = "+count);
//		  br.close();
		int a[]=new int[count];
		int i=0;
		BufferedReader br1 = new BufferedReader(new FileReader(file)); 
		while ((st = br1.readLine()) != null) 
		  {
		    	a[i]=Integer.parseInt(st);
//		    	System.out.println("p= "+a[i]);
		    	i++;
		  }
		
	
//		  br1.close();
		  Arrays.sort(a);
		
		  int[] b = new int[count];  
	        int j = 0;  
	        for (int ii=0; ii<count-1; ii++){  
	            if (a[ii] != a[ii+1]){  
	                b[j++] = a[ii];  
	            }  
	         }  
	        b[j++] = a[count-1]; 
	        
	      int c[]=new int [j];
//	      System.out.println("j = "+j);
	      for(int k=0;k<j;k++)
	      {
	    	  int t=0;
	    	  for(int u=0;u<count;u++)
	    	  {
	    		  if(b[k]==a[u])
	    		  {
	    			  t++;
	    		  }
	    	  }
	    	  c[k]=t;
	      }
	      
	    	  FileInputStream is = new FileInputStream("C:\\Users\\Dell\\Desktop\\project\\c_selected.txt");  //going in c_selected to display the data of registered candidates
	  		
//	  		int count=0;
	  		student so=null;
	  		
	  		while(is.available()>0)
	  		{
	  			ObjectInputStream ois = new ObjectInputStream(is);             //reading the file to know number of registered candidates
	  			so= (student) ois.readObject();
	  			
	  			for(int k=0;k<j;k++)
	  			{
	  				if(so.ID==b[k])
	  				{
	  					System.out.print(so.name+"  ");
	  					System.out.print(so.ID+"  ");
	  					System.out.print(so.batch+"  ");
	  					System.out.println("no. of votes = "+c[k]);
	  				}
	  			}
	  			
	  		}
	  		is.close();
	      
		  
	}
	
	
	
	
	public static void g_t_list() throws IOException, ClassNotFoundException           //function to  declare the winners of general cultural elections
	{
		File file = new File("C:\\Users\\Dell\\Desktop\\project\\stats_gen_technical.txt"); 
		  int count=0;
		  BufferedReader br = new BufferedReader(new FileReader(file)); 
		  String st; 
		  while ((st = br.readLine()) != null) 
		  {
		    count++; 
		  } 
		  if(count==0)
		  {
			  return;
		  }
		int a[]=new int[count];
		int i=0;
		BufferedReader br1 = new BufferedReader(new FileReader(file)); 
		while ((st = br1.readLine()) != null) 
		  {
		    	a[i]=Integer.parseInt(st);
		    	i++;
		  }
		
	
//		  br1.close();
		  Arrays.sort(a);
		
		  int[] b = new int[count];  
	        int j = 0;  
	        for (int ii=0; ii<count-1; ii++){  
	            if (a[ii] != a[ii+1]){  
	                b[j++] = a[ii];  
	            }  
	         }  
	        b[j++] = a[count-1]; 
	        
	      int c[]=new int [j];
//	      System.out.println("j = "+j);
	      for(int k=0;k<j;k++)
	      {
	    	  int t=0;
	    	  for(int u=0;u<count;u++)
	    	  {
	    		  if(b[k]==a[u])
	    		  {
	    			  t++;
	    		  }
	    	  }
	    	  c[k]=t;
	      }
	      
	    	  FileInputStream is = new FileInputStream("C:\\Users\\Dell\\Desktop\\project\\t_selected.txt");  //going in c_selected to display the data of registered candidates
	  		
//	  		int count=0;
	  		student so=null;
	  		
	  		while(is.available()>0)
	  		{
	  			ObjectInputStream ois = new ObjectInputStream(is);             //reading the file to know number of registered candidates
	  			so= (student) ois.readObject();
	  			
	  			for(int k=0;k<j;k++)
	  			{
	  				if(so.ID==b[k])
	  				{
	  					System.out.print(so.name+"  ");
	  					System.out.print(so.ID+"  ");
	  					System.out.print(so.batch+"  ");
	  					System.out.println("no. of votes = "+c[k]);
	  				}
	  			}
	  			
	  		}
	  		is.close();
	      
		  
	}
	
	
	
	
	public static void g_l_list() throws IOException, ClassNotFoundException           //function to  declare the winners of general cultural elections
	{
		File file = new File("C:\\Users\\Dell\\Desktop\\project\\stats_gen_literature.txt"); 
		  int count=0;
		  BufferedReader br = new BufferedReader(new FileReader(file)); 
		  String st; 
		  while ((st = br.readLine()) != null) 
		  {
		    count++; 
		  } 
		  if(count==0)
		  {
			  return;
		  }
		int a[]=new int[count];
		int i=0;
		BufferedReader br1 = new BufferedReader(new FileReader(file)); 
		while ((st = br1.readLine()) != null) 
		  {
		    	a[i]=Integer.parseInt(st);
//		    	System.out.println("p= "+a[i]);
		    	i++;
		  }
		
	
//		  br1.close();
		  Arrays.sort(a);
		
		  int[] b = new int[count];  
	        int j = 0;  
	        for (int ii=0; ii<count-1; ii++){  
	            if (a[ii] != a[ii+1]){  
	                b[j++] = a[ii];  
	            }  
	         }  
	        b[j++] = a[count-1]; 
	        
	      int c[]=new int [j];
//	      System.out.println("j = "+j);
	      for(int k=0;k<j;k++)
	      {
	    	  int t=0;
	    	  for(int u=0;u<count;u++)
	    	  {
	    		  if(b[k]==a[u])
	    		  {
	    			  t++;
	    		  }
	    	  }
	    	  c[k]=t;
	      }
	      
	    	  FileInputStream is = new FileInputStream("C:\\Users\\Dell\\Desktop\\project\\l_selected.txt");  //going in c_selected to display the data of registered candidates
	  		
//	  		int count=0;
	  		student so=null;
	  		
	  		while(is.available()>0)
	  		{
	  			ObjectInputStream ois = new ObjectInputStream(is);             //reading the file to know number of registered candidates
	  			so= (student) ois.readObject();
	  			
	  			for(int k=0;k<j;k++)
	  			{
	  				if(so.ID==b[k])
	  				{
	  					System.out.print(so.name+"  ");
	  					System.out.print(so.ID+"  ");
	  					System.out.print(so.batch+"  ");
	  					System.out.println("no. of votes = "+c[k]);
	  				}
	  			}
	  			
	  		}
	  		is.close();
	      
		  
	}
	
	
	
	public static void g_s_list() throws IOException, ClassNotFoundException           //function to  declare the winners of general cultural elections
	{
		File file = new File("C:\\Users\\Dell\\Desktop\\project\\stats_gen_sports.txt"); 
		  int count=0;
		  BufferedReader br = new BufferedReader(new FileReader(file)); 
		  String st; 
		  while ((st = br.readLine()) != null) 
		  {
		    count++; 
		  } 
		  if(count==0)
		  {
			  return;
		  }
		int a[]=new int[count];
		int i=0;
		BufferedReader br1 = new BufferedReader(new FileReader(file)); 
		while ((st = br1.readLine()) != null) 
		  {
		    	a[i]=Integer.parseInt(st);
//		    	System.out.println("p= "+a[i]);
		    	i++;
		  }
		
	
//		  br1.close();
		  Arrays.sort(a);
		
		  int[] b = new int[count];  
	        int j = 0;  
	        for (int ii=0; ii<count-1; ii++){  
	            if (a[ii] != a[ii+1]){  
	                b[j++] = a[ii];  
	            }  
	         }  
	        b[j++] = a[count-1]; 
	        
	      int c[]=new int [j];
//	      System.out.println("j = "+j);
	      for(int k=0;k<j;k++)
	      {
	    	  int t=0;
	    	  for(int u=0;u<count;u++)
	    	  {
	    		  if(b[k]==a[u])
	    		  {
	    			  t++;
	    		  }
	    	  }
	    	  c[k]=t;
	      }
	      
	    	  FileInputStream is = new FileInputStream("C:\\Users\\Dell\\Desktop\\project\\s_selected.txt");  //going in c_selected to display the data of registered candidates
	  		
//	  		int count=0;
	  		student so=null;
	  		
	  		while(is.available()>0)
	  		{
	  			ObjectInputStream ois = new ObjectInputStream(is);             //reading the file to know number of registered candidates
	  			so= (student) ois.readObject();
	  			
	  			for(int k=0;k<j;k++)
	  			{
	  				if(so.ID==b[k])
	  				{
	  					System.out.print(so.name+"  ");
	  					System.out.print(so.ID+"  ");
	  					System.out.print(so.batch+"  ");
	  					System.out.println("no. of votes = "+c[k]);
	  				}
	  			}
	  			
	  		}
	  		is.close();
	      
		  
	}
	
	
	
	
	public static void g_c_result() throws IOException, ClassNotFoundException
	{
		File file = new File("C:\\Users\\Dell\\Desktop\\project\\stats_gen_cult.txt"); 
		  int count=0;
		  BufferedReader br = new BufferedReader(new FileReader(file)); 
		  String st; 
		  while ((st = br.readLine()) != null) 
		  {
		    count++; 
		  } 
		  if(count==0)
		  {
			  return;
		  }
//		  System.out.println("count = "+count);
//		  br.close();
		int a[]=new int[count];
		int i=0;
		BufferedReader br1 = new BufferedReader(new FileReader(file)); 
		while ((st = br1.readLine()) != null) 
		  {
		    	a[i]=Integer.parseInt(st);
//		    	System.out.println("p= "+a[i]);
		    	i++;
		  }
		
	
//		  br1.close();
		  Arrays.sort(a);
		
		  int[] b = new int[count];  
	        int j = 0;  
	        for (int ii=0; ii<count-1; ii++){  
	            if (a[ii] != a[ii+1]){  
	                b[j++] = a[ii];  
	            }  
	         }  
	        b[j++] = a[count-1]; 
	        
	      int c[]=new int [j];
//	      System.out.println("j = "+j);
	      for(int k=0;k<j;k++)
	      {
	    	  int t=0;
	    	  for(int u=0;u<count;u++)
	    	  {
	    		  if(b[k]==a[u])
	    		  {
	    			  t++;
	    		  }
	    	  }
	    	  c[k]=t;
	      }
	      
	  		int temp=0;
	  		for (int q = 0; q < (j-1); q++)
	  	    {
	  	        for (int w = 0; w < (j-q-1); w++)
	  	        {
	  	            if (c[w] <c[w+1])
	  	            {
	  	                // swap temp and arr[i]
	  	                temp = c[w];
	  	                c[w] = c[w+1];
	  	                c[w+1] = temp;
	  	              temp = b[w];
	  	                b[w] = b[w+1];
	  	                b[w+1] = temp;
	  	            }
	  	        }
	  	        
	  	    }
	    	int oo=12;
	  		student so=null;
	  		if(j<12)
	  		{
	  			oo=j;
	  		}
	  		
	  		int d[]=new int[oo];
	  		for(int q=0;q<oo;q++)
	  		{
	  			d[q]=b[q];
	  		}
	  		
	  		System.out.println("the results of cultural committe are =  ");
	  		
	  		try 
			{	
				
				// write object to file
	  			FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\Dell\\Desktop\\project\\g_c_results.txt"),true);
	  			ObjectOutputStream oos = new ObjectOutputStream(fos);
				
//	  			FileInputStream is=null;
//	  			ObjectInputStream ois=null; 
	  			
	  			
	  			FileInputStream is = new FileInputStream("C:\\Users\\Dell\\Desktop\\project\\c_selected.txt");  //going in c_selected to display the data of registered candidates
		  		
//		  		int count=0;
		  		student sp=null;
		  		
		  		while(is.available()>0)
		  		{
		  			ObjectInputStream ois = new ObjectInputStream(is);             //reading the file to know number of registered candidates
		  			sp= (student) ois.readObject();
		  			
		  			for(int k=0;k<oo;k++)
		  			{
		  				if(sp.ID==d[k])
		  				{
		  					System.out.print("name =  "+sp.name+"  ");
		  					System.out.print("id = "+sp.ID+"  ");
		  					System.out.print("batch =  "+sp.batch+"  ");
//		  					System.out.println("no. of votes = "+c[k]);
		  					oos.writeObject(sp);
		  					break;
		  				}
		  				
		  			}
		  			System.out.println();
		  		}
		  		System.out.println();
		  		is.close();
				
				oos.close();
				fos.close();
				
//				System.out.println("Done");
				
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
	
	
	
	public static void g_s_result() throws IOException, ClassNotFoundException
	{
		File file = new File("C:\\Users\\Dell\\Desktop\\project\\stats_gen_sports.txt"); 
		  int count=0;
		  BufferedReader br = new BufferedReader(new FileReader(file)); 
		  String st; 
		  while ((st = br.readLine()) != null) 
		  {
		    count++; 
		  } 
		  if(count==0)
		  {
			  return;
		  }
		int a[]=new int[count];
		int i=0;
		BufferedReader br1 = new BufferedReader(new FileReader(file)); 
		while ((st = br1.readLine()) != null) 
		  {
		    	a[i]=Integer.parseInt(st);
//		    	System.out.println("p= "+a[i]);
		    	i++;
		  }
		
	
//		  br1.close();
		  Arrays.sort(a);
		
		  int[] b = new int[count];  
	        int j = 0;  
	        for (int ii=0; ii<count-1; ii++){  
	            if (a[ii] != a[ii+1]){  
	                b[j++] = a[ii];  
	            }  
	         }  
	        b[j++] = a[count-1]; 
	        
	      int c[]=new int [j];
//	      System.out.println("j = "+j);
	      for(int k=0;k<j;k++)
	      {
	    	  int t=0;
	    	  for(int u=0;u<count;u++)
	    	  {
	    		  if(b[k]==a[u])
	    		  {
	    			  t++;
	    		  }
	    	  }
	    	  c[k]=t;
	      }
	      
	      
	    	int oo=12;
	  		student so=null;
	  		if(j<12)
	  		{
	  			oo=j;
	  		}
	  		
	  		int d[]=new int[oo];
	  		for(int q=0;q<oo;q++)
	  		{
	  			d[q]=b[q];
	  		}
	  		
	  		System.out.println("the results of sports committe are =  ");
	  		
	  		try 
			{	
				
				// write object to file
	  			FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\Dell\\Desktop\\project\\g_s_results.txt"),true);
	  			ObjectOutputStream oos = new ObjectOutputStream(fos);
				
//	  			FileInputStream is=null;
//	  			ObjectInputStream ois=null; 
	  			
	  			
	  			FileInputStream is = new FileInputStream("C:\\Users\\Dell\\Desktop\\project\\s_selected.txt");  //going in c_selected to display the data of registered candidates
		  		
//		  		int count=0;
		  		student sp=null;
		  		
		  		while(is.available()>0)
		  		{
		  			ObjectInputStream ois = new ObjectInputStream(is);             //reading the file to know number of registered candidates
		  			sp= (student) ois.readObject();
		  			
		  			for(int k=0;k<oo;k++)
		  			{
		  				if(sp.ID==d[k])
		  				{
		  					System.out.print("name =  "+sp.name+"  ");
		  					System.out.print("id = "+sp.ID+"  ");
		  					System.out.print("batch =  "+sp.batch+"  ");
//		  					System.out.println("no. of votes = "+c[k]);
		  					oos.writeObject(sp);
		  					break;
		  				}
		  			}
		  			System.out.println();
		  			
		  		}
		  		System.out.println();
		  		is.close();
				
				oos.close();
				fos.close();
				
//				System.out.println("Done");
				
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
	

	
	public static void g_l_result() throws IOException, ClassNotFoundException
	{
		File file = new File("C:\\Users\\Dell\\Desktop\\project\\stats_gen_literature.txt"); 
		  int count=0;
		  BufferedReader br = new BufferedReader(new FileReader(file)); 
		  String st; 
		  while ((st = br.readLine()) != null) 
		  {
		    count++; 
		  } 
		  if(count==0)
		  {
			  return;
		  }
//		  System.out.println("count = "+count);
//		  br.close();
		int a[]=new int[count];
		int i=0;
		BufferedReader br1 = new BufferedReader(new FileReader(file)); 
		while ((st = br1.readLine()) != null) 
		  {
		    	a[i]=Integer.parseInt(st);
//		    	System.out.println("p= "+a[i]);
		    	i++;
		  }
		
	
//		  br1.close();
		  Arrays.sort(a);
		
		  int[] b = new int[count];  
	        int j = 0;  
	        for (int ii=0; ii<count-1; ii++){  
	            if (a[ii] != a[ii+1]){  
	                b[j++] = a[ii];  
	            }  
	         }  
	        b[j++] = a[count-1]; 
	        
	      int c[]=new int [j];
//	      System.out.println("j = "+j);
	      for(int k=0;k<j;k++)
	      {
	    	  int t=0;
	    	  for(int u=0;u<count;u++)
	    	  {
	    		  if(b[k]==a[u])
	    		  {
	    			  t++;
	    		  }
	    	  }
	    	  c[k]=t;
	      }
	      
	      
	    	int oo=12;
	  		student so=null;
	  		if(j<12)
	  		{
	  			oo=j;
	  		}
	  		
	  		int d[]=new int[oo];
	  		for(int q=0;q<oo;q++)
	  		{
	  			d[q]=b[q];
	  		}
	  		
	  		System.out.println("the results of literature committe are =  ");
	  		
	  		try 
			{	
				
				// write object to file
	  			FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\Dell\\Desktop\\project\\g_l_results.txt"),true);
	  			ObjectOutputStream oos = new ObjectOutputStream(fos);
  			
	  			FileInputStream is = new FileInputStream("C:\\Users\\Dell\\Desktop\\project\\l_selected.txt");  //going in c_selected to display the data of registered candidates
		  		
//		  		int count=0;
		  		student sp=null;
		  		
		  		while(is.available()>0)
		  		{
		  			ObjectInputStream ois = new ObjectInputStream(is);             //reading the file to know number of registered candidates
		  			sp= (student) ois.readObject();
		  			
		  			for(int k=0;k<oo;k++)
		  			{
		  				if(sp.ID==d[k])
		  				{
		  					System.out.print("name =  "+sp.name+"  ");
		  					System.out.print("id = "+sp.ID+"  ");
		  					System.out.print("batch =  "+sp.batch+"  ");
//		  					System.out.println("no. of votes = "+c[k]);
		  					oos.writeObject(sp);
		  					break;
		  				}
		  			}
		  			System.out.println();
		  			
		  		}
		  		System.out.println();
		  		is.close();
				
				oos.close();
				fos.close();
				
//				System.out.println("Done");
				
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
	
	
	
	
	public static void g_t_result() throws IOException, ClassNotFoundException
	{
		File file = new File("C:\\Users\\Dell\\Desktop\\project\\stats_gen_technical.txt"); 
		  int count=0;
		  BufferedReader br = new BufferedReader(new FileReader(file)); 
		  String st; 
		  while ((st = br.readLine()) != null) 
		  {
		    count++; 
		  } 
		  if(count==0)
		  {
			  return;
		  }
//		  System.out.println("count = "+count);
//		  br.close();
		int a[]=new int[count];
		int i=0;
		BufferedReader br1 = new BufferedReader(new FileReader(file)); 
		while ((st = br1.readLine()) != null) 
		  {
		    	a[i]=Integer.parseInt(st);
//		    	System.out.println("p= "+a[i]);
		    	i++;
		  }
		
	
//		  br1.close();
		  Arrays.sort(a);
		
		  int[] b = new int[count];  
	        int j = 0;  
	        for (int ii=0; ii<count-1; ii++){  
	            if (a[ii] != a[ii+1]){  
	                b[j++] = a[ii];  
	            }  
	         }  
	        b[j++] = a[count-1]; 
	        
	      int c[]=new int [j];
//	      System.out.println("j = "+j);
	      for(int k=0;k<j;k++)
	      {
	    	  int t=0;
	    	  for(int u=0;u<count;u++)
	    	  {
	    		  if(b[k]==a[u])
	    		  {
	    			  t++;
	    		  }
	    	  }
	    	  c[k]=t;
	      }
	      
	      
	    	int oo=12;
	  		student so=null;
	  		if(j<12)
	  		{
	  			oo=j;
	  		}
	  		
	  		int d[]=new int[oo];
	  		for(int q=0;q<oo;q++)
	  		{
	  			d[q]=b[q];
	  		}
	  		
	  		System.out.println("the results of technical committe are =  ");
	  		
	  		try 
			{	
				
				// write object to file
	  			FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\Dell\\Desktop\\project\\g_t_results.txt"),true);
	  			ObjectOutputStream oos = new ObjectOutputStream(fos);
	  			FileInputStream is = new FileInputStream("C:\\Users\\Dell\\Desktop\\project\\t_selected.txt");  //going in c_selected to display the data of registered candidates
		  		
//		  		int count=0;
		  		student sp=null;
		  		
		  		while(is.available()>0)
		  		{
		  			ObjectInputStream ois = new ObjectInputStream(is);             //reading the file to know number of registered candidates
		  			sp= (student) ois.readObject();
		  			
		  			for(int k=0;k<oo;k++)
		  			{
		  				if(sp.ID==d[k])
		  				{
		  					System.out.print("name =  "+sp.name+"  ");
		  					System.out.print("id = "+sp.ID+"  ");
		  					System.out.print("batch =  "+sp.batch+"  ");
//		  					System.out.println("no. of votes = "+c[k]);
		  					oos.writeObject(sp);
		  					break;
		  				}
		  			}
		  			System.out.println();
		  			
		  		}
		  		System.out.println();
		  		is.close();
				
				oos.close();
				fos.close();
				
//				System.out.println("Done");
				
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
