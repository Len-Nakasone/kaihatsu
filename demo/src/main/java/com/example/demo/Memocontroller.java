  package com.example.demo;
 
  import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jakarta.websocket.server.PathParam;
   
  @Controller
  public class Memocontroller {
    static ArrayList<ArrayList> data = new ArrayList<ArrayList>();
    static final int max = 10;
   
    // メモにGETアクセス
    @RequestMapping("/memo")
    public ModelAndView index(ModelAndView mv) {
      mv.setViewName("Memo");
      mv.addObject("title", "Todo");
      mv.addObject("data", Memocontroller.data);
      return mv;
    }
     
    // メモのフォーム送信
    @RequestMapping(value="/memoed", method=RequestMethod.POST)
    public String form(@PathParam("memo") String memo) {
    	System.out.println(memo);
      ArrayList list = new ArrayList();
      list.add(memo);
      list.add(Calendar.getInstance().getTime());
      data.add(0, list);
      if (data.size() > max) {
        data.remove(max);
      }
      return "redirect:/memo";
      
    }
  } 
