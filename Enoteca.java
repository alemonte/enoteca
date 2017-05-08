import java.util.*;
public class Enoteca 
{
	

  //Stampare tutti i vini
	
	public void  stampaVini()
	{
		int k=0;
		for(k=0;k<vini.size();k++)
		{
			Vino vino=vini.get(k);	
			System.out.println("nome: "+vino.getNome()+" prezzo: "+ vino.getPrezzo());
		}	
	} 

		
	//Stampare la quantità di bottiglie per ogni Vino	
	public void qntXvino()
	{
		int i=0;
		for(i=0;i<vini.size();i++)
		{
			System.out.println("i vini "+vini.get(i).getNome+"sono " vini.get(i).getQnt());
		}
	}
	
	//Stampare la quantità di Bottiglie per ogni Produttore
	public void qntXproduttore()
	{
		int i =0;
		int k=0;
		int count=0;
		Vector<String> produttori= new Vector<String>();
		
		for(i=0;i<vini.size();i++)
		{
			String produttore= vini.get(i).GetProduttore;
			if( nellaLista(produttori,produttore)==1)
			produttori.add(produttore);
		}
		
		for(i=0;i<produttori.size();i++)
		{
			for(k=0;k<vini.size();k++)
			{
				String produttore=vini.get(i).GetProduttore;
				if(produttore.equals(produttori.get(k)))
				{
					count++;
				}
			}
			System.out.println("ci sono "+count+" vini del produttore "+produttori.get(i));
		}
		
	}
	
	public int nellaLista(Vector<String> vettore,String cercato)
	{
		int noinlista=1;
		int siinlista=0;
		int i=0;
	    int count=0;
		for(i=0;i<vettore.size();i++)
		{
			if(vettore.get(i).equals(cercato))
			count++;
		}
		if(count==0) return  noinlista;
		if(count>0) return siinlista;
		else return noinlista;
	}
	
	//Data una certa fascia di Annata (es. dal 1990 al 2015) stampare tutti i vini
	public void inAnno()
	{
		
	}
}
