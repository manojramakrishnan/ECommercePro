package com.shopeasy.common.audit;

public interface Auditable {
	
	AuditSection getAuditSection();

	void setAuditSection(AuditSection audit);

}
