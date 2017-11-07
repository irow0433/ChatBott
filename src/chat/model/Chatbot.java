package chat.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;

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
	
	public Chatbot(String username)
	{
		this.movieList = null;
		this.shoppingList = new ArrayList<String>();
		this.cuteAnimalMemes = null;
		this.questions = new String[10];
		this.username = username;
		this.content = null;
		this.intro = null;
		this.currentTime = null;
		this.topics = new String [7];
		this.verbs = new String [4];
		this.followUps = new String [5];
		
		buildVerbs();
		buildTopics();
		buildFollowups();
		buildQuestions();	
		buildShoppingList();
	}
	
	private void buildVerbs()
	{
		verbs[0] = " like ";
		verbs[1] = " dislike ";
		verbs[2] = " am ambivalent about ";
		verbs[3] = " am thinking about ";
	}

	private void buildMovieList()
	{
		Movie StarWars = new Movie("Star Wars");
		Movie Hulk = new Movie("Hulk");
		Movie TheRevenant = new Movie("The Revenant");
		Movie Warrior = new Movie("Warrior");
		Movie LordofTheRings = new Movie("Lord of The Rings");
		Movie SpiderMan = new Movie("SpiderMan");
		Movie HiddenFigures = new Movie("Hidden Figures");
		movieList.add(StarWars);
		movieList.add(Hulk);
		movieList.add(TheRevenant);
		movieList.add(Warrior);
		movieList.add(LordofTheRings);
		movieList.add(SpiderMan);
		movieList.add(HiddenFigures);
		
		
	}
	
	private void buildTopics()
	{
		topics[0] = " Football ";
		topics[1] = " Rap ";
		topics[2] = " Life ";
		topics[3] = " Mario ";
		topics[4] = " Cereal ";
		topics[5] = " T.V. Shows ";
		topics[6] = " Google ";
	}
	
	private void buildFollowups()
	{
		
	}
	
	private void buildShoppingList()
	{
		shoppingList.add("snacks");
		shoppingList.add("veggies");
		shoppingList.add("protein");
		shoppingList.add("slug bait");
		shoppingList.add("gross things");		
	}
	
	private void buildCuteAnimals()
	{
		cuteAnimalMemes.add("otter");
		cuteAnimalMemes.add("pupper");
		cuteAnimalMemes.add("kittie");
		cuteAnimalMemes.add("FLOOFER");
		
	}
	
	private void buildQuestions()
	{
		questions[0] = "What is your favorite movie?";
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
	
	public String processConversation(String input)
	{
		String chatbotResponse = " ";
		chatbotResponse += "You said: " + "\n" + input + "\n";
		chatbotResponse += buildChatbotResponse();
		
		return chatbotResponse;
	}
	
	private String buildChatbotResponse()
	{
		String response = " I ";
		int random = (int) (Math.random() * verbs.length);
		
		response += verbs[random];
		
		random = (int) (Math.random() * topics.length);
		response +=" " + topics[random] + ".\n";
		
		random = (int) (Math.random() * questions.length);
		response += questions[random];
		
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
		return false;
	}
	
	public boolean userNameChecker(String input)
	{
		return false;
	}
	
	public boolean contentChecker(String contentCheck)
	{
		return false;
	}
	
	public boolean cuteAnimalMemeChecker(String input)
	{
		return false;
	}
	
	public boolean shoppingListChecker(String shoppingItem)
	{
		return false;
	}
	
	public boolean movieTitleChecker(String title)
	{
		return false;
	}
	
	public boolean movieGenreChecker(String genre)
	{
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
		return false;
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
		return null;
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
		return null;
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