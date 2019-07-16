package com.github.Doomsdayrs.Jikan4java.types.Support.Stats.Score;

import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 * Jikan4java
 * 29 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
public class Score {
    @JsonProperty("1")
    public Position one;
    @JsonProperty("2")
    public Position two;
    @JsonProperty("3")
    public Position three;
    @JsonProperty("4")
    public Position four;
    @JsonProperty("5")
    public Position five;
    @JsonProperty("6")
    public Position six;
    @JsonProperty("7")
    public Position seven;
    @JsonProperty("8")
    public Position eight;
    @JsonProperty("9")
    public Position nine;
    @JsonProperty("10")
    public Position ten;
    
    @Override
    public String toString() {
        return "Score{" +
                "one=" + one +
                ", two=" + two +
                ", three=" + three +
                ", four=" + four +
                ", five=" + five +
                ", six=" + six +
                ", seven=" + seven +
                ", eight=" + eight +
                ", nine=" + nine +
                ", ten=" + ten +
                '}';
    }
}
