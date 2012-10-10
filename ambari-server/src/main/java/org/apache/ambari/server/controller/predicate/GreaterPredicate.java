/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.ambari.server.controller.predicate;

import org.apache.ambari.server.controller.spi.PropertyId;
import org.apache.ambari.server.controller.spi.Resource;

/**
 * Predicate that checks if a given value is greater than a {@link Resource} property.
 */
public class GreaterPredicate extends ComparisonPredicate {

  public GreaterPredicate(PropertyId propertyId, Comparable<String> value) {
    super(propertyId, value);
  }

  @Override
  public boolean evaluate(Resource resource) {
    String propertyValue = resource.getPropertyValue(getPropertyId());
    return propertyValue == null ? false : getValue().compareTo(resource.getPropertyValue(getPropertyId())) < 0;
  }

  @Override
  public String getOperator() {
    return ">";
  }
}
