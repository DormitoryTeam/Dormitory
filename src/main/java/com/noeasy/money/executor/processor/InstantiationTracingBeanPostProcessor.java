/*
 * This code is provided solely for the use of the licensee subject to the terms
 * and conditions of the Master Service Agreement. Redistribution and use in
 * source and binary forms, with or without modification, are prohibited.
 * 
 * DISCLAIMER.THIS SOFTWARE IS PROVIDED BY AAXIS GROUP CORPORATION "AS IS."
 * EXCEPT AS SPECIFICALLY SET FORTH IN THE MASTER SERVICES AGREEMENT, ALL
 * EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS, AND WARRANTIES INCLUDING,
 * WITHOUT LIMITATION, ANY IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE, NONINFRINGEMENT OR ARISING FROM A COURSE OF DEALING,
 * USAGE, OR TRADE PRACTICE, ARE HEREBY EXCLUDED TO THE EXTENT ALLOWED BY
 * APPLICABLE LAW.
 * 
 * IN NO EVENT WILL AAXIS GROUP CORPORATION, THE COPYRIGHT OWNER OR CONTRIBUTORS
 * BE LIABLE FOR ANY LOST REVENUE, PROFIT, OR DATA, OR FOR SPECIAL, INDIRECT,
 * CONSEQUENTIAL, INCIDENTAL, EXEMPLARY OR PUNITIVE DAMAGESINCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA,
 * OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND REGARDLESS OF THE
 * THEORY OF LIABILITY ARISING OUT OF THE USE OF OR INABILITY TO USE THE
 * SOFTWARE EVEN IF AAXIS GROUP CORPORATION HAS BEEN ADVISED OF THE POSSIBILITY
 * OF SUCH DAMAGES.
 * 
 * IN NO EVENT SHALL AAXIS GROUP CORPORATION'S LIABILITY TO THE CUSTOMER OR USER
 * OF THIS SOFTWARE, WHETHER IN CONTRACT, TORT (INCLUDING NEGLIGENCE), OR
 * OTHERWISE, EXCEED THE PRICE PAID BY THE CUSTOMER OR USER FOR THIS SOFTWARE.
 * THE FOREGOING LIMITATIONS SHALL APPLY EVEN IF THE ANY WARRANTY PROVIDED IN
 * THE MASTER SERVICE AGREEMENT FAILS OF ITS ESSENTIAL PURPOSE.
 */
package com.noeasy.money.executor.processor;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.noeasy.money.enumeration.DormitoryStatus;
import com.noeasy.money.service.IDormitoryService;

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Mar 24, 2014
 */

public class InstantiationTracingBeanPostProcessor implements ApplicationListener<ContextRefreshedEvent> {

    @Resource(name = "dormitoryService")
    IDormitoryService dormitoryService;



    /**
     * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
     */
    @Override
    public void onApplicationEvent(final ContextRefreshedEvent pEvent) {
        // get the parent context
        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        ServletContext servletContext = webApplicationContext.getServletContext();

        List<Map<String, Object>> contractTypes = dormitoryService.queryContractTypes();
        List<Map<String, Object>> roomTypes = dormitoryService.queryRoomTypes();
        Object[] allDormitoryStatus = DormitoryStatus.getAllStatus();

        servletContext.setAttribute("contractTypes", contractTypes);
        servletContext.setAttribute("roomTypes", roomTypes);
        servletContext.setAttribute("allDormitoryStatus", allDormitoryStatus);

    }
}
