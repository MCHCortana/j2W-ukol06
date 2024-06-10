package cz.czechitas.java2webapps.ukol6.controller;

import cz.czechitas.java2webapps.ukol6.entity.Vizitka;
import cz.czechitas.java2webapps.ukol6.repository.VizitkaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class VizitkyController {

    private final VizitkaRepository vizitkaRepository;

    public VizitkyController(VizitkaRepository vizitkaRepository) {
        this.vizitkaRepository = vizitkaRepository;
    }

    @InitBinder
    public void nullStringBinding(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @GetMapping("/")
    public ModelAndView seznam() {
        return new ModelAndView("seznam")
                .addObject("seznamVizitek", vizitkaRepository.findAll());
    }

    @GetMapping("/vizitka/{id}")
    public ModelAndView detail(Long id) {
        Optional<Vizitka> jednaVizitka = vizitkaRepository.findById(id);
        if (jednaVizitka.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return new ModelAndView("/vizitka")
                .addObject("jednavizitka", jednaVizitka.get());
    }

    @GetMapping("/novaVizitka")
    public ModelAndView nova() {
        return new ModelAndView("formular").
                addObject("vizitka", new Vizitka());
    }
    @PostMapping("/novaVizitka")
    public String pridat(@ModelAttribute("vizitka") @Valid Vizitka vizitka, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "formular";
        }
        vizitka.setId(null);
        vizitkaRepository.save(vizitka);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteVizitka(Long id) {
        vizitkaRepository.deleteById(id + 1);
        return "redirect:/";
    }


}
