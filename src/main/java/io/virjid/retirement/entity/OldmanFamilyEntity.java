package io.virjid.retirement.entity;

import java.util.List;

public class OldmanFamilyEntity extends AccountEntity {
	private static final long serialVersionUID = -5819311386742961161L;
	
	private List<OldmanEntity> oldmans;

	public List<OldmanEntity> getOldmans() {
		return oldmans;
	}

	public void setOldmans(List<OldmanEntity> oldmans) {
		this.oldmans = oldmans;
	}
}
