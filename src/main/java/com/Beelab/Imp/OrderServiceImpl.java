package com.Beelab.Imp;

import org.springframework.stereotype.Service;

import com.Beelab.Service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
//	@Autowired
//	OrderDAO dao;
//
//	@Autowired
//	OrderDetailDAO ddao;
//
//	@Override
//	public Order create(JsonNode orderData) {
//
//		ObjectMapper mapper = new ObjectMapper();
//
//		Order order = mapper.convertValue(orderData, Order.class);
//		dao.save(order);
//
//		TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {};
//		List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"), type)
//				.stream().peek(d -> d.setOrder(order)).collect(Collectors.toList());
//		ddao.saveAll(details);
//
//		return order;
//
//	}
//
//	@Override
//	public Order findById(Long id) {
//		return dao.findById(id).get();
//	}
//
//	@Override
//	public List<Order> findByUsername(String username) {
//		return dao.findByUsername(username);
//	}
}
