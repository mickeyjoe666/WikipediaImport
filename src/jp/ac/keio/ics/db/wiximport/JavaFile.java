package jp.ac.keio.ics.db.wiximport;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JavaFile {
	public static void main(String[] args) {
		try {
			// read file content from file
			StringBuffer sb= new StringBuffer("");

            FileReader reader = new FileReader("/Users/toyamalab/Desktop/zhwiki_titles.txt");
            BufferedReader br = new BufferedReader(reader);
           
            String str = null;
           
            while((str = br.readLine()) != null) {
                  sb.append(str+"/n");
                 
                  System.out.println(str);
            }
           
            br.close();
            reader.close();
           
            // write string to file
            FileWriter writer = new FileWriter("");
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write(sb.toString());
           
            bw.close();
            writer.close();
      }
      catch(FileNotFoundException e) {
                  e.printStackTrace();
            }
            catch(IOException e) {
                  e.printStackTrace();
            }
      }
 
}
