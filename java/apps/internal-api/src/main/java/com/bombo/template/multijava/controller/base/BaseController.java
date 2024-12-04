package com.bombo.template.multijava.controller.base;

import com.bombo.template.multijava.usecase.AppUseCase;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    private final AppUseCase appUseCase;

    public BaseController(AppUseCase appUseCase) {
        this.appUseCase = appUseCase;
    }
}
