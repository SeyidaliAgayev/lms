package com.div;

import com.div.service.ManagementService;
import com.div.service.impl.ManagementServiceImpl;

public class Main {
    public static void main(String[] args) {
        ManagementService managementService = new ManagementServiceImpl();
        managementService.baseManagement();
        //TODO exceptions nezere alinmayib
        //TODO CRUD service interfacesi cox yaxsi
        //TODO singletona yeniden bax
        //TODO
    }
}