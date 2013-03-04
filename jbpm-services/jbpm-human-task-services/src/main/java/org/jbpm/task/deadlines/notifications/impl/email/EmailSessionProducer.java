/*
 * Copyright 2012 JBoss by Red Hat.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jbpm.task.deadlines.notifications.impl.email;

import java.util.Properties;

import javax.annotation.Resource;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;
import javax.mail.Session;

public class EmailSessionProducer {

    @Resource
    private Session mailSession;
    
    
    @Produces
    @Singleton
    public Session produceSession() {
        if (mailSession == null) {
            Properties conf = new Properties();
            try {
                conf.load(this.getClass().getResourceAsStream("/email.properties"));
                
                mailSession = Session.getInstance(conf);
            } catch (Exception e) {
                return null;
            }
        
        }
        
        return mailSession;
    }
}
