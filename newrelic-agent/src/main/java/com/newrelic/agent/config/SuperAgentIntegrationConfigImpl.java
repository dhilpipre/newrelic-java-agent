/*
 *
 *  * Copyright 2024 New Relic Corporation. All rights reserved.
 *  * SPDX-License-Identifier: Apache-2.0
 *
 */
package com.newrelic.agent.config;

import com.newrelic.agent.Agent;
import org.apache.commons.lang3.StringUtils;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.Map;
import java.util.logging.Level;

public class SuperAgentIntegrationConfigImpl extends BaseConfig implements SuperAgentIntegrationConfig {
    public static final String ROOT = "superagent";
    public static final String SYSTEM_PROPERTY_ROOT = "newrelic.config.superagent.";
    public static final String FLEET_ID = "fleet_id";

    private final String fleetId;

    private final SuperAgentIntegrationHealthConfig superAgentIntegrationHealthConfig;

    public SuperAgentIntegrationConfigImpl(Map<String, Object> configProps) {
        super(configProps, SYSTEM_PROPERTY_ROOT);
        superAgentIntegrationHealthConfig = createHealthConfig();
        String tmpFleetId = getProperty(FLEET_ID);

        if (StringUtils.isNotEmpty(tmpFleetId) && superAgentIntegrationHealthConfig.getHealthDeliveryLocation() == null) {
            Agent.LOG.log(Level.WARNING, "Configured Super Agent health delivery location is not a valid URI; " +
                    "SuperAgent integration service will not be started");
            fleetId = null;
        } else {
            fleetId = tmpFleetId;
        }
    }

    private SuperAgentIntegrationHealthConfig createHealthConfig() {
        Map<String, Object> healthProps = getProperty(SuperAgentIntegrationHealthConfig.ROOT, Collections.emptyMap());
        SuperAgentIntegrationHealthConfig superAgentIntegrationHealthConfig;

        superAgentIntegrationHealthConfig = new SuperAgentIntegrationHealthConfig(healthProps, SYSTEM_PROPERTY_ROOT);
        return superAgentIntegrationHealthConfig;
    }

    @Override
    public boolean isEnabled() {
        return fleetId != null;
    }

    @Override
    public URI getHealthDeliveryLocation() {
        return superAgentIntegrationHealthConfig == null ? null : superAgentIntegrationHealthConfig.getHealthDeliveryLocation();
    }

    @Override
    public int getHealthReportingFrequency() {
        return superAgentIntegrationHealthConfig == null ? 0 : superAgentIntegrationHealthConfig.getHealthReportingFrequency();
    }

    @Override
    public String getFleetId() {
        return fleetId;
    }

    @Override
    public String getHealthClientType() {
        return superAgentIntegrationHealthConfig == null ? null : superAgentIntegrationHealthConfig.getHealthClientType();
    }
}
