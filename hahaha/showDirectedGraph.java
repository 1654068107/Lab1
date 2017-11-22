package hahaha;

import java.io.File;
public class showDirectedGraph {
	public static void showDirectedGraph(int[][] arrays , String[] newwords){
		Graphviz gv = new Graphviz();
	    gv.addln(gv.start_graph());

		System.out.println("展示有向图：");
		int i , j;
		//String result = "";
		for (i = 0 ; i < arrays.length ; i ++){
			for (j = 0 ; j < arrays.length ; j ++){
				if (arrays[i][j] > 0){
					gv.addln(newwords[i] + " -> " + newwords[j] + "[label = " + arrays[i][j] + "]" + ";");
				}
			}
		}
		gv.addln(gv.end_graph());
		String type = "png";
		File out = new File("Graph." + type); 
	    gv.writeGraphToFile( gv.getGraph( gv.getDotSource(), type ), out );
	}

}
