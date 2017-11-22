package hahaha;

import java.io.PrintWriter;
import java.util.Scanner;

public class randomWalk {
	
	public  static String randomWalk() throws Exception {
		Demo demo = new Demo();
		matric ma = new matric();
		stringarrays sa = new stringarrays();
		int[][] arrays = ma.arrays;
		String[] newwords = sa.newwords;
		 int num = demo.len(newwords);
		 if (num == 0){
			 System.out.println("图为空！！");
			 return null;
		 }
		 int [][] newarrays = new int[num][num];
		 int i , j , k , kn , flag = 1;
		 PrintWriter out = new PrintWriter("my.txt");
		 //System.out.println(arrays.size);
		 for(i = 0 ; i < num ; i ++){
			 for(j = 0 ; j < num ; j ++){
				 newarrays[i][j] = arrays[i][j];
			 }
		 }
		 j = num;
		 java.util.Random r = new java.util.Random();
		 k = r.nextInt(j);
		 out.print(newwords[k] + " ");
		 Scanner in = new Scanner(System.in);
		 System.out.print("是否要继续(Y or N)?");
		 String inpu = in.nextLine() ;
		 while(inpu.equals("Y")){
			 int [] lines = new int[num];
			 j = 0;
			 for (i = 0 ; i < num ; i ++){
				 if(newarrays[k][i] != 0){
					 lines[j] = i;
					 j ++;
				 }
			 }
			 if (j == 0){
				 System.out.print("已经没有路了！");
				 break;
			 }
			 java.util.Random rn = new java.util.Random();
			 kn = rn.nextInt(j);
		     out.print(newwords[lines[kn]] + " ");
			 System.out.print("是否要继续(Y or N)?");
			 String inp = in.nextLine();
			 if(inp.equals("N")){
				 break;
			 }
			 if (newarrays[k][lines[kn]] == -1){
				 System.out.println("路径重复");
				 break;
			 }
			 else{
				 newarrays[k][lines[kn]] = -1;
				 k = lines[kn];
			 }
		 }
		 out.close();
		 return "#";
	}
}
