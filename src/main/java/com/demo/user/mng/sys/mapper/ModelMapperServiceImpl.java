package com.demo.user.mng.sys.mapper;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelMapperServiceImpl implements ModelMapperService {

	@Autowired
	ModelMapper modelMapper;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T convertToType(Object source, Class<T> resultClass) {
		return modelMapper.map(source, resultClass);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T, D> List<D> convertListEntityToListDto(List<T> list, Class<D> convertInto) {
		return list.stream().map(e -> convertToType(e, convertInto)).toList();
	}

}
