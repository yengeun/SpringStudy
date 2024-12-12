package com.mysite.todo;

import java.util.List;
import java.util.Map;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class ToDoController {

    private final ToDoService toDoService;

    // 투두 리스트 조회
    @RequestMapping("/todo")
    public String list(Model model) {
        List<ToDoEntity> toDoEntityList = this.toDoService.getList();
        model.addAttribute("toDoEntityList", toDoEntityList);
        return "todolist";
    }

    // 루트 페이지 리다이렉션
    @RequestMapping("/")
    public String root() {
        return "redirect:/todo";
    }

    // 새로운 투두 항목 생성
    @PostMapping("/todo/create")
    public String todoCreate(@RequestParam String content) {
        this.toDoService.create(content);
        return "redirect:/todo";
    }

    // 투두 항목 삭제
    @DeleteMapping("/todo/delete/{id}")
    public ResponseEntity<Void> todoDelete(@PathVariable Integer id) {
        this.toDoService.delete(id);
        return ResponseEntity.ok().build(); // 성공 응답 반환
    }

    // 수행 여부 업데이트
    @PutMapping("/todo/update/{id}")
    public ResponseEntity<Void> updateStatus(@PathVariable Integer id, @RequestBody Map<String, Boolean> request) {
        Boolean completed = request.get("completed");
        this.toDoService.updateStatus(id, completed);
        return ResponseEntity.ok().build(); // 성공 응답 반환
    }
}
