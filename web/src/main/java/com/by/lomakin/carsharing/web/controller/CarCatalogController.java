package com.by.lomakin.carsharing.web.controller;

import com.by.lomakin.carsharing.dao.api.filter.CarCatalogFilter;
import com.by.lomakin.carsharing.dao.api.model.ICarCatalog;
import com.by.lomakin.carsharing.service.ICarCatalogService;
import com.by.lomakin.carsharing.web.converter.CarCatalogFromDtoConverter;
import com.by.lomakin.carsharing.web.converter.CarCatalogToDtoConverter;
import com.by.lomakin.carsharing.web.dto.CarCatalogDTO;
import com.by.lomakin.carsharing.web.util.ListDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/carcatalog")
public class CarCatalogController extends AbstractController<CarCatalogDTO, CarCatalogFilter> {

	@Autowired
	private ICarCatalogService carCatalogService;

	@Autowired
	private CarCatalogFromDtoConverter fromDtoConverter;

	@Autowired
	private CarCatalogToDtoConverter toDtoConverter;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(final HttpServletRequest req,
			@RequestParam(name = "page", required = false) final Integer pageNumber,
			@RequestParam(name = "sort", required = false) final String sortColumn) {

		final ListDTO<CarCatalogDTO> listDTO = getListDTO(req);
		listDTO.setPage(pageNumber);
		listDTO.setSort(sortColumn);

		final CarCatalogFilter filter = new CarCatalogFilter();
		applySortAndOrder2Filter(listDTO, filter);

		listDTO.setTotalCount(carCatalogService.getCount(filter));

		applySortAndOrder2Filter(listDTO, filter);
		final List<ICarCatalog> entities = carCatalogService.find(filter);
		listDTO.setList(entities.stream().map(toDtoConverter).collect(Collectors.toList()));

		final HashMap<String, Object> models = new HashMap<>();
		models.put(ListDTO.SESSION_ATTR_NAME, listDTO);
		return new ModelAndView("carcatalog.list", models);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView showForm() {

		final HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("formModel", new CarCatalogDTO());

		return new ModelAndView("carcatalog.edit", hashMap);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Object save(@Valid @ModelAttribute("formModel") final CarCatalogDTO formModel, final BindingResult result)
			throws Exception {
		if (result.hasErrors()) {
			final Map<String, Object> hashMap = new HashMap<>();
			hashMap.put("formModel", formModel);
			return new ModelAndView("carcatalog.edit", hashMap);
		} else {
			final ICarCatalog entity = fromDtoConverter.apply(formModel);
			carCatalogService.save(entity);
			return "redirect:/carcatalog";
		}
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable(name = "id", required = true) final Integer id) {
		carCatalogService.delete(id);
		return "redirect:/carcatalog";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView viewDetails(@PathVariable(name = "id", required = true) final Integer id) {
		final ICarCatalog dbModel = carCatalogService.get(id);
		final CarCatalogDTO dto = toDtoConverter.apply(dbModel);
		final HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("formModel", dto);
		hashMap.put("readonly", true);

		return new ModelAndView("carcatalog.edit", hashMap);
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable(name = "id", required = true) final Integer id) {
		final CarCatalogDTO dto = toDtoConverter.apply(carCatalogService.get(id));

		final HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("formModel", dto);

		return new ModelAndView("carcatalog.edit", hashMap);
	}

}
