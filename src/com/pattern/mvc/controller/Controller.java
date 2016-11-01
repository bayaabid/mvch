package com.pattern.mvc.controller;

import com.pattern.mvc.model.Model;
import com.pattern.mvc.view.LoginFormEvent;
import com.pattern.mvc.view.LoginListener;
import com.pattern.mvc.view.View;


/*
 * il observer et il va recevoir login event
 * 
 */
public class Controller implements LoginListener{
	
	private View view;
	private Model model;
	
	public Controller(View view, Model model) {

		this.setView(view);
		this.setModel(model);
	}

	//@Override
	public void loginPerformed(LoginFormEvent event) {
		System.out.println("Login event received. " + event.getName()+ "  "+event.getPassword());		
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}
	
	

}
