package dev.be.moduleapi.service;

import dev.be.modulecommon.domain.Member;
import dev.be.modulecommon.enums.CodeEnum;
import dev.be.modulecommon.repository.MemberRepository;
import dev.be.modulecommon.service.CommonDemoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DemoService {

    @Value("${profile-name}")
    private String name;

    private final CommonDemoService commonDemoService;
    private final MemberRepository memberRepository;

    public String save() {
        log.info("name: " + name);

        if (name == "local") {
            // AAA
        } else if (name == "beta") {
            // BBB
        }

        log.info(CodeEnum.SUCCESS.getCode());
        log.info(commonDemoService.commonService());

        memberRepository.save(
                Member.builder()
                        .name(Thread.currentThread().getName())
                        .build()
        );

        return "save";
    }

    public String find() {
        int size = memberRepository.findAll().size();

        log.info("Member size: " + size);
        return "find";
    }

    public String exception() {
        return "exception";
    }
}
