package com.miles.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName BaseEntity
 * @Description TODO
 * @Author Miles
 * @Date 2019/4/7 10:56
 * @Version 1.0
 */
@Data
@RequiredArgsConstructor
public class BaseEntity implements Serializable {

    private Date dateCreated;
    private Date dateUpdate;
    private String createdBy;
    private String updatedBy;
}
