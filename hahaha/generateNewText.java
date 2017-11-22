package hahaha;

import java.util.Random;

public class generateNewText {
	public static  String findBridgeWords(String word1 , String word2){
		Demo demo = new Demo();
		matric ma = new matric();
	    stringarrays sa = new stringarrays();
	    int[][] arrays = ma.arrays;
	    String[] newwords = sa.newwords;
		int i, j = 0, k, place1, place2; 
		String[] bridgewords = new String[100]; 
		place1 = demo.place(newwords, word1); 
		place2 = demo.place(newwords, word2); 
		if (place1 != -1 && place2 != -1) { 
		for (i = 0; i < newwords.length; i++) { 
 				if (arrays[place1][i] > 0) { 
 					if (arrays[i][place2] > 0) { 
 						bridgewords[j] = newwords[i]; 
 						j++;  					
 					} 
 				} 
 			} 
		if (j == 0) { 
 				return "#"; 
 		} 
		else if (j == 1) { 
 				return bridgewords[0]; 
 			} 
 			else if (j > 1) { 
 				long t = System.currentTimeMillis(); 
 				Random rd = new Random(t); 
 				k = (int) (rd.nextInt() * j); 
 				return bridgewords[k]; 
 			} 
 		} 
 		else { 
 			return "#"; 
 		} 
 		return "#"; 
 	} 

	public static String generateNewText(String inputText){
		Demo demo = new Demo();
		matric ma = new matric();
	    stringarrays sa = new stringarrays();
	    int[][] arrays = ma.arrays;
	    String[] newwords = sa.newwords;
		String newst = inputText.replaceAll("[\\p{Punct}]", " ");
	    String news = newst.replaceAll("[^a-zA-Z\\s]", "");
	    String[] newchars = news.split("\\s+");
	    int i;
	    String bw = new String();
	    if (newchars.length == 1){
	    	System.out.println(newchars[0]);
	    	return "#";
	    }
	    for( i = 0 ; i < newchars.length - 1 ; i ++){
	    	System.out.print(newchars[i] + " ");
	    	bw = findBridgeWords(newchars[i] , newchars[i + 1]);
	    	if (bw != "#"){
	    		System.out.print(bw + " ");
	    	}
		}
	    System.out.println(newchars[newchars.length - 1]);
	    return "#";
	}
}
