/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.spatial4j.core.shape;

import com.spatial4j.core.context.SpatialContext;

/**
 * Shape instances are usually retrieved via one of the create* methods on a {@link SpatialContext}.
 * Shapes are generally immutable and thread-safe.
 * The sub-classes of Shape generally implement the same contract for {@link Object#equals(Object)}
 * and {@link Object#hashCode()} amongst the same sub-interface type.  This means, for example, that
 * multiple Point implementations of different classes are equal if they share the same x & y.
 */
public interface Shape {

  /**
   * Describe the relationship between the two objects.  For example
   * <ul>
   *   <li>this is WITHIN other</li>
   *   <li>this CONTAINS other</li>
   *   <li>this is DISJOINT other</li>
   *   <li>this INTERSECTS other</li>
   * </ul>
   */
  SpatialRelation relate(Shape other, SpatialContext ctx);

  /**
   * Get the bounding box for this Shape
   */
  Rectangle getBoundingBox();

  /**
   * @return true if the shape has area.  This will be false for points and lines
   */
  boolean hasArea();

  Point getCenter();
}

