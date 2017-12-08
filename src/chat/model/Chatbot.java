package chat.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.*;
/**
 * The chatbot model includes all of the methods needed for the user
 * @author Isaac Rowlette
 *
 */
public class Chatbot
{
	private List<Movie> movieList;
	private List<String> shoppingList;
	private List<String> cuteAnimalMemes;
	private String [] verbs;
	private String [] topics;
	private String [] followUps;
	private String [] questions;
	private String username;
	private String content;
	private String intro;
	private LocalTime currentTime;
	/**
	 * in a way activates and gives a perpose to the programs.
	 * @param username
	 */
	public Chatbot(String username)
	{
		this.movieList = new ArrayList<Movie>();
		this.shoppingList = new ArrayList<String>();
		this.cuteAnimalMemes = new ArrayList<String>();
		this.questions = new String[10];
		this.username = username;
		this.content = "";
		this.intro = null;
		this.currentTime = LocalTime.now();
		this.topics = new String [7];
		this.verbs = new String [4];
		this.followUps = new String [5];
		
		buildVerbs();
		buildTopics();
		buildFollowups();
		buildQuestions();	
		buildShoppingList();
		buildMovieList();
		buildCuteAnimals();

	}
	/**
	 * gives the program a verb to use for the response
	 */
	private void buildVerbs()
	{
		verbs[0] = " like";
		verbs[1] = " dislike";
		verbs[2] = " am ambivalent about";
		verbs[3] = " am thinking about";
	}
	/**
	 * gives the program  a list of movies to say and uses the verbs to create a sentence
	 */
	private void buildMovieList()
	{
		Movie StarWars = new Movie("Star Wars");
		Movie Hulk = new Movie("Hulk");
		Movie Warrior = new Movie("Warrior");
		Movie LordofTheRings = new Movie("Lord of The Rings");
		Movie SpiderMan = new Movie("SpiderMan");
		Movie HiddenFigures = new Movie("Hidden Figures");
		movieList.add(StarWars);
		movieList.add(Hulk);
		movieList.add(Warrior);
		movieList.add(LordofTheRings);
		movieList.add(SpiderMan);
		movieList.add(HiddenFigures);
		
		
	}
	/**
	 * gives the program a list of topics to talk about
	 */
	private void buildTopics()
	{
		topics[0] = " Football ";
		topics[1] = " Rap";
		topics[2] = " Life";
		topics[3] = " Mario";
		topics[4] = " Cereal";
		topics[5] = " T.V. Shows";
		topics[6] = " Google";
	}
	
	private void buildFollowups()
	{
	
	}
	
	private void buildShoppingList()
	{
		shoppingList.add("snacks");
		shoppingList.add("veggies");
		shoppingList.add("protein");
		shoppingList.add("gross things");	
		shoppingList.add("turkey");
		shoppingList.add("jam");
		shoppingList.add("ham");
		shoppingList.add("sandwitch");
		shoppingList.add("turkey leg");
		shoppingList.add("poptart");
		shoppingList.add("cereal");
	}
	
	private void buildCuteAnimals()
	{
		cuteAnimalMemes.add("pupper");
		cuteAnimalMemes.add("otter");
		cuteAnimalMemes.add("FLOOFER");
		cuteAnimalMemes.add("kittie");
		
	}
	/**
	 * gives the chatbot a question to ask
	 */
	private void buildQuestions()
	{
		questions[0] = "What is your user name?";
		questions[1] = "What is your address?";
		questions[2] = "Who are your parents?";
		questions[3] = "Whats your favorite thing to do?";
		questions[4] = "Whats your annual networth?";
		questions[5] = "If you could have a super power what would it be?";
		questions[6] = "What is your job?";
		questions[7] = "What is one of your hobbies?";
		questions[8] = "What is your favorite t.v. show?";
		questions[9] = "Would you like to run off into the sunset?";
	}
	
	/**
	 * describe what the method does using a complete sentence(s)
	 * Description - takes what the users text input is and processes it and returns a string.
	 * @param input Explain each parameter using a full sentence too
	 * @return Define what is returned
	 */
	
	/**
	 * Builds a response based on the users input and the created chatbot response.
	 * @param input The users text as a String
	 * @return the combined user and the chatbot response as a String
	 */
	public String processConversation(String input)
	{
		String chatbotResponse = " ";
		chatbotResponse += currentTime.getHour() + ":" + currentTime.getMinute() + " ";
		chatbotResponse += "You said: " + "\n" + input + "\n";
		
		chatbotResponse += buildChatbotResponse();
		
		return chatbotResponse;
	}
	
	/**
	 * builds a random response using the chatbot's sentence part arrays
	 * @return The random response of the chatbot
	 */
	private String buildChatbotResponse()
	{
		String response = "I ";
		int random = (int) (Math.random() * verbs.length);
		
		response += verbs[random];
		
		random = (int) (Math.random() * topics.length);
		response +=" " + topics[random] + ".\n";
		
		random = (int) (Math.random() * questions.length);
		response += questions[random];
		
		random = (int) (Math.random() * 2);
		
		if (random % 2 ==0)
		{
			random = (int) (Math.random() * movieList.size());
					response += "\n" + movieList.get(random).getTitle() + " is a great movie!";
		}
		
		int followup = (int) (Math.random() * 5);
		
		switch (followup)
		{
		case 0:
			response += followUps[0] + "\n";
			break;
		case 3:
			response += followUps[1] + "\n";
		case 1:
			response += followUps[2] + "\n";
			break;
		default:
			response += followUps[4] + "\n";
			response += followUps[3] + "\n";
		}
		
		return response;
	}
	
	public boolean lengthChecker(String input)
	{
		if (input != null && input.length() > 2)
		{
			return true;
		}
		return false;
	}
	
	public boolean htmlTagChecker(String input)
	{
		if(input.contains("<P>")) 
		{
			return true;
		}
		if(input.contains("HREF")&&(!input.contains("=")))
		{
			return false;
		}
		if(input.indexOf(">")<input.lastIndexOf(">")&&input.indexOf("<")<input.lastIndexOf("<"))
		{
			return true;
		}
		
		
		return false;
	}
	
	public boolean userNameChecker(String input)
	{
		if(input == null || input.length() == 0 || !input.substring(0, 1).equals("@"))
		{
			return false;
		}
			for(int i =1; i<input.length(); i++)
			{
				if(input.substring(i, i+1).equals("@"))
				{
					return false;
				}
			}
			return true;
	}
	
	public boolean contentChecker(String contentCheck)
	{
		return false;
	}
	
	public boolean cuteAnimalMemeChecker(String input)
	{
		for(String item : cuteAnimalMemes)
		{
			if(input.toLowerCase().equals(item))
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean shoppingListChecker(String shoppingItem)
	{
		for(String item: shoppingList)
		{
			if(shoppingList != null && shoppingItem.equalsIgnoreCase(item))
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean movieTitleChecker(String title)
	{
		if(title != null && title.length() > 3)
		{
			return true;
		}
		return false;
	}
	
	public boolean movieGenreChecker(String genre)
	{
		if(genre != null && genre.length() > 4)
		{
			return true;
		}
		return false;
	}
	
	public boolean quitChecker(String exitString)
	{
		if (exitString!= null && exitString.equalsIgnoreCase("quit"))
		{
		return true;
		}
		return false;
	}

	public boolean keyboardMashChecker(String sample)
	{
		//The word were can be incorrectly shown as mash as I check for keys
		if(sample.toLowerCase().contains("were"))
		{
			return false;
		}
		
		String keyboard = "wqqertyuiop[]asdfghjkl;'zxcvbnm,./";
		for (int index = 0; index< sample.length() - 2; index ++)
		{
			String sampleKeys = sample.substring(index, index +3);
			for(int i = 0; i < keyboard.length() - 2; i++)
			{
				String keys = keyboard.substring(i, i + 3);
						//check forward
						if(keys.equals(sampleKeys.toLowerCase()))
						{
							return true;
						}
				//check backward
				keys = keys.substring(2, 3) + keys.substring(1, 2) + keys.substring(0, 1);
				if(keys.equals(sampleKeys.toLowerCase()))
				{
					return true;
				}
				
			}
		}
		return false;
	}
	
	public String toString()
	{
		String str = "";
		return str;
	}
	
	public List<Movie> getMovieList()
	{	
		return movieList;
	}
	
	public List<String> getShoppingList()
	{ 
		return shoppingList;
	}
	
	public List<String> getCuteAnimalMemes()
	{
		return cuteAnimalMemes;
	}

	public String [] getQuestions()
	{
		return questions;
	}
	
	public String[] getVerbs()
	{
		return verbs;
	}

	public String[] getTopics()
	{
		return topics;
	}

	public String[] getFollowUps()
	{
		return followUps;
	}

	public String getUsername()
	{
		return username;
	}
	
	public String getContent()
	{
		return content;
	}

	public String getIntro()
	{
		return null;
	}
	
	public LocalTime getCurrentTime()
	{
		currentTime = LocalTime.now();
				return currentTime;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
}
