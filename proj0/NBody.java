public class NBody {
	public static double readRadius(String filePath) {
		In in = new In(filePath);
		int numOfPlanets = in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	public static Body[] readBodies(String filePath) {
		In in = new In(filePath);
		int numOfPlanets = in.readInt();
		double radius = in.readDouble();
		Body[] bodies = new Body[numOfPlanets];
		for (int i = 0; i < numOfPlanets; i++) {
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String imgFilePath = in.readString();
			bodies[i] = new Body(xxPos, yyPos, xxVel, yyVel, mass, imgFilePath);
		}
		return bodies;
	}

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double time = 0.0;
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = NBody.readRadius(filename);
		Body[] bodies = NBody.readBodies(filename);
		String imageToDraw = "./images/starfield.jpg";
		System.out.println(T+" "+dt+" "+filename);

		//draw background
		StdDraw.enableDoubleBuffering();

		/** Sets up the universe so it goes from
		  * -100, -100 up to 100, 100 */
		StdDraw.setScale(-radius, radius);

		/* Clears the drawing window. */
		StdDraw.clear();

		/* Stamps three copies of advice.png in a triangular pattern. */
		StdDraw.picture(0, 0, imageToDraw);
		
		
		// draw all bodies
		for (Body b: bodies) {
			b.draw();
		}

		while (time <= T) {
			/* Clears the drawing window. */
			StdDraw.clear();

			/* Stamps three copies of advice.png in a triangular pattern. */
			StdDraw.picture(0, 0, imageToDraw);

			double[] xForces = new double[bodies.length];
			double[] yForces = new double[bodies.length];
			for (int i = 0; i < bodies.length; i++) {
				xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
				yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
				bodies[i].update(dt, xForces[i], yForces[i]);
				bodies[i].draw();
			}
			/* Shows the drawing to the screen, and waits 2000 milliseconds. */
			StdDraw.show();
			StdDraw.pause(10);
			time+=dt;
		}

		StdOut.printf("%d\n", bodies.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < bodies.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                  bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);

		}
	}

}