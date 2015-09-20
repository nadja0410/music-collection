package org.ninja.music.collection.data;

import java.util.LinkedList;
import java.util.List;


public class Artist
{
	String name 	= "";
	String genre 	= "Other";
	String owner 	= "TBD";
	List<CD> albums = new LinkedList<CD>();
	
	
	public Artist(String name)
	{
		this.name = name;
	}
	
	
	public void addAlbum(CD album)
	{
		this.albums.add(album);
	}
	
	public CD getAlbum(int index)
	{
		return albums.get(index);
	}


	/**
	 * Sets the owner tag, based on its array index in TagCloud.</br>
	 * "TBD", "Jane", "Nadja", "NinJa".
	 */
	public void setOwner(String owner)
	{
		if ((this.owner == "Jane" && owner == "Nadja") || 
				(this.owner == "Nadja" && owner == "Jane")) 
		{
			this.owner = "NinJa";
		} else {
			this.owner = owner;
		}
	}

	
	/**
	 * Sets the genre tags, based on their array index in TagCloud.</br>
	 * Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", 
	 * "Grunge", "Jazz", "Metal", "New Age", "Oldies", "Other", 
	 * "Pop", "R&B", "Reggae", "Rock", "Industrial", "Alternative", 
	 * "Ska", "Death Metal", "Soundtrack", "Vocal", "Classical", 
	 * "Instrumental", "Sound Clip", "Gospel", "Alt Rock", "Soul", 
	 * "Punk", "Instrumental Pop", "Instrumental Rock", "Gothic", 
	 * "Southern Rock", "Comedy", "Top 40", "Pop/Funk", "Showtunes", "Trailer", 
	 * "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", 
	 * "Folk/Rock", "Latin", "Gothic Rock", "Progressive Rock", "Symphonic Rock", 
	 * "Slow Rock", "Big Band", "Easy Listening", "Acoustic", "Opera", "Symphony", 
	 * "Satire/Parody", "Ballad", "Power Ballad", "Freestyle", "Duet", "Punk Rock", 
	 * "Drum Solo", "Acapella", "Hardcore", "Indie", "BritPop", "Polsk Punk", 
	 * "Heavy Metal", "Black Metal", "Crossover", "Christian Rock", 
	 * "Thrash Metal", "Anime", .... 
	 * @param ids Number 0 to 147.
	 */
	public void setGenre(String genre)
	{
		this.genre = genre;
	}
	

	@Override
	public String toString()
	{
		String artist = this.name + " (";
		artist += TagCloud.getOwnerTag(owner) + "; " + this.genre + ")";
		
		for (int i=0; i<this.albums.size(); i++)
		{
			artist += "-> " + this.albums.get(i).toString() + "\n";
		}
		
		return artist;
	}
	
	
}
