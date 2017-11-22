package hahaha;

public class queryBridgeWords {
  public  static String queryBridgeWords(String word1 , String word2){

	Demo demo = new Demo();
	matric ma = new matric();
    stringarrays sa = new stringarrays();
    int[][] arrays = ma.arrays;
    String[] newwords = sa.newwords;
	int i , j = 0 , k , place1 , place2;
	String[] bridgewords = new String[100];
	String result = new String();
	place1 = demo.place(newwords , word1);
	place2 = demo.place(newwords , word2);
	//System.out.println(place1 + place2);
	if (place1 != -1 && place2 != -1){
		for (i = 0 ; i < newwords.length ; i ++){
			if (arrays[place1][i] > 0){
				if (arrays[i][place2] > 0){
					bridgewords[j] = newwords[i];
					j ++;
				}
			}
		}
		if (j == 0 ){
			result = "No bridge words from \"" + word1 + "\" to \"" + word2 + "\"!";
		}
		else if (j == 1){
			result = "The bridge words from \"" + word1 +  "\" to \"" + word2 + "\" is:" + bridgewords[0];
		}
		else if (j > 1){
			result = "The bridge words from \"" + word1 + "\" to \"" + word2 + "\" are:";
			for (k = 0 ; k < j - 1; k ++){
				result = result + bridgewords[k] + ",";
			}
			result = result + "and " + bridgewords[j - 1] + "\n";
		}
	}
	else if (place1 != -1){
		result = "No \"" + word2 + "\" in the graph!";
	}
	else if (place2 != -1){
		result = result + "No \"" + word1 + "\" in the graph!";
	}
	else{
		result = result + "No \"" + word1 + "\" and \"" + word2 + "\" in the graph!";
	}
	return result;
  }
}
