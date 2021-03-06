package chat.view;
import javax.swing.SpringLayout;
import chat.controller.ChatController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Need import for scrollpane
import javax.swing.JScrollPane;

/**
 * The JPanel subclass for the chatbot project
 * @author Isaac Rowlette
 * @version 21/11/17 1.2
 */

import javax.swing.*;

import chat.controller.ChatController;

public class ChatPanel extends JPanel
{
	private ChatController appController;
	private JButton chatButton;
	private JButton checkerButton;
	private JTextField inputField;
	private JTextArea chatArea;
	private SpringLayout appLayout;
	private JLabel infoLabel;
	//Need a data member for the scrollpane
	private JScrollPane chatScrollPane;
	
	public ChatPanel(ChatController appController)
	{
		/**super must be the first thing called because extends was used in this method
		 * all five privates above are calling the different things.
		 * the imports are calling the other class so they can get the info from each other
		 */
		super();
		this.appController = appController;
		chatButton = new JButton("chat");
		chatArea = new JTextArea(10, 15);
		inputField = new JTextField(20);
		appLayout = new SpringLayout();
		infoLabel = new JLabel("Type to chat with the chatbot");
		chatScrollPane = new JScrollPane();
		checkerButton = new JButton("Check contents");
		
		//call new helper method
		/**
		 * the "setups" below call the privates that are below that.
		 */
		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupScrollPane()
	{
		chatScrollPane.setViewportView(chatArea);
		chatScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		
	}
	
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = inputField.getText();
				String displayText = appController.interactWithChatbot(userText);
				chatArea.append(displayText);
				inputField.setText("");
			}
		});
		
		checkerButton.addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent click)
			{
				String userText = inputField.getText();
				String displayText = appController.useCheckers(userText);
				chatArea.append(displayText);
				inputField.setText("");
			}
		});
			
		
			
				
	}
	
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.NORTH, chatScrollPane, 0, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, chatScrollPane, 0, SpringLayout.EAST, chatButton);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 84, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.WEST, chatScrollPane, 10, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, -10, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, -10, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, infoLabel, 116, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, infoLabel, -6, SpringLayout.NORTH, inputField);
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.ORANGE);
		this.setLayout(appLayout);
		this.add(chatButton);
		this.add(inputField);
		this.add(chatScrollPane);
		this.add(infoLabel);
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
	}
	
}
