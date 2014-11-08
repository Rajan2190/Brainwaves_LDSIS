package Commons;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;

public class Encrypt {   
    private Key symKey;
    private Cipher cipher; 

    public Encrypt(String algorithm) throws Exception 
    {               
        symKey = KeyGenerator.getInstance(algorithm).generateKey();     
        cipher = Cipher.getInstance(algorithm);
    }
    public byte[] encrypt(String toEncrypt) throws Exception
    {
        cipher.init(Cipher.ENCRYPT_MODE, symKey);
        byte[] inputBytes = toEncrypt.getBytes();
        return cipher.doFinal(inputBytes);
    }
    public String decrypt(byte[] toDecrypt) throws Exception
    {
        cipher.init(Cipher.DECRYPT_MODE, symKey);
        byte[] decrypt = cipher.doFinal(toDecrypt);
        String decrypted = new String(decrypt);
        return decrypted;
    }
    public static void main(String[] args) throws Exception {
        String algorithm = "RC2";   //successfully tested with AES, Blowfish, DES, DESede, RC2
        Encrypt cryptHandler = new Encrypt(algorithm);

        String input = "HDFC 123456789 10000";
        //Encryption
        byte[] encryptedBytes = cryptHandler.encrypt(input);
        System.out.println("Encrypted result of 'Hello World' : " + encryptedBytes);
        //Decryption
        String decryptedStr = cryptHandler.decrypt(encryptedBytes);
        System.out.println("Decrypted result : " + decryptedStr);
    }
}