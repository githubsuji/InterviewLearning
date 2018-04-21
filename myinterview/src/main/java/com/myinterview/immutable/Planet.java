package com.myinterview.immutable;

import java.util.Date;

import org.apache.log4j.Logger;

import com.interthread.legacyway.Consumer;

public final class Planet {
	//https://dzone.com/articles/taming-concurrency-with-immutability
	  private static final Logger logger = Logger.getLogger(Planet.class);
	 /**
	  * Final primitive data is always immutable.
	  */
	  private final double fMass;
	  
	  /**
	   * An immutable object field. (String objects never change state.)
	   */
	   private final String fName;

	   /**
	   * A mutable object field. In this case, the state of this mutable field
	   * is to be changed only by this class. (In other cases, it makes perfect
	   * sense to allow the state of a field to be changed outside the native
	   * class; this is the case when a field acts as a "pointer" to an object
	   * created elsewhere.)
	   */
	   private final Date fDateOfDiscovery;
	   
	   public Planet (double aMass, String aName, Date aDateOfDiscovery) {
		     fMass = aMass;
		     fName = aName;
		     //make a private copy of aDateOfDiscovery
		     //this is the only way to keep the fDateOfDiscovery
		     //field private, and shields this class from any changes that 
		     //the caller may make to the original aDateOfDiscovery object
		     fDateOfDiscovery = new Date(aDateOfDiscovery.getTime());
		     logger.info(fDateOfDiscovery);
		  }
	   /**
	    * Returns a mutable object - good style.
	    * 
	    * Returns a defensive copy of the field.
	    * The caller of this method can do anything they want with the
	    * returned Date object, without affecting the internals of this
	    * class in any way. Why? Because they do not have a reference to 
	    * fDate. Rather, they are playing with a second Date that initially has the 
	    * same data as fDate.
	    */
	    public Date getDateOfDiscovery() {
	      return new Date(fDateOfDiscovery.getTime());
	    }
	public double getfMass() {
		return fMass;
	}
	public String getfName() {
		return fName;
	}
	    
	    
}
