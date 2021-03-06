/*
 * Created on 3 avr. 2014 ( Time 19:39:49 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.demo.rest.controller;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.demo.bean.Country;
import org.demo.business.service.CountryService;
import org.demo.web.listitem.CountryListItem;

/**
 * Spring MVC controller for 'Country' management.
 */
@Controller
public class CountryRestController {

	@Resource
	private CountryService countryService;
	
	@RequestMapping( value="/items/country",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<CountryListItem> findAllAsListItems() {
		List<Country> list = countryService.findAll();
		List<CountryListItem> items = new LinkedList<CountryListItem>();
		for ( Country country : list ) {
			items.add(new CountryListItem( country ) );
		}
		return items;
	}
	
	@RequestMapping( value="/country",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Country> findAll() {
		return countryService.findAll();
	}

	@RequestMapping( value="/country/{code}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Country findOne(@PathVariable("code") String code) {
		return countryService.findById(code);
	}
	
	@RequestMapping( value="/country",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Country create(@RequestBody Country country) {
		return countryService.create(country);
	}

	@RequestMapping( value="/country/{code}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Country update(@PathVariable("code") String code, @RequestBody Country country) {
		return countryService.update(country);
	}

	@RequestMapping( value="/country/{code}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("code") String code) {
		countryService.delete(code);
	}
	
}
