package com.warp.model;

import android.graphics.Canvas;

public class CelestialObject implements Renderable {
	
	protected double x; // likewise in meters
	protected double y; // in meters
	
	protected double velX; // in m/s^2
	protected double velY; // in m/s^2
	
	protected double mass; // in kilograms
	// if no mass is provided, mass = averageMass + (new Random()).nextGaussian()) * averageMassVariance
	protected double averageMass, averageMassVariance; // used to calculate a reasonable mass when none is provided
	
	public final double GRA_CONST = 6.67384 * Math.pow(10.0, -11.0); // in SI units, see http://en.wikipedia.org/wiki/Gravitational_constant
	
	public CelestialObject(double x, double y, double velX, double velY, double mass) {
		this.x = x;
		this.y = y;
		this.velX = velX;
		this.velY = velY;
		this.mass = mass;
	}
	
	public void update(long delta) {
		this.x += this.velX;
		this.y += this.velY;
	}

	public void render(Canvas canvas) {
		
	}
	
	public double getDistance(CelestialObject obj) {
		double objX = obj.getX();
		double objY = obj.getY();
		return Math.sqrt(Math.pow(objX - this.x, 2.0) + Math.pow(objY - this.y, 2.0));
	}
	
	public void accelerate(double accX, double accY) {
		velX += accX;
		velY += accY;
	}
	
	public void applyGravitationalAcceleration(CelestialObject obj) {
		double objX = obj.getX(), objY = obj.getY(), distance = this.getDistance(obj);
		double force = GRA_CONST * this.mass * obj.getMass() / distance;
		double axisX = Math.abs(this.x - objX);
		double axisY = Math.abs(this.y - objY);
		double forceX = (force * axisX) / distance;
		double forceY = (force * axisY) / distance;
		this.accelerate(forceX / this.mass, forceY / this.mass);
	}
	
	public double getX() { return this.x; }
	
	public double getY() { return this.y; }
	
	public double getMass() { return this.mass; }

}
