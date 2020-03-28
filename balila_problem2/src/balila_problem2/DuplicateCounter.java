package balila_problem2;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class DuplicateCounter 
{
	// HashMap with each String associated with the number of times it appears in the text file
	HashMap<String, Integer> wordCounter = new HashMap<>();
	
	// Counts the number of times each word appears in a text file
	public void count(String dataFile)
	{
		// Creates a File object representing dataFile
		File myFile = new File(dataFile);
		
		try(Scanner reader = new Scanner(myFile);)
		{
			boolean isUnique;
			
			while (reader.hasNext())
			{
				isUnique = true;
				String temp = reader.next();
				
				// To ignore cases when determining uniqueness
				temp = temp.toLowerCase();
				
				// Checks if String being read is unique, increases count if already in HashMap
				if (wordCounter.containsKey(temp))
				{
					isUnique = false;
					wordCounter.put(temp, wordCounter.get(temp) + 1);
				}
				
				if (isUnique)
				{
					wordCounter.put(temp, 1);
				}
			}
		}
		catch(IOException e)
		{
			System.out.println("Error: An IOException has occurred.");
			System.exit(0);
		}
	}
	
	// Writes to outputFile each word in HashMap along with how many times it appeared
	public void write(String outputFile)
	{
		File myFile = new File(outputFile);
		
		try(FileWriter myWriter = new FileWriter(outputFile);)
		{
			myFile.createNewFile();
			myWriter.write(wordCounter.toString());
		}
		catch(IOException e)
		{
			System.out.println("Error: An IOException has occurred");
			System.exit(0);
		}
	}
}
