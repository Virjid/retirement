package io.virjid.retirement.dto;

import java.util.List;

import io.virjid.retirement.entity.OldmanEntity;

public class DoctorContext extends AccountContext {
	private List<OldmanEntity> oldmans;

	public List<OldmanEntity> getOldmans() {
		return oldmans;
	}

	public void setOldmans(List<OldmanEntity> oldmans) {
		this.oldmans = oldmans;
	}
}
