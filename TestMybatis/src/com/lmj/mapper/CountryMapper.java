package com.lmj.mapper;

import java.util.List;

import com.lmj.bean.Country;
import com.lmj.bean.CountryVo;

public interface CountryMapper {
	List<Country> selectAll();
	
	List<CountryVo> selectAllCountryVo();
}
