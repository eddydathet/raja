package Server.Indoor.Graphic.ViewInTab.ViewOwl;

import java.awt.Color;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Random;
import java.util.Vector;

import javax.swing.JLayeredPane;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.NodeIterator;

public class ViewOwlComponent extends JLayeredPane {

	private HashMap<String, EntiteRDF> entites;
	private HashMap<String, Vector<ProprieteRDF>> proprietes;
	private HashMap<String, Color> uriColors;
	
	public ViewOwlComponent()
	{
		super();
		build();
		//on garde les couleurs pour toutes les requêtes d'une même tab
		uriColors = new HashMap<String, Color>();
	}
	
	private void build()
	{
		setLayout(null);
		setBackground(new Color(255,255,255));
		setVisible(true);
		setOpaque(true);
		Dimension dimension = new Dimension(800, 600);
		setPreferredSize(dimension);
		setSize(dimension);
		setMinimumSize(dimension);
	}
	
	public void dessine(Model model)
	{
		removeAll();
		Query q = QueryFactory.create("SELECT ?a ?b ?c WHERE {?a ?b ?c}");
		QueryExecution qexec = QueryExecutionFactory.create(q,model);
		ResultSet rs = qexec.execSelect();
		QuerySolution o = null;
		entites = new HashMap<String, EntiteRDF>();
		proprietes = new HashMap<String, Vector<ProprieteRDF>>();
		while(rs.hasNext())
		{
			o = rs.nextSolution();
			EntiteRDF entitea = null;
			String uri_entitea = o.get("a").toString();
			String prefix_a = "";
			if(entites.containsKey(uri_entitea))
			{
				entitea = entites.get(uri_entitea);
			}
			else
			{
				Color fond = Color.white;
				if(uri_entitea.contains("#"))
				{
					prefix_a = uri_entitea.split("#")[0];
					if(uriColors.containsKey(prefix_a))
					{
						fond = uriColors.get(prefix_a);
					}
					else
					{
						Random rand = new Random();
						fond = new Color(rand.nextInt(256), 
		                         rand.nextInt(256),
		                         rand.nextInt(256));
						uriColors.put(prefix_a, fond);
					}
				}
				entitea = new EntiteRDF(this, uri_entitea, fond);
				entites.put(uri_entitea, entitea);
				add(entitea);
			}
			EntiteRDF entitec = null;
			String uri_entitec = o.get("c").toString();
			String prefix_c = "";
			if(entites.containsKey(uri_entitec))
			{
				entitec = entites.get(uri_entitec);
			}
			else
			{
				Color fond = Color.white;
				if(uri_entitec.contains("#"))
				{
					prefix_c = uri_entitec.split("#")[0];
					if(uriColors.containsKey(prefix_c))
					{
						fond = uriColors.get(prefix_c);
					}
					else
					{
						Random rand = new Random();
						fond = new Color(rand.nextInt(256), 
		                         rand.nextInt(256),
		                         rand.nextInt(256));
						uriColors.put(prefix_c, fond);
					}
				}
				entitec = new EntiteRDF(this, uri_entitec, fond);
				entites.put(uri_entitec, entitec);
				add(entitec);
			}
			if(entitea != entitec)
			{
				String uri_entiteb = o.get("b").toString();
				ProprieteRDF entiteb = new ProprieteRDF(uri_entiteb, entitea, entitec);
				if(prefix_a.equals(prefix_c))
				{
					entiteb.setColor(uriColors.get(prefix_c));
				}
				if(proprietes.containsKey(uri_entiteb))
				{
					proprietes.get(uri_entiteb).add(entiteb);
				}
				else
				{
					Vector<ProprieteRDF> v = new Vector<ProprieteRDF>();
					v.add(entiteb);
					proprietes.put(uri_entiteb, v);
				}
				entitea.addPropriete(entiteb);
				entitec.addPropriete(entiteb);
				add(entiteb);
			}
		}
		placement();
	}
	
	private void placement()
	{
		int max_x = 0;
		int max_y = 0;
		Vector<EntiteRDF> v = getEntitesByNbPropriete();
		int profondeur = 0;
		int ecart_entre_2_rayon = 80;
		for(int i=0; i<v.size(); i++)
		{
			EntiteRDF entite = v.get(i);
			if(i%10 == 0)
			{
				if(profondeur < 5)
				{
					profondeur++;
				}
			}
			int ro = profondeur*ecart_entre_2_rayon;
			double teta = (i*50) * ((2*Math.PI)/v.size());
			int x = (int) (ro*Math.cos(teta)) + 450;
			entite.setX(x);
			int y = (int) (ro*Math.sin(teta)) + 400;
			entite.setY(y);
			if(x > max_x)
			{
				max_x = x;
			}
			if(y > max_y)
			{
				max_y = y;
			}
			if(i==0)
			{
				profondeur++;
			}
		}
		Dimension dimension = new Dimension(max_x+100, max_y+100);
		setPreferredSize(dimension);
		setSize(dimension);
		setMinimumSize(dimension);
		validate();
		repaint();
	}
	
	private Vector<EntiteRDF> getEntitesByNbPropriete()
	{
		Vector<EntiteRDF> res = new Vector<EntiteRDF>();
		for(EntiteRDF entite : entites.values())
		{
			boolean trouve = false;
			for(int j=0; j<res.size() && !trouve; j++)
			{
				if(entite.getProprietes().size() > res.get(j).getProprietes().size())
				{
					res.add(j, entite);
					trouve = true;
				}
			}
			if(!trouve)
			{
				res.add(entite);
			}
		}
		return res;
	}
	
	public void lignesDessous()
	{
		for(EntiteRDF rdf : getEntites().values())
		{
			setComponentZOrder(rdf, 0);
			rdf.repaint();
		}
	}
	
	public HashMap<String, EntiteRDF> getEntites() 
	{
		return entites;
	}

	public HashMap<String, Vector<ProprieteRDF>> getProprietes()
	{
		return proprietes;
	}
}
