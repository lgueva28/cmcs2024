import java.util.Scanner;
public class MovieDriver {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		Movie movie = new Movie();
		String again;
		
		//this is where the computer will ask & receive the input from the user 
		do {
			//this will ask the user for their movie of choice
		System.out.println("Enter the name of a movie");
		String title = keyboard.next();
		movie.setTitle(title);
		
		//this will ask the user for their rating on the movie
		System.out.println("Enter the rating of the movie");
		String rating = keyboard.next();
		movie.setRating(rating);
		
		//this will ask the user for the number of tickets sold
		System.out.println("Enter the number of tickets sold for this movie");
		int soldTickets = keyboard.nextInt();
		movie.setSoldTickets(soldTickets);
		
		//this will print out their summary of what they input
		System.out.println(movie.toString());
		
		//this section will now ask the user is they would like to watch another movie
		System.out.println("Do you want to enter another? (y or n) ");
		again = keyboard.next();
		
		}while(!again.equalsIgnoreCase("n"));
		System.out.println("Goodbye");
	}

}
