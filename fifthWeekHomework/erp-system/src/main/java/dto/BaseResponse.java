package main.java.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseResponse<T> {
    private int status;
    private boolean isSuccess;
    @Builder.Default
    private String error="no message available";
    private T data;
}
