package com.mindskip.zxks.service;

import com.mindskip.zxks.domain.ExamPaper;
import com.mindskip.zxks.domain.User;
import com.mindskip.zxks.viewmodel.admin.exam.ExamPaperEditRequestVM;
import com.mindskip.zxks.viewmodel.admin.exam.ExamPaperPageRequestVM;
import com.mindskip.zxks.viewmodel.student.dashboard.PaperFilter;
import com.mindskip.zxks.viewmodel.student.dashboard.PaperInfo;
import com.mindskip.zxks.viewmodel.student.exam.ExamPaperPageVM;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ExamPaperService extends BaseService<ExamPaper> {

    PageInfo<ExamPaper> page(ExamPaperPageRequestVM requestVM);

    PageInfo<ExamPaper> taskExamPage(ExamPaperPageRequestVM requestVM);

    PageInfo<ExamPaper> studentPage(ExamPaperPageVM requestVM);

    ExamPaper savePaperFromVM(ExamPaperEditRequestVM examPaperEditRequestVM, User user);

    ExamPaperEditRequestVM examPaperToVM(Integer id);

    List<PaperInfo> indexPaper(PaperFilter paperFilter);

    Integer selectAllCount();

    List<Integer> selectMothCount();
}
