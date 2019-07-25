import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*; 
public class MyFrame extends JFrame implements ActionListener,KeyListener{  
    TextField input;
    List l1;
    String data;
    Button b;
    // Label img;
    MyFrame(String title){  
        super(title);
        data="";

        addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e) {  
                dispose(); 
                data="****"; 
            }  
        });
        setSize(400,550); 
        l1=new List();  
        l1.setBounds(0,0, 400,450);   
        add(l1);
        input=new TextField("");  
        input.setBounds(0,465,350,25);  
        add(input);
         
        b=new Button("Send ");  
        b.setBounds(350,465,50,25);  
        b.addActionListener(this);
        add(b);
        input.addKeyListener(this);  


        // img=new Label("Typing...") ;
        // img.setBounds(100,460,200,60);    
        // add(img);
        // img.setVisible(false);   



        setResizable(false);
        setLayout(null);  
        setVisible(true);  
    }

     public void keyPressed(KeyEvent e) {  
        try{  
            if((int) e.getKeyChar()==10){
                data=input.getText();
                // data="YOU: "+data;
                l1.add("YOU: "+data,0);
                input.setText("");
            }
        }catch(Exception ex){System.out.println(ex);}  
        // System.out.println((int) e.getKeyChar()); 
    }  
    public String getString(){
        // System.out.println(data);
        // input.setVisible(true);
        String ans=this.data;
        this.data="";
        return ans;

    }

    public void addString(String str){
        l1.add("PERSON: "+str,0);
        // input.setVisible(false);
    }
    // public void setFlag(boolean f){
    //         input.setVisible(f);
    //         b.setVisible(f);
    //         f=!f;
    //         img.setVisible(f);

    // }
    


    public void keyReleased(KeyEvent e) {  
        // l.setText("Key Released");  
    } 
     public void keyTyped(KeyEvent e) {  
        // l.setText("Key Typed");  
    }   

    public void actionPerformed(ActionEvent e) {  
        try{  
            
            
            l1.add(input.getText());
            input.setText("");
        }catch(Exception ex){System.out.println(ex);}  
    }  
    
   
}