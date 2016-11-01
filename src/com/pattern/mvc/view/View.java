package com.pattern.mvc.view;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.pattern.mvc.model.Database;
import com.pattern.mvc.model.Model;

@SuppressWarnings("serial")
public class View extends JFrame implements ActionListener{
	
	private Model model;
	private JButton button;
	private JPasswordField txtPassword ;
	private JTextField txtUser;
	private JLabel labelPassword;
	private JLabel labelUser;
	private JPanel panel;
	private LoginListener loginListener;

	public View(Model model) throws HeadlessException {
		super("MVC Demo");
		this.setModel(model);
		this.button = new JButton("Click Me");
		this.labelUser = new JLabel("User");
		this.labelPassword = new JLabel("Password");
		this.panel = new JPanel();
		this.txtUser = new JTextField(6);
		this.txtPassword = new JPasswordField(6);
		
		BorderLayout layout = new BorderLayout();
		setLayout(layout);
		this.add(panel, BorderLayout.CENTER);
		this.panel.add(labelUser);
		this.panel.add(txtUser);
		this.panel.add(labelPassword);
		this.panel.add(txtPassword);
		this.panel.add(button);
		
		//Database  dataBase = new Database();
		//Database database = Database.getInstance();
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowOpened(WindowEvent e) {
				try {
					Database.getInstance().connect();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(View.this, "Unable to connect to database.",
							"Error", JOptionPane.WARNING_MESSAGE);
					e1.printStackTrace();
				}

			}

			@Override
			public void windowClosing(WindowEvent e) {
				Database.getInstance().disconnect();
			}
			
			
			
		});
		
		this.button.addActionListener(this);
		
		setSize(600 , 500);
		//pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	//@Override
	public void actionPerformed(ActionEvent e) {

		String password = new String(txtPassword.getPassword());
		String name = txtUser.getText();
		
		fireLoginEvent(new LoginFormEvent(password, name));
		
	}

	public void setLoginListener(LoginListener loginListener) {
		this.loginListener = loginListener;
		
	}
	
	public void fireLoginEvent(LoginFormEvent event){
		if(loginListener != null){
			loginListener.loginPerformed(event);
		}
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}
	

}
