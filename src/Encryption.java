import java.io.*;
import java.util.Scanner;


public class Encryption {
		public static String cipher;
		public static void vigenereEncrypt()
		{
			
			Vigenere v = new Vigenere();
		     v.encrypt(cipher);
		    System.out.println("Vignere Encrypted");
		}
		
		public static void vigenereDecrypt(String line)
		{
			Vigenere v = new Vigenere();
			
	        line = line.toUpperCase();
		    String something = v.decrypt(line);//Add argument
		    System.out.println(something);
		}

		public static void ceaserEncrypt()
		{
			Ceaser c=new Ceaser();
			c.encrypt(cipher);
			System.out.println("Ceaser Encrypted");
		}
		
		public static void ceaserDecrypt(String line)
		{
			Ceaser c=new Ceaser();
			cipher=c.decrypt(line);
			System.out.println(cipher);
		}
		
	    public static void main(String[] args) {
	       int ch = 0;
	       int c=0;
	    	Scanner in=new Scanner(System.in);
	    	do{
	    	System.out.println("Enter 1:To Encrypt\n\t2:To Decrypt\n\t3:Exit :");
	    	try
	    	{
	    		
	    			ch=in.nextInt();
	    		
	    	}
	    	catch(Exception e)
	    	{
	    		System.out.println(e);
	    	}
	    	
	       switch(ch){
	    	   case 1:
	    		System.out.print("Enter String to Encrypt:");
	    		
	    		cipher=in.next();
	    		System.out.print("Enter Type of Encrypt:\n 1:Vigenere Encryption\n2:Ceaser Encryption    :");
	    		
	    		c=in.nextInt();
	    	   switch(c){
	    	   case 1:
	    		   vigenereEncrypt();
	    		  
	    		   break;
	    	   case 2:
	    		   ceaserEncrypt();
	    		   break;
	    	   }
	    	   break;
	    	   case 2:
	       
	    		   String line="";
	    		   try {
	    			   File myFile = new File("Encrypt.txt");
	    			   
	    			   FileReader fileReader = new FileReader(myFile);
	    			   BufferedReader reader= new BufferedReader(fileReader);
				
	    			   line = reader.readLine();
				
	    			   reader.close();
				
			
	    		   } catch (FileNotFoundException e) {
	    			   // TODO Auto-generated catch block
	    			   System.out.println("File Not Found");
	    			   break;
	    		   } catch (IOException e) {
	    			   // TODO Auto-generated catch block
	    			   e.printStackTrace();
	    		   }	
			
	        switch(line.charAt(0)){
	        case '1':
	    		   vigenereDecrypt(line);
	       break;
	    	   case '2':
	    	   {
	    		   ceaserDecrypt(line);
	    	   }
	        	   break;
	        }
	        break;
	    	   case 3:
	    		   break;
	    	  default:
	    	   System.out.println("Invalid Input");
	       }
	       
	    }while(ch!=3);
	    	in.close();
	    }
}
