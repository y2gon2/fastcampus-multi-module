package dev.be.moduleapi.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import dev.be.modulecommon.enums.CodeEnum;
import lombok.*;

// transaction 이 발생하는 객체에 대해서는 해당 객체를 생성할 수 있는 최대한 모든 조건을 고려하여 생성자를 미리 구현해 놓는다.
// annotation 을 사용하여 기본적으로 각각의 독립된 field 값을 모두 던지는 경우, parameter 없이 그냥 객체만 생성하는 경우는 대체 구현 가능
// 그 밖의 생성자는 내부 구현을 진행
//
// Builder pattern 을 적용한 객체 생성 예시
// CommonResponse response = CommonResPonse.builde()
//              .returnCode("0000")
//              .returnMessage("SUCCESS")
//              .info(info)
//              .build();
@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL) // JSON 생성시 null 인 field 는 Json 생성 시 아예 빼버리겠다.
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> {
    private String returnCode;
    private String returnMessage;
    private T info;  // 각 요청별 응답값

    // new CodeEnum(CodeEnum.xxx)  : returnCode 와 returnMessage 를 굳이 각각 처리할 필요 없이 이미 모두 포함하고 있는 enum 만 받아서 생성 작업이 가능해짐.
    public CommonResponse(CodeEnum codeEnum) {
        setReturnCode(codeEnum.getCode());
        setReturnMessage(codeEnum.getMessage());
    }

    // 응답 처리가 되었으니 성공으로 알아서 처리해줘
    public CommonResponse(T info) {
        setReturnCode(CodeEnum.SUCCESS.getCode());
        setReturnMessage(CodeEnum.SUCCESS.getMessage());
        setInfo(info);
    }

    public CommonResponse(CodeEnum codeEnum, T info) {
        setReturnCode(codeEnum.getCode());
        setReturnMessage(codeEnum.getMessage());
        setInfo(info);
    }
}
