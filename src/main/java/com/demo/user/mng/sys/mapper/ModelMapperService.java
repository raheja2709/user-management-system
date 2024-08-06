package com.demo.user.mng.sys.mapper;

import java.util.*;

public interface ModelMapperService {

	public <T> T convertToType(Object source, Class<T> resultClass);

	public <T, D> List<D> convertListEntityToListDto(List<T> list, Class<D> convertInto);

}
