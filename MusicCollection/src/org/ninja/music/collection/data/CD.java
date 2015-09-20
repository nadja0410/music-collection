package org.ninja.music.collection.data;

import java.util.LinkedList;
import java.util.List;


public class CD
{
	private String title 		= "";
	private String path		= "";
	private List<String> songs 	= new LinkedList<String>();
	
	
	public CD (String title, String path)
	{
		this.title 	= title;
	}

	public CD (String title, String path, List<String> songs)
	{
		this.title 	= title;
		this.songs	= songs;
	}

	
	public void addSong(String song)
	{
		this.songs.add(song);
	}
	
	public String getPath()
	{
		return this.path;
	}

	@Override
	public String toString()
	{
		String cdName = title + "\n";
		
		for (String song : songs)
		{
			cdName += "\t" + song + "\n";
		}		
		
		return cdName.trim();
	}
	
	
}
