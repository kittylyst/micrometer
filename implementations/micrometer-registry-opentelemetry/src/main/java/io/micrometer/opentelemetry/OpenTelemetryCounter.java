/**
 * Copyright 2020 VMware, Inc.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * https://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micrometer.opentelemetry;

import io.micrometer.core.instrument.AbstractMeter;
import io.micrometer.core.instrument.Counter;
import io.opentelemetry.metrics.DoubleCounter;

/**
 * Use an Asynchronous Callback to observe the value of the Micrometer counter.
 *
 * @author Erin Schnabel
 */
public class OpenTelemetryCounter extends AbstractMeter implements Counter {
    final DoubleCounter counter;

    public OpenTelemetryCounter(Id id, DoubleCounter counter) {
        super(id);
        this.counter = counter;
    }

    @Override
    public void increment(double amount) {
        counter.add(amount);
    }

    @Override
    public double count() {
        return 0;
    }
}
