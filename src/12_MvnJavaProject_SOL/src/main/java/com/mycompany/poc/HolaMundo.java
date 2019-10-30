/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.poc;

import java.util.logging.Logger;

/**
 *
 * @author usuario
 *
 */
public class HolaMundo {

    private static final int I = 0;

    public static int getI() {
        return I;
    }
    private static Logger logger = Logger.getAnonymousLogger();

    public static void main(String[] args) {
        /**
         * mvn sonar:sonar -Dsonar.host.url=http://localhost:9000 -Dsonar.login=0c54f70d8f6bda84f368a5cd7e3dc88fb1553d1a
         */
        logger.info("Hola Mundo");
    }

}
