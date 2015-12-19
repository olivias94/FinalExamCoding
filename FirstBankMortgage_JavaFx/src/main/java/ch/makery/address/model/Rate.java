
package ch.makery.address.model;

import domain.RateDomainModel;

import org.apache.poi.ss.formula.functions.FinanceLib;

import base.RateDAL;
import ch.makery.address.view.*;

public class Rate extends RateDomainModel {
	
	public static double getPayment(double creditScore, double term, double houseCost)
	{
		
		double interestRate = RateDAL.getRate(creditScore);
		//now to code for amortization
		double numberOfPeriods = term*12; //15 0r 30
		double presentValue = houseCost; //House Value
		double futureValue = 0;
		boolean t = false;
		
		double PMT = FinanceLib.pmt(interestRate, numberOfPeriods, presentValue, futureValue, t); 
		System.out.println("---------------" + PMT + "-----------------");
		//System.out.println("The total tuition that you have to pay is: $%.2d", PMT);
		
		//FinalExam
		//	Normally this kind of method would be in a BLL, but alas...
		
		//	Figure out payment based on:
		//	Interest rate
		//	PV
		//	FV (make FV = 0, unless you want a balloon payment
		//	Compounding = True
		//	Number of Payments (passed in)
		
		
		
		return PMT;
	}
}
