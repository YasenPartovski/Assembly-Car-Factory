package carFactory;

public class AssemblyLine {
	
	static class Frame extends Thread{
		public Frame(String name) {
			setName(name);
		}
		
		@Override
		public void run() {
			try {
				Thread.sleep(5000); 
				System.out.println(getName()+" has been made.");
			} 
			catch (InterruptedException e) {
				System.out.println("The making of the frame has been interrupted!");
			}
		}	
	}
	
	static class Tire extends Thread{
		public Tire(String name) {
			setName(name);
		}
		
		@Override
		public void run() {
			try {
				Thread.sleep(2000); // it takes 2 seconds for the tire to be made
				System.out.println(getName()+" has been made.");
			} 
			catch (InterruptedException e) {
				System.out.println("The making of one of the tires has been interrupted!");
			}
		}	
	}	
	
	static class Seat extends Thread{
		public Seat(String name) {
			setName(name);
		}
		
		@Override
		public void run() {
			try {
				Thread.sleep(3000); 
				System.out.println(getName()+" has been made.");
			} 
			catch (InterruptedException e) {
				System.out.println("The making of one of the seats has been interrupted!");
			}
		}	
	}
	
	static class Engine extends Thread{
		public Engine(String name) {
			setName(name);
		}
		
		@Override
		public void run() {
			try {
				Thread.sleep(7000); 
				System.out.println(getName()+" has been made.");
			} 
			catch (InterruptedException e) {
				System.out.println("The making of the engine has been interrupted!");
			}
		}	
	}
	

	public static void main(String[] args) {
		
		assemblyLine();
		
	}
	
	public static void assemblyLine() {
		// Creating the objects and preparing them for building:
		Tire tire1 = new Tire("Tire 1");
		Tire tire2 = new Tire("Tire 2");
		Tire tire3 = new Tire("Tire 3");
		Tire tire4 = new Tire("Tire 4");
		
		Seat seat1 = new Seat("Seat 1");
		Seat seat2 = new Seat("Seat 2");
		Seat seat3 = new Seat("Seat 3");
		Seat seat4 = new Seat("Seat 4");
		Seat seat5 = new Seat("Seat 5");
		
		Engine engine = new Engine("Engine");
		
		Frame frame = new Frame("Frame");
		

		//......... Version 1:
		System.out.println("<<< The building process has begun! >>>");
		long start = System.currentTimeMillis();
		
		System.out.println("\n**The first three tires are being constructed...**");
		tire1.start();
		tire2.start();
		tire3.start();
		
		try {
			tire1.join();
			tire2.join();
			tire3.join();
		} catch (InterruptedException e) {
			System.out.println("Parts are being built...");
		}
		
		System.out.println("\n**The fourth tire and the first two seats are being constructed...**");
		tire4.start();
		seat1.start();
		seat2.start();
		
		try {
			tire4.join();
			seat1.join();
			seat2.join();
		} catch (InterruptedException e) {
			System.out.println("Parts are being built...");
		}
		
		System.out.println("\n**The last three seats are being constructed...**");
		seat3.start();
		seat4.start();
		seat5.start();
		
		try {
			seat3.join();
			seat4.join();
			seat5.join();
		} catch (InterruptedException e) {
			System.out.println("Parts are being built...");
		}
		
		System.out.println("\n**The engine and the frame are being constructed...**");
		engine.start();
		frame.start();
		
		try {
			engine.join();
			frame.join();
			
		} catch (InterruptedException e) {
			System.out.println("Parts are being built...");
		}

		long elapsedTime = System.currentTimeMillis() - start;
		
		System.out.println("\n<<< The Car is complete! It took exactly "+((double)elapsedTime/1000)+" seconds. >>>");
			
	}

}