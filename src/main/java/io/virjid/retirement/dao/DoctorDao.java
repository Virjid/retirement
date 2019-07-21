package io.virjid.retirement.dao;

import io.virjid.retirement.entity.DoctorEntity;

public interface DoctorDao extends AccountDao {
	void insertDoctor(DoctorEntity e) throws Exception;
}
