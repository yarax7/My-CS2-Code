import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab42{ 

	public static void main(String[] args){ 

		Film head = null;
		head = getFilmFromDataFile("input.txt"); 
		System.out.println("--------------------------------------");
		System.out.println("Printing the Linked List");
		printLL(head);

      Film newFilm = new Film("The Matrix", "Lana Wachowski", "Sci-Fi", 1999, 8.7);
		head = addFilm(head, newFilm, 0);
		System.out.println("\n\n--------------------------------------");
		System.out.println("Adding a new Film at position 0\n");
		System.out.println("Printing the Linked List\n");
		printLL(head);

      Film newFilm2 = new Film("Shrek", "Andrew Adamson", "Animation", 2001, 9.5);
		head = addFilm(head, newFilm2, 3);
		System.out.println("\n\n--------------------------------------");
		System.out.println("Adding a new Film at position 3\n");
		System.out.println("Printing the Linked List\n");
		printLL(head);

      head = deleteFilm(head, 3);
		System.out.println("\n\n--------------------------------------");
		System.out.println("Deleting Film information from position 3\n");
		System.out.println("Printing the Linked List\n");
		printLL(head);

      head = deleteFilm(head, 0);
		System.out.println("\n\n--------------------------------------");
		System.out.println("Deleting Film information from position 0\n");
		System.out.println("Printing the Linked List\n");
		printLL(head);

      System.out.println("\n\n--------------------------------------");
		System.out.println("\nThe name of the Director of the best rated film: ");
		bestRated(head);

      System.out.println("\n\n--------------------------------------");
		System.out.println("\nThe name of the oldest film: ");
	   oldestRelease(head);

      System.out.println("\n\n--------------------------------------");
		System.out.println("\nThe average rating for: ");
	   averageRating(head, "Crime");

	} 

	/** 
	 * Complete this method to print the Film Linkedlist
	 * given the head of the Film LinkedList
	 * @param head of the Film LinkedList 
	 */ 

	public static void printLL (Film head) { 

        Film curr=head;

		while(head!=null){
            System.out.println(curr);
            if(curr.next==null){ //If we have reached the end of the LL.
                return;
            }
            curr=curr.next;

		}
	} 

	/**  
     * This method will add a Film to the linked list in a given position.
	 * @param head
	 * @param newFilm
	 * @param position
	 * @return head
	 */   
	public static Film addFilm(Film head, Film newFilm, int position) {

        if(head==null){
            return null;
        } else if(position==0){
            newFilm.next=head;
            return newFilm;
        } 
		int count=1; 
        Film beg=head; //Head is given to a new film in order to create the new LL.
        Film curr=head.next;

		while(head!=null){
		 	if(position==count){ //Checks if we are in the correct position to add a new film.
		 		beg.next=newFilm;
                newFilm.next=curr;
                return head;
		 	}
            count++;
            beg=curr;
		 	curr=curr.next;
		}

        if(position==count){ //This statement goes outside the loop to add a film to the end of the LL.
            beg.next=newFilm;
            return head;
        } else {
            System.out.println("Please enter a valid position to add a new film.");
		    return head;
        }
        
   } 

    /**  
     * This method will delate a Film from the linked list from a given position.
	 * @param head
	 * @param position
	 * @return head
	 */      
	public static Film deleteFilm (Film head, int position) { 
        Film curr=head; //Creating new Film in order to traverse through LL.
		if(head==null){ //If LL is empty return null.
			return null;
		}

        if(position==0){ //Simply skips over the first film.
            return head.next;
        }

        int count=1;

		while(count<position && curr.next!=null){ //Checks if we have reached the given position and if we are at the end of the LL.
            curr=curr.next;
            count++;
        }
		if(curr.next!=null){ 
			head.next=head.next.next;
            return head;
		} else {
			System.out.println("Please enter a valid position to delete");
		}
		return head;
	}

	/**  
     * This method finds the Film with the best rating.
	 * @param head
	 */   
    public static void bestRated(Film head) { 
        //Initializing our variables:
        Film best=null;
        Film curr=head;

    	if(head==null){ //If LL is empty return null.
    		return;
    	}

		
		while(curr!=null){
			if(best==null || curr.getRating()>best.getRating()){ //Checks if best is actually better than curr.
				best=curr;
			} 
			curr=curr.next; //Continues throughout LL.

		}

        String director=best.getDirector();
        double maxRating=best.getRating();

       // if(best!=null){
            System.out.println("Name: "+director+" Rating: "+maxRating);
       // } 

    }

	/**  
     * This method find the Film with the oldest release date.
	 * @param head
	 */   
     public static void oldestRelease(Film head) { 
        //Initializing variables.
        Film old=null;
        Film curr=head;

        while(head!=null){
        	if(old==null || curr.getReleaseYear()<old.getReleaseYear()){ //Checks if "old" is actually older than curr.
        		old=curr;
        	}  
        	head=head.next;	//Continues throughout LL.
        }

        System.out.println("Name: "+old.getTitle()+", Release year: "+old.getReleaseYear());
    }

    /**  
     * This method calculates the average rating of all the movies 
     * in a given genre
	 * @param head
	 * @param genre
	 */  
	public static void averageRating(Film head, String genre) {
        //initializing all variables:
		double rating=0;
		int count=0;
		double average=0;
        Film curr=head;
		while(curr!=null){
			if(curr.getGenre().equals(genre)){ //Checks if we are averaging the correct genre.
				rating+=curr.getRating();
				count++; //Counting in order to calculate the average.
			}
            curr=curr.next; //Continues moving through the LL.
		}
		average=rating/count; //Averaging.
		if(count==0){
			System.out.println("No films found for specified genre.");
		} else {
			System.out.println("The average rating for "+genre+" is: "+average);
		}
    }

    /** 
	 * This method reads the input file and creates a linked list
	 * based on the content of the file.   
	 * The method returns the head of linkedlist. 
	 * @param fileName 
	 * @return head of the created Linked List  
	 */ 
	static Film getFilmFromDataFile (String fileName){ 
        Film head = null;
		try{
            File file = new File(fileName);
            Scanner fileReader = new Scanner(file);
            //Creating scanner object to read the file.
            while(fileReader.hasNextLine()){
                String lineReader = fileReader.nextLine();
                String[] attributes = lineReader.split("\t");
                //Differentiates all our different types of data (title, director, etc).
                if(attributes.length >= 5){
                    if(attributes[0] != null && attributes[1] != null && attributes[2] != null && attributes[3] != null && attributes[4] != null){
                        //Giving the variables data from the file.
                        String title = attributes[0];
                        String director = attributes[1];
                        String genre = attributes[2];
                        int year = Integer.parseInt(attributes[3]);
                        double rating = Double.parseDouble(attributes[4]);
                        Film film = new Film(title,director,genre,year,rating);//Creates a new film object.
                        if(head == null){
                            head = film;
                        }else{
                            Film previous = head;
                            while(previous.next != null){
                                previous = previous.next;
                            }
                            previous.next = film;
                        }
                    }else{
                        System.out.println("Invalid Data");
                    }
                }
            }
        }
    // Catches if anything goes wrong with finding the file.
    catch(FileNotFoundException e) {
      System.out.println("File Not Found");
    }
    return head; 
	}
} 