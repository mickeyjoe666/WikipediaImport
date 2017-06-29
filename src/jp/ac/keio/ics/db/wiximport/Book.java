package jp.ac.keio.ics.db.wiximport;

public class Book {  
    
    private String id;  
    private String name;  
  
    public Book(String id, String name) {  
        super();  
        this.id = id;  
        this.name = name;  
    }  
  
    public String getBook_id() {  
        return id;  
    }  
  
    public String getBook_name() {  
        return name;  
    }  
  
}  