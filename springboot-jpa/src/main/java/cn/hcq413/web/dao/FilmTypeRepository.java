package cn.hcq413.web.dao;

import cn.hcq413.web.pojo.FilmType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmTypeRepository extends JpaRepository<FilmType,Integer> {
}
