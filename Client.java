import java.io.*;
import java.util.Scanner;    
import java.net.*;  
class Client{
    public static void main(String[] args) {
    MyFrame frame=new MyFrame("Client Window ");
            try{      
    Socket s=new Socket("localhost",6666); 
    DataInputStream dis=new DataInputStream(s.getInputStream());  
    DataOutputStream dout=new DataOutputStream(s.getOutputStream()); 
    Scanner sc=new Scanner(System.in);
    String send="";
    String Exit="start";
    boolean flag;
    // frame.setFlag(true);
    FileWriter br=new FileWriter("log/file_"+System.currentTimeMillis()+".txt",true);
    while(!Exit.equals("bye")){
    
        do{ 
            // frame.setFlag(true);
            send=frame.getString();
            int count=0;
            while(send.length()==0){

                send=frame.getString();
                if(send.equals("****")){
                    System.exit(0);
                }
                Thread.sleep(1000);
                // if(count>=10)
                    send="over";
                // count+=1;
            }   
            if(send.equals("bye")){
              break;
            }
            if(!send.equals("over"))
                br.write("YOU :"+send+"\n");
            dout.writeUTF(send); 
            dout.flush(); 
        }while(!send.equals("over"));

        Exit=send;
        if(send.equals("bye")){
          break;
        }
            
        String  str=(String)dis.readUTF();  
        while(!str.equals("over")){
            // frame.setFlag(false);
            // System.out.println("Server send: "+str);  

            if(str.equals("bye")){
              break;
            }
            frame.addString(str);
            br.write("PERSON: "+str+"\n");
         str=(String)dis.readUTF();  
         // System.out.println("reading...");
        }
        Exit=str;
    }     
    dout.close();
    s.close(); 
    br.close(); 
    // frame.setNull();
    }catch(Exception e){
    System.out.println(e);
    } 
    }
}