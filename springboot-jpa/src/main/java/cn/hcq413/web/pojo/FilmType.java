package cn.hcq413.web.pojo;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "filmtype")
@Data
public class FilmType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    // inverse=true 设置关联维护方为多方  mappedBy = "filmType"
    // 数据加载：默认是延时加载      FetchType.EAGER(即时加载)  FetchType.LAZY(懒加载)
    //一对多

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "filmType")
    private Set<FilmInfo> filmList = new HashSet<>();


}