package ViewLayer;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import DBManager.ConnectToDB_H;
import LogManager.LogWriter;


public class Frame {
	
	static JPanel  p1;
    //final ConnectToDB_H ctdh
	public void initializeFrame(final ConnectToDB_H ctdh) {
			
		//Main Heading
		JFrame  f = new JFrame("Maa Vindhyavasini Diagnostic Center");
        Panel p=new Panel();
        
        //Add Panel
		JPanel p0=p.getPanel(4,35,995,100);
		       p1=p.getPanel(4,139,995,500);   Color color1 = new Color(51,204,255);p1.setBackground(color1);
		JPanel p2=p.getPanel(1004,35,189,100); Color color2 = new Color(51,204,255);p2.setBackground(color2);
		JPanel p3=p.getPanel(1004,138,189,500);Color color3 = new Color(51,204,255);p3.setBackground(color3);
		JPanel p4=p.getPanel(0,0,0,0);         Color color4 = new Color(51,204,255);p4.setBackground(color4);
		
		//Add Component
		p0=p.addLabel0(p0);
		p2=p.addTextArea2(p2);
		p3=p.addLabel3(p3);
		p3=p.addTextArea3(p3);
		p3=p.addButton3(p3);
		p3=p.addLabel33(p3);
		p3=p.addTextArea33(p3);
		p3=p.addButton33(p3);
		p0=p.addTextField0(p0);
		p0=p.addComboBox0(p0);
		p0=p.addButton0(p0);
		p4=p.addComboBox4(p4);
		p4=p.addTextField4(p4);
	    p1=p.addTables1(p1);
	    p1=p.addButton1(p1);
	    p.loadInitialValues();
	    
	    //add to frame
		f.add(p0);
		f.add(p1);
		f.add(p2);
		f.add(p3);
		f.add(p4);
		f.setSize(1215,683);    
        f.setVisible(true); 
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		f.addWindowListener(new WindowAdapter()
		{
		    @Override
		    public void windowClosing(WindowEvent e)
		    {
		        super.windowClosing(e);
		        ctdh.close();
		        System.out.print("Closing Connection...");
		    }
		});
	}
}
