package benchmark;

public class ElapsedTime {
	private long beginTime;
	private long endTime;

	private float result;

	public void begin() {
		beginTime = System.nanoTime();
	}

	public void end() {
		endTime = System.nanoTime();
		long temp = (long)((endTime - beginTime) / 100000.0f);
		result = temp / 10.f;
	}

	public float get() {
		return result;
	}
}
