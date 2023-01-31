package org.testjetty;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.model.Country;
import org.model.ErrorMessage;
import org.repositories.CountryRepository;

import java.io.IOException;
import java.util.Map;

public class BlockingServlet extends HttpServlet {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static final Map<String, Country> countries = Map.ofEntries(
            Map.entry("/france", new Country("France", "Paris", 65.5)),
            Map.entry("/russia", new Country("Russia", "Moscow", 145.1))
    );

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        response.setContentType("application/json");
        response.setHeader("Access-Control-Allow-Origin", "*");

        String path = request.getPathInfo();
        Country country = countries.get(path);
        //Country country = CountryRepository.getCountry(path.substring(1));
        if (country == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().println(
                    objectMapper.writeValueAsString(new ErrorMessage("country not found"))
            );
        } else {
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().println(
                    objectMapper.writeValueAsString(country)
            );
        }
    }
}
