package com.by.lomakin.carsharing.web.controller;

import com.by.lomakin.carsharing.dao.api.filter.CarFilter;
import com.by.lomakin.carsharing.dao.api.model.ICar;
import com.by.lomakin.carsharing.service.ICarService;
import com.by.lomakin.carsharing.web.converter.CarFromDtoConverter;
import com.by.lomakin.carsharing.web.converter.CarToDtoConverter;
import com.by.lomakin.carsharing.web.dto.CarDTO;
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
@RequestMapping(value = "/car")
public class CarController extends AbstractController<CarDTO, CarFilter> {

    @Autowired
    private ICarService carService;

    @Autowired
    private CarFromDtoConverter fromDtoConverter;

    @Autowired
    private CarToDtoConverter toDtoConverter;

    @RequestMapping(method = { RequestMethod.POST, RequestMethod.GET })
    public ModelAndView index(final HttpServletRequest req,
            @RequestParam(name = "page", required = false) final Integer pageNumber,
            @RequestParam(name = "sort", required = false) final String sortColumn) {

        final ListDTO<CarDTO> listDTO = getListDTO(req);
        listDTO.setPage(pageNumber);
        listDTO.setSort(sortColumn);

        final CarFilter filter = new CarFilter();

        applySortAndOrder2Filter(listDTO, filter);
        listDTO.setTotalCount(carService.getCount(filter));

        final List<ICar> entities = carService.find(filter);
        listDTO.setList(
                entities.stream().map(toDtoConverter).collect(Collectors.toList()));

        final HashMap<String, Object> models = new HashMap<>();
        models.put(ListDTO.SESSION_ATTR_NAME, listDTO);
        return new ModelAndView("car.list", models);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView showForm() {

        final HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("formModel", new CarDTO());
        return new ModelAndView("car.edit", hashMap);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object save(@Valid @ModelAttribute("formModel") final CarDTO formModel,
            final BindingResult result) throws Exception {
        if (result.hasErrors()) {
            final Map<String, Object> hashMap = new HashMap<>();
            hashMap.put("formModel", formModel);
            return new ModelAndView("car.edit", hashMap);
        } else {
            final ICar entity = fromDtoConverter.apply(formModel);
            carService.save(entity);
            return "redirect:/car";
        }
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable(name = "id", required = true) final Integer id) {
        carService.delete(id);
        return "redirect:/car";
    }

    @RequestMapping(value = "/{id}", method = { RequestMethod.POST, RequestMethod.GET })
    public ModelAndView viewDetails(
            @PathVariable(name = "id", required = true) final Integer id) {
        final ICar dbModel = carService.get(id);
        final CarDTO dto = toDtoConverter.apply(dbModel);
        final HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("formModel", dto);
        return new ModelAndView("car.info", hashMap);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public ModelAndView edit(
            @PathVariable(name = "id", required = true) final Integer id) {
        final CarDTO dto = toDtoConverter.apply(carService.get(id));

        final HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("formModel", dto);
        return new ModelAndView("car.edit", hashMap);
    }

}
