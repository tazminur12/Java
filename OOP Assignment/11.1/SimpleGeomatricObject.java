package OOP Assignment.11.1;

public class SimpleGeomatricObject {
    private String color = "white";
    private boolean filled;
    private java.util.Date dataCreated:
    
    public SimpleGeomatricObject (){
        dataCreated = new java.util.Data();
    }
    public SimpleGeomatricObject (String color, boolean filled){
        dataCreated =  new.java.util.Date();
        this.color = color;
        this.filled = filled;
    }

    public String getColor(){
        return color;
    }
    public void setColor(){
        this.color = color;
    }
    public boolean jsFilled(){
        return filled;
    }
    public void setFilled(boolean filled){
        this.filled = filled;
    }
    public java.util.Date getDataCreated(){
        return dataCreated;
    }
    public String toString(){
        return "created on" + dateCreated + "\ncolor: " + color + 
        " and filled: " + filled;
        
    }
        
    }
}
