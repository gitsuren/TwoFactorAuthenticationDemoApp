package com.suru;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class appBean {
	private int id;
	private String[] names = { "Surendra","Ghaith","James","Mario" };
	private List<String> players;
	private String[] scoresa = new String[16];
	private List<Integer> scores;

	public appBean() throws IOException {
		//id=6;
		players=new ArrayList<String>();
		scores=new ArrayList<Integer>();
		loadFromFile();
	}
	
	public void setId(int id){
		this.id=id;
	}
	
	public String getPlayer(int i){
		return players.get(i);
	}
	
	public int getScore(int i){
		return scores.get(i);
	}
	
	public void increaseScore() throws IOException, URISyntaxException{
		scores.set(id, scores.get(id)+1);		
	
		URL dir_url = getClass().getResource("/gamecount.txt");			    
		
		// Turn the resource into a File object
		File file = new File(dir_url.toURI());
		
		PrintWriter pw=new PrintWriter(file);
		String s="";
		for(int i=0;i<4;i++){
			s+=scores.get(i).toString();			
			if(i!=3)
				s+=":";			
		}
		pw.print(s);
		pw.flush();
		pw.close();
	}
	
	private void loadFromFile() throws IOException{
		scores.clear();
		players.clear();
		
		InputStream is = getClass().getResourceAsStream("/gamecount.txt");			    
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		String marks = br.readLine();
		if (marks != null) {
			scoresa = marks.split(":");
		}
		
		for(int i=0;i<4;i++){
			scores.add(Integer.parseInt(scoresa[i]));
			players.add(names[i]);
		}		
	}
}