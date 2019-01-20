package com.tensquare.spit.pojp;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 冯彧
 * @date 2019/1/20 20:25
 * @description
 */
@Getter
@Setter
public class Spit implements Serializable {

    @Id
    private String _id;
    private String content;
    private Date publishtime;
    private String userid;
    private String nickname;
    private Integer visits;
    private Integer thumbup;
    private Integer share;
    private Integer comment;
    private String state;
    private String parentid;

}
