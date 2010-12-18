package Server.Adapter;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.jdom.Element;
import org.mindswap.pellet.jena.PelletReasonerFactory;

import Exception.DataBaseNotAccessibleException;
import Exception.MalformedQueryException;
import Query.IQuery;
import Query.SelectQuery;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.InfModel;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.reasoner.Reasoner;
import com.hp.hpl.jena.sparql.util.IndentedWriter;
import com.hp.hpl.jena.util.FileManager;
import com.hp.hpl.jena.vocabulary.OWL;
import com.hp.hpl.jena.vocabulary.RDF;
import com.hp.hpl.jena.vocabulary.RDFS;

import de.fuberlin.wiwiss.d2rq.ModelD2RQ;

/**
 * Adaptor of several Adaptor. Needed to merge RDF informations from under Adaptor.
 */
public class CompositeAdapter extends Adapter 
{
	private String owlFile;
	private Model model;
	/**
	 * Composite pattern.
	 * These are the sub-adapters managed by this adapter.
	 */
	protected Vector<IAdapter> subAdapters;	
	
	public static final String NL = System.getProperty("line.separator");
	public CompositeAdapter(String owlFile) 
	{
		this.owlFile = owlFile;
		subAdapters = new Vector<IAdapter>();
		model = ModelFactory.createDefaultModel();
        Reasoner reasoner = PelletReasonerFactory.theInstance().create();	

        FileManager.get().readModel(model, "/home/audrey/Master/Master2/Semestre1/GestionDonnes/workspace/Raja/src/maladiesVirus.owl");
	}



	/**
	 * Return true if query match to database
	 */
	public boolean isQueryMatching(IQuery query) 
	{
		System.out.println("taille modele "+model.size()+"");
		if(query.getClass().getSimpleName().equals("SelectQuery")){
			SelectQuery sq = (SelectQuery)query;
			try {
				sq.parseQuery(query.getQuery());
				String prolog_r = "PREFIX rdf: <"+RDF.getURI()+">" ;
				String prolog_rdfs = "PREFIX rdfs: <"+RDFS.getURI()+">" ;
				String prolog_owl = "PREFIX owl: <"+OWL.getURI()+">" ;
				String prolog_m = "PREFIX maladie: <http://www.lirmm.fr/maladie#>" ;
				String prolog_e = "PREFIX virus: <http://www.lirmm.fr/virus#>" ;
				
				String prefix = prolog_m + NL + prolog_r + NL +  prolog_rdfs + NL +prolog_owl + NL + prolog_e + NL;
				
//				for(int i=0; i<getPrefix().size();i++){
//					prefix+=getPrefix().get(i);
//				}
				
				String str = prefix+" SELECT ?a ?b WHERE {";
				System.out.println(sq.getWhere().size()+"");
				if(sq.getWhere().size()>1){
					for(int i=0; i<sq.getWhere().size();i++){
						if(i<sq.getWhere().size()-1){
							str+= "{?a "+sq.getWhere().get(i)+" ?b} UNION ";
						}
						else
						{
							str+= "{?a "+sq.getWhere().get(i)+" ?b }}";
						}
					}
				}
				else
				{
					str+= "?a "+sq.getWhere().get(0)+" ?b}";
				}

				Query q = QueryFactory.create(str) ;
				QueryExecution qexec = QueryExecutionFactory.create(q,model) ;
				ResultSet result = qexec.execSelect() ;
				System.out.println("taille"+result.getResultVars().size()+"");
				//if(result)
				
			} catch (MalformedQueryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return true;
	}

	public Vector<IAdapter> getSubAdapters() {
		return subAdapters;
	}

	public void setSubAdapters(Vector<IAdapter> subAdapters) {
		this.subAdapters = subAdapters;
	}

	/**
	 * Give the query to all sub adaptor which execute it and check if no errors occurs.
	 */
	public ResultSet execute(IQuery query) throws DataBaseNotAccessibleException 
	{
		return null;

	}

	/**
	 * Return the global RDF schema of sub adapters.
	 */
	public ResultSet getLocalSchema() 
	{
		return null;
	}
	
}
