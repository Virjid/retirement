package io.virjid.retirement.entity;

import java.util.List;

public class NurseEntity extends AccountEntity {
	private static final long serialVersionUID = -7066957057580276326L;
	
	private List<OldmanEntity> oldmans;

	public List<OldmanEntity> getOldmans() {
		return oldmans;
	}

	public void setOldmans(List<OldmanEntity> oldmans) {
		this.oldmans = oldmans;
	}
}
