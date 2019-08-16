import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.channels.FileLock;


public class FileLocking extends Thread
{
    private static final File file = new File("lock.test");
 
    boolean isFileUnlocked = false;
    public static void main(String[] args) throws Exception
    {
        for (int i = 0; i < 5; i++) {
            new FileLocking().start();
        }
    }

 
    public void run()
    {
    	
    	   int counter=0;
       synchronized(file) {
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(file);

                
            
                FileLock lock = fos.getChannel().lock();
                System.out.println("Got a lock in " + getName());
                BufferedReader reader = new BufferedReader(new FileReader("lock.test"));
               isFileUnlocked=true;
                counter++;

                sleep(50000);
               
                reader.close();
                fos.close();
               
             
                
                System.out.println("Thread Removed " + getName());
                isFileUnlocked=false;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (fos != null) {
                    try {
                        fos.close();
                   } catch (IOException ex) {
                    }
                }
            }
        }
    }
            
}