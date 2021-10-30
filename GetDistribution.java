package AnalysisResuts0917;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


import java.io.IOException;

public class GetDistribution {
	public static void main(String args[])throws IOException{
		getDistribution();
	}
	public static void getDistribution()throws IOException{
		FileReader fr=new FileReader(new File("C:\\Users\\zhen\\Desktop\\CCLE_BreastCancer\\pathwayLength7"));
		BufferedReader bf=new BufferedReader(fr);
		String s=null;
		int statics[]=new int[50];
		while((s=bf.readLine())!=null) {
			String tem[]=s.split("\t");
			double value=Double.valueOf(tem[0]);
			double newValue=-Math.log10(value);
			int realNum=(int)newValue;
			statics[realNum]++;
			//System.out.println(newValue);
		}
		bf.close();
		fr.close();
		for(int i=0;i<statics.length;i++) {
			System.out.println(i+"\t"+statics[i]);
			
		}
	}
	
}
