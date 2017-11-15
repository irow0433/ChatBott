package chat.view;
import java.awt.Color;

import javax.swing.*;

import chat.controller.ChatController;

public class ChatPanel extends JPanel
{
	private ChatController appController;
	private JButton chatButton;
	private JTextField inputField;
	private JTextArea chatArea;
	private SpringLayout appLayout;
	
	public ChatPanel(ChatController appController)
	{
		super();
		this.appController = appController;
		chatButton = new JButton("chat");
		chatArea = new JTextArea(10, 15);
		inputField = new JTextField(20);
		appLayout = new SpringLayout();
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupListeners()
	{
		
	}
	
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.NORTH, chatArea, 0, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, chatArea, 0, SpringLayout.EAST, chatButton);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 84, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.WEST, chatArea, 10, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, -10, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, -10, SpringLayout.EAST, this);
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.GREEN);
		this.setLayout(appLayout);
		this.add(chatButton);
		this.add(inputField);
		this.add(chatArea);
	}
}
