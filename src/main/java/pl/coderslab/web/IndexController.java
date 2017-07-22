package pl.coderslab.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @RequestMapping("/content")
    public String content(Model model){
        return "content";
    }


    @RequestMapping("/")
    public String home(Model model){
        return "home";
    }

    @RequestMapping(value = "/import", method = RequestMethod.GET)
    public String importRepo(Model model){
        return "import";
    }

    @RequestMapping(value = "/import", method = RequestMethod.POST)
    public String importRepoSubmit(Model model){

        return "import";
    }

    @RequestMapping(value = "/testApi")
    public String testApi(Model model){

        return "testApi";
    }

}
