package entity;

public class Server {
	
	private Packet curPacket = null;
	private double serviceRate;
	private double next_serviceTime=0;  //in ms
	

	private double busyTime=0; //As soon as packet is completed, add the service time of packet to this variable.
	private double serverOnTime; // If isActive in every instance of time, add one to this variable.
	private int ID; //Server ID
	
	
	public double getNext_serviceTime() {
		return next_serviceTime;
	}

	public void setNext_serviceTime(double next_serviceTime) {
		this.next_serviceTime = next_serviceTime;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	private boolean isActive=false;
	
	public double getServiceRate() {
		return serviceRate;
	}

	public void setServiceRate(double serviceRate) {
		this.serviceRate = serviceRate;
	}

	public Packet getCurPacket() {
		return curPacket;
	}

	public void setCurPacket(Packet curPacket) {
		this.curPacket = curPacket;
	}

	public double getBusyTime() {
		return busyTime;
	}

	public void setBusyTime(double busyTime) {
		this.busyTime = busyTime;
	}

	public double getServerOnTime() {
		return serverOnTime;
	}

	public void setServerOnTime(double serverOnTime) {
		this.serverOnTime = serverOnTime;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}
