/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginandregister;

/**
 *
 * @author SCSM11
 */
    public class userClass {
    private String email;
    private String username;
    private String password;
    private String registrationDate;
    private int currentPoint;
    
    public userClass (String email,String username,String password,String registrationDate,int currentPoint){
     this.email=email;
     this.username=username;
     this.password=password;
     this.registrationDate=registrationDate;
     this.currentPoint=currentPoint;}

  
    public String email(){
        return email;
    }
    
      public String username(){
        return username;
    }
    
    
     public String password(){
        return password;
    }
    
     public String registrationDate(){
        return registrationDate;
    }
    
    public int currentPoint(){
        return currentPoint;
    }

}

