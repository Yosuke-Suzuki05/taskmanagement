package com.example.demo.controller;

import java.util.List;
import java.util.Locale;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.user.model.MTask;
import com.example.demo.domain.user.service.TaskService;
import com.example.demo.form.GroupOrder;
import com.example.demo.form.TaskDetailForm;
import com.example.demo.form.TaskRegisterForm;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private ModelMapper modelMapper;

    // タスク一覧画面を表示
    @GetMapping("/tasklist")
    public String getTaskList(Model model) {
        List<MTask> taskList = taskService.getTasks();
        model.addAttribute("tasklist", taskList);
        model.addAttribute("totalTasks", taskList.size());
        return "tasklist";
    }

    // タスク詳細画面を表示
    @GetMapping("task/detail/{taskId:.+}")
    public String getTaskDetail(@PathVariable("taskId") String taskId, TaskDetailForm form, Model model) {
        MTask task = taskService.getTask(taskId);
        form = modelMapper.map(task, TaskDetailForm.class);
        model.addAttribute("taskDetailForm", form);
        return "taskdetail";
    }

    // タスク登録画面を表示
    @GetMapping("task/taskregister")
    public String getTaskRegister(@ModelAttribute TaskRegisterForm form, Model model, Locale locale) {
        return "taskregister";
    }

    // タスク登録処理
    @PostMapping("task/taskregister")
    public String registerTask(@ModelAttribute @Validated(GroupOrder.class) TaskRegisterForm form, BindingResult bindingResult, Model model, Locale locale) {
        if (bindingResult.hasErrors()) {
            return "taskregister";
        }
        MTask task = modelMapper.map(form, MTask.class);
        taskService.registerTask(task);
        return "redirect:/tasklist";
    }

    // タスク更新処理
    @PostMapping(value = "task/detail", params="update")
    public String updateTask(TaskDetailForm form, Model model) {
        taskService.updateTask(form.getTaskId(), form.getTitle(), form.getTaskId());
        return "redirect:/tasklist";
    }

    // タスク削除処理
    @PostMapping(value = "task/detail", params="delete")
    public String deleteTask(TaskDetailForm form, Model model) {
        taskService.deleteTask(form.getTaskId());
        return "redirect:/tasklist";
    }
}