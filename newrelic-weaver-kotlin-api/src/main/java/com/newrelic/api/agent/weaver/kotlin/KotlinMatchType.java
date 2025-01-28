/*
 *
 *  * Copyright 2020 New Relic Corporation. All rights reserved.
 *  * SPDX-License-Identifier: Apache-2.0
 *
 */

package com.newrelic.api.agent.weaver.kotlin;

/**
 * The match type of a weave instrumentation class written in scala.
 */
public enum KotlinMatchType {
    /**
     * An exact class match. The weave instrumentation will be injected into the class with the exact same name as the
     * weave class.
     */
    ExactClass,
    
    /**
     * 
     */
    BaseClass,
    /**
     * 
     */
    FunctionalInterface,
    /**
     * The weave instrumentation will be injected into the scala object with the exact same name as the weave class.
     */
    Object
}