package org.ninja.music.collection.data;

import com.mpatric.mp3agic.*;

public class TagCloud extends ID3v1Genres
{
	private static String[] OWNER_TAGS = {"TBD", "Jane", "Nadja", "NinJa"};	

	
	public static String getOwnerTag(String tag)
	{	
		for (int i = 0; i < OWNER_TAGS.length; i++)
		{
			if (OWNER_TAGS[i] == tag)
			{
				return OWNER_TAGS[i];
			}
				
		}
		
		return OWNER_TAGS[0];	
	}
	
	public String prettyPrintGenreTags()
	{
		String prettyTags = "";
		
		for (int i = 0; i < GENRES.length; i++)
		{
			prettyTags += i + ": " + GENRES[i] + "\n";
		}
		
		return prettyTags;
	}
	
	
	/*
	private static String[] USER_TAGS = {"TBD", "Jane", "Nadja", "NinJa"};
	private static String[] GENRE_TAGS = GENRES;
	

	
	public static String getUserTag(int id)
	{		
		return USER_TAGS[id];
	}
	
	public static String getGenreTag(int id)
	{		
		return GENRE_TAGS[id];
	}
	
	public static int getTagIndex(String tag)
	{		
		for (int i = 0; i < GENRE_TAGS.length; i++)
		{
			if (tag == GENRE_TAGS[i])
			{
				return i;
			}
		}
		
		return -1;
	}
	
	public String prettyPrintGenreTags()
	{
		String prettyTags = "";
		
		for (int i = 0; i < GENRE_TAGS.length; i++)
		{
			prettyTags += i + ": " + GENRE_TAGS[i] + "\n";
		}
		
		return prettyTags;
	}
	*/
}
