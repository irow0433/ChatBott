package chat.controller;

import chat.view.PopupDisplay;
/**
 * the chat runner is the class that runs the the rest of the program
 * @author irow0433
 */
public class ChatRunner 
{	
	public static void main(String [] args)
	{
		ChatController controller = new ChatController();
		controller.start();
	}
}
