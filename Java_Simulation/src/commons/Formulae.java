package commons;

public class Formulae {
	
	public double calculate_factorial(double fac)
	{
		double factorial=1;
		for(int i=1;i<=fac;i++)
			factorial=factorial*i;
		
		factorial=Math.max(1,factorial);
		
		return factorial;
	}

	public double calculate_traffic_intensity(double arrival_rate, double number_servers, double service_rate, double total_buffer_capacity)
	{
		double traffic_intensity=arrival_rate/(number_servers*service_rate);
		
		
		if(Double.isNaN(traffic_intensity))
			traffic_intensity=0;
		traffic_intensity=Math.max(0, traffic_intensity);
		
		return traffic_intensity;
		
	}
	
	public double calculate_zero_probability(double arrival_rate, double number_servers, double service_rate, double total_buffer_capacity)
	{
		double traffic_intensity=calculate_traffic_intensity(arrival_rate, number_servers, service_rate, total_buffer_capacity);
		double zero_probability=1;
		
		for(int j=1;j<number_servers;j++)
		{
			zero_probability=zero_probability+(Math.pow((number_servers*traffic_intensity), j)/calculate_factorial(j));
		}
		if(traffic_intensity==1)
		{
			zero_probability=zero_probability+((Math.pow(number_servers, number_servers)*(total_buffer_capacity-number_servers+1))/calculate_factorial(number_servers));
		}
		else if(traffic_intensity!=1)
		zero_probability=zero_probability+(((1-Math.pow(traffic_intensity,( total_buffer_capacity-number_servers+1)))*(Math.pow((number_servers*traffic_intensity), number_servers)))/((calculate_factorial(number_servers)*(1-traffic_intensity))));
		
		zero_probability=1/zero_probability;
		
		
		if(Double.isNaN(zero_probability))
			zero_probability=0;
		zero_probability=Math.max(0, zero_probability);
		zero_probability=Math.min(1, zero_probability);
		
		return zero_probability;
	}
	
	public double calculate_n_probability(double arrival_rate, double number_servers, double service_rate, double total_buffer_capacity,double n)
	{
		double n_prob=0;
		double traffic_intensity=calculate_traffic_intensity(arrival_rate, number_servers, service_rate, total_buffer_capacity);
		double zero_prob=calculate_zero_probability(arrival_rate, number_servers, service_rate, total_buffer_capacity);
		if((n>=0)&&(n<number_servers))
			n_prob=(Math.pow((number_servers*traffic_intensity), n)*zero_prob)/calculate_factorial(n);
		else
			n_prob=(Math.pow(number_servers, number_servers)*Math.pow(traffic_intensity, n)*zero_prob)/calculate_factorial(number_servers);
		
		if(Double.isNaN(n_prob))
			n_prob=0;
		n_prob=Math.max(0, n_prob);
		n_prob=Math.min(1, n_prob);
		
		return n_prob;
		
	}
	
public double calculate_buffer_occupancy(double arrival_rate, double number_servers, double service_rate, double total_buffer_capacity)
{
	double buffer_occupied=0;
	double n_prob=0;
	for(int i=1;i<=total_buffer_capacity;i++)
	{
		 n_prob=calculate_n_probability(arrival_rate, number_servers, service_rate, total_buffer_capacity, i);
		buffer_occupied=buffer_occupied+(i*n_prob);
	}
	
	if(Double.isNaN(buffer_occupied))
		buffer_occupied=0;
	buffer_occupied=Math.max(0, buffer_occupied);
	
	return buffer_occupied;
}

public double calculate_blocking_probability(double arrival_rate, double number_servers, double service_rate, double total_buffer_capacity)
{
	double blocking_prob=0;
	
	blocking_prob=calculate_n_probability(arrival_rate, number_servers, service_rate, total_buffer_capacity, total_buffer_capacity);
	
	if(Double.isNaN(blocking_prob))
		blocking_prob=0;
	blocking_prob=Math.max(0, blocking_prob);
	blocking_prob=Math.min(1, blocking_prob);
	
	return blocking_prob;
	
}

public double calculate_effective_arrival_rate(double arrival_rate, double number_servers, double service_rate, double total_buffer_capacity)
{
	double effective_arrival=0;
	double blocking_prob=calculate_blocking_probability(arrival_rate, number_servers, service_rate, total_buffer_capacity);
	effective_arrival=(arrival_rate)*(1-blocking_prob);
	
	if(Double.isNaN(effective_arrival))
		effective_arrival=0;
	effective_arrival=Math.max(0, effective_arrival);
	
	return effective_arrival;
}

public double calculate_gateway_processing_efficiency(double arrival_rate, double number_servers, double service_rate, double total_buffer_capacity)
{
	double utilisation=0;
	double traffic_intensity=calculate_traffic_intensity(arrival_rate, number_servers, service_rate, total_buffer_capacity);
	double blocking_prob=calculate_blocking_probability(arrival_rate, number_servers, service_rate, total_buffer_capacity);
	
	utilisation=traffic_intensity*(1-blocking_prob);
	
if(Double.isNaN(utilisation))
		utilisation=0;
	utilisation=Math.max(0, utilisation);
	utilisation=Math.min(1, utilisation);
			
	return utilisation;
}

public double calculate_avg_response_time(double arrival_rate, double number_servers, double service_rate, double total_buffer_capacity)
{
  double response_time=0;
  double buffer_occupied=calculate_buffer_occupancy(arrival_rate, number_servers, service_rate, total_buffer_capacity);
  double effective_arrival=calculate_effective_arrival_rate(arrival_rate, number_servers, service_rate, total_buffer_capacity);

  response_time=buffer_occupied/effective_arrival;
  
  if(Double.isNaN(response_time))
		response_time=0;
	response_time=Math.max(0, response_time);
			
	return response_time;
}

public double calculate_loss_rate(double arrival_rate, double number_servers, double service_rate, double total_buffer_capacity)
{
	double loss_rate=0;
	
	 double blocking_prob=calculate_blocking_probability(arrival_rate, number_servers, service_rate, total_buffer_capacity);
	 
	 loss_rate=arrival_rate*blocking_prob;
	 
	  if(Double.isNaN(loss_rate))
			loss_rate=0;
		loss_rate=Math.max(0, loss_rate);
				
		return loss_rate;
}

public double m_calculate_zero_probability(double arrival_rate, double number_servers, double service_rate, double total_buffer_capacity)
{
	double traffic_intensity=calculate_traffic_intensity(arrival_rate, number_servers, service_rate, total_buffer_capacity);
	double m_zero_probability=1;
	
	
	for(int j=1;j<number_servers;j++)
	{
		m_zero_probability=m_zero_probability+(Math.pow((number_servers*traffic_intensity), j)/calculate_factorial(j));
	}
	if(traffic_intensity!=1)
		m_zero_probability=m_zero_probability+(((Math.pow((number_servers*traffic_intensity), number_servers)))/((calculate_factorial(number_servers)*(1-traffic_intensity))));
	
	if(Double.isNaN(m_zero_probability))
		m_zero_probability=0;
	m_zero_probability=Math.max(0, m_zero_probability);
	m_zero_probability=Math.min(1, m_zero_probability);
	
	return m_zero_probability;
}

public double m_calculate_n_probability(double arrival_rate, double number_servers, double service_rate, double total_buffer_capacity,double n)
{
	double m_n_prob=0;
	double traffic_intensity=calculate_traffic_intensity(arrival_rate, number_servers, service_rate, total_buffer_capacity);
	double m_zero_prob=m_calculate_zero_probability(arrival_rate, number_servers, service_rate, total_buffer_capacity);
	if((n>=0)&&(n<number_servers))
		m_n_prob=(Math.pow((number_servers*traffic_intensity), n)*m_zero_prob)/calculate_factorial(n);
	else
		m_n_prob=(Math.pow(number_servers, number_servers)*Math.pow(traffic_intensity, n)*m_zero_prob)/calculate_factorial(number_servers);
	
	if(Double.isNaN(m_n_prob))
		m_n_prob=0;
	m_n_prob=Math.max(0, m_n_prob);
	m_n_prob=Math.min(1, m_n_prob);
	
	return m_n_prob;
	
}

public double m_calculate_queueing_probability(double arrival_rate, double number_servers, double service_rate, double total_buffer_capacity)
{
	double m_queueing_prob=0;
	double traffic_intensity=calculate_traffic_intensity(arrival_rate, number_servers, service_rate, total_buffer_capacity);
	double m_zero_prob=m_calculate_zero_probability(arrival_rate, number_servers, service_rate, total_buffer_capacity);

		m_queueing_prob=(((Math.pow((number_servers*traffic_intensity), number_servers)))/((calculate_factorial(number_servers)*(1-traffic_intensity))))*m_zero_prob;

	
	if(Double.isNaN(m_queueing_prob))
		m_queueing_prob=0;
	m_queueing_prob=Math.max(0, m_queueing_prob);
	m_queueing_prob=Math.min(1, m_queueing_prob);
	
	return m_queueing_prob;
	
}
public double m_calculate_buffer_occupancy(double arrival_rate, double number_servers, double service_rate, double total_buffer_capacity)
{
	double m_buffer_occupied=0;
	
	double traffic_intensity=calculate_traffic_intensity(arrival_rate, number_servers, service_rate, total_buffer_capacity);
	double m_queueing_prob=m_calculate_queueing_probability(arrival_rate, number_servers, service_rate, total_buffer_capacity);

	m_buffer_occupied=(number_servers*traffic_intensity);
	if(traffic_intensity!=1)
		m_buffer_occupied=m_buffer_occupied	+((traffic_intensity*m_queueing_prob)/(1-traffic_intensity));
	if(Double.isNaN(m_buffer_occupied))
		m_buffer_occupied=0;
	m_buffer_occupied=Math.max(0, m_buffer_occupied);
	
	return m_buffer_occupied;
}
public double m_calculate_gateway_processing_efficiency(double arrival_rate, double number_servers, double service_rate, double total_buffer_capacity)
{
	double m_utilisation=0;
	double traffic_intensity=calculate_traffic_intensity(arrival_rate, number_servers, service_rate, total_buffer_capacity);

	
	m_utilisation=traffic_intensity;
	
if(Double.isNaN(m_utilisation))
		m_utilisation=0;
	m_utilisation=Math.max(0, m_utilisation);
	m_utilisation=Math.min(1, m_utilisation);
			
	return m_utilisation;
}
}
