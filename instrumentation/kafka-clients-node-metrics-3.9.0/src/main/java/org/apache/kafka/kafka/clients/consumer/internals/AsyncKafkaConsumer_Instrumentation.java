/*
 *
 *  * Copyright 2025 New Relic Corporation. All rights reserved.
 *  * SPDX-License-Identifier: Apache-2.0
 *
 */

package org.apache.kafka.kafka.clients.consumer.internals;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.weaver.NewField;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.WeaveAllConstructors;
import com.newrelic.api.agent.weaver.Weaver;
import com.nr.instrumentation.kafka.ClientType;
import com.nr.instrumentation.kafka.NewRelicMetricsReporter;
import org.apache.kafka.clients.consumer.internals.ConsumerMetadata;
import org.apache.kafka.common.Metric;
import org.apache.kafka.common.MetricName;
import org.apache.kafka.common.Node;
import org.apache.kafka.common.Uuid;
import org.apache.kafka.common.metrics.Metrics;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;

@Weave(originalName = "org.apache.kafka.clients.consumer.internals.AsyncKafkaConsumer")
public abstract class AsyncKafkaConsumer_Instrumentation<K, V> {
    // It's possible for constructors to be invoked multiple times (e.g. `C() { C("some default") }` ).
    // When this happens we don't want to register the metrics reporter multiple times.
    @NewField
    private boolean metricsReporterInstalled;

    private final Metrics metrics = Weaver.callOriginal();
    private final ConsumerMetadata metadata = Weaver.callOriginal();

    @WeaveAllConstructors
    public AsyncKafkaConsumer_Instrumentation() {
        if (!metricsReporterInstalled) {
            metrics.addReporter(new NewRelicMetricsReporter(ClientType.CONSUMER, metadata.fetch().nodes()));
            metricsReporterInstalled = true;
        }
    }
}
