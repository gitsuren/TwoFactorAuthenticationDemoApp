package com.suru;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Word {
	private String questionWord;	
	private appBean aBean;

	
	public void setQuestionWord(String questionWord) {
		this.questionWord = questionWord;
	}

	public String getQuestionWord() {
		return questionWord;
	}

	public void setQuestionWord() throws FileNotFoundException {

		InputStream is = getClass().getResourceAsStream("/words.txt");			    
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		Random rand = new Random();
		int n = 2365;
		int i = rand.nextInt(n + 1);
		int j = 0;

		System.out.print(i);
		while (true) {
			j++;
			questionWord = "";
			try {
				questionWord = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (j >= i)
				if (questionWord.length() == 4)
					break;
		}

		if (questionWord.equals("")) {			
			questionWord = "java";
		}
		//questionWord="rude";
	}

	public String checkWord(String testWord) throws IOException, URISyntaxException {
		testWord = testWord.toLowerCase();
		questionWord = questionWord.toLowerCase();
		String toreturn = "";

		if (realWord(testWord) == false)
			return "<resp><word>false</word><game>false</game><bull>0</bull><cow>0</cow><real>real?</real></resp>";

		if (testWord.equals(questionWord)){
			aBean.increaseScore();
			return "<resp><word>true</word><game>true</game><bull>4</bull><cow>0</cow><real>"+questionWord+"</real></resp>";
		}

		int bull = 0;
		int cow = 0;

		List<String> testlist = new ArrayList<String>();
		List<String> questionlist = new ArrayList<String>();
		List<Integer> torem = new ArrayList<Integer>();

		int counta = testWord.length();
		for (int i = 0; i < counta; i++) {
			testlist.add(testWord.substring(i, i + 1));
			questionlist.add(questionWord.substring(i, i + 1));
			if (testlist.get(i).equals(questionlist.get(i))) {
				bull++;
				torem.add(i);
			}
		}

		for (int i = torem.size() - 1; i > -1; i--) {
			int rem = (int) torem.get(i);
			testlist.remove(rem);
			questionlist.remove(rem);
		}

		int count = testlist.size();
		for (int i = 0; i < count; i++) {
			if (questionlist.contains(testlist.get(i))) {
				cow++;
				questionlist.remove(testlist.get(i));
				testlist.remove(testlist.get(i));
				count--;
				i--;
			}
		}

		toreturn = "<resp><word>true</word><game>false</game>" + "<bull>"
				+ bull + "</bull><cow>" + cow + "</cow><real>"+questionWord+"</real></resp>";

		return toreturn;

	}

	private boolean realWord(String testWord) throws IOException {
		InputStream is = getClass().getResourceAsStream("/words.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		while (true) {
			String currentword = br.readLine();
			if (testWord.equals(currentword))
				return true;
			if (currentword == null)
				break;
		}

		return false;
	}

	public void setABean(appBean bean) {
		aBean = bean;
	}
}