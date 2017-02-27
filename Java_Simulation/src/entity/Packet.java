package entity;

public class Packet {
	
	private int ID;
	private int srcGateway_ID;
	private int destGateway_ID;
	public int getSrcGateway_ID() {
		return srcGateway_ID;
	}
	public void setSrcGateway_ID(int srcGateway_ID) {
		this.srcGateway_ID = srcGateway_ID;
	}
	public int getDestGateway_ID() {
		return destGateway_ID;
	}
	public void setDestGateway_ID(int destGateway_ID) {
		this.destGateway_ID = destGateway_ID;
	}
	private double genTime; //Time it came into the system (Queue)
	private double startTime; //Time it got the server
	private double completionTime; //Completed the service
	
	private double latency; //Latency
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public double getGenTime() {
		return genTime;
	}
	public void setGenTime(double genTime) {
		this.genTime = genTime;
	}
	public double getStartTime() {
		return startTime;
	}
	public void setStartTime(double startTime) {
		this.startTime = startTime;
	}
	public double getCompletionTime() {
		return completionTime;
	}
	public void setCompletionTime(double completionTime) {
		this.completionTime = completionTime;
	}
	public double getLatency() {
		return latency;
	}
	public void setLatency(double latency) {
		this.latency = latency;
	}
	@Override
	public String toString() {
		return "Packet [ID=" + ID + ", srcGateway=" + srcGateway_ID
				+ ", destGateway=" + destGateway_ID + ", genTime=" + genTime
				+ ", startTime=" + startTime + ", completionTime="
				+ completionTime + ", latency=" + latency + "]";
	}
	
	
	
}
