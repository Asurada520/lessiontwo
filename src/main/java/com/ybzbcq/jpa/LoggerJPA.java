package com.ybzbcq.jpa;

import com.ybzbcq.entity.LoggerEntity;
import com.ybzbcq.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface LoggerJPA extends JpaRepository<LoggerEntity, Long>, JpaSpecificationExecutor<LoggerEntity>, Serializable {

}
