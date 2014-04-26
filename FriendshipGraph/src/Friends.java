/**
 * 
 * @author Marco Giancarli
 * @author Milan Patel
 * 
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
}

public class Friends {
	public Vertex[] friendGraph;
	
	/**
	 * @param graphFile Name of the file to be scanned.
	 * 
	 * Builds the graph from the graph file.
	 */
	public Friends(String graphFile) {
		Scanner fileReader = new Scanner(graphFile);
		final int NUM_PEOPLE = fileReader.nextInt();
		friendGraph = new Vertex[NUM_PEOPLE];
		// This hashmap allows O(1) access to a person's index from their name.
		HashMap<String,Integer> personMap = new HashMap<String,Integer>(NUM_PEOPLE,0.75f);
		String[] personData, friendship;
		String name, school;
		int indexA, indexB;
		
		// Construct each vertex and put it into the array.
		for(int i=0; i<friendGraph.length; i++) {
			personData = fileReader.nextLine().split("|");
			name = personData[0];
			school = personData[1].equals("y") ? personData[2] : null;
			friendGraph[i] = new Vertex(name, school);
			personMap.put(name, i);
		}
		
		// Add all friendships to the adjacency lists in each vertex.
		while(fileReader.hasNext()) {
			friendship = fileReader.nextLine().split("|");
			indexA = personMap.get(friendship[0]);
			indexB = personMap.get(friendship[1]);
			friendGraph[indexA].friends.add(indexB);
			friendGraph[indexB].friends.add(indexA);
		}
	}
	
	/**
	 * @param schoolName Name of school (case insensitive), e.g. "penn state"
	 * @return subgraph Subgraph of original graph, vertices are all students 
	 * at the given school, edges are a subset of the edges of the original 
	 * graph such that both endpoints are students at the school. The subgraph 
	 * must be in stored in the adjacency linked lists form, just as for the 
	 * original graph.
	 */
	public ArrayList<Vertex> subgraph(String schoolName) {
		ArrayList<Vertex> subgraph = new ArrayList<Vertex>();
		
		return subgraph;
	}
	
	/**
	 * @param start Name of person who wants the intro.
	 * @param end Name of the person who start wants to be introduced to.
	 * @return chain The shortest chain of people in the graph starting at the 
	 * first and ending at the second.
	 */
	public ArrayList<Vertex> shortestPath(String start, String end) {
		ArrayList<Vertex> path = new ArrayList<Vertex>();
		
		return path;
	}
	
	/**
	 * @param schoolName Name of the school to be found.
	 * @return The subgraphs for each of the cliques.
	 */
	public ArrayList<Vertex> cliques(String schoolName) {
		ArrayList<Vertex> clique = new ArrayList<Vertex>();
		
		return clique;
	}
	
	/**
	 * @return Names of all people who are connectors in the graph
	 */
	public ArrayList<String> connectors() {
		ArrayList<String> connectors = new ArrayList<String>();
		
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
		for(int i=0; i<friends.friendGraph.length; i++) {
			System.out.print(friends.friendGraph[i]);
		}
	}
}
