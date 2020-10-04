/*
 * MIT License
 *
 * Copyright (c) 2020 Mimich-FR, BlacklistMCJavaAPI
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package fr.mimich.blacklistmcapi;

public enum ApiCheckType {

    /**
     * ID CheckType.
     */
    ID,

    /**
     * TWITTER_USERNAME CheckType.
     */
    TWITTER_USERNAME,

    /**
     * MINECRAFT_USERNAME CheckType.
     */
    MINECRAFT_USERNAME,

    /**
     * DISCORD_ID CheckType.
     */
    DISCORD_ID;

    /**
     * Get a check api link.
     *
     * @param apiCheckLinkEnum a type of a check.
     * @param search a object do you want search. (id, username)
     *
     * @return the full link from the type.
     */
    public final String getLink(final ApiCheckType apiCheckLinkEnum, final String search) {

        final String BASE_LINK = "https://api.blacklistmc.net/api/search/";

        if (apiCheckLinkEnum.equals(ID)){

            return BASE_LINK + "id/" + search;

        }

        if (apiCheckLinkEnum.equals(TWITTER_USERNAME)){

            return BASE_LINK + "twitter/" + search;

        }

        if (apiCheckLinkEnum.equals(MINECRAFT_USERNAME)){

            return BASE_LINK + "mc/" + search;

        }

        if (apiCheckLinkEnum.equals(DISCORD_ID)){

            return BASE_LINK + "discord/" + search + "/id";

        }

        return null;

    }

}
