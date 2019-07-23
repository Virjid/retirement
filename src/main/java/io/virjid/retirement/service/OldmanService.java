package io.virjid.retirement.service;

import io.virjid.retirement.ao.OldmanAddAo;
import io.virjid.retirement.dto.OldmanContext;

public interface OldmanService extends AccountService<OldmanContext, OldmanAddAo> {
	OldmanContext login(String account, String password);
}