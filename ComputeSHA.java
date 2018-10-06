import java.io.*;
import java.security.*;

public class ComputeSHA
{
    public static void main(String args[]) throws IOException
    {
        // Check how many arguments were passed in
        if(args.length != 1)
        {
            System.out.println("Only the filename is required");
            System.exit(0);
        }

        FileInputStream file = null;
        MessageDigest md;

        try
        { 
            md = MessageDigest.getInstance("SHA-1");
            file = new FileInputStream(args[0]);
            byte[] buffer = new byte[1024];
   	    int n = 0;
 
            while((n = file.read(buffer)) != -1)
            {
                md.update(buffer, 0, n);
            }

            byte[] hash = md.digest();
            
            StringBuffer stringBuffer = new StringBuffer();
            
            for(byte b: hash)
            {
                stringBuffer.append(String.format("%02x", b & 0xff));
            }
            
            System.out.println(stringBuffer.toString());
        }

        catch (NoSuchAlgorithmException e)
        {
            System.out.println("No such algorithm");
            System.exit(0);
        }
        
        catch (IOException e)
        {
            System.out.println("IO error");
            System.exit(0);
        }
    }
}
