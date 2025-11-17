package com.sudip.application.Inventory.Management.System.service;

import com.sudip.application.Inventory.Management.System.entity.Supplier;

public interface EmailTemplateService {
    public void sendWelcomeMail(Supplier supplier);
}
