package com.github.Doomsdayrs.Jikan4java.connection;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.types.Support.enums.Stati;
import com.github.Doomsdayrs.Jikan4java.types.Support.enums.Types;

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
 * 13 / May / 2019
 *
 * @author github.com/doomsdayrs
 */
public class Search extends Retriever {
    private final Types type;
    private String query = null;
    private int pages;
    private Stati status;

    Search(Types type) {
        super();
        this.type = type;
    }

    Search(Types type, ObjectMapper mapper) {
        super(mapper);
        this.type = type;
    }

    public String createURL(){
        return baseURL+"/"+type+"q="+query;
    }

    public void setPages(int pages){
        this.pages=pages;
    }

    public Object query(String title) {
        return null;
    }

    public void setStatus(Stati status) {
        this.status = status;
    }
}
