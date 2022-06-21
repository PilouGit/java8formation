package com.neuresys.formation.java8.defaultinterface;

public interface Alarm {
	  default String turnAlarmOn() {
	        return "Turning the alarm on.";
	    }
	    
	    default String turnAlarmOff() {
	        return "Turning the alarm off.";
	    }
	    default String giveBrand()
	    {
	    	return "defaultBrand";
	    }
}
