package AnalysisResuts0917;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class GetSubpthwayLengDis {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		getDistribution();
		getDistribution_1();
	}
	public static void getDistribution_1()throws IOException{
		FileReader fr=new FileReader(new File("E:\\SubpathwayResut"));
		BufferedReader bf=new BufferedReader(fr);
		FileWriter fw=new FileWriter(new File("E:\\result_1\\"));
		BufferedWriter bw=new BufferedWriter(fw);
		String s=null;
		Vector<Double> result=new Vector<>();
		int line=0;
		
		while((s=bf.readLine())!=null) {
			String tem[]=s.split("\t");
			line++;
			int length=Integer.valueOf(tem[1]);
			if(length==7&&line%100==0) {
				
				double oneRes=-Math.log10(Double.valueOf(tem[2]));
				result.add(oneRes);
				System.out.println(oneRes);
				bw.write(Double.toString(oneRes)+"\r\n");
				if(result.size()==Math.pow(10, 4)) {
					break;
				}
			}
		}
		bw.close();
		fw.close();
		bf.close();
		fr.close();
	}
	//不减一
	public static void getDistribution()throws IOException{
		FileReader fr=new FileReader(new File("D:\\\\GenerateSubpathway\\\\subpathwayResult\\\\SubpathwayResut1"));
		BufferedReader bf=new BufferedReader(fr);
		FileWriter fw=new FileWriter(new File("E:\\result1\\"));
		BufferedWriter bw=new BufferedWriter(fw);
		String s=null;
		Vector<Double> result=new Vector<>();
		int line=0;
		while((s=bf.readLine())!=null) {
			//System.out.println(s);
			String tem[]=s.split("\t");
			line++;
			int length=Integer.valueOf(tem[1]);
			if(length==7&&line%100==0) {
				
				double oneRes=(Double.valueOf(tem[2]));
				result.add(oneRes);
				System.out.println(oneRes);
				bw.write(Double.toString(oneRes)+"\r\n");
				if(result.size()==Math.pow(10, 4)) {
					break;
				}
			}
		}
		bw.close();
		fw.close();
		bf.close();
		fr.close();
	}

}
