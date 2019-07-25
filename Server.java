import java.io.*;
    import java.util.Scanner;    
    import java.net.*;  

class Server{

	public static void main(String[] args) {
		try{  
	MyFrame frame=new MyFrame("Server Window");
    ServerSocket ss=new ServerSocket(6666);  
    Socket s=ss.accept();//establishes connection  
    // frame.setFlag(false);


	DataOutputStream dout=new DataOutputStream(s.getOutputStream()); 
	Scanner sc=new Scanner(System.in);
	DataInputStream dis=new DataInputStream(s.getInputStream());  
	String send="";



	String Exit="start";
	while(!Exit.equals("bye")){
		// frame.setFlag(false);
		String  str=(String)dis.readUTF();  
		while(!str.equals("over")){
		   
			if(str.equals("bye")){
			  break;
			}
		 // System.out.println("Client send: "+str);  
		 frame.addString(str);
		 str=(String)dis.readUTF();  
		}
		
		Exit=str;
			if(Exit.equals("bye")){
			  break;
			}


		do{ 
		// System.out.print("Write message: "); 
		// frame.setFlag(true); 
		send=frame.getString();
        int count=0;
        while(send.length()==0){

            send=frame.getString();
            Thread.sleep(100);
            if(count>=10)
                send="over";
            count+=1;
        }  
			if(send.equals("bye")){
			  break;
			}
		dout.writeUTF(send); 
		dout.flush(); 
		}while(!send.equals("over"));
	      	
    		
		
		Exit=send;






	}




	
	      
    dout.close();  

 

  
    ss.close();  
    }catch(Exception e){System.out.println(e);} 
	}
}
