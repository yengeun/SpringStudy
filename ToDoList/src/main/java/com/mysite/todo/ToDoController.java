package com.mysite.todo;

import java.util.List;
import java.util.Map;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class ToDoController {

    private final ToDoService toDoService;

    @RequestMapping("/todo")
    public String list(Model model){
        List<ToDoEntity> toDoEntityList = this.toDoService.getList();
        model.addAttribute("toDoEntityList",toDoEntityList);
        return "todolist";
    }

    @RequestMapping("/")
    public String root(){
        return "redirect:/todo";
    }

    @PostMapping("/todo/create")
    public String todoCreate(@RequestParam String content){
        this.toDoService.create(content);
        return "redirect:/todo";
    }

    @DeleteMapping("/todo/delete/{id}")
    public String todoDelete(@PathVariable Integer id) {
        this.toDoService.delete(id);
        return "redirect:/todo";
    }

}