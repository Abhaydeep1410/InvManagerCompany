/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author abhaydeep
 */


import java.io.IOException;

public class Main {
	login l=new login();
	 public void changeSceneDashboard() throws IOException{
		dashboard d=new dashboard();
		d.show();
	 }
	 public void changeSceneFind() throws IOException{
			find f=new find();
			f.show();
		 }

}
