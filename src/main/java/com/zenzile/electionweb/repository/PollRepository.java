/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zenzile.electionweb.repository;

import com.zenzile.electionweb.domain.Poll;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sihle
 */
public interface PollRepository extends JpaRepository<Poll, Long>{
    
}
