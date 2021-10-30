package AnalysisResuts0917;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class qvalues {
	public static void main(String args[])throws IOException{
		double qvalue[]=getPvalue();
/*		for(int i=0;i<qvalue.length;i++) {
			System.out.println(qvalue[i]);
		}
		*/
		System.out.println("begin");
		System.out.println(qvalue.length);
		System.out.println(qvalue[10000]);
		System.out.println(qvalue[33333]);
		//quick(qvalue, 0, qvalue.length-1);
		//q-value(i)=p(i)*length(p)/rank(p)
		Quick_Sort.QuickSort(qvalue, 0, qvalue.length-1);
		
		FileWriter fw=new FileWriter(new File("C:\\Users\\zhen\\Desktop\\CCLE_BreastCancer\\pathwayLength5"));
		BufferedWriter bw=new BufferedWriter(fw);
		for(int i=1;i<qvalue.length;i++) {
			System.out.println(qvalue[i]*qvalue.length/i);
			bw.write(qvalue[i]+"\t"+qvalue[i]*qvalue.length/i+"\r\n");
		}
		bw.close();
		fw.close();
	}
	public static double [] getPvalue()throws IOException{
		FileReader fr=new FileReader(new File("C:\\Users\\zhen\\eclipse-workspace\\GenerateSubpathway\\SubpathwayResut"));
		BufferedReader bf=new BufferedReader(fr);
		FileWriter fw=new FileWriter(new File("C:\\\\Users\\\\zhen\\\\eclipse-workspace\\\\GenerateSubpathway\\\\SubpathwayResut-length5"));
		BufferedWriter bw=new BufferedWriter(fw);
		String s=null;
		Vector<Double> result=new Vector<>();
		int line=0;
		while((s=bf.readLine())!=null) {
			String tem[]=s.split("\t");
			//System.out.println(s);
			int length=Integer.valueOf(tem[1]);
			if(length==5) {
				line++;
				result.add(Double.valueOf(tem[2]));
				bw.write(s+"\r\n");
			}
			
		}
		System.out.println(line);
		bw.close();
		fw.close();
		bf.close();
		fr.close();
		double qvalue[]=new double[result.size()];
		for(int i=0;i<result.size();i++) {
			qvalue[i]=result.get(i);
		}

		return qvalue;
	}
	
}
