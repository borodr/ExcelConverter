package com.converter.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.converter.Model.Roba;
import com.converter.Repository.RobaRepository;

@Service
public class RobaService {

	
	private final RobaRepository robarep;
	
	@Autowired
	public RobaService(RobaRepository robarep) {
		this.robarep = robarep;
	}
	
	
	public List<Roba> findAll(int offset, int limit, Map<String, Boolean> sortOrders) {
        int page = offset / limit;
        List<Sort.Order> orders = sortOrders.entrySet().stream()
                .map(e -> new Sort.Order(e.getValue() ? Sort.Direction.ASC : Sort.Direction.DESC, e.getKey()))
                .collect(Collectors.toList());

        PageRequest pageRequest = new PageRequest(page, limit, orders.isEmpty() ? null : new Sort(orders));
        List<Roba> items = robarep.findAll(pageRequest).getContent();
        return items.subList(offset%limit, items.size());
    }
	
	 public Integer count() {
	        return Math.toIntExact(robarep.count());
	 }
	
}
