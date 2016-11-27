package JUNTRA.maingame;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public class ReadAndWriteFile {
	int index=0;
	
	int size=0;//ขนาดข้อมูล
	
	String name[];
	String score[];
	String data[];//เอาไว้เก็บตอนสปิด
	
	JTextArea showscore;
	
	ReadAndWriteFile(){}
	void WriteFile(String name,int score){
		try
		{
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("data.txt",true)));
				bw.newLine();
				bw.write(name+" "+score);
				bw.close();
		}catch (FileNotFoundException e){}
		 catch(IOException e){System.err.println(e);}
	}
	
	public void readFile(JTextArea show){
		this.showscore=show;
		serchsize();
		name=new String[size];
		score=new String[size];
		
		try
		{
		   BufferedReader br =new BufferedReader(new InputStreamReader(new FileInputStream("data.txt")));
	        for (int i=0;i<size ;i++ )
	        {
				String s=br.readLine();
				data=s.split(" ");
				name[i]=data[0];
				score[i]=data[1];
	        }//for
		    br.close();	
		  }//try
			catch (FileNotFoundException e){System.out.print("There is no such file.\n");}
			catch(IOException e){System.err.println(e);}
		sort();
		showdata();
		writenewfile();
		
	}	
	void writenewfile(){
		try
		{
			BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("data.txt")));
			bw1.write("");
			bw1.close();
			//ลบข้อมูลทั้งหมดออดออกแล้วเขียนใหม่ 
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("data.txt",true)));
				for(int i=0;i<size;i++){
					if(i!=0)bw.newLine();
					bw.write(name[i]+" "+score[i]);
				}
			bw.close();
		}catch (FileNotFoundException e){}
		 catch(IOException e){System.err.println(e);}
	}
	void sort(){
		String maxscore;
		String maxname;
		int maxindex;
		for(int a=0;a<size;a++){
			for(int i=0;i<size-1;i++){
				if(Integer.parseInt(score[i])<Integer.parseInt(score[i+1])){
					maxindex=i+1;
					maxscore=score[maxindex];
					maxname=name[maxindex];
					score[maxindex]=score[i];
					score[i]=maxscore;
					name[maxindex]=name[i];
					name[i]=maxname;

				}
			}
		}
	}
	void serchsize(){
		try
		{
		   BufferedReader br =new BufferedReader(new InputStreamReader(new FileInputStream("data.txt")));
	        for (; ; )
	        {
	        	String s=br.readLine();
	        	if (s==null){break;}
	        	size++;
	        }//for
		    br.close();	
		}//try
			catch (FileNotFoundException e){System.out.print("There is no such file.\n");}
			catch(IOException e){System.err.println(e);}
	}
	void showdata(){
		//ต้องการโชว์แค่ 10 คนแรก
		if(size>10)size=10;
		for(int i=0;i<size;i++){
			showscore.append(name[i]+"		"+score[i]+"\n");
		}
	}
}	
