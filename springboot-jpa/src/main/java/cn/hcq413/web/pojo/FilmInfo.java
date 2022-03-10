package cn.hcq413.web.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "filminfo")
@Data
public class FilmInfo implements Serializable {
    //默认所有的属性都是可持久化属性
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String filmName;
    private String actor;
    private String director;
    private Double ticketPrice;
    @ManyToOne   //多对一
    @JoinColumn(name = "type_id")  //设置filminfo表的外键列
    private FilmType filmType;   //一方映射


}