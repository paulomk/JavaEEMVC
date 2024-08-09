package com.cestar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import com.cestar.beans.TaxFiler;
import com.cestar.dao.TaxFilerDao;

@Controller
@RequestMapping("/taxFiler")
public class TaxFilerController {
    @Autowired
    private TaxFilerDao taxFilerDao;

    @GetMapping
    public String viewTaxFilers(Model model) {
        List<TaxFiler> taxFilers = taxFilerDao.getAllTaxFilers();
        model.addAttribute("taxFilers", taxFilers);
        return "viewTaxFilers"; // This corresponds to the view (JSP) name
    }

    @PostMapping("/add")
    public String addTaxFiler(@ModelAttribute TaxFiler filer) {
        taxFilerDao.saveTaxFiler(filer);
        return "redirect:/taxFiler"; // Redirect to view all tax filers after adding
    }

    @PostMapping("/update")
    public String updateTaxFiler(@ModelAttribute TaxFiler filer) {
        taxFilerDao.updateTaxFiler(filer);
        return "redirect:/taxFiler"; // Redirect to view all tax filers after updating
    }

    @PostMapping("/delete")
    public String deleteTaxFiler(@RequestParam int filerID) {
        taxFilerDao.deleteTaxFiler(filerID);
        return "redirect:/taxFiler"; // Redirect to view all tax filers after deletion
    }
}
