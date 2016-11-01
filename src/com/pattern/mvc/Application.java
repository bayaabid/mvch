package com.pattern.mvc;

import javax.swing.SwingUtilities;

import com.pattern.mvc.controller.Controller;
import com.pattern.mvc.model.Model;
import com.pattern.mvc.view.View;

public class Application {
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			//@Override
			public void run() {
				
				runApp();
				
			}
		});
	}
	
	public static void runApp(){
		
		Model model = new Model();
		
		View view = new View(model);
		
		Controller controller = new Controller(view , model);
		
		view.setLoginListener(controller);
		
	}

}
