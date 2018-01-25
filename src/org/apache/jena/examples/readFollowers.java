package org.apache.jena.examples;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;



public class readFollowers {
	
	public readFollowers(){}
	
	public void writeFollowers()
	{
		String fileName = "Data/eclipse_followers";
		 String line = null;
		 //Ex iri = new Ex();
		 Model model = ModelFactory.createDefaultModel();
		 Property predicate = ResourceFactory.createProperty("http://xmlns.com/SNR/0.1/","followedBy");
		 try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			List<String> userList = new ArrayList<String>();
			try {
				String sub = new String();
				Resource subject=ResourceFactory.createResource("http://example.org/");
				while((line = bufferedReader.readLine()) != null) {
					StringTokenizer st = new StringTokenizer(line," "); //,
					if(st.countTokens()>1){
						while(st.hasMoreElements()) sub = st.nextToken();
						
						if(!userList.contains(sub)) userList.add(sub);
						subject = ResourceFactory.createResource("http://example.org/"+sub);
					}
					else if(st.countTokens()==1){
					    String followerID = st.nextToken();
						RDFNode object = ResourceFactory.createStringLiteral(followerID);
						model.add (subject, predicate, object);
						//System.out.println(followerID);
					}
					System.out.println(line);
				}
				System.out.println("Total user node:"+userList.size());
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
		
		
       
       
       
       
    //   model.add (subject, RDF.type, FOAF.Person);
    //   model.add (subject, FOAF.name, "Alice");
    //   model.add (subject, FOAF.mbox, ResourceFactory.createResource("mailto:alice@example.org"));
    //   model.add (subject, FOAF.knows, bob);
		 try {
			PrintWriter out = new PrintWriter(new FileWriter("output_followers.nt"));
			model.write(out, "N-Triple");
			System.out.println("followers rdf created");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("rdf cannot be created");
			//e.printStackTrace();
		}
       

	}


}
