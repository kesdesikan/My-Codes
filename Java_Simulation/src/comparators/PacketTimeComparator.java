package comparators;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

import entity.Packet;

public class PacketTimeComparator implements Comparator<Packet> {

	@Override
	public int compare(Packet p0, Packet p1) {
		
		if(p0.getGenTime() <= p1.getGenTime()){
			return -1;
		}
		
		return 1;
	}

}
