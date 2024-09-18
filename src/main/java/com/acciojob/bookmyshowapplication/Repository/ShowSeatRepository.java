package com.acciojob.bookmyshowapplication.Repository;

import com.acciojob.bookmyshowapplication.Models.Show;
import com.acciojob.bookmyshowapplication.Models.ShowSeat;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Integer> {
        public List<ShowSeat> findAllByShow(Show show); //inbuilt method invoking

                            //custom JPA Query
    @Query(nativeQuery = true, value ="select * from show_seats where show_show_id = :showId")
    public List<ShowSeat> findShowSeats(Integer showId);
}
