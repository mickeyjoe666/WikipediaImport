package jp.ac.keio.ics.db.wiximport;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

import org.jdom2.Document;  
import org.jdom2.Element;  
import org.jdom2.JDOMException;  
import org.jdom2.output.Format;  
import org.jdom2.output.XMLOutputter;  
  
   
public class Wixfilewrite {  
      
    public void buildXMLDoc() throws IOException, JDOMException {
    	
        // 创建根节点 并设置它的属性 ;     
        Element root = new Element("WIX");     
        // 将根节点添加到文档中；     
        Document doc = new Document(root);
        // header部記述
    	Element header = new Element("header");
    	Element comment = new Element("comment").setText("中国版wikipedia");
    	Element description = new Element("description").setText("説明");
    	Element language = new Element("language").setText("zh");
    	header.addContent(comment);
    	header.addContent(description);
    	header.addContent(language);
    	
    	Element body = new Element("body");
    	
    	try (BufferedReader br = new BufferedReader(new FileReader("/Users/toyamalab/Desktop/zhwiki-20170601-all-titles-in-ns0.txt"))){
			// read file content from file
			//StringBuffer sb = new StringBuffer("");            
            String str = null;
            while((str = br.readLine()) != null) {
            	System.out.println(str);
            	addEntry(body,str);
            }
    	} catch(FileNotFoundException e) {
                  e.printStackTrace();
        } catch(IOException e) {
                  e.printStackTrace();
        }
    	
        root.addContent(header);
        root.addContent(body);
        
        Format format = Format.getPrettyFormat();  
        XMLOutputter XMLOut = new XMLOutputter(format);  
        XMLOut.output(doc,new FileOutputStream("/Users/toyamalab/Desktop/zhwixfinal.xml"));
        
    }
    
    private void addEntry(Element body, String keywordStr) {
    	Element entry = new Element("entry");
    	entry.addContent(new Element("keyword").setText(keywordStr));
		entry.addContent(new Element("target").setText("https://zh.wikipedia.org/wiki/"+keywordStr));
		body.addContent(entry);
    }
    	

    public static void main(String[] args) {
    	Wixfilewrite wfw = new Wixfilewrite();
    	try {
			wfw.buildXMLDoc();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println("正在生成 zhwixfinal.xml 文件...");
    	System.out.println("/Users/toyamalab/Desktop/zhwixfinal.xml文件已生成");  
    }    
}  