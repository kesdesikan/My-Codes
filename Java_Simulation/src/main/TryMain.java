package main;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

import matlabcontrol.MatlabConnectionException;
import matlabcontrol.MatlabInvocationException;

import commons.*;
import entity.*;
import comparators.*;
import stats.*;



public class TryMain {

	
	public static void main(String[] args) throws IOException, MatlabInvocationException, MatlabConnectionException {
		
		Formulae f=new Formulae();
		Scanner sc=new Scanner(System.in);

//----------------------------------------------------------------Reading from the file-------------------------------------------------------------
		/*
		FileReader reader = new FileReader("Simulation Parameters.txt");
		BufferedReader bufferedReader = new BufferedReader(reader);
		String s=bufferedReader.readLine();
		PARAMS.analy_arrival_rate[0]=PARAMS.sim_arrival_rate[0]=Double.parseDouble(s);
		reader.close();
*/	
//------------------------------------------------------------------------------------------------------------------------------------------------------
		 PARAMS.number_gws=4;
		for(int index=0;index<=5000;index+=50)
		{	
			PrintWriter wr2 = new PrintWriter(new FileOutputStream(new File(
					"GW_APP_RESPONSE_TIME_A_S.txt"), true));
			PrintWriter wr3 = new PrintWriter(new FileOutputStream(new File(
					"GW_BUFFER_OCCUPANCY_A_S.txt"), true));
			PrintWriter wr4 = new PrintWriter(new FileOutputStream(new File(
					"GW_OFFLOADED_RATIO_A_S.txt"), true));
			PrintWriter wr6 = new PrintWriter(new FileOutputStream(new File(
					"GW_APP_PROCESSING_EFFICIENCY_A_S.txt"), true));
			PrintWriter wr7 = new PrintWriter(new FileOutputStream(new File(
					"GW_BUFFER_OCCUPANCY_EFFICIENCY_A_S.txt"), true));
			PrintWriter wr9= new PrintWriter(new FileOutputStream(new File(
					"GW_EFFECTIVE_ARRIVAL_RATE_A_S.txt"), true));
			PrintWriter wr26 = new PrintWriter(new FileOutputStream(new File(
					"GW_APP_RESPONSE_TIME_CLD_GWCLD_GWGWCLD.txt"), true));
			PrintWriter wr27 = new PrintWriter(new FileOutputStream(new File(
					"GW_BUFFER_OCCUPANCY_CLD_GWCLD_GWGWCLD.txt"), true));
			PrintWriter wr28 = new PrintWriter(new FileOutputStream(new File(
					"GW_OFFLOADED_RATIO_CLD_GWCLD_GWGWCLD.txt"), true));
			PrintWriter wr29 = new PrintWriter(new FileOutputStream(new File(
					"SYSTEM_RESPONSE_TIME_CLD_GWCLD_GWGWCLD.txt"), true));
			PrintWriter wr30 = new PrintWriter(new FileOutputStream(new File(
					"GW_APP_PROCESSING_EFFICIENCY_CLD_GWCLD_GWGWCLD.txt"), true));
			PrintWriter wr31 = new PrintWriter(new FileOutputStream(new File(
					"GW_BUFFER_OCCUPANCY_EFFICIENCY_CLD_GWCLD_GWGWCLD.txt"), true));
			PrintWriter wr33= new PrintWriter(new FileOutputStream(new File(
					"GW_EFFECTIVE_ARRIVAL_RATE_CLD_GWCLD_GWGWCLD.txt"), true));

			
			
			PARAMS.number_runs=3;
			for (int i = 0; i < PARAMS.number_gws; i++) {
				PARAMS.avg_analy_buffer_occupied[i]=0;
				PARAMS.avg_sim_buffer_occupied[i]=0;
				
				 PARAMS.sim_average_avg_arrival_rate[i]=0;
				 PARAMS.sim_average_effective_arrival_rate[i]=0;
				 PARAMS.sim_average_loss_rate[i]=0;
				 PARAMS.sim_average_buffer_occupied[i]=0;
				 PARAMS.sim_average_gw_response_time[i]=0;
				 PARAMS.sim_average_app_response_time[i]=0;
				 PARAMS.sim_average_offloaded_ratio[i]=0;
				 PARAMS.sim_average_avg_response_time_with_fog=0;
				 PARAMS.sim_average_avg_response_time_without_fog=0;
				 PARAMS.sim_average_gw_app_processing_efficiency[i]=0;
				 PARAMS.sim_average_gw_buffer_occupancy_efficiency[i]=0;
				
				 PARAMS.dynamic_average_avg_arrival_rate[i]=0;
				 PARAMS.dynamic_average_effective_arrival_rate[i]=0;
				 PARAMS.dynamic_average_loss_rate[i]=0;
				 PARAMS.dynamic_average_buffer_occupied[i]=0;
				 PARAMS.dynamic_average_gw_response_time[i]=0;
				 PARAMS.dynamic_average_app_response_time[i]=0;
				 PARAMS.dynamic_average_offloaded_ratio[i]=0;
				 PARAMS.dynamic_average_avg_response_time_with_fog=0;
				 PARAMS.dynamic_average_avg_response_time_without_fog=0;
				 PARAMS.dynamic_average_gw_app_processing_efficiency[i]=0;
				 PARAMS.dynamic_average_gw_buffer_occupancy_efficiency[i]=0;
				 
				 PARAMS.one_hop_average_avg_arrival_rate[i]=0;
				 PARAMS.one_hop_average_effective_arrival_rate[i]=0;
				 PARAMS.one_hop_average_loss_rate[i]=0;
				 PARAMS.one_hop_average_buffer_occupied[i]=0;
				 PARAMS.one_hop_average_gw_response_time[i]=0;
				 PARAMS.one_hop_average_app_response_time[i]=0;
				 PARAMS.one_hop_average_offloaded_ratio[i]=0;
				 PARAMS.one_hop_average_avg_response_time_with_fog=0;
				 PARAMS.one_hop_average_avg_response_time_without_fog=0;
				 PARAMS.one_hop_average_gw_app_processing_efficiency[i]=0;
				 PARAMS.one_hop_average_gw_buffer_occupancy_efficiency[i]=0;
				 
				 PARAMS.pure_cloud_average_avg_arrival_rate[i]=0;
				 PARAMS.pure_cloud_average_effective_arrival_rate[i]=0;
				 PARAMS.pure_cloud_average_loss_rate[i]=0;
				 PARAMS.pure_cloud_average_buffer_occupied[i]=0;
				 PARAMS.pure_cloud_average_gw_response_time[i]=0;
				 PARAMS.pure_cloud_average_app_response_time[i]=0;
				 PARAMS.pure_cloud_average_offloaded_ratio[i]=0;
				 PARAMS.pure_cloud_average_avg_response_time_with_fog=0;
				 PARAMS.pure_cloud_average_avg_response_time_without_fog=0;
				 PARAMS.pure_cloud_average_gw_app_processing_efficiency[i]=0;
				 PARAMS.pure_cloud_average_gw_buffer_occupancy_efficiency[i]=0;
			}
		for(int run=0;run<PARAMS.number_runs;run++)
		{
			
			
			//SSGW 1 802.11a and all
			
			PARAMS.analy_arrival_rate[0]=index;
			PARAMS.sim_arrival_rate[0]=index;
			PARAMS.dynamic_arrival_rate[0]=index;
			PARAMS.one_hop_arrival_rate[0]=index;
			PARAMS.pure_cloud_arrival_rate[0]=index;

			 PARAMS.service_rate[0]=200;
			 PARAMS.number_servers[0]= 2;
			 PARAMS.dynamic_number_servers[0]=2;
			 PARAMS.one_hop_number_servers[0]=2;
			 PARAMS.pure_cloud_number_servers[0]=2;
			 
			 PARAMS.total_buffer_capacity[0]= 20;
			 PARAMS.dynamic_total_buffer_capacity[0]= 20;
			 PARAMS.one_hop_total_buffer_capacity[0]= 20;
			 PARAMS.pure_cloud_total_buffer_capacity[0]= 20;
			 
			 PARAMS.inter_latency[0] = 0.39;

			
			 //SSGW 2 802.11b
			 	 
			 PARAMS.analy_arrival_rate[1] =200;
			 PARAMS.sim_arrival_rate[1]=200;
			 PARAMS.dynamic_arrival_rate[1]=200;
			 PARAMS.one_hop_arrival_rate[1]=200;
			 PARAMS.pure_cloud_arrival_rate[1]=200;

			 
			 PARAMS.service_rate[1]= 200;
			 PARAMS.number_servers[1] = 2;
			 PARAMS.dynamic_number_servers[1] = 2;
			 PARAMS.one_hop_number_servers[1] = 2;
			 PARAMS.pure_cloud_number_servers[1] = 2;

			 
			 PARAMS.total_buffer_capacity[1] = 20;
			 PARAMS.dynamic_total_buffer_capacity[1] = 20;
			 PARAMS.one_hop_total_buffer_capacity[1] = 20;
			 PARAMS.pure_cloud_total_buffer_capacity[1] = 20;

			 
			 PARAMS.inter_latency[1]=1.56;
			 
			 //IGW 802.11a		 
			 
			 PARAMS.analy_arrival_rate[2]=400;
			 PARAMS.sim_arrival_rate[2] =400; 
			 PARAMS.dynamic_arrival_rate[2] =400; 
			 PARAMS.one_hop_arrival_rate[2] =400; 
			 PARAMS.pure_cloud_arrival_rate[2] =400; 

			 
			 PARAMS.service_rate[2]  =400;
			 PARAMS.number_servers[2] =4;
			 PARAMS.dynamic_number_servers[2]  =4;
			 PARAMS.one_hop_number_servers[2]  =4;
			 PARAMS.pure_cloud_number_servers[2]  =4;

			 PARAMS.total_buffer_capacity[2]  =40;
			 PARAMS.dynamic_total_buffer_capacity[2]  =40;
			 PARAMS.one_hop_total_buffer_capacity[2]  =40;
			 PARAMS.pure_cloud_total_buffer_capacity[2]  =40;

			 
			 PARAMS.inter_latency[2] =0.39 ;

//	 //SSGW 3 Bluetooth	 
//			 
//			 PARAMS.analy_arrival_rate[3]=50;
//			 PARAMS.sim_arrival_rate[3] =50; 
//			 PARAMS.dynamic_arrival_rate[3] =50; 
//			 PARAMS.one_hop_arrival_rate[3] =50; 
//			 PARAMS.pure_cloud_arrival_rate[3] =50; 
//
//			 
//			 PARAMS.service_rate[3]  =50;
//			 PARAMS.number_servers[3] =2;
//			 PARAMS.dynamic_number_servers[3]  =2;
//			 PARAMS.one_hop_number_servers[3]  =2;
//			 PARAMS.pure_cloud_number_servers[3]  =2;
//
//			 PARAMS.total_buffer_capacity[3]  =20;
//			 PARAMS.dynamic_total_buffer_capacity[3]  =20;
//			 PARAMS.one_hop_total_buffer_capacity[3]  =20;
//			 PARAMS.pure_cloud_total_buffer_capacity[3]  =20;
//
//			 
//			 PARAMS.inter_latency[3] =3.91 ;
//
// //SSGW 4 Zigbee	 
//			 
//			 PARAMS.analy_arrival_rate[4]=20;
//			 PARAMS.sim_arrival_rate[4] =20; 
//			 PARAMS.dynamic_arrival_rate[4] =20; 
//			 PARAMS.one_hop_arrival_rate[4] =20; 
//			 PARAMS.pure_cloud_arrival_rate[4] =20; 
//
//			 
//			 PARAMS.service_rate[4]  =20;
//			 PARAMS.number_servers[4] =1;
//			 PARAMS.dynamic_number_servers[4]  =1;
//			 PARAMS.one_hop_number_servers[4]  =1;
//			 PARAMS.pure_cloud_number_servers[4]  =1;
//
//			 PARAMS.total_buffer_capacity[4]  =10;
//			 PARAMS.dynamic_total_buffer_capacity[4]  =10;
//			 PARAMS.one_hop_total_buffer_capacity[4]  =10;
//			 PARAMS.pure_cloud_total_buffer_capacity[4]  =10;
//
//			 
//			 PARAMS.inter_latency[4] =31.25 ;
//			 
// //SSGW 5 BLE	 
//			 
//			 PARAMS.analy_arrival_rate[5]=50;
//			 PARAMS.sim_arrival_rate[5] =50; 
//			 PARAMS.dynamic_arrival_rate[5] =50; 
//			 PARAMS.one_hop_arrival_rate[5] =50; 
//			 PARAMS.pure_cloud_arrival_rate[5] =50; 
//
//			 
//			 PARAMS.service_rate[5]  =50;
//			 PARAMS.number_servers[5] =2;
//			 PARAMS.dynamic_number_servers[5]  =2;
//			 PARAMS.one_hop_number_servers[5]  =2;
//			 PARAMS.pure_cloud_number_servers[5]  =2;
//
//			 PARAMS.total_buffer_capacity[5]  =20;
//			 PARAMS.dynamic_total_buffer_capacity[5]  =20;
//			 PARAMS.one_hop_total_buffer_capacity[5]  =20;
//			 PARAMS.pure_cloud_total_buffer_capacity[5]  =20;
//
//			 
//			 PARAMS.inter_latency[5] =7.81 ;
			 
 //Gateway 7 CLOUD
			 
			 PARAMS.analy_arrival_rate[3]=0;
			 PARAMS.sim_arrival_rate[3]=  0;
			 PARAMS.dynamic_arrival_rate[3]=  0;
			 PARAMS.one_hop_arrival_rate[3]=  0;
			 PARAMS.pure_cloud_arrival_rate[3]=  0;

			 PARAMS.service_rate[3] = 1000;
			 PARAMS.number_servers[3] =20;
			 PARAMS.dynamic_number_servers[3] =20;
			 PARAMS.one_hop_number_servers[3] =20;
			 PARAMS.pure_cloud_number_servers[3] =20;

			 
			 PARAMS.inter_latency[3]  = 235;
			 PARAMS.total_buffer_capacity[3]= 200;
			 PARAMS.dynamic_total_buffer_capacity[3]= 200;
			 PARAMS.one_hop_total_buffer_capacity[3]= 200;
			 PARAMS.pure_cloud_total_buffer_capacity[3]= 200;
			
			
			// PARAMS.total_inter_latency =PARAMS.inter_latency[1]+PARAMS.inter_latency[2]+PARAMS.inter_latency[3]+PARAMS.inter_latency[4]+PARAMS.inter_latency[5]+PARAMS.inter_latency[6];
			 PARAMS.total_inter_latency =PARAMS.inter_latency[1]+PARAMS.inter_latency[2]+PARAMS.inter_latency[3];

			 for( int i = 0; i < PARAMS.number_gws; i++) {
					PARAMS.offloaded_packets[i] = new ArrayList<Packet>();
					PARAMS.dynamic_offloaded_packets[i] = new ArrayList<Packet>();
					PARAMS.one_hop_offloaded_packets[i] = new ArrayList<Packet>();
					PARAMS.pure_cloud_offloaded_packets[i] = new ArrayList<Packet>();

				}

			for (int i = 0; i < PARAMS.number_gws; i++) {
				
				PARAMS.analy_buffer_available[i]=0;
				PARAMS.sim_buffer_available[i]=0;
				PARAMS.dynamic_buffer_available[i]=0;
				PARAMS.one_hop_buffer_available[i]=0;
				PARAMS.pure_cloud_buffer_available[i]=0;

				PARAMS.analy_buffer_occupied[i]=0;
				PARAMS.sim_buffer_occupied[i]=0;
				PARAMS.dynamic_buffer_occupied[i]=0;
				PARAMS.one_hop_buffer_occupied[i]=0;
				PARAMS.pure_cloud_buffer_occupied[i]=0;

				PARAMS.analy_prob[i]=0;
				PARAMS.sim_prob[i]=0;
				PARAMS.dynamic_prob[i]=0;

				PARAMS.analy_cum_prob[i]=0;
				PARAMS.sim_cum_prob[i]=0;
				PARAMS.dynamic_cum_prob[i]=0;
				
				PARAMS.analy_buffer_factor[i]=0;
				PARAMS.sim_buffer_factor[i]=0;
				PARAMS.dynamic_buffer_factor[i]=0;
				PARAMS.one_hop_buffer_factor[i]=0;
				PARAMS.pure_cloud_buffer_factor[i]=0;

				
				PARAMS.analy_gw_app_processing_efficiency[i]=0;
				PARAMS.sim_gw_app_processing_efficiency[i]=0;
				PARAMS.dynamic_gw_app_processing_efficiency[i]=0;
				PARAMS.one_hop_gw_app_processing_efficiency[i]=0;
				PARAMS.pure_cloud_gw_app_processing_efficiency[i]=0;

				
				PARAMS.analy_gw_buffer_occupancy_efficiency[i]=0;
				PARAMS.sim_gw_buffer_occupancy_efficiency[i]=0;
				PARAMS.dynamic_gw_buffer_occupancy_efficiency[i]=0;
				PARAMS.one_hop_gw_buffer_occupancy_efficiency[i]=0;
				PARAMS.pure_cloud_gw_buffer_occupancy_efficiency[i]=0;

				
				PARAMS.analy_offloaded[i]=0;
				PARAMS.sim_offloaded_ratio[i]=0;
				PARAMS.dynamic_offloaded_ratio[i]=0;
				PARAMS.one_hop_offloaded_ratio[i]=0;
				PARAMS.pure_cloud_offloaded_ratio[i]=0;

				
				PARAMS.analy_offloaded_ratio[i]=0;
				PARAMS.sim_offloaded_ratio[i]=0;
				PARAMS.dynamic_offloaded_ratio[i]=0;
				PARAMS.one_hop_offloaded_ratio[i]=0;
				PARAMS.pure_cloud_offloaded_ratio[i]=0;

				
				PARAMS.analy_avg_arrival_rate[i]=0;
				PARAMS.sim_avg_arrival_rate[i]=0;
				PARAMS.dynamic_avg_arrival_rate[i]=0;
				PARAMS.one_hop_avg_arrival_rate[i]=0;
				PARAMS.pure_cloud_avg_arrival_rate[i]=0;

				
				PARAMS.analy_app_response_time[i]=0;
				PARAMS.sim_app_response_time[i]=0;
				PARAMS.dynamic_app_response_time[i]=0;
				PARAMS.one_hop_app_response_time[i]=0;
				PARAMS.pure_cloud_app_response_time[i]=0;

				
				PARAMS.analy_gw_response_time[i]=0;
				PARAMS.sim_gw_response_time[i]=0;
				PARAMS.dynamic_gw_response_time[i]=0;
				PARAMS.one_hop_gw_response_time[i]=0;
				PARAMS.pure_cloud_gw_response_time[i]=0;

				
				PARAMS.sim_avg_arrival_rate[i]=0;
				PARAMS.dynamic_avg_arrival_rate[i]=0;
				PARAMS.one_hop_avg_arrival_rate[i]=0;
				PARAMS.pure_cloud_avg_arrival_rate[i]=0;

				
				PARAMS.sim_effective_arrival_rate[i]=0;
				PARAMS.dynamic_effective_arrival_rate[i]=0;
				PARAMS.analy_effective_arrival_rate[i]=0;
				PARAMS.one_hop_effective_arrival_rate[i]=0;
				PARAMS.pure_cloud_effective_arrival_rate[i]=0;
				
				PARAMS.sim_loss_rate[i]=0;
				PARAMS.dynamic_loss_rate[i]=0;
				PARAMS.analy_loss_rate[i]=0;
				PARAMS.one_hop_loss_rate[i]=0;
				PARAMS.pure_cloud_loss_rate[i]=0;

				
				PARAMS.number_packets_slot[i]=0;
				PARAMS.sim_temp_buffer_occupied[i]=0;
				
				PARAMS.dynamic_number_packets_slot[i]=0;
				PARAMS.dynamic_temp_buffer_occupied[i]=0;
				
				PARAMS.one_hop_number_packets_slot[i]=0;
				PARAMS.one_hop_temp_buffer_occupied[i]=0;
				
				PARAMS.pure_cloud_number_packets_slot[i]=0;
				PARAMS.pure_cloud_temp_buffer_occupied[i]=0;
				
				PARAMS.sim_total_gateways_packets_processed[i]=0;
				PARAMS.sim_total_gateways_time[i]=0;
				
				PARAMS.dynamic_total_gateways_packets_processed[i]=0;
				PARAMS.dynamic_total_gateways_time[i]=0;
				
				PARAMS.one_hop_total_gateways_packets_processed[i]=0;
				PARAMS.one_hop_total_gateways_time[i]=0;
				
				PARAMS.pure_cloud_total_gateways_packets_processed[i]=0;
				PARAMS.pure_cloud_total_gateways_time[i]=0;
				
				PARAMS.sim_total_gateways_app_packets_processed[i]=0;
				PARAMS.sim_total_gateways_app_time[i]=0;
				
				PARAMS.dynamic_total_gateways_app_packets_processed[i]=0;
				PARAMS.dynamic_total_gateways_app_time[i]=0;
				
				PARAMS.one_hop_total_gateways_app_packets_processed[i]=0;
				PARAMS.one_hop_total_gateways_app_time[i]=0;
				
				PARAMS.pure_cloud_total_gateways_app_packets_processed[i]=0;
				PARAMS.pure_cloud_total_gateways_app_time[i]=0;
				
			    PARAMS.analy_total_offloaded=0;
			    
			    PARAMS.sim_buffer_actual_capability[i]=0;
			    PARAMS.sim_buffer_actual_occupied[i]=0;
			    
			    PARAMS.dynamic_buffer_actual_occupied[i]=0;
			    PARAMS.dynamic_buffer_actual_capability[i]=0;
			    
			    PARAMS.one_hop_buffer_actual_occupied[i]=0;
			    PARAMS.one_hop_buffer_actual_capability[i]=0;
			    
			    PARAMS.pure_cloud_buffer_actual_occupied[i]=0;
			    PARAMS.pure_cloud_buffer_actual_capability[i]=0;
				
				for(int j=0;j<PARAMS.number_servers[i];j++)
				{
					 PARAMS.sim_server_on_time[i][j]=0;
					 PARAMS.sim_server_busy_time[i][j]=0;
					 
					 PARAMS.dynamic_server_busy_time[i][j]=0;
					 PARAMS.dynamic_server_on_time[i][j]=0;
					 
					 PARAMS.one_hop_server_busy_time[i][j]=0;
					 PARAMS.one_hop_server_on_time[i][j]=0;
					 
					 PARAMS.pure_cloud_server_busy_time[i][j]=0;
					 PARAMS.pure_cloud_server_on_time[i][j]=0;
					 
									
				}
			}
//----------------------------------------------------------------------------Analytical------------------------------------------------------------------------------
			if((PARAMS.analy_arrival_rate[0]==0)&&(run==0))
			{	
			
				wr2.println("Gateway 0 Arrival Rate"+"\t"+"Simulation App Response Time of 0"+"\t"+"Simulation App Response Time of 0"+"\t"+"Simulation App Response Time of 1"+"\t"+"Simulation App Response Time of 2"+"\t"+"Simulation App Response Time of Cloud");

				wr3.println("Gateway 0 Arrival Rate"+"\t"+"Analytical Buffer Occupancy of 0"+"\t"+"Simulation Buffer Occupancy of 0"+"\t"+"Analytical Buffer Occupancy of 1"+"\t"+"Simulation Buffer Occupancy of 1"+"\t"+"Analytical Buffer Occupancy of 2"+"\t"+"Simulation Buffer Occupancy of 2"+"\t"+"Analytical Buffer Occupancy of Cloud"+"\t"+"Simulation Buffer Occupancy of Cloud");
				wr4.println("Gateway 0 Arrival Rate"+"\t"+"Analytical Percentage of Offloaded to 0"+"\t"+"Simulation Percentage of Offloaded to 0"+"\t"+"Analytical Percentage of Offloaded to 1"+"\t"+"Simulation Percentage of Offloaded to 1"+"\t"+"Analytical Percentage of Offloaded to 2"+"\t"+"Simulation Percentage of Offloaded to 2"+"\t"+"Analytical Percentage of Offloaded to Cloud"+"\t"+"Simulation Percentage of Offloaded to 3");
				

				wr6.println("Gateway 0 Arrival Rate"+"\t"+"Analytical Avg Gateway App Processing Efficiency of 0"+"\t"+"Simulation Avg Gateway App Processing Efficiency of 0"+"\t"+"Analytical Avg Gateway App Processing Efficiency of 1"+"\t"+"Simulation Avg Gateway App Processing Efficiency of 1"+"\t"+"Analytical Avg Gateway App Processing Efficiency of 2"+"\t"+"Simulation Avg Gateway App Processing Efficiency of 2"+"\t"+"Analytical Avg Gateway App Processing Efficiency of Cloud"+"\t"+"Simulation Avg Gateway App Processing Efficiency of Cloud");
				wr7.println("Gateway 0 Arrival Rate"+"\t"+"Analytical Avg Gateway Buffer Occupancy Efficiency of 0"+"\t"+"Simulation Avg Gateway Buffer Occupancy Efficiency of 0"+"\t"+"Analytical Avg Gateway Buffer Occupancy Efficiency of 1"+"\t"+"Simulation Avg Gateway Buffer Occupancy Efficiency of 1"+"\t"+"Analytical Avg Gateway Buffer Occupancy Efficiency of 2"+"\t"+"Simulation Avg Gateway Buffer Occupancy Efficiency of 2"+"\t"+"Analytical Avg Gateway Buffer Occupancy Efficiency of Cloud"+"\t"+"Simulation Avg Gateway Buffer Occupancy Efficiency of Cloud");
				wr9.println("Gateway 0 Arrival Rate"+"\t"+"Analytical Effective  Arrival Rate of 0"+"\t"+"Simulation Effective  Arrival Rate of 0"+"\t"+"Analytical Effective  Arrival Rate of 1"+"\t"+"Simulation Effective  Arrival Rate of 1"+"\t"+"Analytical Effective  Arrival Rate of 2"+"\t"+"Simulation Effective  Arrival Rate of 2"+"\t"+"Analytical Effective  Arrival Rate of Cloud"+"\t"+"Simulation Effective Arrival Rate of Cloud"+"\t"+"Analytical Total Effective  Arrival Rate "+"\t"+"Simulation Total Effective  Arrival Rate");
				
		
			    
			    //ALL COMPARISONS
			    
			    //APP RESPONSE TIME	  
			    wr26.println("Gateway 0 Arrival Rate"+"\t"+"Pure Cloud APP  Response Time of 0"+"\t"+"Next Hop APP  Response Time of 0"+"\t"+"Probabilistic DF APP  Response Time of 0"+"\t"+"Pure Cloud APP  Response Time of 1"+"\t"+"Next Hop APP  Response Time of 1"+"\t"+"Probabilistic DF APP  Response Time of 1"+"\t"+"Pure Cloud APP  Response Time of 2"+"\t"+"Next Hop APP  Response Time of 2"+"\t"+"Probabilistic DF APP  Response Time of 2"+"\t"+"Pure Cloud APP  Response Time of Cloud"+"\t"+"Next Hop APP  Response Time of Cloud"+"\t"+"Probabilistic DF APP  Response Time of Cloud");
			    //BUFFER OCCUPANCY		
			    wr27.println("Gateway 0 Arrival Rate"+"\t"+"Pure Cloud Buffer Occupancy of 0"+"\t"+"Next Hop Buffer Occupancy of 0"+"\t"+"Pure Cloud Buffer Occupancy of 1"+"\t"+"Next Hop Buffer Occupancy of 1"+"\t"+"Pure Cloud Buffer Occupancy of 2"+"\t"+"Next Hop Buffer Occupancy of 2"+"\t"+"Pure Cloud Buffer Occupancy of Cloud"+"\t"+"Next Hop Buffer Occupancy of Cloud");
			    //OFFLOADED TO		
			    wr28.println("Gateway 0 Arrival Rate"+"\t"+"Pure Cloud Offloaded to of 0"+"\t"+"Next Hop Offloaded to of 0"+"\t"+"Probabilistic DF Offloaded to of 0"+"\t"+"Pure Cloud Offloaded to of 1"+"\t"+"Next Hop Offloaded to of 1"+"\t"+"Probabilistic DF Offloaded to of 1"+"\t"+"Pure Cloud Offloaded to of 2"+"\t"+"Next Hop Offloaded to of 2"+"\t"+"Probabilistic DF Offloaded to of 2"+"\t"+"Pure Cloud Offloaded to of Cloud"+"\t"+"Next Hop Offloaded to of Cloud"+"\t"+"Probabilistic DF Offloaded to of Cloud");	
			    //SYSTEM RESPONSE TIME  
			    wr29.println("Gateway 0 Arrival Rate"+"\t"+"Pure Cloud Total System Response Time"+"\t"+"Next Hop Total System Response Time"+"\t"+"Probabilistic DF Total System Response Time");	
			    //AVG GW APP PROCESSING EFFICIENCY	
			    wr30.println("Gateway 0 Arrival Rate"+"\t"+"Pure Cloud App Processing Efficiency of 0"+"\t"+"Next Hop App Processing Efficiency of 0"+"\t"+"Probabilistic DF App Processing Efficiency of 0"+"\t"+"Pure Cloud App Processing Efficiency of 1"+"\t"+"Next Hop App Processing Efficiency of 1"+"\t"+"Probabilistic DF App Processing Efficiency of 1"+"\t"+"Pure Cloud App Processing Efficiency of 2"+"\t"+"Next Hop App Processing Efficiency of 2"+"\t"+"Probabilistic DF App Processing Efficiency of 2"+"\t"+"Pure Cloud App Processing Efficiency of Cloud"+"\t"+"Next Hop App Processing Efficiency of Cloud"+"\t"+"Probabilistic DF App Processing Efficiency of Cloud");	
			    //AVG GW BUFFER OCCUPANCY EFFICIENCY		
			    wr31.println("Gateway 0 Arrival Rate"+"\t"+"Pure Cloud Buffer Occupancy Efficiency of 0"+"\t"+"Next Hop Buffer Occupancy Efficiency of 0"+"\t"+"Probabilistic DF Buffer Occupancy Efficiency of 0"+"\t"+"Pure Cloud Buffer Occupancy Efficiency of 1"+"\t"+"Next Hop Buffer Occupancy Efficiency of 1"+"\t"+"Probabilistic DF Buffer Occupancy Efficiency of 1"+"\t"+"Pure Cloud Buffer Occupancy Efficiency of 2"+"\t"+"Next Hop Buffer Occupancy Efficiency of 2"+"\t"+"Probabilistic DF Buffer Occupancy Efficiency of 2"+"\t"+"Pure Cloud Buffer Occupancy Efficiency of Cloud"+"\t"+"Next Hop Buffer Occupancy Efficiency of Cloud"+"\t"+"Probabilistic DF Buffer Occupancy Efficiency of Cloud");	
			    //ARRIVAL RATE  
				//EEFFECTIVE ARRIVAL RATE
			    wr33.println("Gateway 0 Arrival Rate"+"\t"+"Pure Cloud Average Effective Arrival rate of 0"+"\t"+"Next Hop Average Effective Arrival rate of 0"+"\t"+"Probabilistic DF Average Effective Arrival rate of 0"+"\t"+"Pure Cloud Average Effective Arrival rate of 1"+"\t"+"Next Hop Average Effective Arrival rate of 1"+"\t"+"Probabilistic DF Average Effective Arrival rate of 1"+"\t"+"Pure Cloud Average Effective Arrival rate of 2"+"\t"+"Next Hop Average Effective Arrival rate of 2"+"\t"+"Probabilistic DF Average Effective Arrival rate of 2"+"\t"+"Pure Cloud Average Effective Arrival rate of Cloud"+"\t"+"Next Hop Average Effective Arrival rate of Cloud"+"\t"+"Probabilistic DF Average Effective Arrival rate of Cloud");	
				//LOSS RATE		
				}		
				


					 
			 for(int i=0;i<=3;i++)
			 {
				   PARAMS.analy_effective_arrival_rate[i]=f.calculate_effective_arrival_rate(PARAMS.analy_arrival_rate[i], PARAMS.number_servers[i], PARAMS.service_rate[i], PARAMS.total_buffer_capacity[i]);
		           PARAMS.analy_buffer_occupied[i]=f.calculate_buffer_occupancy(PARAMS.analy_arrival_rate[i], PARAMS.number_servers[i], PARAMS.service_rate[i], PARAMS.total_buffer_capacity[i]);
		           PARAMS.analy_loss_rate[i]=f.calculate_loss_rate(PARAMS.analy_arrival_rate[i], PARAMS.number_servers[i], PARAMS.service_rate[i], PARAMS.total_buffer_capacity[i]);
		           PARAMS.analy_buffer_available[i]=PARAMS.total_buffer_capacity[i]-PARAMS.analy_buffer_occupied[i];
		           PARAMS.analy_avg_arrival_rate[i]=PARAMS.analy_arrival_rate[i];
				   PARAMS.analy_gw_response_time[i]=f.calculate_avg_response_time(PARAMS.analy_arrival_rate[i], PARAMS.number_servers[i], PARAMS.service_rate[i], PARAMS.total_buffer_capacity[i]);

		           
			 }
			 
//-------------------------------------------------------------------------------Offloading------------------------------------------------------------------------------
			 PARAMS.analy_total_buffer_available=0;
			 PARAMS.analy_total_trans_prob=0;
			 
			if(PARAMS.analy_loss_rate[0]>0)
			{
				
				PARAMS.analy_total_buffer_available=0;
				 for(int k=1;k<PARAMS.number_gws;k++)
				 {
					// PARAMS.analy_total_buffer_available=PARAMS.analy_total_buffer_available+PARAMS.analy_buffer_available[k];
					 PARAMS.analy_total_buffer_available=PARAMS.analy_total_buffer_available+PARAMS.total_buffer_capacity[k];
				 }
				
				for(int i=1;i<PARAMS.number_gws;i++)
				{
					//if(PARAMS.analy_buffer_available[i]!=0)
						PARAMS.analy_buffer_factor[i]=1;
				//	else
					//	PARAMS.analy_buffer_factor[i]=0;
							
				//	 PARAMS.analy_trans_prob[i]=(PARAMS.inter_latency_weight_factor*(1-(PARAMS.inter_latency[i]/PARAMS.total_latency)))+(PARAMS.buffer_weight_factor*(PARAMS.analy_buffer_available[i]/ PARAMS.analy_total_buffer_available));
					 PARAMS.analy_trans_prob[i]=(PARAMS.latency_weight_factor*(1-(PARAMS.inter_latency[i]/PARAMS.total_inter_latency)))+(PARAMS.buffer_weight_factor*(PARAMS.total_buffer_capacity[i]/ PARAMS.analy_total_buffer_available));
					 PARAMS.analy_trans_prob[i]=PARAMS.analy_trans_prob[i]*PARAMS.analy_buffer_factor[i];
					 PARAMS.analy_total_trans_prob=PARAMS.analy_total_trans_prob+PARAMS.analy_trans_prob[i];
				}
				for(int i=1;i<PARAMS.number_gws;i++)
				{	
					
					PARAMS.analy_prob[i]=PARAMS.analy_trans_prob[i]/PARAMS.analy_total_trans_prob;		
					//System.out.println("Time="+PARAMS.TIME+" Prob of Gateway "+i+" ="+PARAMS.analy_prob[i]);
					PARAMS.analy_offloaded[i]=PARAMS.analy_loss_rate[0]*PARAMS.analy_prob[i];
					//System.out.println("---------------------Analy offloaded to gateway "+i+"= "+PARAMS.analy_offloaded[i]);
					
					PARAMS.analy_arrival_rate[i]=PARAMS.analy_arrival_rate[i]+PARAMS.analy_offloaded[i];
					//System.out.println("---------------------nEW aRRIVAL RATE OF gateway "+i+"= "+PARAMS.analy_arrival_rate[i]);
					
				}		
			
		
//-------------------------------------------------------------Calculation of Parameters after Offloading--------------------------------------------------------------			
				
				
		
			
				for(int i=0;i<=3;i++)
				{
					PARAMS.analy_buffer_occupied[i]=f.calculate_buffer_occupancy(PARAMS.analy_arrival_rate[i], PARAMS.number_servers[i],PARAMS.service_rate[i], PARAMS.total_buffer_capacity[i]);
					PARAMS.analy_gw_response_time[i]=f.calculate_avg_response_time(PARAMS.analy_arrival_rate[i], PARAMS.number_servers[i], PARAMS.service_rate[i], PARAMS.total_buffer_capacity[i]);
					PARAMS.analy_gw_app_processing_efficiency[i]=f.calculate_gateway_processing_efficiency(PARAMS.analy_arrival_rate[i], PARAMS.number_servers[i], PARAMS.service_rate[i], PARAMS.total_buffer_capacity[i]);
					PARAMS. analy_gw_buffer_occupancy_efficiency[i]=PARAMS.analy_buffer_occupied[i]/PARAMS.total_buffer_capacity[i];
					PARAMS.analy_avg_arrival_rate[i]=PARAMS.analy_arrival_rate[i];
                    PARAMS.analy_gw_response_time[i]=f.calculate_avg_response_time(PARAMS.analy_arrival_rate[i], PARAMS.number_servers[i],PARAMS.service_rate[i], PARAMS.total_buffer_capacity[i]);
                    PARAMS.analy_app_response_time[i]=(PARAMS.inter_latency[i]+PARAMS.analy_gw_response_time[i]);
 		           PARAMS.analy_loss_rate[i]=f.calculate_loss_rate(PARAMS.analy_arrival_rate[i], PARAMS.number_servers[i], PARAMS.service_rate[i], PARAMS.total_buffer_capacity[i]);

                    PARAMS.analy_effective_arrival_rate[i]=f.calculate_effective_arrival_rate(PARAMS.analy_arrival_rate[i], PARAMS.number_servers[i],PARAMS.service_rate[i], PARAMS.total_buffer_capacity[i]);
				}
			
			}		


			
			
			
	
//-----------------------------------------------------------------Simulation---------------------------------------------------------------------------------------
			
			
	
			Gateway[] gw=new Gateway[(int) PARAMS.number_gws];
			DynamicGateway[] Dgw=new DynamicGateway[(int) PARAMS.number_gws];
			OneHopGateway[] Ogw=new OneHopGateway[(int) PARAMS.number_gws];
			PureCloudGateway[] Pgw=new PureCloudGateway[(int) PARAMS.number_gws];
			
			for(int i=0;i<PARAMS.number_gws;i++)
			{   gw[i]=new Gateway();
				gw[i].setID(i);
				gw[i].setSrc();
				gw[i].setQueue();
				gw[i].setServers();
				Dgw[i]=new DynamicGateway();
				Dgw[i].setID(i);
				Dgw[i].setSrc();
				Dgw[i].setQueue();
				Dgw[i].setServers();
				Ogw[i]=new OneHopGateway();
				Ogw[i].setID(i);
				Ogw[i].setSrc();
				Ogw[i].setQueue();
				Ogw[i].setServers();
				Pgw[i]=new PureCloudGateway();
				Pgw[i].setID(i);
				Pgw[i].setSrc();
				Pgw[i].setQueue();
				Pgw[i].setServers();
				
			}
			
			for(PARAMS.TIME=0;PARAMS.TIME<100000;PARAMS.TIME++)
			{
				for(int i=0;i<PARAMS.number_gws;i++)
				{	
					gw[i].generatePackets();
					Dgw[i].generatePackets();
					Ogw[i].generatePackets();
					Pgw[i].generatePackets();
					
					gw[i].Service();
					Dgw[i].Service();
					Ogw[i].Service();
					Pgw[i].Service();
				}
			}
			PARAMS.analy_total_offloaded=0;
			for(int i=0;i<PARAMS.number_gws;i++)
			{
				gw[i].findResultParameters();
				Dgw[i].findResultParameters();
				Ogw[i].findResultParameters();
				Pgw[i].findResultParameters();
				PARAMS.analy_total_offloaded=PARAMS.analy_total_offloaded+PARAMS.analy_offloaded[i];
			}
			
			for(int i=0;i<PARAMS.number_gws;i++)
			{
			 PARAMS.sim_average_avg_arrival_rate[i]=PARAMS.sim_average_avg_arrival_rate[i]+PARAMS.sim_avg_arrival_rate[i];
			 PARAMS.sim_average_effective_arrival_rate[i]= PARAMS.sim_average_effective_arrival_rate[i]+PARAMS.sim_effective_arrival_rate[i];
			 PARAMS.sim_average_loss_rate[i]=PARAMS.sim_average_loss_rate[i]+PARAMS.sim_loss_rate[i];
			 PARAMS.sim_average_buffer_occupied[i]=PARAMS.sim_average_buffer_occupied[i]+PARAMS.sim_buffer_occupied[i];
			 PARAMS.sim_average_gw_response_time[i]=PARAMS.sim_average_gw_response_time[i]+PARAMS.sim_gw_response_time[i];
			 PARAMS.sim_average_app_response_time[i]= PARAMS.sim_average_app_response_time[i]+ PARAMS.sim_app_response_time[i];
			 PARAMS.sim_average_offloaded_ratio[i]=PARAMS.sim_average_offloaded_ratio[i]+PARAMS.sim_offloaded_ratio[i];
			  PARAMS.sim_average_gw_app_processing_efficiency[i]=PARAMS.sim_average_gw_app_processing_efficiency[i]+PARAMS.sim_gw_app_processing_efficiency[i];
			 PARAMS.sim_average_gw_buffer_occupancy_efficiency[i]=PARAMS.sim_average_gw_buffer_occupancy_efficiency[i]+PARAMS.sim_gw_buffer_occupancy_efficiency[i];
			 
			 PARAMS.dynamic_average_avg_arrival_rate[i]=PARAMS.dynamic_average_avg_arrival_rate[i]+PARAMS.dynamic_avg_arrival_rate[i];
			 PARAMS.dynamic_average_effective_arrival_rate[i]= PARAMS.dynamic_average_effective_arrival_rate[i]+PARAMS.dynamic_effective_arrival_rate[i];
			 PARAMS.dynamic_average_loss_rate[i]=PARAMS.dynamic_average_loss_rate[i]+PARAMS.dynamic_loss_rate[i];
			 PARAMS.dynamic_average_buffer_occupied[i]=PARAMS.dynamic_average_buffer_occupied[i]+PARAMS.dynamic_buffer_occupied[i];
			 PARAMS.dynamic_average_gw_response_time[i]=PARAMS.dynamic_average_gw_response_time[i]+PARAMS.dynamic_gw_response_time[i];
			 PARAMS.dynamic_average_app_response_time[i]= PARAMS.dynamic_average_app_response_time[i]+ PARAMS.dynamic_app_response_time[i];
			 PARAMS.dynamic_average_offloaded_ratio[i]=PARAMS.dynamic_average_offloaded_ratio[i]+PARAMS.dynamic_offloaded_ratio[i];
			 PARAMS.dynamic_average_gw_app_processing_efficiency[i]=PARAMS.dynamic_average_gw_app_processing_efficiency[i]+PARAMS.dynamic_gw_app_processing_efficiency[i];
			 PARAMS.dynamic_average_gw_buffer_occupancy_efficiency[i]=PARAMS.dynamic_average_gw_buffer_occupancy_efficiency[i]+PARAMS.dynamic_gw_buffer_occupancy_efficiency[i];
			 
			 PARAMS.one_hop_average_avg_arrival_rate[i]=PARAMS.one_hop_average_avg_arrival_rate[i]+PARAMS.one_hop_avg_arrival_rate[i];
			 PARAMS.one_hop_average_effective_arrival_rate[i]= PARAMS.one_hop_average_effective_arrival_rate[i]+PARAMS.one_hop_effective_arrival_rate[i];
			 PARAMS.one_hop_average_loss_rate[i]=PARAMS.one_hop_average_loss_rate[i]+PARAMS.one_hop_loss_rate[i];
			 PARAMS.one_hop_average_buffer_occupied[i]=PARAMS.one_hop_average_buffer_occupied[i]+PARAMS.one_hop_buffer_occupied[i];
			 PARAMS.one_hop_average_gw_response_time[i]=PARAMS.one_hop_average_gw_response_time[i]+PARAMS.one_hop_gw_response_time[i];
			 PARAMS.one_hop_average_app_response_time[i]= PARAMS.one_hop_average_app_response_time[i]+ PARAMS.one_hop_app_response_time[i];
			 PARAMS.one_hop_average_offloaded_ratio[i]=PARAMS.one_hop_average_offloaded_ratio[i]+PARAMS.one_hop_offloaded_ratio[i];
			 PARAMS.one_hop_average_gw_app_processing_efficiency[i]=PARAMS.one_hop_average_gw_app_processing_efficiency[i]+PARAMS.one_hop_gw_app_processing_efficiency[i];
			 PARAMS.one_hop_average_gw_buffer_occupancy_efficiency[i]=PARAMS.one_hop_average_gw_buffer_occupancy_efficiency[i]+PARAMS.one_hop_gw_buffer_occupancy_efficiency[i];
	
			 PARAMS.pure_cloud_average_avg_arrival_rate[i]=PARAMS.pure_cloud_average_avg_arrival_rate[i]+PARAMS.pure_cloud_avg_arrival_rate[i];
			 PARAMS.pure_cloud_average_effective_arrival_rate[i]= PARAMS.pure_cloud_average_effective_arrival_rate[i]+PARAMS.pure_cloud_effective_arrival_rate[i];
			 PARAMS.pure_cloud_average_loss_rate[i]=PARAMS.pure_cloud_average_loss_rate[i]+PARAMS.pure_cloud_loss_rate[i];
			 PARAMS.pure_cloud_average_buffer_occupied[i]=PARAMS.pure_cloud_average_buffer_occupied[i]+PARAMS.pure_cloud_buffer_occupied[i];
			 PARAMS.pure_cloud_average_gw_response_time[i]=PARAMS.pure_cloud_average_gw_response_time[i]+PARAMS.pure_cloud_gw_response_time[i];
			 PARAMS.pure_cloud_average_app_response_time[i]= PARAMS.pure_cloud_average_app_response_time[i]+ PARAMS.pure_cloud_app_response_time[i];
			 PARAMS.pure_cloud_average_offloaded_ratio[i]=PARAMS.pure_cloud_average_offloaded_ratio[i]+PARAMS.pure_cloud_offloaded_ratio[i];
			 PARAMS.pure_cloud_average_gw_app_processing_efficiency[i]=PARAMS.pure_cloud_average_gw_app_processing_efficiency[i]+PARAMS.pure_cloud_gw_app_processing_efficiency[i];
			 PARAMS.pure_cloud_average_gw_buffer_occupancy_efficiency[i]=PARAMS.pure_cloud_average_gw_buffer_occupancy_efficiency[i]+PARAMS.pure_cloud_gw_buffer_occupancy_efficiency[i];
	
			}
			PARAMS.sim_average_avg_response_time_with_fog=PARAMS.sim_average_avg_response_time_with_fog+PARAMS.sim_avg_response_time_with_fog;
			PARAMS.sim_average_avg_response_time_without_fog=PARAMS.sim_average_avg_response_time_without_fog+PARAMS.sim_avg_response_time_without_fog;
			
			 PARAMS.dynamic_average_avg_response_time_with_fog=PARAMS.dynamic_average_avg_response_time_with_fog+PARAMS.dynamic_avg_response_time_with_fog;
			 PARAMS.dynamic_average_avg_response_time_without_fog=PARAMS.dynamic_average_avg_response_time_without_fog+PARAMS.dynamic_avg_response_time_without_fog;
			 
			 PARAMS.pure_cloud_average_avg_response_time_with_fog=PARAMS.pure_cloud_average_avg_response_time_with_fog+PARAMS.pure_cloud_avg_response_time_with_fog;
			 PARAMS.pure_cloud_average_avg_response_time_without_fog=PARAMS.pure_cloud_average_avg_response_time_without_fog+PARAMS.pure_cloud_avg_response_time_without_fog;
			 
			 PARAMS.one_hop_average_avg_response_time_with_fog=PARAMS.one_hop_average_avg_response_time_with_fog+PARAMS.one_hop_avg_response_time_with_fog;
			 PARAMS.one_hop_average_avg_response_time_without_fog=PARAMS.one_hop_average_avg_response_time_without_fog+PARAMS.one_hop_avg_response_time_without_fog;
			 
					
		}	
		for(int i=0;i<PARAMS.number_gws;i++)
		{
			 PARAMS.sim_avg_arrival_rate[i]=PARAMS.sim_average_avg_arrival_rate[i]/PARAMS.number_runs;
			 PARAMS.sim_effective_arrival_rate[i]=PARAMS.sim_average_effective_arrival_rate[i]/PARAMS.number_runs;
			 PARAMS.sim_loss_rate[i]=PARAMS.sim_average_loss_rate[i]/PARAMS.number_runs;
			 PARAMS.sim_buffer_occupied[i]=PARAMS.sim_average_buffer_occupied[i]/PARAMS.number_runs;
			 PARAMS.sim_gw_response_time[i]=PARAMS.sim_average_gw_response_time[i]/PARAMS.number_runs;
			 PARAMS.sim_app_response_time[i]=PARAMS.sim_average_app_response_time[i]/PARAMS.number_runs;
			 PARAMS.sim_offloaded_ratio[i]=PARAMS.sim_average_offloaded_ratio[i]/PARAMS.number_runs;
			 PARAMS.sim_gw_app_processing_efficiency[i]=PARAMS.sim_average_gw_app_processing_efficiency[i]/PARAMS.number_runs;
			 PARAMS.sim_gw_buffer_occupancy_efficiency[i]=PARAMS.sim_average_gw_buffer_occupancy_efficiency[i]/PARAMS.number_runs;
			 
			 PARAMS.dynamic_avg_arrival_rate[i]=PARAMS.dynamic_average_avg_arrival_rate[i]/PARAMS.number_runs;
			 PARAMS.dynamic_effective_arrival_rate[i]=PARAMS.dynamic_average_effective_arrival_rate[i]/PARAMS.number_runs;
			 PARAMS.dynamic_loss_rate[i]=PARAMS.dynamic_average_loss_rate[i]/PARAMS.number_runs;
			 PARAMS.dynamic_buffer_occupied[i]=PARAMS.dynamic_average_buffer_occupied[i]/PARAMS.number_runs;
			 PARAMS.dynamic_gw_response_time[i]=PARAMS.dynamic_average_gw_response_time[i]/PARAMS.number_runs;
			 PARAMS.dynamic_app_response_time[i]=PARAMS.dynamic_average_app_response_time[i]/PARAMS.number_runs;
			 PARAMS.dynamic_offloaded_ratio[i]=PARAMS.dynamic_average_offloaded_ratio[i]/PARAMS.number_runs;
			 PARAMS.dynamic_gw_app_processing_efficiency[i]=PARAMS.dynamic_average_gw_app_processing_efficiency[i]/PARAMS.number_runs;
			 PARAMS.dynamic_gw_buffer_occupancy_efficiency[i]=PARAMS.dynamic_average_gw_buffer_occupancy_efficiency[i]/PARAMS.number_runs;
			 
			 PARAMS.one_hop_avg_arrival_rate[i]=PARAMS.one_hop_average_avg_arrival_rate[i]/PARAMS.number_runs;
			 PARAMS.one_hop_effective_arrival_rate[i]=PARAMS.one_hop_average_effective_arrival_rate[i]/PARAMS.number_runs;
			 PARAMS.one_hop_loss_rate[i]=PARAMS.one_hop_average_loss_rate[i]/PARAMS.number_runs;
			 PARAMS.one_hop_buffer_occupied[i]=PARAMS.one_hop_average_buffer_occupied[i]/PARAMS.number_runs;
			 PARAMS.one_hop_gw_response_time[i]=PARAMS.one_hop_average_gw_response_time[i]/PARAMS.number_runs;
			 PARAMS.one_hop_app_response_time[i]=PARAMS.one_hop_average_app_response_time[i]/PARAMS.number_runs;
			 PARAMS.one_hop_offloaded_ratio[i]=PARAMS.one_hop_average_offloaded_ratio[i]/PARAMS.number_runs;
			 PARAMS.one_hop_gw_app_processing_efficiency[i]=PARAMS.one_hop_average_gw_app_processing_efficiency[i]/PARAMS.number_runs;
			 PARAMS.one_hop_gw_buffer_occupancy_efficiency[i]=PARAMS.one_hop_average_gw_buffer_occupancy_efficiency[i]/PARAMS.number_runs;
			 
			 PARAMS.pure_cloud_avg_arrival_rate[i]=PARAMS.pure_cloud_average_avg_arrival_rate[i]/PARAMS.number_runs;
			 PARAMS.pure_cloud_effective_arrival_rate[i]=PARAMS.pure_cloud_average_effective_arrival_rate[i]/PARAMS.number_runs;
			 PARAMS.pure_cloud_loss_rate[i]=PARAMS.pure_cloud_average_loss_rate[i]/PARAMS.number_runs;
			 PARAMS.pure_cloud_buffer_occupied[i]=PARAMS.pure_cloud_average_buffer_occupied[i]/PARAMS.number_runs;
			 PARAMS.pure_cloud_gw_response_time[i]=PARAMS.pure_cloud_average_gw_response_time[i]/PARAMS.number_runs;
			 PARAMS.pure_cloud_app_response_time[i]=PARAMS.pure_cloud_average_app_response_time[i]/PARAMS.number_runs;
			 PARAMS.pure_cloud_offloaded_ratio[i]=PARAMS.pure_cloud_average_offloaded_ratio[i]/PARAMS.number_runs;
			 PARAMS.pure_cloud_gw_app_processing_efficiency[i]=PARAMS.pure_cloud_average_gw_app_processing_efficiency[i]/PARAMS.number_runs;
			 PARAMS.pure_cloud_gw_buffer_occupancy_efficiency[i]=PARAMS.pure_cloud_average_gw_buffer_occupancy_efficiency[i]/PARAMS.number_runs;
			
		}
		 PARAMS.sim_avg_response_time_with_fog=PARAMS.sim_average_avg_response_time_with_fog/PARAMS.number_runs;
		 PARAMS.sim_avg_response_time_without_fog=PARAMS.sim_average_avg_response_time_without_fog/PARAMS.number_runs;
		 
		 PARAMS.dynamic_avg_response_time_with_fog=PARAMS.dynamic_average_avg_response_time_with_fog/PARAMS.number_runs;
		 PARAMS.dynamic_avg_response_time_without_fog=PARAMS.dynamic_average_avg_response_time_without_fog/PARAMS.number_runs;		 
		 
		 PARAMS.pure_cloud_avg_response_time_with_fog=PARAMS.pure_cloud_average_avg_response_time_with_fog/PARAMS.number_runs;
		 PARAMS.pure_cloud_avg_response_time_without_fog=PARAMS.pure_cloud_average_avg_response_time_without_fog/PARAMS.number_runs;
		 
		 PARAMS.one_hop_avg_response_time_with_fog=PARAMS.one_hop_average_avg_response_time_with_fog/PARAMS.number_runs;
		 PARAMS.one_hop_avg_response_time_without_fog=PARAMS.one_hop_average_avg_response_time_without_fog/PARAMS.number_runs;

		PARAMS.analy_app_response_time[0]=((PARAMS.analy_arrival_rate[0]-PARAMS.analy_loss_rate[0])/PARAMS.analy_arrival_rate[0])*PARAMS.analy_gw_response_time[0];
		for(int i=0;i<PARAMS.number_gws;i++)
		{	
//			PARAMS.avg_analy_buffer_occupied[i]=PARAMS.avg_analy_buffer_occupied[i]/PARAMS.number_runs;
//			PARAMS.avg_sim_buffer_occupied[i]=PARAMS.avg_sim_buffer_occupied[i]/PARAMS.number_runs;
			if(PARAMS.analy_total_offloaded==0)
				PARAMS.analy_offloaded_ratio[i]=0;
			else
			PARAMS.analy_offloaded_ratio[i]=PARAMS.analy_offloaded[i]/PARAMS.analy_total_offloaded;
			PARAMS.analy_app_response_time[0]=PARAMS.analy_app_response_time[0]+(PARAMS.analy_offloaded_ratio[i]*(PARAMS.analy_gw_response_time[i]+PARAMS.inter_latency[i]));
		}	
		
		for(int i=0;i<PARAMS.number_gws;i++)
		{
			PARAMS.analy_avg_response_time_with_fog=PARAMS.analy_avg_response_time_with_fog+PARAMS.analy_app_response_time[i];
			
			PARAMS.analy_total_arrival_rate=PARAMS.analy_total_arrival_rate+PARAMS.analy_avg_arrival_rate[i];
			PARAMS.sim_total_arrival_rate=PARAMS.sim_total_arrival_rate+PARAMS.sim_avg_arrival_rate[i];
			PARAMS.dynamic_total_arrival_rate=PARAMS.dynamic_total_arrival_rate+PARAMS.dynamic_avg_arrival_rate[i];
			PARAMS.one_hop_total_arrival_rate=PARAMS.one_hop_total_arrival_rate+PARAMS.one_hop_avg_arrival_rate[i];
			PARAMS.pure_cloud_total_arrival_rate=PARAMS.pure_cloud_total_arrival_rate+PARAMS.pure_cloud_avg_arrival_rate[i];

			
			PARAMS.analy_total_effective_arrival_rate=PARAMS.analy_total_effective_arrival_rate+PARAMS.analy_effective_arrival_rate[i];
			PARAMS.sim_total_effective_arrival_rate=PARAMS.sim_total_effective_arrival_rate+PARAMS.sim_effective_arrival_rate[i];
			PARAMS.dynamic_total_effective_arrival_rate=PARAMS.dynamic_total_effective_arrival_rate+PARAMS.dynamic_effective_arrival_rate[i];
			PARAMS.one_hop_total_effective_arrival_rate=PARAMS.one_hop_total_effective_arrival_rate+PARAMS.one_hop_effective_arrival_rate[i];
			PARAMS.pure_cloud_total_effective_arrival_rate=PARAMS.pure_cloud_total_effective_arrival_rate+PARAMS.pure_cloud_effective_arrival_rate[i];

			
			PARAMS.analy_total_loss_rate=PARAMS.analy_total_loss_rate+PARAMS.analy_loss_rate[i];
			PARAMS.sim_total_loss_rate=PARAMS.sim_total_loss_rate+PARAMS.sim_loss_rate[i];
			PARAMS.dynamic_total_loss_rate=PARAMS.dynamic_total_loss_rate+PARAMS.dynamic_loss_rate[i];
			PARAMS.one_hop_total_loss_rate=PARAMS.one_hop_total_loss_rate+PARAMS.one_hop_loss_rate[i];
			PARAMS.pure_cloud_total_loss_rate=PARAMS.pure_cloud_total_loss_rate+PARAMS.pure_cloud_loss_rate[i];

		}
		
		PARAMS.analy_avg_response_time_with_fog=PARAMS.analy_avg_response_time_with_fog/PARAMS.number_gws;
		PARAMS.analy_avg_response_time_without_fog=PARAMS.analy_app_response_time[(int) (PARAMS.number_gws-1)];
		
		
//-------------------------------------------------------------------------Displaying of Results------------------------------------------------------------------------
			
			wr2.println(PARAMS.analy_arrival_rate[0]+"\t"+PARAMS.sim_app_response_time[0]+"\t"+PARAMS.sim_app_response_time[1]+"\t"+PARAMS.sim_app_response_time[2]+"\t"+PARAMS.sim_app_response_time[3]);

			wr3.println(PARAMS.analy_arrival_rate[0]+"\t"+PARAMS.analy_buffer_occupied[0]+"\t"+PARAMS.sim_buffer_occupied[0]+"\t"+PARAMS.analy_buffer_occupied[1]+"\t"+PARAMS.sim_buffer_occupied[1]+"\t"+PARAMS.analy_buffer_occupied[2]+"\t"+PARAMS.sim_buffer_occupied[2]+"\t"+PARAMS.analy_buffer_occupied[3]+"\t"+PARAMS.sim_buffer_occupied[3]);
			wr4.println(PARAMS.analy_arrival_rate[0]+"\t"+PARAMS.analy_offloaded_ratio[0]+"\t"+PARAMS.sim_offloaded_ratio[0]+"\t"+PARAMS.analy_offloaded_ratio[1]+"\t"+PARAMS.sim_offloaded_ratio[1]+"\t"+PARAMS.analy_offloaded_ratio[2]+"\t"+PARAMS.sim_offloaded_ratio[2]+"\t"+PARAMS.analy_offloaded_ratio[3]+"\t"+PARAMS.sim_offloaded_ratio[3]);
			
			
			wr6.println(PARAMS.analy_arrival_rate[0]+"\t"+PARAMS.analy_gw_app_processing_efficiency[0]+"\t"+PARAMS.sim_gw_app_processing_efficiency[0]+"\t"+PARAMS.analy_gw_app_processing_efficiency[1]+"\t"+PARAMS.sim_gw_app_processing_efficiency[1]+"\t"+PARAMS.analy_gw_app_processing_efficiency[2]+"\t"+PARAMS.sim_gw_app_processing_efficiency[2]+"\t"+PARAMS.analy_gw_app_processing_efficiency[3]+"\t"+PARAMS.sim_gw_app_processing_efficiency[3]);
			wr7.println(PARAMS.analy_arrival_rate[0]+"\t"+PARAMS.analy_gw_buffer_occupancy_efficiency[0]+"\t"+PARAMS.sim_gw_buffer_occupancy_efficiency[0]+"\t"+PARAMS.analy_gw_buffer_occupancy_efficiency[1]+"\t"+PARAMS.sim_gw_buffer_occupancy_efficiency[1]+"\t"+PARAMS.analy_gw_buffer_occupancy_efficiency[2]+"\t"+PARAMS.sim_gw_buffer_occupancy_efficiency[2]+"\t"+PARAMS.analy_gw_buffer_occupancy_efficiency[3]+"\t"+PARAMS.sim_gw_buffer_occupancy_efficiency[3]);
			wr9.println(PARAMS.analy_arrival_rate[0]+"\t"+PARAMS.analy_effective_arrival_rate[0]+"\t"+PARAMS.sim_effective_arrival_rate[0]+"\t"+PARAMS.analy_effective_arrival_rate[1]+"\t"+PARAMS.sim_effective_arrival_rate[1]+"\t"+PARAMS.analy_effective_arrival_rate[2]+"\t"+PARAMS.sim_effective_arrival_rate[2]+"\t"+PARAMS.analy_effective_arrival_rate[3]+"\t"+PARAMS.sim_effective_arrival_rate[3]);

			    //APP RESPONSE TIME	  
			 	wr26.println(PARAMS.sim_arrival_rate[0]+"\t"+PARAMS.pure_cloud_app_response_time[0]+"\t"+PARAMS.one_hop_app_response_time[0]+"\t"+PARAMS.sim_app_response_time[0]+"\t"+PARAMS.pure_cloud_app_response_time[1]+"\t"+PARAMS.one_hop_app_response_time[1]+"\t"+PARAMS.sim_app_response_time[1]+"\t"+PARAMS.pure_cloud_app_response_time[2]+"\t"+PARAMS.one_hop_app_response_time[2]+"\t"+PARAMS.sim_app_response_time[2]+"\t"+PARAMS.pure_cloud_app_response_time[3]+"\t"+PARAMS.one_hop_app_response_time[3]+"\t"+PARAMS.sim_app_response_time[3]);
			    //BUFFER OCCUPANCY		
			 	wr27.println(PARAMS.sim_arrival_rate[0]+"\t"+PARAMS.pure_cloud_buffer_occupied[0]+"\t"+PARAMS.one_hop_buffer_occupied[0]+"\t"+PARAMS.sim_buffer_occupied[0]+"\t"+PARAMS.pure_cloud_buffer_occupied[1]+"\t"+PARAMS.one_hop_buffer_occupied[1]+"\t"+PARAMS.sim_buffer_occupied[1]+"\t"+PARAMS.pure_cloud_buffer_occupied[2]+"\t"+PARAMS.one_hop_buffer_occupied[2]+"\t"+PARAMS.sim_buffer_occupied[2]+"\t"+PARAMS.pure_cloud_buffer_occupied[3]+"\t"+PARAMS.one_hop_buffer_occupied[3]+"\t"+PARAMS.sim_buffer_occupied[3]);
			    //OFFLOADED TO		
			 	wr28.println(PARAMS.sim_arrival_rate[0]+"\t"+PARAMS.pure_cloud_offloaded_ratio[0]+"\t"+PARAMS.one_hop_offloaded_ratio[0]+"\t"+PARAMS.sim_offloaded_ratio[0]+"\t"+PARAMS.pure_cloud_offloaded_ratio[1]+"\t"+PARAMS.one_hop_offloaded_ratio[1]+"\t"+PARAMS.sim_offloaded_ratio[1]+"\t"+PARAMS.pure_cloud_offloaded_ratio[2]+"\t"+PARAMS.one_hop_offloaded_ratio[2]+"\t"+PARAMS.sim_offloaded_ratio[2]+"\t"+PARAMS.pure_cloud_offloaded_ratio[3]+"\t"+PARAMS.one_hop_offloaded_ratio[3]+"\t"+PARAMS.sim_offloaded_ratio[3]);
			    //SYSTEM RESPONSE TIME  
			    wr29.println(PARAMS.sim_arrival_rate[0]+"\t"+PARAMS.pure_cloud_avg_response_time_with_fog+"\t"+PARAMS.one_hop_avg_response_time_with_fog+"\t"+PARAMS.sim_avg_response_time_with_fog);	
			    //AVG GW APP PROCESSING EFFICIENCY	
				 wr30.println(PARAMS.sim_arrival_rate[0]+"\t"+PARAMS.pure_cloud_gw_app_processing_efficiency[0]+"\t"+PARAMS.one_hop_gw_app_processing_efficiency[0]+"\t"+PARAMS.sim_gw_app_processing_efficiency[0]+"\t"+PARAMS.pure_cloud_gw_app_processing_efficiency[1]+"\t"+PARAMS.one_hop_gw_app_processing_efficiency[1]+"\t"+PARAMS.sim_gw_app_processing_efficiency[1]+"\t"+PARAMS.pure_cloud_gw_app_processing_efficiency[2]+"\t"+PARAMS.one_hop_gw_app_processing_efficiency[2]+"\t"+PARAMS.sim_gw_app_processing_efficiency[2]+"\t"+PARAMS.pure_cloud_gw_app_processing_efficiency[3]+"\t"+PARAMS.one_hop_gw_app_processing_efficiency[3]+"\t"+PARAMS.sim_gw_app_processing_efficiency[3]);
			    //AVG GW BUFFER OCCUPANCY EFFICIENCY		
				 wr31.println(PARAMS.sim_arrival_rate[0]+"\t"+PARAMS.pure_cloud_gw_buffer_occupancy_efficiency[0]+"\t"+PARAMS.one_hop_gw_buffer_occupancy_efficiency[0]+"\t"+PARAMS.sim_gw_buffer_occupancy_efficiency[0]+"\t"+PARAMS.pure_cloud_gw_buffer_occupancy_efficiency[1]+"\t"+PARAMS.one_hop_gw_buffer_occupancy_efficiency[1]+"\t"+PARAMS.sim_gw_buffer_occupancy_efficiency[1]+"\t"+PARAMS.pure_cloud_gw_buffer_occupancy_efficiency[2]+"\t"+PARAMS.one_hop_gw_buffer_occupancy_efficiency[2]+"\t"+PARAMS.sim_gw_buffer_occupancy_efficiency[2]+"\t"+PARAMS.pure_cloud_gw_buffer_occupancy_efficiency[3]+"\t"+PARAMS.one_hop_gw_buffer_occupancy_efficiency[3]+"\t"+PARAMS.sim_gw_buffer_occupancy_efficiency[3]);
			    //EEFFECTIVE ARRIVAL RATE
				 wr33.println(PARAMS.sim_arrival_rate[0]+"\t"+PARAMS.pure_cloud_effective_arrival_rate[0]+"\t"+PARAMS.one_hop_effective_arrival_rate[0]+"\t"+PARAMS.sim_effective_arrival_rate[0]+"\t"+PARAMS.pure_cloud_effective_arrival_rate[1]+"\t"+PARAMS.one_hop_effective_arrival_rate[1]+"\t"+PARAMS.sim_effective_arrival_rate[1]+"\t"+PARAMS.pure_cloud_effective_arrival_rate[2]+"\t"+PARAMS.one_hop_effective_arrival_rate[2]+"\t"+PARAMS.sim_effective_arrival_rate[2]+"\t"+PARAMS.pure_cloud_effective_arrival_rate[3]+"\t"+PARAMS.one_hop_effective_arrival_rate[3]+"\t"+PARAMS.sim_effective_arrival_rate[3]);
				
			    
			    
			 wr2.close();
			 wr3.close();
			 wr4.close();
			 wr6.close();
			 wr7.close();
			 wr9.close();
			 wr26.close();
			 wr27.close();
			 wr28.close();
			 wr29.close();
			 wr30.close();
			 wr31.close();
			 wr33.close();
			 
		}		
			 

		}
	}

