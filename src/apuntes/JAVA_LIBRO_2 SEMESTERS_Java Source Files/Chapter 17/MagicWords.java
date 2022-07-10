
import javax.swing.*;

public class MagicWords
{
	public static void main(String[] args)
	{
		int result;
		do 
		{
			// declare an array of strings to represent the choices
			String[] choice = {"Enter a word", "Find the secret", "Quit"};
			/* create an option dialogue; the showOptionDialog method
			returns an integer */
			result = JOptionPane.showOptionDialog
			(null,
			"Choose an option",
			"Magic Words",
			JOptionPane.DEFAULT_OPTION,
			JOptionPane.PLAIN_MESSAGE,
			null,
			choice,
			"Enter a word");
			switch(result)
			{
			case 0 : // the first button, "Enter a word", was pushed
			enterWord();
			break;
			case 1 : 	// the second button, "Find the secret", was pushed
			findSecret();
			}
		}while(result != 2); 	// continue until the "Quit" button is pushed
		 System.exit(0);
	}
	// helper methods

	static void enterWord()
	{
		char first, last;
		String word, message;
		/* create an input dialogue; the showInputDialog method
		returns a string */
		word = JOptionPane.showInputDialog
		(null, "Enter a word",
		null,
		JOptionPane.PLAIN_MESSAGE);
		if(word != null) // the cross-hairs were not clicked on
		{
			if(word.length() != 0)
			{
				word = word.toUpperCase();
				first = word.charAt(0);
				last = word.charAt(word.length() - 1);
				if(first == last)
			{
				message = "You entered a magic word";
			}
			else
			{
				message = "You did not enter a magic word";
			}
			// create a message dialogue, giving information
			JOptionPane.showMessageDialog
				(null, message,
				null,
				JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
			// create a message dialogue, showing an error
				message = "You did not enter a word!";
				JOptionPane.showMessageDialog
				(null, message,
				null,
				JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	static void findSecret()
	{
		/* create a confirm dialogue; the showConfirmDialog method
		returns an integer */
		int answer;
		answer = JOptionPane.showConfirmDialog
		(null,
		"Are you sure you want to know the secret?",
		null,
		JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE);
		if(answer == JOptionPane.YES_OPTION)
		{
			/* the message dialog defaults to an information
			message if the following constructor is used */
			JOptionPane.showMessageDialog
			(null,
			"A magic word starts and ends with the same letter");
			}
	}
}

