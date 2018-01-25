package org.apache.jena.examples;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;

public class Ex {

		/**
		 * The full namespace: "http://example.org/".
		 */
		public static final String NAMESPACE = "http://example.org/";
		public static final String NODE = "http://xmlns.com/SNR/0.1/";

		/**
		 * The prefix usually used for this vocabulary: 'ex'.
		 */
		public static final String PREFIX = "ex";

		/**
		 * The <code>ex:creatorOf</code> property.
		 */
		public static final IRI CREATOR_OF = getIRI("creatorOf",'p');

		/**
		 * The <code>ex:Artist</code> class.
		 */
		public static final IRI ARTIST = getIRI("Artist",'o');

		/**
		 * Creates a new {@link IRI} with this vocabulary's namespace for the given local name.
		 *
		 * @param localName a local name of an IRI, e.g. 'creatorOf', 'name', 'Artist', etc.
		 * @return an IRI using the http://example.org/ namespace and the given local name.
		 */
		public static IRI getIRI(String localName, char c) {
			if(c=='s' || c=='o') return SimpleValueFactory.getInstance().createIRI(NAMESPACE, localName);
			else return SimpleValueFactory.getInstance().createIRI(NODE, localName);
		}

}
