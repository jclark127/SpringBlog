package com.codeup.springblog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdRepository extends JpaRepository <Ad,Long>{

//    Ad findByTitle(String title);
//
//    @Query(value = "SELECT * FROM ad", nativeQuery = true)
//    Ad allOfit();

}
