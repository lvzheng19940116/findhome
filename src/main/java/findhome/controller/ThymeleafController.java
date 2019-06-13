package findhome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 以动手实践为荣,以只看不练为耻.
 * 以打印日志为荣,以出错不报为耻.
 * 以局部变量为荣,以全局变量为耻.
 * 以单元测试为荣,以手工测试为耻.
 * 以代码重用为荣,以复制粘贴为耻.
 * 以多态应用为荣,以分支判断为耻.
 * 以定义常量为荣,以魔法数字为耻.
 * 以总结思考为荣,以不求甚解为耻.
 *
 * @author LvZheng
 * 创建时间：2019/6/10 下午7:59
 */
@Controller
public class ThymeleafController {

    @GetMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("name", "吕正");
        return "/index";
    }

    @GetMapping("/404")
    public String not() {
        return "/404";
    }

    @GetMapping("/403")
    public String permission() {
        return "/403";
    }

    @GetMapping("/500")
    public String error() {
        return "/500";
    }


    @GetMapping("/logout/page")
    public String logout() {
        return "/logout";
    }
}

