/**
 * Friend Graph Project
 * Rutgers University - CS112
 * 
 * @author Marco Giancarli
 * @author Milan Patel
 * 
 * May 2, 2014
 */

import java.lang.*;
import java.io.*;
import java.util.*;

class Vertex {
	public String name;
	public String school;
	public ArrayList<Integer> friends;
	
	public Vertex(String name, String school) {
		this.name = name;
		this.school = school;
		friends = new ArrayList<Integer>();
	}
	
	public String toString() {
		if(school == null) {
			return name + "|n";
		}
		return name + "|y|" + school;
	}
}

public class Friends {
	public Vertex[] friendGraph;
	
	/**
	 * @param graphFile Name of the file to be scanned.
	 * 
	 * Builds the graph from the graph file.
	 */
	public Friends(String graphFile) {
		Scanner fileReader;
		try {
			fileReader = new Scanner(new File(graphFile));
			final int NUM_PEOPLE = Integer.parseInt(fileReader.nextLine());
			friendGraph = new Vertex[NUM_PEOPLE];
			// This hashmap allows O(1) access to a person's index from their name.
			HashMap<String,Integer> personMap = new HashMap<String,Integer>(NUM_PEOPLE,0.75f);
			String[] personData, friendship;
			String name, school;
			int indexA, indexB;
			
			// Construct each vertex and put it into the array.
			for(int i=0; i<friendGraph.length; i++) {
				personData = fileReader.nextLine().split("\\|");
				name = personData[0];
				school = personData[1].equals("y") ? personData[2] : null;
				friendGraph[i] = new Vertex(name, school);
				personMap.put(name, i);
			}
			
			// Add all friendships to the adjacency lists in each vertex.
			while(fileReader.hasNext()) {
				friendship = fileReader.nextLine().split("\\|");
				indexA = personMap.get(friendship[0]);
				indexB = personMap.get(friendship[1]);
				friendGraph[indexA].friends.add(indexB);
				friendGraph[indexB].friends.add(indexA);
			}
			
			fileReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("That file doesn't appear to exist. Quitting...");
			System.exit(1);
		}
	}
	
	/**
	 * @param schoolName Name of school (case insensitive), e.g. "penn state"
	 * @return subgraph String representing the vertices and 
	 * friendships with the same format as the original file.
	 */
	public String subgraph(String schoolName) {
		String subgraph = "";
		// what do you do when nobody is in that school? exception?
		return subgraph;
	}
	
	/**
	 * @param start Name of person who wants the intro.
	 * @param end Name of the person who start wants to be introduced to.
	 * @return chain The shortest chain of people in the graph starting at the 
	 * first and ending at the second.
	 */
	public String shortestPath(String start, String end) {
		String path = "";
		// what do you do when there is no path? return string saying so
		return path;
	}
	
	/**
	 * @param schoolName Name of the school to be found.
	 * @return The subgraphs for each of the cliques at this school. Use the 
	 * same formatting as the original file.
	 */
	public String cliques(String schoolName) {
		int cliqueCount = 1;
		String cliques = "";
		while(cliqueCount == 6969) { // yeah change this shit
			cliques = "Clique " + cliqueCount++ + ":\n";
		}
		return cliques;
	}
	
	/**
	 * @return Names of all people who are connectors in the graph, separated 
	 * by commas.
	 */
	public String connectors() {
		String connectors = "";
		
		return connectors;
	}
	
	/**
	 * Driver outputs:
	 * 
	 * Connectors
	 * Output: Print names of all people who are connectors in the graph, comma
	 * separated, in any order.
	 * 
	 * Connected Islands
	 * Output: Print the subgraph for each clique, in the same format as the 
	 * input described in the Graph build section.
	 * 
	 * Shortest Path
	 * Output: Print the chain of people in the shortest path.
	 * 
	 * Subgraph
	 * Output: Print the subgraph in the same format as the input in the Graph 
	 * build section above.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("What is the graph file name?");
		String graphFile = sc.next();
		Friends friends = new Friends(graphFile);
		
		int action = 0;
		while(action != 5) {
			System.out.println("Enter the number of the operation you wish to perform.");
			System.out.println("1: Students at a school");
			System.out.println("2: Shortest introduction path");
			System.out.println("3: Cliques at school");
			System.out.println("4: Connectors");
			System.out.println("5: Quit");
			
			action = sc.nextInt();
			switch(action) {
			case 1:
				System.out.println("Enter the name of a school to find the subgraph of:");
				System.out.println(friends.subgraph(sc.nextLine()));
				break;
			case 2:
				System.out.println("Enter the names of the people you want to find the shortest path between:");
				System.out.println(friends.shortestPath(sc.next(), sc.next()));
				break;
			case 3:
				System.out.println("Enter the name of a school to find the cliques of:");
				System.out.println(friends.cliques(sc.nextLine()));
				break;
			case 4:
				System.out.println(friends.connectors());
				break;
			case 5:
				System.exit(0);
			default:
				System.out.println("Invalid number. Try again.");
				break;
			}
		}
		sc.close();
	}
}
