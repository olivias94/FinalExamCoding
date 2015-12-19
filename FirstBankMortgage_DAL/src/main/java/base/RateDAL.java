package base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.RateDomainModel;
import util.HibernateUtil;

public class RateDAL {

	public static double getRate(int GivenCreditScore) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		RateDomainModel rateGet = null;		
		double minrate = 0;
		try {
			tx = session.beginTransaction();	
				
			Query query = session.createQuery("from RateDomainModel where minCreditScore <= " + GivenCreditScore);
			
			List<?> list = query.list(); //each entry is a RateDomainModel
			
			minrate = ((RateDomainModel) list.get(0)).getInterestRate();
		
			for (int z = 0; z <  list.size(); z++){ //gets the minimum rate you can have
				
				if (minrate > ((RateDomainModel) list.get(z)).getInterestRate())
					minrate = ((RateDomainModel) list.get(z)).getInterestRate();
				
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		System.out.println("------------------" + minrate + "--------------");	
		return minrate;
	}

}