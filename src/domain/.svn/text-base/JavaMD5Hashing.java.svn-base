/*
 * Hashing Code
 * Code Used From: http://viralpatel.net/blogs/java-md5-hashing-salting-password/
 * Author: Viral Patel
 */
package domain;
 
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
 
public class JavaMD5Hashing 
{    
    public static String produceMD5Hash(String input) 
    {
        String md5 = null;
         
        if(null == input) 
        	return null;
         
        try 
        {          
        	//Create MessageDigest object for MD5
        	MessageDigest digest = MessageDigest.getInstance("MD5");
         
        	//Update input string in message digest
        	digest.update(input.getBytes(), 0, input.length());
 
        	//Converts message digest value in base 16 (hex) 
        	md5 = new BigInteger(1, digest.digest()).toString(16);
        } 
        
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return md5;
    }
}