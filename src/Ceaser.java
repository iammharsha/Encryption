import java.io.FileWriter;
import java.io.IOException;

public class Ceaser implements Cipher{
	
	@Override
	public void encrypt(String cipher)
	{
		String res="";
		for(int i=0;i<cipher.length();i++)
		{
			char a=(char)((int)cipher.charAt(i)+1);
			res=res+a;
		}
		res="2"+res;
		FileWriter writer=null;
		try {
			writer = new FileWriter("Encrypt.txt");
			writer.write(res);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	
	@Override
	public String decrypt(String line)
	{
		String res="";
		for(int i=1;i<line.length();i++)
		{
			char a=(char)((int)line.charAt(i)-1);
			res=res+a;
		}
		return res;
	}
}
