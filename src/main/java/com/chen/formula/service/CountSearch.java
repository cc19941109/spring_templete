package com.chen.formula.service;

import com.chen.formula.dto.SearchDto;

public interface CountSearch {
	/**
	 * 
	 * @param searchDto
	 * @return
	 */
	Long getCount(SearchDto searchDto);

	/**
	 * 
	 * @param searchDto
	 * @param pastYear
	 * @return
	 */
	Long getCount(SearchDto searchDto, Integer pastYear);

}
