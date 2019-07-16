package com.github.Doomsdayrs.Jikan4java.types.Main.Meta;

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
 * 05 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
public class Status {
    @JsonProperty("cached_requests")
    public int cached_requests;
    @JsonProperty("requests_today")
    public int requests_today;
    @JsonProperty("requests_this_week")
    public int requests_this_week;
    @JsonProperty("requests_this_month")
    public int requests_this_month;
    @JsonProperty("connected_clients")
    public String connected_clients;
    @JsonProperty("total_connections_received")
    public String total_connections_received;

    @Override
    public String toString() {
        return "Status{" +
                "cached_requests=" + cached_requests +
                ", requests_today=" + requests_today +
                ", requests_this_week=" + requests_this_week +
                ", requests_this_month=" + requests_this_month +
                ", connected_clients='" + connected_clients + '\'' +
                ", total_connections_received='" + total_connections_received + '\'' +
                '}';
    }
}
