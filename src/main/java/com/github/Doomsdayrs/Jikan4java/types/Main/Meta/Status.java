package com.github.Doomsdayrs.Jikan4java.types.Main.Meta;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This file is part of Jikan4java.
 * Jikan4java is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Foobar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with Jikan4java.  If not, see <https://www.gnu.org/licenses/>.
 * ====================================================================
 * Jikan4java
 * 05 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
public class Status {
    @JsonProperty("cached_requests")
    private int cached_requests;
    @JsonProperty("requests_today")
    private int requests_today;
    @JsonProperty("requests_this_week")
    private int requests_this_week;
    @JsonProperty("requests_this_month")
    private int requests_this_month;
    @JsonProperty("connected_clients")
    private String connected_clients;
    @JsonProperty("total_connections_received")
    private String total_connections_received;

    public int getCached_requests() {
        return cached_requests;
    }

    public int getRequests_today() {
        return requests_today;
    }

    public int getRequests_this_week() {
        return requests_this_week;
    }

    public int getRequests_this_month() {
        return requests_this_month;
    }

    public String getConnected_clients() {
        return connected_clients;
    }

    public String getTotal_connections_received() {
        return total_connections_received;
    }

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
