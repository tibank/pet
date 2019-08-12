package com.epam.rd.spring2019.pet.Utils;

import com.epam.rd.spring2019.pet.web.dtos.FilterProductDto;
import com.epam.rd.spring2019.pet.web.dtos.UserCreateDto;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class UtilsServlet {

    public static Map<String, String> getRequestParams(HttpServletRequest request) {
        Map<String, String> resultMap = new HashMap<>();

        Enumeration paramsName = request.getParameterNames();

        while (paramsName.hasMoreElements()) {
            String key = (String) paramsName.nextElement();
            String value = request.getParameter(key);
            resultMap.put(key, value);
        }

        return resultMap;
    }

    public static UserCreateDto extractUserFromRequest(HttpServletRequest req) {
        String email = req.getParameter("email").trim();
        String password = req.getParameter("password").trim();
        String firstName = req.getParameter("firstname").trim();
        String lastName = req.getParameter("lastname").trim();
        String sex = req.getParameter("sex").trim();
        String birthDay = req.getParameter("birthday").trim();

        return new UserCreateDto(firstName, lastName, sex, birthDay, email, password);
    }

    public static FilterProductDto extractFilterFromRequest(HttpServletRequest req) {
        String minPrice = req.getParameter("minprice");
        String maxPrice = req.getParameter("maxprice");
        List<String> listProductsId = getProductsId(req);

        FilterProductDto filterProductDto = new FilterProductDto();
        filterProductDto.setMinPrice(minPrice);
        filterProductDto.setMaxPrice(maxPrice);
        filterProductDto.setCategoriesId(listProductsId);

        return filterProductDto;
    }

    private static List<String> getProductsId(HttpServletRequest req) {
        List<String> parameterNames = new ArrayList<String>();
        Enumeration enumeration = req.getParameterNames();
        while (enumeration.hasMoreElements()) {
            String parameterName = (String) enumeration.nextElement();
            if (parameterName.startsWith("option")) {
                parameterNames.add(req.getParameter(parameterName));
            }
        }
        return parameterNames;
    }

}
