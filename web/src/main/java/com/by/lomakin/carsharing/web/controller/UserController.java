package com.by.lomakin.carsharing.web.controller;

import com.by.lomakin.carsharing.dao.api.filter.UserDataFilter;
import com.by.lomakin.carsharing.dao.api.model.IUserData;
import com.by.lomakin.carsharing.service.IUserDataService;
import com.by.lomakin.carsharing.web.converter.UserFromDtoConverter;
import com.by.lomakin.carsharing.web.converter.UserToDtoConverter;
import com.by.lomakin.carsharing.web.dto.UserDTO;
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
@RequestMapping(value = "/user")
public class UserController extends AbstractController<UserDTO, UserDataFilter> {

    @Autowired
    private IUserDataService userService;

    @Autowired
    private UserFromDtoConverter fromDtoConverter;

    @Autowired
    private UserToDtoConverter toDtoConverter;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(final HttpServletRequest req,
            @RequestParam(name = "page", required = false) final Integer pageNumber,
            @RequestParam(name = "sort", required = false) final String sortColumn) {

        final ListDTO<UserDTO> listDTO = getListDTO(req);
        listDTO.setPage(pageNumber);
        listDTO.setSort(sortColumn);

        final UserDataFilter filter = new UserDataFilter();
        applySortAndOrder2Filter(listDTO, filter);

        listDTO.setTotalCount(userService.getCount(filter));

        applySortAndOrder2Filter(listDTO, filter);
        final List<IUserData> entities = userService.find(filter);
        listDTO.setList(
                entities.stream().map(toDtoConverter).collect(Collectors.toList()));

        final HashMap<String, Object> models = new HashMap<>();
        models.put(ListDTO.SESSION_ATTR_NAME, listDTO);
        return new ModelAndView("user.list", models);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView showForm() {

        final HashMap<String, Object> hashMap = new HashMap<>();
        final IUserData newEntity = userService.createEntity();
        hashMap.put("formModel", toDtoConverter.apply(newEntity));

        return new ModelAndView("user.edit", hashMap);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object save(@Valid @ModelAttribute("formModel") final UserDTO formModel,
            final BindingResult result) throws Exception {
        if (result.hasErrors()) {
            final Map<String, Object> hashMap = new HashMap<>();
            hashMap.put("formModel", formModel);
            return new ModelAndView("user.edit", hashMap);
        } else {
            final IUserData entity = fromDtoConverter.apply(formModel);
            if (entity.getRole() == null) {
                entity.setRole("ROLE_USER");
            }
            userService.save(entity);
            return "redirect:/user";
        }
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable(name = "id", required = true) final Integer id) {
        userService.delete(id);
        return "redirect:/user";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView viewDetails(
            @PathVariable(name = "id", required = true) final Integer id) {
        final IUserData dbModel = userService.get(id);
        final UserDTO dto = toDtoConverter.apply(dbModel);
        final HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("formModel", dto);
        hashMap.put("readonly", true);

        return new ModelAndView("user.edit", hashMap);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public ModelAndView edit(
            @PathVariable(name = "id", required = true) final Integer id) {
        final UserDTO dto = toDtoConverter.apply(userService.get(id));

        final HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("formModel", dto);

        return new ModelAndView("user.edit", hashMap);
    }

}
