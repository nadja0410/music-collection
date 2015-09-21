package org.ninja.music.collection;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.ninja.music.collection.data.Artist;
import org.ninja.music.collection.init.CollectionReader;
import com.google.gson.*;

public class Main {

	public static void main(String[] args) {
<<<<<<< HEAD
		//CollectionReader collection = new CollectionReader("M:\\Collection");
		//CollectionReader collection = new CollectionReader("M:\\_Road Trip Music");		
		CollectionReader collection = new CollectionReader("D:\\Privat\\Music");
		//CollectionReader collection = new CollectionReader("F:\\Music\\Nadja's Guilty Pleasure");
		//CollectionReader collection = new CollectionReader("F:\\Music\\Collection");
=======
		//FolderList fList = new FolderList("M:\\Collection");
		//FolderList fList = new FolderList("M:\\_Road Trip Music");
		//FolderList fList = new FolderList("D:\\Privat\\Music");
		FolderList fList = new FolderList("/local/home/coates/Documents");
>>>>>>> branch 'master' of https://github.com/nadja0410/music-collection.git
		
			
		Gson gson = new Gson();
		

		try (FileWriter writer = new FileWriter("D:\\Privat\\collection.json"))
		{
			for (Artist artist : collection.readFolders())
			{
				writer.write(gson.toJson(artist) + "\n");
			}
			writer.close();
	    } catch (IOException e) {
	    	System.out.println("Oh oh. Could not write json file.");
	    }
		
		
		try (BufferedReader reader = new BufferedReader(new FileReader("D:\\Privat\\collection.json")))
		{
			String line = "";
			while ((line = reader.readLine()) != null)
			{
				Artist artist = gson.fromJson(line, Artist.class);
				System.out.println(artist);
			}
			
			reader.close();
		} catch (FileNotFoundException e) {
	    	System.out.println("Oh noes. Could not find json file.");
		} catch (IOException e) {
	    	System.out.println("Oh crap. Could not read json file.");
		}

	}

}
