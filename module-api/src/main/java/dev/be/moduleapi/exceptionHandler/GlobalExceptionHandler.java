package dev.be.moduleapi.exceptionHandler;

import dev.be.moduleapi.exception.CustomException;
import dev.be.moduleapi.response.CommonResponse;
import dev.be.modulecommon.enums.CodeEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // 클래스 레벨에 적용되며, Spring MVC의 컨트롤러에서 발생하는 예외들을 전역적으로 처리하기 위해 사용
public class GlobalExceptionHandler {

    // 어떤 예외 조건만을 처리할 것인지 정의
    @ExceptionHandler(CustomException.class) // 메서드 레벨에 적용되며, 특정 예외 유형을 처리하는 핸들러를 정의할 때 사용
    public CommonResponse handlerCustomException(CustomException e) { // 여기에서 선언한 type 을 해당 예외 발생시 user 에게 반환 ??
        return CommonResponse.builder()                               // client 와 통신 개체로 항상 통일된 type (CommonResponse) 객체를 사용
                .returnCode(e.getReturnCode())
                .returnMessage(e.getReturnMessage())
                .build();
    }

    @ExceptionHandler(Exception.class)
    public CommonResponse handlerExection(Exception e) {
        return CommonResponse.builder()
                .returnCode(CodeEnum.UNKNOWN_ERROR.getCode())
                .returnMessage(CodeEnum.UNKNOWN_ERROR.getMessage())
                .build();
    }
}
