package com.example.springmedico.Controller;

import com.example.springmedico.Modelo.Medico;
import com.example.springmedico.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Controller
public class MedicoController {


    MedicoService medicoService;

    @Autowired
    public void setMedicoService(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @RequestMapping("/")
    public String getHome(Model model){
        List<Medico> medicoList = medicoService.findAll();
        model.addAttribute("medicoList",medicoList);
        return "index";
    }

    @RequestMapping("/cadastrar")
     public String getPaginaCadastro(Model model){
        var medico = new Medico();
        model.addAttribute("medico",medico);
         return "/cadastrar";
     }

//model atribute pega o objeto do front medico
     @RequestMapping("/salvar")
    public String addMedico(@ModelAttribute @Valid Medico medico, Errors errors ){

        if (errors.hasErrors()){
            return "/cadastrar";
        }else
        {
            medicoService.add(medico);
            return "redirect:/";
        }
     }
    //pagina andviewmodel pq precisa pasaar um model ja tualizando a wiel de inico
     @RequestMapping("/editar/{id}")
     public ModelAndView editMedico(@PathVariable(name = "id") Long id){
        var modelAndView = new ModelAndView("/editar");
        var medico = medicoService.buscarId(id);
        modelAndView.addObject("medico",medico);
        return modelAndView;
     }

     @RequestMapping("/deletar/{id}")
        public String deletarMedico(@PathVariable(name = "id") Long id){
            medicoService.deleteMedico(id);
            return "redirect:/";
        }
        @RequestMapping("/deletarpNome")
        public String deleteNome(){return "/deletarpNome";}

        @RequestMapping("/deletarNome")
        public String deletarNome( String nome, ModelMap model){


            var pagina = "redirect:/";
            var medicos = medicoService.findAll();
             AtomicBoolean flag= new AtomicBoolean(false);
            medicos.forEach(medico -> {
                if(medico.getNome().equals(nome)){
                    flag.set(true);
                }
            });
            boolean val = flag.get();

            if(val){
                medicoService.deletarPorNome(nome.toString());
            }
            else{
                System.out.println("nome não existe");

                Medico m = new Medico();
                m.setNome("não existe nome");
                model.addAttribute("msg","o nome"+' '+ nome.toString()+' '+" não existe nos dados!");
                pagina = "/deletarpNome";
            }


            return pagina;
        }

        @RequestMapping("/gravarCookie")
        public  String GravaCookies(HttpServletResponse response){

            Cookie c = new Cookie("nome","marcos");
            response.addCookie(c);
        return "/cookies";
        }
        @RequestMapping("/lerCookie")
        public String LerCookie(@CookieValue(value = "nome" ,defaultValue = "taniro") String nome,ModelMap model){
            System.out.println(nome.toString());
            model.addAttribute("nome",nome);
        return  "/cookies";
        }
}
