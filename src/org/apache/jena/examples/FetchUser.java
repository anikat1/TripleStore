package org.apache.jena.examples;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FetchUser {
	List<String> userList;
	public FetchUser(){
		userList = new ArrayList<String>();
	}
	public void writeUser(List<String>fileNames){
		try{
		PrintWriter out = new PrintWriter("userIDs"+".txt");
		for(int i=0;i<fileNames.size();i++){
			try {
				FileReader fileReader = new FileReader("Data/"+fileNames.get(i)+".csv");
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String line= bufferedReader.readLine(); // read first line column name
				while((line= bufferedReader.readLine())!=null){
					StringTokenizer st = new StringTokenizer(line,",");
					int j=0;
					while(st.hasMoreTokens()){
						String u = st.nextToken();
						if(j==0){
							if(!userList.contains(u)){
								userList.add(u);
								out.write(u);
								out.write("\n");
								System.out.println(u);
							}
							break;
						}
						j++;
					}
				}
				bufferedReader.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("Unable to open file " + fileNames.get(i));
			}catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("unable to read file");
			}
		}
		out.close();
		System.out.println("Total users "+userList.size());
		/*try {
			PrintWriter out = new PrintWriter("userNames"+".txt");
			for(String u : userList){
				out.write(u);
				out.write("\n");
			}
			System.out.println("eclipse users created");
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("users cannot be created");
			//e.printStackTrace();
		}*/
	}catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("unable to write in file");
	}
	}
}
