package cn.hcq413.web.service_impl;

import cn.hcq413.web.domain.Items;
import cn.hcq413.web.mapper.ItemsMapper;
import cn.hcq413.web.service.itemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class itemServiceImpl implements itemService {

    @Autowired
    ItemsMapper itemsMapper;

    @Override
    public List<Items> getAll() {
        return itemsMapper.selectAll();
    }
}
