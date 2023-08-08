package com.day13;
import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
//import MusicFileFormatException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Interactive menu where the user can use the functionalities of the MusicRecommender
 *
 * @version 2
 * @author 
 */



class MusicFileFormatException extends Exception{
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Error in music file format..";
	}
	
}

class NoRecommendationException extends Exception{
	

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "No recommendation..";
	}
}


class MusicRecommender{
	String musicListFileName;

    String wholeFile;
    String records[];
    String record[];
    
	String trackname;
	String artist_name;
    String genre ;
    int BPM;
    int  popularity;

	public MusicRecommender(String musicListFileName) throws Exception {
		// TODO Auto-generated constructor stub
		this.musicListFileName=musicListFileName;
		
	 	//reading from file
	      File file = new File("Music_list.txt");
	      
	      //Creating a Scanner object
	      Scanner sc = new Scanner(file);
	      
	      //StringBuffer to store the contents
	      StringBuffer sb = new StringBuffer();
	      
	      //Appending each line to the buffer
	      while(sc.hasNextLine()) {
	         sb.append(sc.nextLine()+"\n");
	      }
	      sc.close();
	      String s = sb.toString();
	      this.wholeFile=s;

	      String [] records = s.split("\n");
	      this.records=records;
	      
//	      String [] record = records[0].split(" ");
//	      this.record=record;
	     
//	      String track_name = record[0];
//	      String artist_name = record[1];
//	      String genre = record[2];
//	      int BPM = Integer.parseInt(record[3]);
//	      int  popularity = Integer.parseInt(record[4]);
//	      
//	      System.out.println(track_name+" by "+artist_name+": "+genre+" with "+BPM+" BPM. Recommended "+popularity);
	}
	
	public String getMusicListFileName() {
		return musicListFileName;
	}

	public void setMusicListFileName(String musicListFileName) {
		this.musicListFileName = musicListFileName;
	}
	
	public ArrayList<Music> searchArtists(MusicProfile musicProfile) throws NoRecommendationException{
		ArrayList<Music> newMusicList= new ArrayList<Music>();
		

		
		for(int i=0;i<records.length;i++) {
			
		      String track_name = this.records[i].split(" ")[0];
		      String artist_name = this.records[i].split(" ")[1];
		      String genre = this.records[i].split(" ")[2];
		      int BPM = Integer.parseInt(this.records[i].split(" ")[3]);
		      int  popularity = Integer.parseInt(this.records[i].split(" ")[4]);
			
			
		      if (artist_name.toLowerCase().contains(musicProfile.getPreferredArtist().toLowerCase())) {
//				if(artist_name.equalsIgnoreCase(musicProfile.getPreferredArtist())) {

				Music m = new Music(track_name,artist_name,genre,BPM,popularity+1);
				newMusicList.add(m);
				this.trackname=track_name;
				this.artist_name=artist_name;
				this.genre=genre;
				this.BPM=BPM;
				
				popularity++;
				this.popularity=popularity;
				String oldPopularityStr = this.records[i].split(" ")[4];
				String updatedPopularityStr = Integer.toString(popularity);
				this.records[i] = this.records[i].replace(oldPopularityStr, updatedPopularityStr);
			}
		}
		
		if(newMusicList.isEmpty()) {
			System.out.println("Sorry we did not find any artist like your favorite artist");
			throw new NoRecommendationException();
		}
		
		
		
		return newMusicList;
	}
//	
	public Music genreBasedRecommendation(MusicProfile musicProfile) throws NoRecommendationException  {
		Music newMusic = new Music("","","",0,0);
		for(int i=0;i<records.length;i++) {
		      String track_name = this.records[i].split(" ")[0];
		      String artist_name = this.records[i].split(" ")[1];
		      String genre = this.records[i].split(" ")[2];
		      int BPM = Integer.parseInt(this.records[i].split(" ")[3]);
		      int  popularity = Integer.parseInt(this.records[i].split(" ")[4]);
			
			
			if(genre.equalsIgnoreCase(musicProfile.getPreferredGenre())) {
//				System.out.println(track_name+" by "+artist_name+": "+genre+" with "+BPM+" BPM. Recommended "+popularity);
				newMusic.setTrack(track_name);
				newMusic.setArtist(artist_name);
				newMusic.setGenre(genre);
				newMusic.setBPM(BPM);
				newMusic.setPopularity(popularity+1);
				
				this.trackname=track_name;
				this.artist_name=artist_name;
				this.genre=genre;
				this.BPM=BPM;
				this.popularity=popularity+1;
				popularity++;
				this.popularity=popularity;
				String oldPopularityStr = this.records[i].split(" ")[4];
				String updatedPopularityStr = Integer.toString(popularity);
				this.records[i] = this.records[i].replace(oldPopularityStr, updatedPopularityStr);
			}
			
			
			
		}
		if(newMusic.getArtist().equals(null))
			throw new NoRecommendationException();
		
		return newMusic;
		//increase popularity
	}
	
	public Music  BPMBasedRecommendation(MusicProfile musicProfile) throws NoRecommendationException {
		Music newMusic = new Music("","","",0,0);
		int min =Integer.MAX_VALUE;
		for(int i=0;i<records.length;i++) {
		      String track_name = this.records[i].split(" ")[0];
		      String artist_name = this.records[i].split(" ")[1];
		      String genre = this.records[i].split(" ")[2];
		      int BPM = Integer.parseInt(this.records[i].split(" ")[3]);
//		      System.out.println(BPM);
		      int  popularity = Integer.parseInt(this.records[i].split(" ")[4]);
		      
		      
		      if(Math.abs(musicProfile.getPreferredBPM()- BPM)< min) {
		    	  	min=Math.abs(musicProfile.getPreferredBPM()- BPM);
					newMusic.setTrack(track_name);
					newMusic.setArtist(artist_name);
					newMusic.setGenre(genre);
					newMusic.setBPM(BPM);
					newMusic.setPopularity(popularity+1);
					
					this.trackname=track_name;
					this.artist_name=artist_name;
					this.genre=genre;
					this.BPM=BPM;
					popularity++;
					this.popularity=popularity;
					String oldPopularityStr = this.records[i].split(" ")[4];
					String updatedPopularityStr = Integer.toString(popularity);
					this.records[i] = this.records[i].replace(oldPopularityStr, updatedPopularityStr);
		      }
		      
		      
		}
		
		if(newMusic.getArtist().equals(null))
			throw new NoRecommendationException();
		
		return newMusic;
	}
	public Music getMostPopularMusic() throws NoRecommendationException {
		Music newMusic = new Music("","","",0,0);
		
		for(int i=0;i<records.length;i++) {
		      String track_name = this.records[i].split(" ")[0];
		      String artist_name = this.records[i].split(" ")[1];
		      String genre = this.records[i].split(" ")[2];
		      int BPM = Integer.parseInt(this.records[i].split(" ")[3]);
		      int  popularity = Integer.parseInt(this.records[i].split(" ")[4]);
		      
		      int max =Integer.MIN_VALUE;
		      if(popularity>= max ) {
		    	  	max= popularity;
					newMusic.setTrack(track_name);
					newMusic.setArtist(artist_name);
					newMusic.setGenre(genre);
					newMusic.setBPM(BPM);
					newMusic.setPopularity(popularity+1);
					
					this.trackname=track_name;
					this.artist_name=artist_name;
					this.genre=genre;
					this.BPM=BPM;
//					this.popularity=popularity;
					popularity++;
					this.popularity=popularity;
					String oldPopularityStr = this.records[i].split(" ")[4];
					String updatedPopularityStr = Integer.toString(popularity);
					this.records[i] = this.records[i].replace(oldPopularityStr, updatedPopularityStr);;
		      }
		      
		      
		}
		
		if(newMusic.getArtist().equals(null))
			throw new NoRecommendationException();
		
		
		return newMusic;
	}
	public void saveMusicList() throws FileNotFoundException {
        String outputFilePath = getMusicListFileName();
        String[] dataArray = records;
        try {
            // Create a FileWriter object with full overwrite
            FileWriter fileWriter = new FileWriter(outputFilePath, false);

            try {
                // Write each element to the file on a new line
                for (String element : dataArray) {
                    fileWriter.write(element + System.lineSeparator());
                }
            } finally {
                // Close the FileWriter
                fileWriter.close();
            }


        } catch (IOException e) {
            // Handle any potential exceptions
            e.printStackTrace();
        }
    
	}
	
	
}


 public class MusicRecommenderMenu {
	 

    /**
     * Interactive menu where the user can use the functionalities of the MusicRecommender
     * @param args No argument is needed for this main method
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws Exception {
 

	      
        Scanner scan = new Scanner(System.in);
        MusicRecommender musicRecommender = null;
    	
    	
        while (true) {
            try {
//                System.out.println("Welcome! What's the name of the file containing the music list?");
//                String musicListFileName = scan.nextLine();
//                musicRecommender = new MusicRecommender(musicListFileName);
            	musicRecommender = new MusicRecommender("Music_list.txt");
                 break;
            }  
            
            catch (FileNotFoundException e) {
                System.out.println("The file does not exist! Please enter a valid file name!");
            }
            catch (MusicFileFormatException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        System.out.println("What's the name of the user?");
        String name = scan.nextLine();
        System.out.println("Who's your favorite artist?");
        String artist = scan.nextLine();
        System.out.println("What's your favorite genre?");
        String genre = scan.nextLine();
        System.out.println("What's your preferred BPM?");
        int BPM = scan.nextInt();
        System.out.println("Do you like popular music? (Y/N)");
        scan.nextLine();
        boolean likePopular = (scan.nextLine().equalsIgnoreCase("Y"));
        MusicProfile musicProfile = new MusicProfile(name, artist, genre, BPM, likePopular);

        System.out.printf("Hi %s!\n", musicProfile.getName());
        int option = -1;
        while (option != 5) {
            System.out.println("1. Find songs of my favorite artists\n" +
                    "2. Get a recommendation based on my preferred genre\n" +
                    "3. Get a recommendation based on my preferred BPM\n" +
                    "4. Show me the most popular song\n" +
                    "5. Exit");
            boolean wrongCondition;
            do {
                option = scan.nextInt();
                wrongCondition = ((option != 1) && (option != 2) && (option != 3) && (option != 4) && (option != 5));
                if (wrongCondition) System.out.println("Please enter a valid option!");
            } while (wrongCondition);
            switch (option) {
                case 1 -> {
                    try {
                        ArrayList<Music> searchResult = musicRecommender.searchArtists(musicProfile);
                        System.out.printf("Listing songs by %s:\n", musicProfile.getPreferredArtist());
                        for (Music music : searchResult) {
                            System.out.println(music.toString());
                        }
                    } catch (NoRecommendationException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 2 -> {
                    try {
                        System.out.println(musicRecommender.genreBasedRecommendation(musicProfile).toString());
                    } catch (NoRecommendationException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> {
                    try {
                        System.out.println(musicRecommender.BPMBasedRecommendation(musicProfile).toString());
                    } catch (NoRecommendationException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 4 -> System.out.println(musicRecommender.getMostPopularMusic().toString());
                case 5 -> { }
            }
        }
        musicRecommender.saveMusicList();
        
        System.out.println("Thanks for using the music recommender!");
    }
}