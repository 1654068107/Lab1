package hahaha;

import java.io.File;

public class calcShortestPath {
	Demo demo = new Demo();
    public  static String calcShortestPath(String word1 , String word2){
    	Demo demo = new Demo();
    	int[][] arrays = matric.arrays;
        String[] newwords = stringarrays.newwords;
		int v = newwords.length;
		int[][] P = new int[v][v];
		int[][] A = new int[v][v];
		int i , j , k;
		for (i = 0 ; i < v ; i ++){
			for (j = 0 ; j < v ; j ++){
				if (arrays[i][j] == 0){
					A[i][j] = 100;
					P[i][j] = j;
				}
				else{
					A[i][j] = arrays[i][j];
					P[i][j] = -1;
				}
			}
		}
		for (k = 0 ; k < v ; k ++){
			for (i = 0 ; i < v ; i ++){
				for (j = 0 ; j < v ; j ++){
					if (A[i][k] + A[k][j] < A[i][j]){
						//System.out.println( A[i][k] + " " + A[k][j]);
						A[i][j] = A[i][k] + A[k][j];
						P[i][j] = k;
						
					}
				}
			}
		}
		int bnf , enf , temp , pathvalue , sum = 0;
		bnf = demo.place(newwords , word1);
		enf = demo.place(newwords , word2);
		if (bnf == -1 || enf == -1){
			System.out.println("单词不存在！！");
			return "#";
		}
		if (bnf == enf){
			System.out.println( "\n最短路径的长度为0" );
			return "#";
			
		}
		temp = P[bnf][enf];
		pathvalue = bnf;
	    Graphviz gv = new Graphviz();
		gv.addln(gv.start_graph());
		for (i = 0 ; i < newwords.length ; i ++){
			for ( j = 0 ; j < newwords.length ;j ++){
				if (arrays[i][j] > 0){
					gv.addln(newwords[i] + " -> " + newwords[j] + "[label = " + arrays[i][j] + "]" + ";");
				}
			}
		}
		if (arrays[bnf][enf] > 0){
	    	gv.addln(newwords[bnf] + " -> " + newwords[enf] + "[color = " + "\"blue\"" +"]" + ";");;
	    	System.out.println(word1 + "->" + word2 + "\n最短路径长度为1");
	    	return "#";
	    }
	    int n = 0;
		int[] path = new int[newwords.length];
	    if (temp != -1){
	    	path[0] = bnf;
	    	n ++;
	    	int temp1 = temp;
    		int[] oldpath = new int[newwords.length];
    		int oldn = 1;
    		while(temp1 != -1){
    			oldpath[oldn] = temp1;
		        temp1 = P[bnf][temp1];
		        oldn ++;
    		}
    		for (i = 2; i <= oldn - 1 ; i ++){
    			path[i - 1] = oldpath[oldn - i + 1];
    		}
    		n = oldn - 1;
	    	while(temp != -1)
		    {
		        sum = sum + A[pathvalue][enf];
		        path[n] = temp;
		        temp = P[temp][enf];
		        pathvalue = temp;
		        n ++;
		    }
	    }
	    if (sum == 0)
	    {
	        System.out.println("不可达");
	    }
	    else{
	    	path[n] = enf;
	    	for (i = 0 ; i < n ; i ++){
	    		gv.addln(newwords[path[i]] + " -> " + newwords[path[i + 1]] + "[color = " + "\"blue\"" +"]" + ";");;
	    		System.out.print(newwords[path[i]] + " -> ");
	    	}
	    	System.out.println(newwords[enf]);
	    	System.out.println("最短路径长度为" + A[bnf][enf]);
	    }
	    gv.addln(gv.end_graph());
		String type = "png";
		File out = new File("ShortestPath." + type); 
	    gv.writeGraphToFile( gv.getGraph( gv.getDotSource(), type ), out );      
	    return "#";
	}
    
}
