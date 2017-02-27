package entity;

import java.util.ArrayList;
import java.util.List;

public class Queue {
	
	private List<Packet> packets = new ArrayList<Packet>();
	private int maxBufferSize;
	
	private List<Integer> queueSizeEveryInstance = new ArrayList<Integer>();

	public List<Packet> getPackets() {
		return packets;
	}

	public void setPackets(List<Packet> packets) {
		this.packets = packets;
	}

	public int getMaxBufferSize() {
		return maxBufferSize;
	}

	public void setMaxBufferSize(int maxBufferSize) {
		this.maxBufferSize = maxBufferSize;
	}

	public List<Integer> getQueueSizeEveryInstance() {
		return queueSizeEveryInstance;
	}

	public void setQueueSizeEveryInstance(List<Integer> queueSizeEveryInstance) {
		this.queueSizeEveryInstance = queueSizeEveryInstance;
	}
	

}
