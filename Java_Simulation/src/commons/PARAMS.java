package commons;
import entity.*;

import java.awt.List;
import java.util.ArrayList;

public class PARAMS {
	
	public static double TIME;
	public static int PACKET_ID;
	public static int GATEWAY_ID;
	
	public static double number_gws;
	public static double[] analy_arrival_rate=new double[100];	
	public static double[] sim_arrival_rate=new double[100];
	public static double[] dynamic_arrival_rate=new double[100];
	public static double[] one_hop_arrival_rate=new double[100];
	public static double[] pure_cloud_arrival_rate=new double[100];
	
	public static double[] number_servers=new double[100];
	public static double[] dynamic_number_servers=new double[100];
	public static double[] one_hop_number_servers=new double[100];
	public static double[] pure_cloud_number_servers=new double[100];
	
	public static double[] service_rate=new double[100];
	
	public static double[] total_buffer_capacity=new double[100];
	public static double[] dynamic_total_buffer_capacity=new double[100];
	public static double[] one_hop_total_buffer_capacity=new double[100];
	public static double[] pure_cloud_total_buffer_capacity=new double[100];

	public static String[] tech_name=new String[100];
	public static double[] tech_range=new double[100];
	
	public static double[] inter_latency=new double[100];
	public static double[] intra_latency=new double[100];
		
	public static double[] max_data_rate=new double[100];
	public static double total_inter_latency=0;
	
	public static double analy_total_buffer_available=0;
	public static double sim_total_buffer_available=0;
	public static double dynamic_total_buffer_available=0;
	public static double one_hop_total_buffer_available=0;
	public static double pure_cloud_total_buffer_available=0;

	
	
	public static double[] analy_buffer_occupied=new double[100];
	public static double[] sim_buffer_occupied=new double[100];
	public static double[] dynamic_buffer_occupied=new double[100];
	public static double[] one_hop_buffer_occupied=new double[100];
	public static double[] pure_cloud_buffer_occupied=new double[100];

	
	public static double[] sim_temp_buffer_occupied=new double[100];
	public static double[] dynamic_temp_buffer_occupied=new double[100];
	public static double[] one_hop_temp_buffer_occupied=new double[100];
	public static double[] pure_cloud_temp_buffer_occupied=new double[100];

	
	public static double[] sim_buffer_available=new double[100];
	public static double[] dynamic_buffer_available=new double[100];
	public static double[] analy_buffer_available=new double[100];
	public static double[] one_hop_buffer_available=new double[100];
	public static double[] pure_cloud_buffer_available=new double[100];

	

	public static double[] analy_blocking_prob=new double[100];
	public static double[] sim_blocking_prob=new double[100];
    public static double[] dynamic_blocking_prob=new double[100];
    public static double[] one_hop_blocking_prob=new double[100];
    public static double[] pure_cloud_blocking_prob=new double[100];

	
	public static double[] analy_buffer_factor=new double[100];
	public static double[] sim_buffer_factor=new double[100];
	public static double[] dynamic_buffer_factor=new double[100];
	public static double[] one_hop_buffer_factor=new double[100];
	public static double[] pure_cloud_buffer_factor=new double[100];
	
	public static double[] analy_gw_response_time=new double[100];
    public static double[] sim_gw_response_time=new double[100];
    public static double[] dynamic_gw_response_time=new double[100];
    public static double[] one_hop_gw_response_time=new double[100];
    public static double[] pure_cloud_gw_response_time=new double[100];

    
    public static double[] analy_app_response_time=new double[100];
    public static double[] sim_app_response_time=new double[100];
    public static double[] dynamic_app_response_time=new double[100];
    public static double[] one_hop_app_response_time=new double[100];
    public static double[] pure_cloud_app_response_time=new double[100];

    public static double[] analy_prob=new double[100];
    public static double[] sim_prob=new double[100];
    public static double[] dynamic_prob=new double[100];
    
    public static double[] analy_cum_prob=new double[100];
    public static double[] sim_cum_prob=new double[100];
    public static double[] dynamic_cum_prob=new double[100];
    
    public static double[] analy_trans_prob=new double[100];
    public static double[] sim_trans_prob=new double[100];
    public static double[] dynamic_trans_prob=new double[100];
    
    public static double analy_total_trans_prob=0;
    public static double sim_total_trans_prob=0;
    public static double dynamic_total_trans_prob=0;
    
    public static double[] analy_offloaded=new double[100];
    public static double[] sim_offloaded=new double[100];
    public static double[] dynamic_offloaded=new double[100];
    public static double[] one_hop_offloaded=new double[100];
    public static double[] pure_cloud_offloaded=new double[100];

    
    public static double[] analy_offloaded_ratio=new double[100];
    public static double[] sim_offloaded_ratio=new double[100];
    public static double[] dynamic_offloaded_ratio=new double[100];
    public static double[] one_hop_offloaded_ratio=new double[100];
    public static double[] pure_cloud_offloaded_ratio=new double[100];
   
    public static double[] analy_gw_app_processing_efficiency=new double[100];
    public static double[] sim_gw_app_processing_efficiency=new double[100];
    public static double[] dynamic_gw_app_processing_efficiency=new double[100];
    public static double[] one_hop_gw_app_processing_efficiency=new double[100];
    public static double[] pure_cloud_gw_app_processing_efficiency=new double[100];

    
    public static double[] analy_gw_buffer_occupancy_efficiency=new double[100];
    public static double[] sim_gw_buffer_occupancy_efficiency=new double[100];
    public static double[] dynamic_gw_buffer_occupancy_efficiency=new double[100];
    public static double[] one_hop_gw_buffer_occupancy_efficiency=new double[100];
    public static double[] pure_cloud_gw_buffer_occupancy_efficiency=new double[100];
   
    public static double[] analy_avg_arrival_rate=new double[100];
    public static double[] sim_avg_arrival_rate=new double[100];
    public static double[] dynamic_avg_arrival_rate=new double[100];
    public static double[] one_hop_avg_arrival_rate=new double[100];
    public static double[] pure_cloud_avg_arrival_rate=new double[100];

    
    public static double[] analy_effective_arrival_rate=new double[100];
    public static double[] sim_effective_arrival_rate=new double[100];
    public static double[] dynamic_effective_arrival_rate=new double[100];
    public static double[] one_hop_effective_arrival_rate=new double[100];
    public static double[] pure_cloud_effective_arrival_rate=new double[100];

    
    public static double[] analy_loss_rate=new double[100];
    public static double[] sim_loss_rate=new double[100];
    public static double[] dynamic_loss_rate=new double[100];
    public static double[] one_hop_loss_rate=new double[100];
    public static double[] pure_cloud_loss_rate=new double[100];

	
    public static double latency_weight_factor=0.75;
	public static double buffer_weight_factor=0.25;
    
	public static double analy_avg_response_time_with_fog=0;
	public static double sim_avg_response_time_with_fog=0;
	public static double dynamic_avg_response_time_with_fog=0;
	public static double one_hop_avg_response_time_with_fog=0;
	public static double pure_cloud_avg_response_time_with_fog=0;

	
	public static double analy_avg_response_time_without_fog=0;
	public static double sim_avg_response_time_without_fog=0;
	public static double dynamic_avg_response_time_without_fog=0;
	public static double one_hop_avg_response_time_without_fog=0;
	public static double pure_cloud_avg_response_time_without_fog=0;

	
	public static double analy_total_arrival_rate=0;
	public static double sim_total_arrival_rate=0;
	public static double dynamic_total_arrival_rate=0;
	public static double one_hop_total_arrival_rate=0;
	public static double pure_cloud_total_arrival_rate=0;

	
	public static double analy_total_loss_rate=0;
	public static double sim_total_loss_rate=0;
	public static double dynamic_total_loss_rate=0;
	public static double one_hop_total_loss_rate=0;
	public static double pure_cloud_total_loss_rate=0;

	
	public static double analy_total_effective_arrival_rate=0;
	public static double sim_total_effective_arrival_rate=0;
    public static double dynamic_total_effective_arrival_rate=0;
    public static double one_hop_total_effective_arrival_rate=0;
    public static double pure_cloud_total_effective_arrival_rate=0;


	public static double[] avg_analy_buffer_occupied=new double[100];
	public static double[] avg_sim_buffer_occupied=new double[100];
	public static double[] avg_dynamic_buffer_occupied=new double[100];
	public static double[] avg_one_hop_buffer_occupied=new double[100];
	public static double[] avg_pure_cloud_buffer_occupied=new double[100];

	
	public static int number_runs=0;
	
	public static int[] number_packets_slot=new int[100];
	public static int[] dynamic_number_packets_slot=new int[100];
	public static int[] one_hop_number_packets_slot=new int[100];
	public static int[] pure_cloud_number_packets_slot=new int[100];

	
	public static ArrayList<Packet>[] offloaded_packets = new ArrayList[100];
	public static ArrayList<Packet>[] dynamic_offloaded_packets = new ArrayList[100];
	public static ArrayList<Packet>[] one_hop_offloaded_packets = new ArrayList[100];
	public static ArrayList<Packet>[] pure_cloud_offloaded_packets = new ArrayList[100];

	
	public static double sim_total_system_time=0;
	public static double dynamic_total_system_time=0;
	public static double one_hop_total_system_time=0;
	public static double pure_cloud_total_system_time=0;

	
	public static double sim_total_system_packets_processed=0;
	public static double dynamic_total_system_packets_processed=0;
	public static double one_hop_total_system_packets_processed=0;
	public static double pure_cloud_total_system_packets_processed=0;

	
	public static double[] sim_total_gateways_packets_processed=new double[100];
	public static double[] dynamic_total_gateways_packets_processed=new double[100];
	public static double[] one_hop_total_gateways_packets_processed=new double[100];
	public static double[] pure_cloud_total_gateways_packets_processed=new double[100];

	
	public static double[] sim_total_gateways_time=new double[100];
	public static double[] dynamic_total_gateways_time=new double[100];
	public static double[] one_hop_total_gateways_time=new double[100];
	public static double[] pure_cloud_total_gateways_time=new double[100];

	
	public static double[] sim_total_gateways_app_packets_processed=new double[100];
	public static double[] dynamic_total_gateways_app_packets_processed=new double[100];
	public static double[] one_hop_total_gateways_app_packets_processed=new double[100];
	public static double[] pure_cloud_total_gateways_app_packets_processed=new double[100];

	
	public static double[] sim_total_gateways_app_time=new double[100];
	public static double[] dynamic_total_gateways_app_time=new double[100];
	public static double[] one_hop_total_gateways_app_time=new double[100];
	public static double[] pure_cloud_total_gateways_app_time=new double[100];

	
	public static double[] total_generated_packets=new double[100];
	public static double[] dynamic_total_generated_packets=new double[100];
	public static double[] one_hop_total_generated_packets=new double[100];
	public static double[] pure_cloud_total_generated_packets=new double[100];

	
	public static double analy_total_offloaded=0;
	public static double sim_total_offloaded=0;
	public static double dynamic_total_offloaded=0;
	public static double one_hop_total_offloaded=0;
	public static double pure_cloud_total_offloaded=0;

	
	public static double[] sim_average_avg_arrival_rate=new double[100];
	public static double[] sim_average_effective_arrival_rate=new double[100];
	public static double[] sim_average_loss_rate=new double[100];
	public static double[] sim_average_buffer_occupied=new double[100];
	public static double[] sim_average_gw_response_time=new double[100];
	public static double[] sim_average_app_response_time=new double[100];
	public static double[] sim_average_offloaded_ratio=new double[100];
	public static double sim_average_avg_response_time_with_fog=0;
	public static double sim_average_avg_response_time_without_fog=0;
	public static double[] sim_average_gw_app_processing_efficiency=new double[100];
	public static double[] sim_average_gw_buffer_occupancy_efficiency=new double[100];
	
	public static double[] dynamic_average_avg_arrival_rate=new double[100];
	public static double[] dynamic_average_effective_arrival_rate=new double[100];
	public static double[] dynamic_average_loss_rate=new double[100];
	public static double[] dynamic_average_buffer_occupied=new double[100];
	public static double[] dynamic_average_gw_response_time=new double[100];
	public static double[] dynamic_average_app_response_time=new double[100];
	public static double[] dynamic_average_offloaded_ratio=new double[100];
	public static double dynamic_average_avg_response_time_with_fog=0;
	public static double dynamic_average_avg_response_time_without_fog=0;
	public static double[] dynamic_average_gw_app_processing_efficiency=new double[100];
	public static double[] dynamic_average_gw_buffer_occupancy_efficiency=new double[100];
	
	
	public static double[] one_hop_average_avg_arrival_rate=new double[100];
	public static double[] one_hop_average_effective_arrival_rate=new double[100];
	public static double[] one_hop_average_loss_rate=new double[100];
	public static double[] one_hop_average_buffer_occupied=new double[100];
	public static double[] one_hop_average_gw_response_time=new double[100];
	public static double[] one_hop_average_app_response_time=new double[100];
	public static double[] one_hop_average_offloaded_ratio=new double[100];
	public static double one_hop_average_avg_response_time_with_fog=0;
	public static double one_hop_average_avg_response_time_without_fog=0;
	public static double[] one_hop_average_gw_app_processing_efficiency=new double[100];
	public static double[] one_hop_average_gw_buffer_occupancy_efficiency=new double[100];
	
	public static double[] pure_cloud_average_avg_arrival_rate=new double[100];
	public static double[] pure_cloud_average_effective_arrival_rate=new double[100];
	public static double[] pure_cloud_average_loss_rate=new double[100];
	public static double[] pure_cloud_average_buffer_occupied=new double[100];
	public static double[] pure_cloud_average_gw_response_time=new double[100];
	public static double[] pure_cloud_average_app_response_time=new double[100];
	public static double[] pure_cloud_average_offloaded_ratio=new double[100];
	public static double pure_cloud_average_avg_response_time_with_fog=0;
	public static double pure_cloud_average_avg_response_time_without_fog=0;
	public static double[] pure_cloud_average_gw_app_processing_efficiency=new double[100];
	public static double[] pure_cloud_average_gw_buffer_occupancy_efficiency=new double[100];
	
	
	public static double[][] sim_server_on_time=new double[100][100];
	public static double[][] sim_server_busy_time=new double[100][100];
	
	public static double[][] dynamic_server_on_time=new double[100][100];
	public static double[][] dynamic_server_busy_time=new double[100][100];
	
	public static double[][] one_hop_server_on_time=new double[100][100];
	public static double[][] one_hop_server_busy_time=new double[100][100];
	
	public static double[][] pure_cloud_server_on_time=new double[100][100];
	public static double[][] pure_cloud_server_busy_time=new double[100][100];
	
	public static double[] sim_buffer_actual_occupied=new double[100];
	public static double[] sim_buffer_actual_capability=new double[100];
	
	public static double[] dynamic_buffer_actual_occupied=new double[100];
	public static double[] dynamic_buffer_actual_capability=new double[100];
	
	public static double[] one_hop_buffer_actual_occupied=new double[100];
	public static double[] one_hop_buffer_actual_capability=new double[100];
	
	public static double[] pure_cloud_buffer_actual_occupied=new double[100];
	public static double[] pure_cloud_buffer_actual_capability=new double[100];
	
	
}
