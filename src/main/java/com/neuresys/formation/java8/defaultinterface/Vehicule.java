package com.neuresys.formation.java8.defaultinterface;

public interface Vehicule {
	 String getBrand();
	    
	    String speedUp();
	    
	    String slowDown();
	    
	    default String turnAlarmOn() {
	        return "Turning the vehicle alarm on.";
	    }
	    
	    default String turnAlarmOff() {
	        return "Turning the vehicle alarm off.";
	    }
	    static int getHorsePower(int rpm, int torque) {
	        return (rpm * torque) / 5252;
	    }
	}
