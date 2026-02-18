package com.mindskip.zxks.controller.wx;

import com.mindskip.zxks.context.WxContext;
import com.mindskip.zxks.domain.User;
import com.mindskip.zxks.domain.UserToken;
import com.mindskip.zxks.utility.ModelMapperSingle;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseWXApiController {
    protected final static ModelMapper modelMapper = ModelMapperSingle.Instance();
    @Autowired
    private WxContext wxContext;

    protected User getCurrentUser() {
        return wxContext.getCurrentUser();
    }

    protected UserToken getUserToken() {
        return wxContext.getCurrentUserToken();
    }
}
