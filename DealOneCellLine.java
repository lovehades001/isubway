package AnalysisResuts0917;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DealOneCellLine {
	public static void main(String args[])throws IOException{
		getOneCellLineData();
	}
	public static void getOneCellLineData()throws IOException{
		FileReader fr=new FileReader(new File("C:\\Users\\zhen\\Desktop\\hsa04114-new"));
		BufferedReader bf=new BufferedReader(fr);
		FileWriter fw=new FileWriter(new File("C:\\\\Users\\\\zhen\\\\Desktop\\\\hsa04114-new_log.csv"));
		BufferedWriter bw=new BufferedWriter(fw);
		String s=null;
		int num[]=new int[10];
		while((s=bf.readLine())!=null) {
			String tem[]=s.split("\t");
			int length=Integer.valueOf(tem[1]);
			num[length]++;
			
			double value=-Math.log10(Double.valueOf(tem[2]));
			bw.write(tem[1]+","+value+"\r\n");
		}
		for(int i=0;i<num.length;i++) {
			System.out.println(i+"\t"+num[i]);
		}
		bw.close();
		fw.close();
		bf.close();
		fr.close();
	}
}	
