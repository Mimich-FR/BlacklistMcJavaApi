#BlacklistMCJavaAPI

A simple java API for the blacklistmc project.

**Coding quality was not perfetct it's the reprieve**

***Exemple***

```java
        final BlacklistMcAPI blacklistMcAPI = new BlacklistMcAPI();

        final String search = "SkyNom";

        if (blacklistMcAPI.isBlackListed(search, ApiCheckType.MINECRAFT_USERNAME)) {

            final BlacklistProfile blacklistProfile = blacklistMcAPI.getProfile(search, ApiCheckType.MINECRAFT_USERNAME);

            System.out.println(blacklistProfile.getTitle());

            System.out.println(blacklistProfile.getDescription());

            System.out.println(blacklistProfile.getMinecraftUsername());
        }
```

**Implementation**

**Maven**

Clone and install for the local .m2

```groovy
    <dependencies>
        <dependency>
            <groupId>fr.mimich</groupId>
            <artifactId>blacklist-mc-java-api</artifactId>
            <version>1.0</version>
            <scope>compile</scope>
        </dependency>
    </dependencies>
```



