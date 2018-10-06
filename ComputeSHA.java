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

        FileInputStream in = null;
        
        try
        {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
        }
        catch (NoSuchAlgorithmException e)
        {
            System.out.println("No such algorithm");
            System.exit(0);
        }
        finally
        {
            in = new FileInputStream(args[0]);
	    int code = in.read();
            String content = new String();

            while(code != -1)
            {
                char c = (char) code;
		content += c;
		code = in.read();
            }
            System.out.print(content);
            byte[] b = content.getBytes();
            md.update(b);
            System.out.print(md.digest().toString());	
        }
    }
}
