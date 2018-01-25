package org.apache.jena.examples;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.apache.jena.vocabulary.RDF;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TripleStoreFollower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* String fileName = "Data/Followers";
		 String line = null;
		 //Ex iri = new Ex();
		 Model model = ModelFactory.createDefaultModel();
		 Property predicate = ResourceFactory.createProperty("http://xmlns.com/SNR/0.1/","followedBy");
		 try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			try {
				while((line = bufferedReader.readLine()) != null) {
					StringTokenizer st = new StringTokenizer(line,","); //,
					String sub = st.nextToken();
					int followerTotal = Integer.parseInt(st.nextToken());
					Resource subject = ResourceFactory.createResource("http://example.org/"+sub);
					//System.out.println("Total followers for "+sub+" "+followerTotal);
					for(int i=0;i<followerTotal;i++){
						String followerID = bufferedReader.readLine();
						RDFNode object = ResourceFactory.createStringLiteral(followerID);
						model.add (subject, predicate, object);
						System.out.println(followerID);
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println( "Error reading file '" + fileName + "'");  
			}   
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Unable to open file '" + fileName + "'");
		}
		 try {
			PrintWriter out = new PrintWriter(new FileWriter("output.nt"));
			model.write(out, "N-Triple");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        */
       // new readFollowers().writeFollowers();
        //new readFriends().writeFriends();
		//new SocialNetwork().readCSV("neweclipse1");
		new SocialNetwork2().readCSV("vegas_shooting2");
		/*List<String>fileNames = new ArrayList<String>();
		fileNames.add("solar_eclipse1");
		fileNames.add("solar_eclipse2");
		new FetchUser().writeUser(fileNames);*/
		
	}

}
