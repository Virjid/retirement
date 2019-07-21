package io.virjid.retirement.service;

import io.virjid.retirement.dto.QueryResult;

public interface AccountService {
	QueryResult queryByKey(String key, Integer pageNo, Integer pageSize) throws Exception;
}
