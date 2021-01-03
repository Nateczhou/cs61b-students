public class Body {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public static final double G = 6.67e-11;

	public Body(double xP, double yP, double xV, double yV, 
				double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Body(Body b) {
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;
	}

	public double calcDistance(Body b) {
		double dx = b.xxPos - xxPos;
		double dy = b.yyPos - yyPos;
		double r = Math.sqrt(dx*dx + dy*dy);
		return r;
	}

	public double calcForceExertedBy(Body b) {
		double r = calcDistance(b);
		double f = G*b.mass*mass/(r*r);
		return f;
	}

	public double calcForceExertedByX(Body b) {
		double dx = b.xxPos - xxPos;
		double r = calcDistance(b);
		double f = calcForceExertedBy(b);
		return f*dx/r;
	}

	public double calcForceExertedByY(Body b) {
		double dy = b.yyPos - yyPos;
		double r = calcDistance(b);
		double f = calcForceExertedBy(b);
		return f*dy/r;
	}

	public double calcNetForceExertedByX(Body[] allBodys) {
		double fx = 0;
		for (int i = 0; i < allBodys.length; i++) {
			if (!allBodys[i].equals(this)) {
				fx+=calcForceExertedByX(allBodys[i]);
			}
		}
		return fx;
	}

	public double calcNetForceExertedByY(Body[] allBodys) {
		double fy = 0;
		for (int i = 0; i < allBodys.length; i++) {
			if (!allBodys[i].equals(this)) {
				fy+=calcForceExertedByY(allBodys[i]);
			}
		}
		return fy;
	}

	public void update(double dt, double fX, double fY) {
		double aX = fX/mass;
		double aY = fY/mass;
		xxVel = xxVel + dt*aX;
		yyVel = yyVel + dt*aY;
		xxPos = xxPos + xxVel*dt;
		yyPos = yyPos + yyVel*dt;
	}

	public void draw() {
		StdDraw.picture(xxPos, yyPos, "./images/"+imgFileName);
	}






}