package com.example.fastreachserve.service.business.impl;

import com.example.fastreachserve.mapper.business.BusinessEmployeeMapper;
import com.example.fastreachserve.service.business.BusinessEmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dto.business.BusinessDishPageDTO;
import dto.business.BusinessEmployeePageDTO;
import entity.Dish;
import entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;
import result.PageResult;

import java.util.List;

@Service
@Slf4j
public class BusinessEmployeeServiceImpl implements BusinessEmployeeService {
    @Autowired
    BusinessEmployeeMapper businessEmployeeMapper;

    @Override
    public PageResult page(BusinessEmployeePageDTO businessEmployeePageDTO) {

        PageHelper.startPage(1,10);
        List<Employee> page = businessEmployeeMapper.page(businessEmployeePageDTO);
        PageInfo<Employee> pageInfo = new PageInfo<Employee>(page);
        log.info("fef{}",pageInfo.getSize());
        return new PageResult(pageInfo.getTotal(), pageInfo.getList());

    }
//    @Override
//    public void delete()
//    {
//        BusinessEmployeeMapper.delete(ids);
//    }


}