package jsoft.ads.individual;

import java.sql.ResultSet;

import Common.ShareControl;
import jsoft.ads.object.IndividualObject;

public interface Individual extends ShareControl{
	public boolean addIndividual(IndividualObject item);
	public boolean editIndividual(IndividualObject item);
	public boolean delIndividual(IndividualObject item);
	
	public ResultSet getAncestor(int id);
	public ResultSet getIndividual(int id);
	public ResultSet getIndividuals(int id);
	public ResultSet getIndividuals(IndividualObject similar, int at, byte total);
}
