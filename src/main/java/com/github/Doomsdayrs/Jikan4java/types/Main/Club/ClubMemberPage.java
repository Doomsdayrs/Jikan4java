package com.github.Doomsdayrs.Jikan4java.types.Main.Club;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

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
 * 05 / January / 2019
 *
 * @author github.com/doomsdayrs
 */
public class ClubMemberPage {
	@JsonProperty("request_hash")
	private String request_hash;
	@JsonProperty("request_cached")
	private boolean request_cached;
	@JsonProperty("request_cache_expiry")
	private int request_cache_expiry;
	@JsonProperty("members")
	private ArrayList<ClubMember> clubMembers;

	public String getRequest_hash() {
		return request_hash;
	}

	public boolean isRequest_cached() {
		return request_cached;
	}

	public int getRequest_cache_expiry() {
		return request_cache_expiry;
	}

	public ArrayList<ClubMember> getClubMembers() {
		return clubMembers;
	}

	@Override
	public String toString() {
		return "ClubMemberPage{" +
				"request_hash='" + request_hash + '\'' +
				", request_cached=" + request_cached +
				", request_cache_expiry=" + request_cache_expiry +
				", clubMembers=" + clubMembers +
				'}';
	}
}
