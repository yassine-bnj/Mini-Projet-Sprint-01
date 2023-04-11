package com.example.livres.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.livres.entities.Livre;
import com.example.livres.entities.TypeLivre;
import com.example.livres.service.LivreService;
import com.example.livres.service.TypeService;


@Controller
public class LivreController {
@Autowired
LivreService livreService;
@Autowired
TypeService typeService;


@RequestMapping("/showCreate")
public String showCreate(ModelMap modelMap)
{
	List<TypeLivre> types=typeService.getAllTypes();
	modelMap.addAttribute("types",types);
	
return "createLivre";
}
@RequestMapping("/saveLivre")
public String saveProduit(@ModelAttribute("livre") Livre livre,
 @RequestParam("dateP") String date,
 ModelMap modelMap,RedirectAttributes redirectAttributes) throws
ParseException
{
//conversion de la date
 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
 Date dateParution = dateformat.parse(String.valueOf(date)); 
 livre.setDateParution(dateParution);
 
 

 Livre saveLivre = livreService.saveLivre(livre);

 //redirectAttributes.addAttribute("page", 1);

 
return "redirect:/ListeLivres";
}

@RequestMapping("/ListeLivres")
public String listeLivres(ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "4") int size)
{
Page<Livre> livres = livreService.getAllLivresParPage(page, size);
modelMap.addAttribute("livres", livres);
 modelMap.addAttribute("pages", new int[livres.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
return "listeLivres";
}



@RequestMapping("/supprimerLivre")
public String supprimerLivre(@RequestParam("id") Long id,
ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "4") int size)
{
livreService.deleteLivreById(id);
Page<Livre> livres = livreService.getAllLivresParPage(page,size);
modelMap.addAttribute("livres", livres);
modelMap.addAttribute("pages", new int[livres.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
modelMap.addAttribute("size", size);
return "listeLivres";
}


@RequestMapping("/modifierLivre")
public String editerProduit(@RequestParam("id") Long id,ModelMap modelMap)
{
Livre l= livreService.getLivre(id);
modelMap.addAttribute("livre", l);
List<TypeLivre> types=typeService.getAllTypes();
modelMap.addAttribute("types",types);
return "editerLivre";
}
@RequestMapping("/updateLivre")
public String updateProduit(@ModelAttribute("livre") Livre livre,
@RequestParam("dateP") String date,ModelMap modelMap) throws ParseException
{
//conversion de la date
 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
 Date setDateParution = dateformat.parse(String.valueOf(date));
 livre.setDateParution(setDateParution);

 livreService.updateLivre(livre);
 List<Livre> livres = livreService.getAllLivres();
 modelMap.addAttribute("livres", livres);
 return "redirect:/ListeLivres";
}


}
