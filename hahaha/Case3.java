package hahaha;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class Case3 {

	@Before
	public void setUp() throws Exception {
	}

	@SuppressWarnings("static-access")
	@Test
	public void testrandomWalk() throws Exception {
        Demo demo = new Demo();
		
        int [][] array  = matric.arrays;
		String[] newword = stringarrays.newwords;
		Scanner in = new Scanner(System.in);
	    String newalpha ="";
	    File file = new File("D:\\score1.txt");
	    
	    Scanner input = new Scanner(file);
	    while (input.hasNext()){
	    	String alpha = input.nextLine();
	    	newalpha = newalpha + alpha + " ";
	    }
	    input.close();
	    String newstr = newalpha.replaceAll("[\\p{Punct}]", " ");
	    String newstring = newstr.replaceAll("[^a-zA-Z\\s]", "");
	    String newnew = newstring.toLowerCase();
	    String[] words = newnew.split("\\s+");
	    int num = words.length;
	    int i , j , k , sign = 1 , number = 0;
	    newword[0] = words[0];
	    for (i = 1 ; i < num ; i ++){
	    	sign = 1;
	    	for (k = 0 ; k <= number ; k ++){
	    		if (newword[k].equalsIgnoreCase(words[i])){
	    			sign = 0;
	    		}
	    	}
	    	if (sign == 1){
	    		number ++;
	    		newword[number] = words[i];
	    		
	    	}
	    } 
	    //System.out.println(lens + "j");
	    for (i = 0 ; i < num - 1; i ++){
	    	j = demo.place(newword , words[i]);
	    	k = demo.place(newword , words[i + 1]);
	    	if (j != k){
	    		array[j][k] ++;
	    	}
	    }
	    randomWalk.randomWalk();
	}

}
