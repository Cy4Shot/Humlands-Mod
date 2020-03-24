package com.turtysproductions.humlands.core.world.generator;

import java.util.Random;

public class VoronoiGenerator {

	private static final double SQRT_2 = 1.4142135623730950488;

	private long seed;
	private int distanceMethod;

	public VoronoiGenerator(long seed, int distanceMethod) {
		this.seed = seed;
		this.distanceMethod = distanceMethod;
	}

	private double getDistance(double xDist, double zDist) {
		switch (distanceMethod) {
		case 0:
			return Math.sqrt(xDist * xDist + zDist * zDist) / SQRT_2;
		case 1:
			return xDist + zDist;
		case 2:
			return Math.pow(Math.E, Math.sqrt(xDist * xDist + zDist * zDist) / SQRT_2) / Math.E;
		default:
			return 1.0;
		}
	}

	public int getDistanceMethod() {
		return distanceMethod;
	}

	public long getSeed() {
		return seed;
	}

	public double noise(double x, double z, double frequency) {
		x *= frequency;
		z *= frequency;

		int xInt = (x > .0 ? (int) x : (int) x - 1);
		int zInt = (z > .0 ? (int) z : (int) z - 1);

		double minDist = 32000000.0;

		double xCandidate = 0;
		double zCandidate = 0;

		for (int zCur = zInt - 2; zCur <= zInt + 2; zCur++) {
			for (int xCur = xInt - 2; xCur <= xInt + 2; xCur++) {

				double xPos = xCur + valueNoise2D(xCur, zCur, seed);
				double zPos = zCur + valueNoise2D(xCur, zCur, new Random(seed).nextLong());
				double xDist = xPos - x;
				double zDist = zPos - z;
				double dist = xDist * xDist + zDist * zDist;

				if (dist < minDist) {
					minDist = dist;
					xCandidate = xPos;
					zCandidate = zPos;
				}
			}
		}

		double xDist = xCandidate - x;
		double zDist = zCandidate - z;

		return getDistance(xDist, zDist);
	}

	public void setDistanceMethod(short distanceMethod) {
		this.distanceMethod = distanceMethod;
	}

	public void setSeed(long seed) {
		this.seed = seed;
	}

	public static double valueNoise2D(int x, int z, long seed) {
		long n = (1619 * x + 6971 * z + 1013 * seed) & 0x7fffffff;
		n = (n >> 13) ^ n;
		return 1.0 - ((double) ((n * (n * n * 60493 + 19990303) + 1376312589) & 0x7fffffff) / 1073741824.0);
	}

}