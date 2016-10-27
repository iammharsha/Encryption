import java.util.*;
import java.io.*;

public class Vigenere implements Cipher,Serializable{
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	private String key;
	
	public void setKey()
	{
		Scanner in= new Scanner(System.in);
		System.out.println("Enter key:");
		key=in.next();
		in.close();
	}
	
	
	@Override
	public String decrypt(String line){
		String res="";
		FileInputStream fin=null;
		ObjectInputStream in=null;
		Vigenere vi = null;
		try {
			fin = new FileInputStream("key.txt");
		
		in=new ObjectInputStream(fin);
		vi=(Vigenere)in.readObject();
		}
		catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		key=vi.key;
        key = key.toUpperCase();
        
        for (int i = 1, j = key.length(); i < line.length(); i++) {
            int c = (line.charAt(i) - 65) ;
            int e = (key.charAt((i-1) % j) - 65);
            int q = (c - e < 0) ? c - e + 26 : c - e % 26;
            char w = (char) (65 + q);
            res += w;
        
        }
        
        try {
			in.close();
			fin.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
    }
    
	@Override
    public void encrypt(String text){
        String res = "";
        Scanner kin=new Scanner(System.in);
        System.out.println("Enter a Key:");
        
        key=kin.next();
        text = text.toUpperCase();
        key = key.toUpperCase();
        
        for (int i = 0, j = key.length(); i < text.length(); i++) {
            int c = (text.charAt(i) - 65) ;
            int e = (key.charAt(i % j) - 65);
            char w = (char) (((char) (c + e) % 26) + 65);
            res += Character.toString(w);
        }
        res="1"+res;
        kin.close();
        try {
			FileOutputStream fout1=new FileOutputStream("key.txt");
			ObjectOutputStream oin1=new ObjectOutputStream(fout1);
			
			if(this!=null)
			oin1.writeObject(this);
			FileWriter writer=new FileWriter("Encrypt.txt");
			writer.write(res);
			oin1.close();
			fout1.close();
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
