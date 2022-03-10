package cn.hcq413.web.dao;

import cn.hcq413.web.pojo.FilmInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmInfoRepository extends JpaRepository<FilmInfo,Integer> {
}
