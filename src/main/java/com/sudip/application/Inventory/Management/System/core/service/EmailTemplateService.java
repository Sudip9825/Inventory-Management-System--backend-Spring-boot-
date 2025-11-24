package com.sudip.application.Inventory.Management.System.core.service;

import com.sudip.application.Inventory.Management.System.entity.Supplier;

public interface EmailTemplateService {
    public void sendWelcomeMail(Supplier supplier);
  //  public void supplyConfirmationMail(Supplier supplier);
}
