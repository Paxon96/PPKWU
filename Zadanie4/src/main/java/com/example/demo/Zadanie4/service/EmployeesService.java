package com.example.demo.Zadanie4.service;

import com.example.demo.Zadanie4.resource.Employee;
import com.example.demo.Zadanie4.util.Base64Coder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeesService {

    @Autowired
    private Environment environment;
    @Autowired
    private Base64Coder base64Coder;

    public List<Employee> getEmployees(String searchingString) throws IOException {
        Document document = Jsoup.connect(environment.getProperty("apiUrl") + URLEncoder.encode((searchingString), StandardCharsets.UTF_8.toString())).get();
        Elements employeesFromDocument = document.select(".user-profile-container");
        List<Employee> employees = new ArrayList<>();
        employeesFromDocument.forEach(employee -> employees.add(Employee.builder()
                .name(employee.selectFirst(".user-info").selectFirst("h3").text())
                .academicDegree(employee.selectFirst(".user-info").selectFirst("h4").text())
                .organization(employee.selectFirst(".user-info").selectFirst(".item-content").text())
                .avatar(employee.selectFirst(".user-image-container").select("img").attr("src"))
                .vCardLink("/vcard/" + base64Coder.base64Encode(employee.selectFirst("h3").text()+"\n"+employee.selectFirst(".item-content").text()+"\n"+employee.selectFirst(".user-info").selectFirst("h4").text()))
                .build()));
        return employees;
    }

}
