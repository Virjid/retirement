package io.virjid.retirement.service;

import io.virjid.retirement.ao.OldmanAddAo;
import io.virjid.retirement.entity.OldmanEntity;

public interface OldmanService extends AccountService {
	OldmanEntity insert(OldmanAddAo ao) throws Exception;
}