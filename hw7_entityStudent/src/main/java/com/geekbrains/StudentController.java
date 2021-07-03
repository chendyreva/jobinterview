package com.geekbrains;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller("MainController")
@RequestMapping("/admin")
public class StudentController {

    @Setter(onMethod = @__(@Autowired))
    private SpringDataRepositoryScanner repositoryScanner;

    public StudentController(SpringDataRepositoryScanner repositoryScanner) {
        this.repositoryScanner = repositoryScanner;
    }


    @GetMapping
    public String showEntityClassList(Model model) {

        model.addAttribute("entityNamesClass", repositoryScanner.getEntityNamesClass());
        return "entity-class-list";
    }

    @GetMapping("/entity-example-list")
    public String showEntityExampleList(Model model,
                                         @RequestParam String entityNameClass) {
        CrudRepository repository = repositoryScanner.getRepository(entityNameClass);
        if (repository != null) {
            List<EntityExampleReflection> entityExampleReflections = EntityExampleReflection.getAllExamples(repository);
            model.addAttribute("entityExamples", entityExampleReflections);
        }

        return "entity-example-list";
    }
}
