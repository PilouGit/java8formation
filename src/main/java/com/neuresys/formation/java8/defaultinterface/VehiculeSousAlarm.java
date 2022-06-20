package com.neuresys.formation.java8.defaultinterface;

public class VehiculeSousAlarm implements Vehicule,Alarm {

	@Override
	public String turnAlarmOff() {
		// TODO Auto-generated method stub
		return Alarm.super.turnAlarmOff();
	}

	@Override
	public String turnAlarmOn() {
		// TODO Auto-generated method stub
		return Alarm.super.turnAlarmOn();
	}

	@Override
	public String getBrand() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String speedUp() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String slowDown() {
		// TODO Auto-generated method stub
		return "";
	}

}
