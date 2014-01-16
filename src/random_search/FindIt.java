package random_search;

/*
 * Student Name: Dov Greenwood
 * Date: 7/12/13
 * 
 * This Thread sub-class is used to find a number (correctNumber) within a given range
 * (start -> end).  Every 10 cycles of incrementing a counter towards the number, it yields the
 * execution to another Thread.  Once it completes the task, it prints the result and exits
 * the program.
 * */

public class FindIt extends Thread {
	
	private int start;
	private int end;
	private int correctNumber;
	private static boolean runCondition = true;
	
	public boolean isRunCondition() {
		return runCondition;
	}

	public void setRunCondition(boolean runCondition) {
		this.runCondition = runCondition;
	}

	public FindIt(int start, int end, int correctNumber) {
		setStart(start);
		setEnd(end);
		setCorrectNumber(correctNumber);
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getCorrectNumber() {
		return correctNumber;
	}

	public void setCorrectNumber(int correctNumber) {
		this.correctNumber = correctNumber;
	}
	
	private void search() {
		for(int i = start; i <= end; i ++) {
			if(runCondition) {
				if(i == correctNumber) {
					System.out.println(this.getName() + " found out that the number was " + i);
					runCondition = false;
				}
				if(i % 10 == 0) {
					//System.out.println(this.getName() + " is yielding");
					Thread.yield();
				}
			}
			else {
				break;
			}
			
		}
	}
	
	public void run() {
		search();
	}
	
}
