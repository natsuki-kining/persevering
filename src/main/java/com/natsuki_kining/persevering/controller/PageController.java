package com.natsuki_kining.persevering.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面controller
 *
 * @Author : natsuki_kining
 * @Date : 2020/10/24 14:37
 */
@Controller
@RequestMapping("/")
public class PageController {

    @GetMapping()
    public String index() {
        return "/index" ;
    }
}
