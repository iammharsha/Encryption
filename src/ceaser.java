package inventory.management;

public class ceaser {
    
    public String decrypt(String ciphertext, String key){
        String res = "";
        
        ciphertext = ciphertext.toUpperCase();
        key = key.toUpperCase();
        
        for (int i = 0, j = key.length(); i < ciphertext.length(); i++) {
            int c = (ciphertext.charAt(i) - 65) ;
            int e = (key.charAt(i % j) - 65);
            int q = (c - e < 0) ? c - e + 26 : c - e % 26;
            char w = (char) (65 + q);
            res += w;
        }
        return res;
    }
    
    public String encrypt(String text, String key){
        String res = "";
        
        text = text.toUpperCase();
        key = key.toUpperCase();
        
        for (int i = 0, j = key.length(); i < text.length(); i++) {
            int c = (text.charAt(i) - 65) ;
            int e = (key.charAt(i % j) - 65);
            char w = (char) (((char) (c + e) % 26) + 65);
            res += Character.toString(w);
        }
        return res;
    }
}
