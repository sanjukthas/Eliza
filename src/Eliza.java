import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Eliza {
	private static Set<String> hedgeSet = new HashSet<String>();
	private static Set<String> qualifierSet = new HashSet<String>();
	private static Map<String,String> replacementMap = new HashMap<String,String>();
	private static Scanner in;
	
	public static void main(String[] args) {
		
		 hedgeSet.add("Please tell me more");
		 hedgeSet.add("Many of my patients tell me the same thing");
		 hedgeSet.add("It is getting late, maybe we had better quit");
		 
		 qualifierSet.add("Why do you say that");
		 qualifierSet.add("You seem to think that");
		 qualifierSet.add("So, you are concerned that");
		 
		replacementMap.put("i", "you");
		replacementMap.put("me", "you");
		replacementMap.put("my", "your");
		replacementMap.put("am", "are");
		replacementMap.put("you", "I");
		replacementMap.put("are", "am");
		
		
		System.out.println("<Eliza:> Greeting to you!. How are you doing today?");
	while(1>0)
	{
		in = new Scanner(System.in);
		System.out.println("<Enter your response here: Enter Q to quit>");
		String sent = in.nextLine(); 
		
		if (sent.equals("Q")) {
			break;
		}
		Random rand= new Random();
		int route = rand.nextInt(2);
		if (route == 0)
		{
			Random rand1= new Random();
			int route1=rand1.nextInt(hedgeSet.size());
			String responseStr = getItemFromSet(hedgeSet, route1);
			System.out.println(responseStr);
					
		}
		else{
			String wordList[] = sent.split(" ");
			String replacedStr = "";
			for (String word:wordList) {
				if (replacementMap.containsKey(word)) {
					replacedStr += replacementMap.get(word) ;
				} else {
					replacedStr += word;
					
				}
				replacedStr+= " ";
			}
			Random rand1= new Random();
			int route1=rand1.nextInt(qualifierSet.size());
			String responseStr = getItemFromSet(qualifierSet, route1);
			responseStr += " " + replacedStr;
			System.out.println(responseStr);
		}
			
	}
	
}
	public static String getItemFromSet(Set<String> sourceSet, int index) {
		
		Iterator<String> iter = sourceSet.iterator();
		for (int i = 0; i < index; i++) {
			iter.next();
			
		}
		return iter.next();
	}
}
