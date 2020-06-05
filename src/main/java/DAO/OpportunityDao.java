package DAO;

import java.util.List;

import Model.Opportunity;
import Model.User;
import net.bytebuddy.implementation.attribute.AnnotationAppender.Target.OnType;

public interface OpportunityDao {
	public List<Opportunity> getAllOpportunity();
	public boolean deleteOpportunity(int id);
	public boolean updateOpportunity(Opportunity op);
	public boolean insertOpportunity(Opportunity op);
	public Opportunity getOpportunity(int id);
}
