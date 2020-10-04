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

import java.util.List;
import java.util.Map;

public final class BlacklistProfile {

    private final boolean blacklisted;

    private final String blacklistMcPost;

    private final String title;

    private final String minecraftUsername;

    private final Map<String, Object> nicknameHistory;

    private final String twitterUsername;

    private final String discordID;

    private final String discordUsername;

    private final String description;

    private final List<String> proofs;

    private final String blacklistMcVerified;

    private final String blacklistedDate;


    public BlacklistProfile(final boolean blacklisted,
                            final String blacklistMcPost,
                            final String title,
                            final String minecraftUsername,
                            final Map<String, Object> nicknameHistory,
                            final String twitterUsername,
                            final String discordID,
                            final String discordUsername,
                            final String description,
                            final List<String> proofs,
                            final String blacklistMcVerified,
                            final String blacklistedDate) {

        this.blacklisted = blacklisted;

        this.blacklistMcPost = blacklistMcPost;

        this.title = title;

        this.minecraftUsername = minecraftUsername;

        this.nicknameHistory = nicknameHistory;

        this.twitterUsername = twitterUsername;

        this.discordID = discordID;

        this.discordUsername = discordUsername;

        this.description = description;

        this.proofs = proofs;

        this.blacklistMcVerified = blacklistMcVerified;

        this.blacklistedDate = blacklistedDate;

    }

    /**
     * Get if is blacklised.
     *
     * @return a blacklisted reponse.
     */
    public final boolean isBlacklisted() {

        return this.blacklisted;

    }

    /**
     * Get a link of the BlacklistMcPost.
     *
     * @return a link.
     */
    public final String getBlacklistMcPost() {

        return this.blacklistMcPost;

    }

    /**
     * Get a title of the post.
     *
     * @return a title.
     */
    public final String getTitle() {

        return this.title;

    }

    /**
     * Get a minecraft username of the blacklisted.
     *
     * @return a minecraft username.
     */
    public final String getMinecraftUsername() {

        return this.minecraftUsername;

    }

    /**
     * Get all nickanme history and change at.
     *
     * @return a map of a nickname history with a change at.
     */
    public final Map<String, Object> getNicknameHistory() {

        return this.nicknameHistory;

    }

    /**
     * Get a twitter username od the blacklisted.
     *
     * @return a twitter username.
     */
    public final String getTwitterUsername() {

        return this.twitterUsername;

    }

    /**
     * Get a id from discord app.
     *
     * @return a discord ID.
     */
    public final String getDiscordID() {

        return this.discordID;

    }

    /**
     * Get a discord username of the blacklisted.
     *
     * @return a discord username.
     */
    public final String getDiscordUsername() {

        return this.discordUsername;

    }

    /**
     * Get a description of the post.
     *
     * @return a description of the blacklisted.
     */
    public final String getDescription() {

        return this.description;

    }

    /**
     * Get all proofs.
     *
     * @return a list of a proof.
     */
    public final List<String> getProofs() {

        return this.proofs;

    }

    /**
     * Get if is verified
     *
     * @return a blacklistmc verified.
     */
    public final String getBlacklistMcVerified() {

        return this.blacklistMcVerified;

    }

    /**
     * Get a date of the object etry on the blacklist.
     *
     * @return a date of the blacklisting.
     */
    public final String getBlacklistedDate() {

        return this.blacklistedDate;

    }

}

