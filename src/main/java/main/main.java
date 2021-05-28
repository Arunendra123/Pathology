package main;

import DBManager.ConnectToDB_H;
import ViewLayer.Frame;

public class main 
{
	public static void main(String s[])
	{
		final ConnectToDB_H ctdh=new ConnectToDB_H();
		ctdh.createConnection();
		Frame f=new Frame();
		f.initializeFrame(ctdh);
    }
}