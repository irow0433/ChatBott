package chat.controller;
import javax.swing.*;

import chat.model.Chatbot;
import chat.view.*;
import chat.tests.ControllerTest;

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
	
	public String interactWithChatbot(String input)
	{
		String chatbotSays = "";
		
		if(chatbot.quitChecker(input))
		{
			
		}
		
		chatbotSays += chatbot.processConversation(input);
		
		return chatbotSays;
	}
	
	public String useCheckers(String text)
	{
		String response = "";
		
		if(chatbot.contentChecker(text))
		{
			response += "This text matches tthe scial contnentt\n";
		}
		if(chatbotcuteAnimalMemeChecker(text))
		{
			response += "";
		}
		//continue will all checkers except length and quit checker
		
		return response;
	}
	
	private boolean chatbotcuteAnimalMemeChecker(String text) {
		// TODO Auto-generated method stub
		return false;
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
	
	public Chatbot getChatbot()
	{
		return chatbot;
	}
	
}
