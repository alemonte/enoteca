import java.util.*;
public class Enoteca 
{
	private ArrayList<Vino> vini= new ArrayList<Vino>();
	

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
			System.out.println("i vini "+vini.get(i).getNome()+"sono "+ vini.get(i).getQnt());
		}
	}
	
	//Stampare la quantità di Bottiglie per ogni Produttore
	public void qntXproduttore()
	{
		int i =0;
		int k=0;
		int count=0;
		Vector<String> produttori= new Vector<String>();
		
		for(i=0;i<vini.size();i++)//questo for crea un vector di string con all' interno la lista dei produttori 
		{
			String produttore= vini.get(i).getProduttore();
			if( nellaLista(produttori,produttore)==1)
			produttori.add(produttore);
		}
		
		for(i=0;i<produttori.size();i++)
		{
			for(k=0;k<vini.size();k++)
			{
				String produttore=vini.get(k).getProduttore();
				if(produttore.equals(produttori.get(i)))
				{
					count+=vini.get(k).getQnt();
				}
			}
			System.out.println("ci sono "+count+" vini del produttore "+produttori.get(i));
		}
		
	}
	
	public int nellaLista(Vector<String> vettore,String cercato)//questo metodo controlla se la stringa passata è presente nella lista di stringhe passata (ritorna: 1 se non è presente,0 altrimenti)
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
		int inizio=InputDati.leggiInteroPositivo("inserisci la data di partenza");
		int fine=InputDati.leggiInteroPositivo("inserisci la data di fine");
		for(int i=0;i<vini.size();i++)
		{
			if(vini.get(i).getAnnata()>=inizio && vini.get(i).getAnnata()<fine) 
			{
				System.out.print("il vino"+vini.get(i).getNome()+" è compreso nell'annata specificata");
			}
		}
	}
//	Stampare il possibile guadagno in Multi-valuta, data come variabile esterna la valuta desiderata
	public void guadagno()
	{
		final double tassoED =1.1164 ;
		final double tassoDE = 0.8957;
		double totale=0;
		String valutaRis=InputDati.leggiStringaNonVuota("inserisci la valuta desiderata");
		String euro="euro";
		String dollari="dollari";
		for(int i=0;i<vini.size();i++)//con questo for calcolo in guadagno totale in dollari
		{
			Vino vino= vini.get(i);
			String valutaVino=vino.getPrezzo().getValuta();
			if(valutaVino.equals(euro))
			{
				Double inDollari=(vino.getPrezzo().getCosto())*tassoED;
				totale +=inDollari;
			}
		
			if(valutaVino.equals(dollari))
			{
				totale+=vino.getPrezzo().getCosto();
			}
		}
		if(valutaRis.equals(dollari))//stampa il possibile guadagno in dollari
			System.out.println("il possibile guadagno in dollari è: "+totale);
		if(valutaRis.equals(euro))//stampa il possibile guadagno in euro
		{
			totale*=tassoDE;
			System.out.println("il possibile guadagno in euro è: "+totale);
		}
				
	}
	
	
	
	
	
	
	
	
	
	
}
