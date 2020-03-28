package balila_problem1;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DuplicateRemover 
{
	// Instance variable to hold uniqueWords
	private ArrayList<String> uniqueWords = new ArrayList<String>();
	
	// Adds all unique words in dataFile to variable "uniqueWords"
	public void remove(String dataFile)
	{
		File myFile = new File(dataFile);
		boolean isUnique;
		
		try (Scanner reader = new Scanner(myFile);)
		{
			String temp;
			
			// Loops through entire data file
			while (reader.hasNext())
			{
				isUnique = true;
				temp = reader.next();
				
				// Checks if the String being read is unique
				for (int i = 0; i < uniqueWords.size(); i++)
				{
					if (temp.equalsIgnoreCase(uniqueWords.get(i)))
					{
						isUnique = false;
					}
				}
				
				if (isUnique)
				{
					uniqueWords.add(temp);
				}
			}
		}
		catch(IOException e)
		{
			System.out.println("Error: An IOException has occurred.");
			System.exit(0);
		}
	}
	
	// Writes all words in "uniqueWords" to outputFile
	public void write(String outputFile)
	{
		// Creates a File object to which data will be output
		File myFile = new File(outputFile);
		
		try (FileWriter myWriter = new FileWriter(outputFile);)
		{
			// Creates output file if it does not already exist
			myFile.createNewFile();
			
			// Writes each unique word to output separated by a space
			for (int i = 0; i < uniqueWords.size(); i++)
			{
				myWriter.write(uniqueWords.get(i) + " ");
			}
		}
		catch (IOException e)
		{
			System.out.println("Error: An IOException has occurred.");
			System.exit(0);
		}
	}
}
