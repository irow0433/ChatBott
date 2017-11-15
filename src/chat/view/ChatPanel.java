package chat.view;

import javax.swing.*;

import chat.controller.ChatController;

public class ChatPanel extends JPanel
{
	private ChatController appController;
	private JButton chatButton;
	private JTextField inputField;
	private JTextArea chatArea;
	private SpringLayout baseLayout;
	
	public ChatPanel(ChatController appController)
	{
		super();
		this.appController = appController;
	}

}
