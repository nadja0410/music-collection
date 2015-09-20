package org.ninja.music.collection.init;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

import org.ninja.music.collection.data.Artist;
import org.ninja.music.collection.data.CD;
import org.ninja.music.collection.data.TagCloud;


public class CollectionReader 
{
	private File rootDir; 
	
	public CollectionReader(String rootPath)
	{
		this.rootDir = new File(rootPath);
	}
	
	public List<Artist> readFolders()
	{
		List<Artist> collection = readArtists(this.rootDir);		
		return collection;
	}
	
	private List<Artist> readArtists(File path)
	{
		List<Artist> collection = new LinkedList<Artist>();
		File[] folderList = path.listFiles();
				
		if (folderList != null)
		{			
			for (File folder : folderList) 
			{
		        if (folder.isDirectory() && !folder.getName().startsWith("_")) 
		        {
		        	Artist artist = new Artist(folder.getName());
		        	readAlbums(artist, new File(path.getAbsolutePath() + "\\" + folder.getName()));
		        	
		        	collection.add(artist);
		        }
		    }
		} else {
			System.out.println("Error: The given folder path is invalid!");
		}
		
		return collection;		
	}
	
	
	private void readAlbums(Artist artist, File path)
	{
		File[] folderList = path.listFiles();
				
		if (folderList != null)
		{			
			for (File folder : folderList) 
			{
		        if (folder.isDirectory()) 
		        {
		        	CD album = new CD(folder.getName(), folder.getAbsolutePath());
		        	readSongs(artist, album, new File(path.getAbsolutePath() + "\\" + folder.getName()));
		        	
		        	artist.addAlbum(album);
		        }
		    }
		} else {
			System.out.println("Error: The given folder path is invalid!");
		}		
	}

	private void readSongs(Artist artist, CD album, File path)
	{
		File[] fileList = path.listFiles();
		
		if (fileList != null)
		{	
			for (File file : fileList) 
			{
		        if (file.isFile() && file.getName().endsWith(".mp3")) 
		        {
		        	try
					{
						String genre = "";
						String owner = "";
						Mp3File mp3 = new Mp3File(file);
				        if (mp3.hasId3v1Tag()) {
				        	genre = mp3.getId3v1Tag().getGenreDescription();
							owner = mp3.getId3v1Tag().getComment();
				        } else if (mp3.hasId3v2Tag()) {
				        	genre = mp3.getId3v2Tag().getGenreDescription();
							owner = mp3.getId3v2Tag().getComment();
				        }
				        
						artist.setGenre(genre);						
						if (owner == null || owner.equals(""))
						{
							owner = "TBD";
						}						
						artist.setOwner(TagCloud.getOwnerTag(owner));
			        	
					} catch (UnsupportedTagException e)	{
						System.out.println("Grrr. Unsupported tag found when "
								+ "creating MP3 object.");
					} catch (InvalidDataException e) {
						System.out.println("Urgh. Invalid data found when "
								+ "creating MP3 object");
					} catch (IOException e)	{
						System.out.println("Hmpf. IO exception encountered when "
								+ "creating MP3 object");
					}
					
			        album.addSong(file.getName());
		        }
			}
		}		
	}
}
