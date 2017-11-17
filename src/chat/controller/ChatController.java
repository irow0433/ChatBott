package chat.controller;
import javax.swing.*;

import chat.model.Chatbot;
import chat.view.*;
/**
 * this is a controller that will when the app is run will pop up with what the what is in "public void start"
 * @author Isaac Rowlette
 *
 */
public class ChatController 
{
	private Chatbot chatbot;
	private PopupDisplay display;
	private ChatFrame appFrame;
	
	public ChatController()
	{
		chatbot = new Chatbot("Isaac Rowlette");
		//View initialized after Model
		display = new PopupDisplay();
		appFrame = new ChatFrame(this);
	}
	/**
	 * public void start creates the start of program 
	 */
	public void start()

	{
		display.displayText("Welcome to Chatbot");
		//String response = display.collectResponse("Lets begin the conversation but you must start");
		
//		while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response))
//		{
//			response = popupChat(response);
//			response = display.collectResponse(response);
//		}
		
	}
	
	public String intectWithChatbot(String input)
	{
		String chatbotSays = "";
		
		if(chatbot.quitChecker(input))
		{
			
		}
		
		chatbotSays += chatbot.processConversation(input);
		
		return chatbotSays;
	}
	
	private void close()
	{
		display.displayText("GoodBye");
		System.exit(0);
	}
	
	private String popupChat(String chat)
	{
		String chatbotSays = ""; //ASSigns a valid value to a variable that will be returned for the method.
		
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
	}
}
