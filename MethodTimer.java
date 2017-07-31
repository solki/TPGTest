/** 
* <p>Title: Q3 </p> 
* <p>Description: </p> 
* <p>Copyright: Copyright (c) 2017</p> 
* <p>Company: </p> 
* @author Xi Zhang 
* @version 1.0
*/ 
public class MethodTimer {

	private long startTime;
	private long stopTime;

	public MethodTimer() {
	}

	public void start() {
		this.setStartTime(System.currentTimeMillis());
	}

	public void stop() {
		this.setStopTime(System.currentTimeMillis());
	}

	public Long getProcessTime() {
		/* if either startTime or stopTime is not set, the process fails */
		if (this.getStartTime() == 0L || this.getStopTime() == 0L) {
			return -100L;
		}
		return this.getStopTime() - this.getStartTime(); // return in
															// millisecond
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getStopTime() {
		return stopTime;
	}

	public void setStopTime(long stopTime) {
		this.stopTime = stopTime;
	}

	// Test method
	public static void main(String[] args) {

		MethodTimer timer = new MethodTimer();
		timer.start();
		// method() start;
		for (long i = 0; i< 400000000L; ++i) {
			;
		}
		// method() stop;
		timer.stop();
		if (timer.getProcessTime() < 0L) {
			System.out.println("Timer is not working properly");
		} else {
			System.out.println("The time consumed for this method is " + timer.getProcessTime() + " milliseconds.");
		}
	}

}
