package com.mindskip.zxks.service;

import com.mindskip.zxks.domain.TaskExam;
import com.mindskip.zxks.domain.User;
import com.mindskip.zxks.viewmodel.admin.task.TaskPageRequestVM;
import com.mindskip.zxks.viewmodel.admin.task.TaskRequestVM;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TaskExamService extends BaseService<TaskExam> {

    PageInfo<TaskExam> page(TaskPageRequestVM requestVM);

    void edit(TaskRequestVM model, User user);

    TaskRequestVM taskExamToVM(Integer id);

    List<TaskExam> getByGradeLevel(Integer gradeLevel);
}
