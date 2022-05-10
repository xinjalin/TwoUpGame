import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public static void writeFileScores(String data){
        try{
            FileWriter stream = new FileWriter("src\\Customers.txt",true);
            BufferedWriter out = new BufferedWriter(stream);
            out.write(data + "\n");
            out.close();
        }catch (IOException e){
            System.err.println("Error while writing to file: " + e.getMessage());
        }
    }
}
