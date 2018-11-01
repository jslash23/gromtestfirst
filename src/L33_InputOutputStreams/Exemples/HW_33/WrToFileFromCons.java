package L33_InputOutputStreams.Exemples.HW_33;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import org.apache.commons.io.IOUtils;


public class WrToFileFromCons {

    public static void writeToFileFromConsol(String path) throws IOException{

        BufferedReader bufread = new BufferedReader(new  InputStreamReader(System.in));//объект который читает целыми строками
        System.out.println("Enter file content to write in the file");

        String text = bufread.readLine();

        try{
            WRText(text,path);
        }
        catch (FileNotFoundException e) {
            System.err.println("File with path " + path + " not found");
            return;
        }
        finally {
            bufread.close();
        }
    }

    public static void WRText(String text,String path)throws IOException{
        FileWriter writer = null;
        BufferedWriter bfWriter = null;

            while ((text) != null){
               try {if (TestWR(text)){
                   writer = new FileWriter(path,true);
                   bfWriter = new BufferedWriter(writer);

                   bfWriter.append(text);
                   bfWriter.append("\n");
                   bfWriter.append("3333333333333");
                   System.out.println("new text was writen");
               }
            }catch (IOException e){
                   System.err.println("Can't write to file with path " + path );
               }
               break;
        }

        IOUtils.closeQuietly(writer);
        IOUtils.closeQuietly(bfWriter);
    }

    private static boolean TestWR(String reader){

        String[] arrtext = reader.split(" ");
        for (String art : arrtext) {
            if (art.equalsIgnoreCase("wr")){
                return true;
            }
        }
        return false;
    }
}
