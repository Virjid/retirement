package io.virjid.retirement.dao;

import io.virjid.retirement.entity.OldmanEntity;

public interface OldmanDao extends AccountDao {
	void insertOldman(OldmanEntity e) throws Exception;
}