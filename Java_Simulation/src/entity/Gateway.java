package entity;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import matlabcontrol.*;

import commons.PARAMS;
import comparators.PacketTimeComparator;
import eduni.simjava.distributions.Sim_negexp_obj;

public class Gateway {

	private int ID;

	private Queue queue = new Queue();
	private List<Server> servers = new ArrayList<Server>();
	private Source src = new Source();

	private List<Packet> packetsCompleted = new ArrayList<Packet>(); //Completed packets

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Queue getQueue() {
		return queue;
	}

	public void setQueue() {
		Queue queue=new Queue();
		queue.setMaxBufferSize((int) PARAMS.total_buffer_capacity[ID]);		
		this.queue = queue;
	}

	public List<Server> getServers() {
		return servers;
	}

	public void setServers() {
		List<Server> servers = new ArrayList<Server>();
		for(int i=0;i<PARAMS.number_servers[ID];i++)
		{
			Server s=new Server();
			s.setID(i);
			s.setServiceRate(PARAMS.service_rate[ID]);
			servers.add(s);
		}
		this.servers = servers;
	}

	public Source getSrc() {
		return src;
	}

	public void setSrc() {
		Source src=new Source();
		src.setPacketsPerUnitTime((int) PARAMS.sim_arrival_rate[ID]);
		this.src = src;
	}

	public List<Packet> getPacketsCompleted() {
		return packetsCompleted;
	}

	public void setPacketsCompleted(List<Packet> packetsCompleted) {
		this.packetsCompleted = packetsCompleted;
	}


	//------------------------------------------------------------Generation of Packets-------------------------------------------------------------------------


	public void generatePackets() throws FileNotFoundException, MatlabInvocationException, MatlabConnectionException{


//----------------------------------------------------------Initial Buffer Calculation----------------------------------------------------------------------------

		int present_queue_size=0;
		present_queue_size=this.queue.getPackets().size();
		for(int i=0;i<PARAMS.number_servers[ID];i++)
		{
			if(this.servers.get(i).getNext_serviceTime()>=PARAMS.TIME)
				present_queue_size++;

		}
		
		PARAMS.sim_temp_buffer_occupied[ID]=present_queue_size;
		//System.out.println("Sim Buffer Available of Gateway"+ID+" ="+PARAMS.sim_buffer_available[ID]);
		System.out.println(" Sim Buffer Occupied of Gateway"+ID+" ="+PARAMS.sim_temp_buffer_occupied[ID]+" \t"+present_queue_size);
		PARAMS.sim_buffer_available[ID]=Math.max(0,PARAMS.total_buffer_capacity[ID]-PARAMS.sim_temp_buffer_occupied[ID]);
		if((PARAMS.TIME%50000)==0)
			PARAMS.number_packets_slot[ID]=0;


//----------------------------------------------------------Generation only if Interarrival time elapses----------------------------------------------------------------------------


		if(PARAMS.TIME>= this.src.getNextPacketArrivalTime()) {
			Sim_negexp_obj arrival = new Sim_negexp_obj("Delay", 50000/PARAMS.sim_arrival_rate[ID]);
			double arrival_time=arrival.sample();
			//System.out.println("Queue Id="+ID);
			//System.out.println("NEXT Inter Arrival TIME="+this.src.getNextPacketArrivalTime());	
			//System.out.println("Inter Arrival Time for gateway "+ID+" ="+arrival_time);
			double nextArrival=PARAMS.TIME+arrival_time;
			this.src.setNextPacketArrivalTime(nextArrival);

//----------------------------------------------------------Generation only if arrival rate not exceeded----------------------------------------------------------------------------
				
			Packet p = new Packet();
				PARAMS.number_packets_slot[ID]++;
				p.setGenTime(PARAMS.TIME);
				p.setID(PARAMS.PACKET_ID++);
				p.setSrcGateway_ID(ID);		
				p.setLatency(PARAMS.inter_latency[ID]*50000);
				PARAMS.sim_avg_arrival_rate[ID]++;
				if(PARAMS.sim_buffer_available[ID]>0)
				{
					this.queue.getPackets().add(p);
					PARAMS.sim_effective_arrival_rate[ID]++;
					//System.out.println("Time="+PARAMS.TIME+" Buffer Available of Gateway"+ID+" Greater than zero");
				}
				else
				{
	
//----------------------------------------------------------------Offloading -----------------------------------------------------------------------------------------------

					this.src.setDroppedPacketCount(this.src.getDroppedPacketCount()+1);
					PARAMS.sim_loss_rate[ID]++;
					//System.out.println("Time="+PARAMS.TIME+" Prob of Gateway "+ID+" ="+PARAMS.sim_prob[ID]);
					
				
					if(ID==0)
					{
                     
						Scanner sc=new Scanner(System.in);
						PARAMS.sim_total_buffer_available=0;
						for(int k=1;k<PARAMS.number_gws;k++)
						{
							//PARAMS.sim_total_buffer_available=PARAMS.sim_total_buffer_available+PARAMS.sim_buffer_available[k];
							PARAMS.sim_total_buffer_available=PARAMS.sim_total_buffer_available+PARAMS.total_buffer_capacity[k];
							
						//	System.out.println("Sim Buffer Available of Gateway"+k+" ="+PARAMS.sim_buffer_available[k]);
						//	System.out.println("Total Sim Buffer Available of Gateway"+k+" ="+PARAMS.sim_total_buffer_available);
							
						}
						
						PARAMS.sim_total_trans_prob=0;
						for(int i=1;i<PARAMS.number_gws;i++)
						{

							//if(PARAMS.sim_buffer_available[i]!=0)
								PARAMS.sim_buffer_factor[i]=1;
							//else
							//	PARAMS.sim_buffer_factor[i]=0;


							//PARAMS.sim_trans_prob[i]=(PARAMS.latency_weight_factor*(1-(PARAMS.inter_latency[i]/PARAMS.total_latency)))+(PARAMS.buffer_weight_factor*(PARAMS.sim_buffer_available[i]/ PARAMS.sim_total_buffer_available));
							PARAMS.sim_trans_prob[i]=(PARAMS.latency_weight_factor*(1-(PARAMS.inter_latency[i]/PARAMS.total_inter_latency)))+(PARAMS.buffer_weight_factor*(PARAMS.total_buffer_capacity[i]/ PARAMS.sim_total_buffer_available));

						//	System.out.println("Trans Prob of Gateway "+i+" ="+PARAMS.sim_trans_prob[i]);
							PARAMS.sim_trans_prob[i]=PARAMS.sim_trans_prob[i]*PARAMS.sim_buffer_factor[i];
						//	System.out.println("Trans Prob of Gateway "+i+" ="+PARAMS.sim_trans_prob[i]);
							PARAMS.sim_total_trans_prob=PARAMS.sim_total_trans_prob+PARAMS.sim_trans_prob[i];
						//	System.out.println("Total Trans Prob of Gateway "+i+" ="+PARAMS.sim_total_trans_prob);

						}
						double[] cum_prob=new double[100];
						cum_prob[0]=0;
						for(int i=1;i<PARAMS.number_gws;i++)
						{	
							PARAMS.sim_prob[i]=PARAMS.sim_trans_prob[i]/PARAMS.sim_total_trans_prob;	
						//	System.out.println("Time="+PARAMS.TIME+" Prob of Gateway "+i+" ="+PARAMS.sim_prob[i]);
							cum_prob[i]=cum_prob[i-1]+PARAMS.sim_prob[i];
		
						}	

						Random rand=new Random();
						double prob=rand.nextDouble();

						for(int i=1;i<PARAMS.number_gws;i++)
						{
							if(prob<=cum_prob[i])
							{
								PARAMS.sim_avg_arrival_rate[i]++;
								//PARAMS.sim_effective_arrival_rate[i]++;
							//	System.out.println("Packet Offloaded to Gateway "+i);
								p.setLatency(p.getLatency()+(PARAMS.inter_latency[i]*50000));
								PARAMS.offloaded_packets[i].add(p);
								break;
							}
						}

					}

	//----------------------------------------------------------------------------------Dropping of packets--------------------------------------------------------------------
				}
							
		}

		//---------------------------------------------------------- Queue Length Updation after Packet Generation----------------------------------------------------------------------------

		present_queue_size=this.queue.getPackets().size();
		for(int i=0;i<PARAMS.number_servers[ID];i++)
		{
			if(this.servers.get(i).getNext_serviceTime()>PARAMS.TIME)
				present_queue_size++;

		}
		PARAMS.sim_temp_buffer_occupied[ID]=present_queue_size;
		PARAMS.sim_buffer_available[ID]=Math.max(0,PARAMS.total_buffer_capacity[ID]-PARAMS.sim_temp_buffer_occupied[ID]);


		//----------------------------------------------------------Offloaded Packets Addition----------------------------------------------------------------------------

 int l=0;

		while((present_queue_size<PARAMS.total_buffer_capacity[ID])&&(PARAMS.offloaded_packets[ID].isEmpty()==false))
		{
			l++;
			System.out.println("Loop Number="+l+" Inside While Present Queue Size of Gateway ID"+ID+" ="+present_queue_size);
			Packet p=PARAMS.offloaded_packets[ID].get(0);
			PARAMS.offloaded_packets[ID].remove(0);
			p.setGenTime(PARAMS.TIME);
			this.queue.getPackets().add(p);
			PARAMS.sim_offloaded[ID]++;
			PARAMS.sim_effective_arrival_rate[ID]++;
			present_queue_size=this.queue.getPackets().size();
			for(int i=0;i<PARAMS.number_servers[ID];i++)
			{
				if(this.servers.get(i).getNext_serviceTime()>PARAMS.TIME)
					present_queue_size++;
                   
			}
			PARAMS.sim_temp_buffer_occupied[ID]=present_queue_size;
			PARAMS.sim_buffer_available[ID]=Math.max(0,PARAMS.total_buffer_capacity[ID]-PARAMS.sim_temp_buffer_occupied[ID]);
		}

		//----------------------------------------------------------Final Queue Length Updation----------------------------------------------------------------------------
		present_queue_size=this.queue.getPackets().size();
		for(int i=0;i<PARAMS.number_servers[ID];i++)
		{
			if(this.servers.get(i).getNext_serviceTime()>PARAMS.TIME)
				present_queue_size++;

		}
		PARAMS.sim_temp_buffer_occupied[ID]=present_queue_size;
		PARAMS.sim_buffer_available[ID]=Math.max(0,PARAMS.total_buffer_capacity[ID]-PARAMS.sim_temp_buffer_occupied[ID]);
		System.out.println("Present Queue Size of Gateway ID"+ID+" ="+present_queue_size);
		this.queue.getQueueSizeEveryInstance().add(present_queue_size);
		System.out.println(" Queue Length in "+ID+" Gateway="+present_queue_size);
		System.out.println(" Queue Length TOTAL  in "+ID+" Gateway="+PARAMS.total_buffer_capacity[ID]);
		PARAMS.sim_buffer_actual_occupied[ID]=PARAMS.sim_buffer_actual_occupied[ID]+present_queue_size;
		PARAMS.sim_buffer_actual_capability[ID]=PARAMS.sim_buffer_actual_capability[ID]+PARAMS.total_buffer_capacity[ID];
	}

	//------------------------------------------------------------------Source to Queue----------------------------------------------------------------------------

	public void sendToQueue() throws FileNotFoundException
	{
		while((this.queue.getPackets().size()<PARAMS.total_buffer_capacity[ID])&&(this.src.getPackets().size()!=0))
		{
			Packet temp=this.src.getPackets().get(0);
			this.queue.getPackets().add(temp);
			this.src.getPackets().remove(0);

		}
		this.src.getPackets().clear();
	
		this.queue.getQueueSizeEveryInstance().add(this.queue.getPackets().size());
		
	}


	//-----------------------------------------------------------------------Servicing--------------------------------------------------------------------------------------

	public void Service()
	{

		for(int i=0;i<PARAMS.number_servers[ID];i++)
		{
			if(this.servers.get(i).getNext_serviceTime()>=PARAMS.TIME)
			{
				PARAMS.sim_server_busy_time[ID][i]++;
			}
			PARAMS.sim_server_on_time[ID][i]++;
		}
			
		System.out.println("TIME="+PARAMS.TIME);
		for(int i=0;i<PARAMS.number_servers[ID];i++)
		{
			//System.out.println("Server Id="+i);
			//System.out.println("NEXT SERVICE TIME="+this.servers.get(i).getNext_serviceTime());	
			if((PARAMS.TIME>=this.servers.get(i).getNext_serviceTime())&&(this.queue.getPackets().size()!=0))
			{
				Sim_negexp_obj service = new Sim_negexp_obj("Delay", 50000/PARAMS.service_rate[ID]);				
				double service_time=service.sample();
				//double service_time=50000/PARAMS.service_rate[ID];
				//System.out.println("Service Time for Gateway "+ID+" ="+service_time);
				Packet temp=this.queue.getPackets().get(0);
				this.queue.getPackets().remove(0);
				this.servers.get(i).setActive(true);
				this.servers.get(i).setCurPacket(temp);
				double nextService=PARAMS.TIME+service_time;
				this.servers.get(i).setNext_serviceTime(nextService);
				double busy=this.servers.get(i).getBusyTime();
				//System.out.println("Busy time="+busy);
				this.servers.get(i).setBusyTime(busy+service_time);
				temp.setCompletionTime(nextService);
				System.out.println("Destination id="+temp.getDestGateway_ID());
				System.out.println("Source id="+temp.getSrcGateway_ID());
				temp.setDestGateway_ID(ID);
				if(temp.getDestGateway_ID()==temp.getSrcGateway_ID())
				{
					System.out.println("Inside 1 "+PARAMS.inter_latency[ID]);
					PARAMS.sim_total_gateways_packets_processed[ID]++;
					PARAMS.sim_total_gateways_time[ID]=PARAMS.sim_total_gateways_time[ID]+(temp.getCompletionTime()-temp.getGenTime());
					PARAMS.sim_total_system_packets_processed++;
					PARAMS.sim_total_system_time=PARAMS.sim_total_system_time+(temp.getCompletionTime()-temp.getGenTime())+(PARAMS.inter_latency[ID]*50000);
					PARAMS.sim_total_gateways_app_packets_processed[ID]++;
					PARAMS.sim_total_gateways_app_time[ID]=PARAMS.sim_total_gateways_app_time[ID]+(PARAMS.inter_latency[ID]*50000)+(temp.getCompletionTime()-temp.getGenTime());
				}
				else
				{
					System.out.println("Inside 2 "+PARAMS.inter_latency[ID]+"\t"+PARAMS.inter_latency[temp.getSrcGateway_ID()] );
					PARAMS.sim_total_gateways_packets_processed[ID]++;
					PARAMS.sim_total_gateways_time[ID]=PARAMS.sim_total_gateways_time[ID]+(temp.getCompletionTime()-temp.getGenTime());
					PARAMS.sim_total_gateways_app_packets_processed[temp.getSrcGateway_ID()]++;
					PARAMS.sim_total_gateways_app_time[temp.getSrcGateway_ID()]=PARAMS.sim_total_gateways_app_time[temp.getSrcGateway_ID()]+(temp.getCompletionTime()-temp.getGenTime())+((PARAMS.inter_latency[ID]+PARAMS.inter_latency[temp.getSrcGateway_ID()])*50000);
					PARAMS.sim_total_system_packets_processed++;
					PARAMS.sim_total_system_time=PARAMS.sim_total_system_time+(temp.getCompletionTime()-temp.getGenTime())+((PARAMS.inter_latency[ID]+PARAMS.inter_latency[temp.getSrcGateway_ID()])*50000);
				}
			}
		}
	}

	//------------------------------------------------------------------------Stats---------------------------------------------------------------------------------------

	public void findResultParameters() throws FileNotFoundException
	{
		double queue_length=0;
		for(int i=0;i<PARAMS.TIME;i++)
		{
			//System.out.println("id="+ID+"Value of i ="+i);
			queue_length=queue_length+this.queue.getQueueSizeEveryInstance().get(i);
			//System.out.println("TIME="+i+"Gateway="+ID+" Queue_Length="+this.queue.getQueueSizeEveryInstance().get(i)+" Total Queue Length="+queue_length+" Total Time="+PARAMS.TIME);
		}

		PARAMS.sim_buffer_occupied[ID]=queue_length/(PARAMS.TIME);
		PARAMS.sim_avg_arrival_rate[ID]=(PARAMS.sim_avg_arrival_rate[ID]*50000)/(PARAMS.TIME);
		PARAMS.sim_effective_arrival_rate[ID]=(PARAMS.sim_effective_arrival_rate[ID]*50000)/(PARAMS.TIME);
		//if(ID==0)
	//	PARAMS.sim_loss_rate[ID]=(PARAMS.sim_loss_rate[ID]*50000)/(PARAMS.TIME);
		//else
			PARAMS.sim_loss_rate[ID]=PARAMS.sim_loss_rate[ID]*50000/(PARAMS.TIME);
		PARAMS.sim_gw_app_processing_efficiency[ID]=0;
		
		for(int i=0;i<PARAMS.number_servers[ID];i++)
	
			//	PARAMS.sim_gw_app_processing_efficiency[ID]=PARAMS.sim_gw_app_processing_efficiency[ID]+this.servers.get(i).getBusyTime()/PARAMS.TIME;
		PARAMS.sim_gw_app_processing_efficiency[ID]=PARAMS.sim_gw_app_processing_efficiency[ID]+PARAMS.sim_server_busy_time[ID][i]/PARAMS.sim_server_on_time[ID][i];
		PARAMS.sim_gw_app_processing_efficiency[ID]=PARAMS.sim_gw_app_processing_efficiency[ID]/PARAMS.number_servers[ID];
	
		//	PARAMS.sim_gw_buffer_occupancy_efficiency[ID]=PARAMS.sim_buffer_occupied[ID]/PARAMS.total_buffer_capacity[ID];
		PARAMS.sim_gw_buffer_occupancy_efficiency[ID]=PARAMS.sim_buffer_actual_occupied[ID]/PARAMS.sim_buffer_actual_capability[ID];
		
		PARAMS.sim_total_offloaded=0;
		for(int i=0;i<PARAMS.number_gws;i++)
			PARAMS.sim_total_offloaded=PARAMS.sim_total_offloaded+PARAMS.sim_offloaded[i];
		if(PARAMS.sim_total_offloaded==0)
			PARAMS.sim_offloaded_ratio[ID]=0;
		else
		PARAMS.sim_offloaded_ratio[ID]=PARAMS.sim_offloaded[ID]/PARAMS.sim_total_offloaded;
		
		PARAMS.sim_gw_response_time[ID]=(PARAMS.sim_total_gateways_time[ID]/50000)/PARAMS.sim_total_gateways_packets_processed[ID];
		PARAMS.sim_app_response_time[ID]=(PARAMS.sim_total_gateways_app_time[ID]/50000)/PARAMS.sim_total_gateways_app_packets_processed[ID];
		PARAMS.sim_avg_response_time_with_fog=(PARAMS.sim_total_system_time/50000)/	PARAMS.sim_total_system_packets_processed;
		PARAMS.sim_avg_response_time_without_fog=(PARAMS.sim_total_gateways_app_time[(int) (PARAMS.number_gws-1)]/50000)/PARAMS.sim_total_gateways_app_packets_processed[(int) (PARAMS.number_gws-1)];
	}

}
