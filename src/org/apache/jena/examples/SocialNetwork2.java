package org.apache.jena.examples;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;


public class SocialNetwork2 {

	List<String> userList;
	public SocialNetwork2(){
		userList = new ArrayList<String>();
	}
	public void readCSV(String fileName){
		Model model = ModelFactory.createDefaultModel();
		Property pred_mentions = ResourceFactory.createProperty("http://xmlns.com/SNR/0.1/","mentions");
		Property pred_replies = ResourceFactory.createProperty("http://xmlns.com/SNR/0.1/","in_reply_to");
		Property pred_retweets = ResourceFactory.createProperty("http://xmlns.com/SNR/0.1/","in_retweet_to");
		Resource subject=ResourceFactory.createResource("http://example.org/");
		try {
			FileReader fileReader = new FileReader("Data/"+fileName+".csv");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			PrintWriter outuser = new PrintWriter(new FileWriter("user_shooting2"+".txt"));
			String line= bufferedReader.readLine(); // read first line column name
			int l=0;
			while((line= bufferedReader.readLine())!=null){
				String[] st = line.split(",");
				String userId="",rtUser="",replyUser="";
				List<String> mentionUser= new ArrayList<String>();
				//System.out.println(st.countTokens(););
				int i=0;
				//System.out.println("token size "+st.length);
				while(i<st.length){
					String users = st[i];
					//System.out.printf("%s,",users);
					if(users!=null && !users.isEmpty()){
						//System.out.println("before split "+users);
						String[] id = users.split("\""); 
						String finalid="";
						//System.out.println("quoted string size:"+id.length+" "+id[1]);
						finalid=id[1];
						/*for(String s:id){
							System.out.println("quote:"+s);
							if(s!=null) {
								finalid=s;
								break;
							}
						}*/
						if(i==1) rtUser=finalid;
						else if(i==2) replyUser=finalid;
						else if(i==0) userId=finalid;
						else mentionUser.add(finalid);
					}
					i++;
				}
				//System.out.println();
				//System.out.println("User "+userId+"retweet "+rtUser+"reply "+replyUser);
				if(!userList.contains(userId)) {
					userList.add(userId);
					//System.out.println("user "+userId);
					outuser.write(userId);
					outuser.write("\n");
					
				}
				if(userId!=null && !userId.isEmpty()){
					subject = ResourceFactory.createResource("http://example.org/"+userId);
				}
				if(rtUser!=null && !rtUser.isEmpty()){
					//System.out.println("retweet added "+rtUser);
					model.add (subject, pred_retweets, rtUser);
				}
				if(replyUser!=null && !replyUser.isEmpty()){
					//System.out.println("replies added "+replyUser);
					model.add (subject, pred_replies, replyUser);
				}
				for(int j=0;j<mentionUser.size();j++){
					//System.out.println("mentions "+mentionUser.get(j));
					if(mentionUser.get(j)!=null && !mentionUser.get(j).isEmpty()){
						//System.out.println("mentions added "+mentionUser.get(j));
						model.add (subject, pred_mentions, mentionUser.get(j));
					}
				}
				l++;
				System.out.println(l);
				//if(l==10) break;
			}
			System.out.println("Total user list:"+userList.size());
			bufferedReader.close();
			outuser.close();
			try {
				PrintWriter out = new PrintWriter(new FileWriter(fileName+".nt"));
				model.write(out, "N-Triple");
				System.out.println("eclipse rdf created");
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("rdf cannot be created");
				//e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Unable to open file " + fileName);
		}catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("unable to read file");
		}
		
		
		
	}
}

