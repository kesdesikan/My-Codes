package entity;

import java.util.ArrayList;
import java.util.List;

public class Source {
	
	private int packetsPerUnitTime;
	private int droppedPacketCount=0;;
	
	private List<Packet> packets = new ArrayList<Packet>();
	
	private double nextPacketArrivalTime=0;
	

	public double getNextPacketArrivalTime() {
		return nextPacketArrivalTime;
	}

	public void setNextPacketArrivalTime(double nextArrival) {
		this.nextPacketArrivalTime = nextArrival;
	}

	public int getPacketsPerUnitTime() {
		return packetsPerUnitTime;
	}

	public void setPacketsPerUnitTime(int packetsPerUnitTime) {
		this.packetsPerUnitTime = packetsPerUnitTime;
	}

	public int getDroppedPacketCount() {
		return droppedPacketCount;
	}

	public void setDroppedPacketCount(int droppedPacketCount) {
		this.droppedPacketCount = droppedPacketCount;
	}

	public List<Packet> getPackets() {
		return packets;
	}

	public void setPackets(List<Packet> packets) {
		this.packets = packets;
	}
	
	
	
	
	

}
