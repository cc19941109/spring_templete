package com.chen.formula.service;

import com.chen.formula.dto.SearchDto;

public interface ScoreSearch {
	/**
	 * 
	 * @param searchDto
	 * @return
	 */
	double getScore(SearchDto searchDto);
	/**
	 * 
	 * @param searchDto
	 * @param pastYear
	 * @return
	 */
	double getScore(SearchDto searchDto,Integer pastYear);
	
}

