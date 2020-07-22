package CreationalPatterns;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class ExportingTask implements Runnable {
	static PrintStream myout = new PrintStream(new FileOutputStream(FileDescriptor.out));
	private ObjectPool<ExportingProcess> pool;
	private int threadNo;

	public ExportingTask(ObjectPool<ExportingProcess> pool, int threadNum) {
		this.pool = pool;
		this.threadNum = threadNum;
	}

	public void run() {
		// get an object from the pool
		ExportingProcess exportingProcess = pool.borrowObject();
		myout.print("Thread " + threadNum + ": Object with process no. " + exportingProcess.getProcessNo()
				+ " is borrowed\n");

		pool.returnObject(exportingProcess);

		myout.print("Thread " + threadNum + ": Object with process no. " + exportingProcess.getProcessNo()
				+ " is returned\n");
	}

}