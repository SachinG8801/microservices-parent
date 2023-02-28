package com.sachin.orderservice.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.sachin.orderservice.dto.OrderLineItemsDto;
import com.sachin.orderservice.dto.OrderRequest;
import com.sachin.orderservice.model.Order;
import com.sachin.orderservice.model.OrderLineItems;
import com.sachin.orderservice.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
	
	private final OrderRepository orderRepository;

	public void placeOrder(OrderRequest orderRequest)
	{
		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		
		List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
		.stream()
		.map(this::mapToDto)
        .toList();
		
		 order.setOrderLineItemsList(orderLineItems);
		 
		
		
	}
	
	private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
	
}
