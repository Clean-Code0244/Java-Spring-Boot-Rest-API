package com.omertursun.gallerist.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
public class Exception<E> {

    private String path;
    private Date createTime;
    private String hostName;
    private E message;

}
