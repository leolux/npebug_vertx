/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.bugnpe;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import lombok.extern.log4j.Log4j2;

/**
 *
 * @author lzeligowski
 */
@Log4j2
public class MainVertx {

    public static void main(String[] args) {
        VertxOptions options = new VertxOptions();
        options.setClustered(true);
        Vertx.clusteredVertx(options, vertxHandler -> {
            if (vertxHandler.succeeded()) {
                Vertx vertx = vertxHandler.result();
                vertx.deployVerticle(new ServerVerticle());
            }
        }
        );
    }
}
