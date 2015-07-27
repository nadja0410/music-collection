package org.ninja.music.collection.init;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class FolderList 
{
	private File[] folderList; 
	private File directory;
	
	public FolderList(String folderPath)
	{
		this.directory = new File(folderPath);
		this.folderList = this.directory.listFiles();		
	}
	
	public List<String> readFolders()
	{
		List<String> collection = new LinkedList<String>();
		
		for (File folder : folderList) 
		{
	        if (folder.isDirectory()) 
	        {
	        	collection.add(folder.getName());
	            //listf(file.getAbsolutePath(), files);
	        }
	    }
		
		return collection;
	}
}
