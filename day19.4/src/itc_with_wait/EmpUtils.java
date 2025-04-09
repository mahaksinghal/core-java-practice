package itc_with_wait;

public class EmpUtils {
	private Emp e;
	private boolean dataReady;

	public synchronized void writeData(Emp ref) throws Exception {
		System.out.println("write entered --- " + Thread.currentThread().getName());
		while(dataReady)
			this.wait();
		// produce data
		e = ref;
		System.out.println("Write Data " + e);
		System.out.println("write exited --- " + Thread.currentThread().getName());
		dataReady=true;
		this.notify();	// producer sending notification signal -> consumer
	}

	public synchronized Emp readData() throws Exception {
		System.out.println("r entered --- " + Thread.currentThread().getName());
		while(!dataReady)
			this.wait();
		// consume data
		System.out.println("Read  Data " + e);
		System.out.println("r exited --- " + Thread.currentThread().getName());
		dataReady=false;
		this.notify();	// consumer waking up the producer
		return e;
	}

}
