package pl.coderslab.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    /**
     * Dashboard site
     *
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String home(Model model) {
        return "home";
    }

}
