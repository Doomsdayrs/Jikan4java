package com.github.Doomsdayrs.Jikan4java.types.Main.User.History;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.Doomsdayrs.Jikan4java.types.Support.Basic.BasicMeta;

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
 * 03 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
public class History {
    @JsonProperty("meta")
    public BasicMeta basicMeta;
    @JsonProperty("increment")
    public int increment;
    @JsonProperty("date")
    public String date;
    

    @Override
    public String toString() {
        return "History{" +
                "meta=" + basicMeta +
                ", increment=" + increment +
                ", date='" + date + '\'' +
                '}';
    }
}
