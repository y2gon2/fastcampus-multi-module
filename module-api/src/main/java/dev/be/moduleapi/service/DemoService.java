package dev.be.moduleapi.service;


import dev.be.modulecommon.enums.CodeEnum;
import dev.be.modulecommon.service.CommonDemoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DemoService {

    private final CommonDemoService commonDemoService;

    public String save() {
        log.info(CodeEnum.SUCCESS.getCode());
        log.info(commonDemoService.commonService());
        return "save";
    }

    public String find() {
        return "find";
    }
}
