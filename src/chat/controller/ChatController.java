package chat.controller;
import javax.swing.*;

import chat.model.Chatbot;
import chat.view.PopupDisplay;

public class ChatController 
{
	private Chatbot chatbot;
	private PopupDisplay display;
	
	public ChatController()
	{
		chatbot = new Chatbot("Isaac Rowlette");
		display = new PopupDisplay();
	}
	
	public void start()
	{
		
		String response = display.collectResponse("What would you like to talk about?");
		
		while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response))
		{
			response = popupChat(response);
			response = display.collectResponse(response);
		}
		
	}
	

	
	private String popupChat(String chat)
	{
		String chatbotSays = ""; //ASSigns a valid value to a variable that will be returned for the method.
		
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
	}
}
