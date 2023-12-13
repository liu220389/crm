package com.ttc.crms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommonResult<T> {
    private Integer code  ;
    private String message   ;
    private  T  retValue;

    public CommonResult( T  retValue) {
        this.retValue = retValue;
        this.setRescultCode(ResultCode.SUCCESS);
    }

    public void success( T retValue ){
        setRescultCode(ResultCode.SUCCESS);
        this.retValue = retValue;
    }

    private void setRescultCode(ResultCode rescultCode) {
        this.code =  rescultCode.getCode();
        this.message = rescultCode.getMessage();
    }


}
