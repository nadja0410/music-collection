package org.ninja.music.collection;

import org.ninja.music.collection.init.FolderList;

public class Main {

	public static void main(String[] args) {
		//FolderList fList = new FolderList("M:\\Collection");
		//FolderList fList = new FolderList("M:\\_Road Trip Music");
		//FolderList fList = new FolderList("D:\\Privat\\Music");
		FolderList fList = new FolderList("/local/home/coates/Documents");
		
		for (String folderName : fList.readFolders()) 
		{
			System.out.println(folderName);
		}
		
	}

}
