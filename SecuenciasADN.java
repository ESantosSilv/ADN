package Aleatorios;

	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.Random;
	public class SecuenciasADN {
	 /**
	  * A continuacion se crea una secuencia de números aleatoria
	  * Para  que el primer número sea menor que el segundo y en
	  * esos números se creara una secuencia de letras semejantes a las del ARN
	  * @param args
	  * @throws IOException
	  * author @NicolasS
	  */
	 public static void main(String[] args) throws IOException {
	  SecuenciasADN cf = new SecuenciasADN();
	  System.out.println(cf.countReads("TTGC"));
	 } //
	 public SecuenciasADN(){
	  
	  int start, length;
	  String Sequence;
	  Random rd = new Random();
	  try
	  {
	   BufferedWriter bf = new BufferedWriter(new FileWriter ("Secuencias.umd"));
	   for (int i = 0; i < 1000; i++)
	   {
	    start = Math.abs( rd.nextInt());
	    length = 5 + rd.nextInt(25);
	    Sequence = "";
	    for(int j = 0; j < length; j++ )
	    {
	     switch(rd.nextInt(4))
	     {
	      case 0: Sequence += "A"; break;
	      case 1: Sequence += "C"; break;
	      case 2: Sequence += "G"; break;
	      case 3: Sequence += "T"; break;
	     }
	    }
	    bf.write(start + "," + (start + length) +  "," + Sequence + "\n");
	   }
	   bf.flush();
	  }
	  catch (IOException e)
	  {
	   e.printStackTrace();
	  }
	 }
	 /**
	  * A continuacion se calcula la candidad de repiticiones 
	  * de letras que son reflejadas 
	  * en la secuencia de numeros 
	  * @param motif
	  * @return
	  * @throws IOException
	  */
	 public int countReads(String motif) throws IOException
	 {
	  BufferedReader br = new BufferedReader (new FileReader("Secuencias.umd"));
	  String read;
	  int lines = 0;
	  read = br.readLine();
	  while(read != null)
	  {
	   if (read.split(",")[2].contains(motif))
	   {
	    lines += 1;
	   } 
	   read = br.readLine();
	  }
	  return lines;
	  }
	}
